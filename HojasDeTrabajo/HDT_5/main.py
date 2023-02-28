#
#HDT 5 estructuras de datos
#Nelson Garía 22434
#Joaquín Puente 22296
#Oscar Fuentes 22763
#

from simpy import Environment, Resource, Container
from random import seed, expovariate, randint
from matplotlib.pyplot import *
import numpy as np


NUCLEOS = 1
CAPACIDADRAM= 100

RANDO_SEED = 42
NOPROCESOS = 25
INTERVALO = 10
CICLOS = 2

tiempos_procesos = {}
times = []

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
        self.tiempo_inicio = 0
        self.tiempo_final = 0
        
        
    def run(self, cpu):
        instructions = min(3, self.leftInst)
        self.cpu_time = instructions * CICLOS
        self.leftInst -= instructions
        #self.tiempo_inicio = self.env.now
        yield self.env.timeout(self.cpu_time)
        
        if self.leftInst <= 0:
            print(f'Proceso No. {self.name} terminado en t={round(self.env.now)}')
            self.tiempo_final = self.env.now
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
        process.tiempo_inicio = env.now
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
                tiempos_procesos[process.name] = (process.tiempo_inicio, process.tiempo_final)
        yield env.timeout(CICLOS)

def calcTiempos(self):
        
        for name, (self.tiempo_inicio, self.tiempo_final) in tiempos_procesos.items():
            time_in_system = self.tiempo_final - self.tiempo_inicio
            times.append(time_in_system)

        mean_time = np.mean(times)
        std_dev = np.std(times)

        print(f"Average time in system: {mean_time}")
        print(f"Standard deviation: {std_dev}")


       

env = Environment()
ram = Container(env, init=CAPACIDADRAM, capacity=CAPACIDADRAM)
cpu = Resource(env, capacity=NUCLEOS)

env.process(genProcess(env, ram))
env.process(cpuScheduler(env,cpu))
env.process(ioScheduler(env))


env.run(until=450)
calcTiempos()


#print(tiempos_procesos)
""""

#Graficas
data = [3, 4, 5, 6, 7]
labels = ['A', 'B', 'C', 'D', 'E']
std_dev = np.std(data)
mean = np.mean(data)

bar(labels, data)
show()
"""