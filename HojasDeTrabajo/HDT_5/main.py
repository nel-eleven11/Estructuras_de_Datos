#
#HDT 5 estructuras de datos
#Nelson Garía 22434
#Joaquín Puente 22296
#Oscar Fuentes 22763
#

from simpy import Environment, Resource, Container
from random import seed, expovariate, randint
from matplotlib.pyplot import *


NUCLEOS = 1
CAPACIDADRAM= 100

RANDO_SEED = 42
NOPROCESOS = 25
INTERVALO = 10
CICLOS = 2

#Colas
ioWait = []
ready = []

class Process:
    def __init__(self, env, name, ramUse):
        self.env = env
        self.name = name
        self.ramUse = ramUse
        self.totalInst = randint(1,10)
        self.leftInst = self.totalInst
        self.cpu_time = 0

    def run(self, cpu):
        instructions = min(3, self.leftInst)
        self.cpu_time = instructions * CICLOS
        self.leftInst -= instructions
        yield self.env.timeout(self.cpu_time)
        if self.leftInst <= 0:
            print(f'Proceso No. {self.name} terminado en t={round(self.env.now)}')
            yield ram.put(self.ramUse)
        else:
            prob = randint(1,2)
            if prob == 1:
                print(f'Proceso No. {self.name} en espera en t={round(self.env.now)}')
                ioWait.append(self)
            else:
                print(f'Proceso No. {self.name} listo en t={round(self.env.now)}')
                ready.append(self)

def genProcess(env, ram):
    for i in range(NOPROCESOS+1):
        ramUsage = randint(1,10)
        process = Process(env,str(i),ramUsage)
        yield ram.get(ramUsage)

        print(f'Proceso No. {process.name} generado en t={round(env.now)}')
        ready.append(process)

        yield env.timeout(expovariate(1/INTERVALO))

def ioScheduler(env):
    while True:
        if len(ioWait) > 0:
            process = ioWait.pop(0)
            print(f'Proceso No. {process.name} listo en t={round(env.now)}')
            ready.append(process)

        yield env.timeout(CICLOS)

def cpuScheduler(env, cpu):
    while True:
        if len(ready) > 0:
            process = ready.pop(0)

            with cpu.request() as req:
                print(f'Proceso No. {process.name} corriendo en {round(env.now)}')
                yield env.process(process.run(cpu))

        yield env.timeout(CICLOS)

env = Environment()
ram = Container(env, init=CAPACIDADRAM, capacity=CAPACIDADRAM)
cpu = Resource(env, capacity=NUCLEOS)

env.process(genProcess(env, ram))
env.process(cpuScheduler(env,cpu))
env.process(ioScheduler(env))

env.run(until=450)

