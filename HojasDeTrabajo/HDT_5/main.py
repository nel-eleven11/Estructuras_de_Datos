import random

from simpy import Environment, Resource, Container
from random import seed, expovariate

#Colas con la clase container y resources 

#número de nucleos
nucleos = 1
capacidadRAM = 100

noProcesos = 10

env = Environment()

class computer:
    def __init__(self, env, ramCap, nuc):
        self.ram = Container(env, init=ramCap, capacity=ramCap)
        self.cpu = Resource(env, capacity=nuc)
        self.monProc = env.process(self.monitor(env))

    def monitor(self, env):
        while True:
            if self.ram.level < 10:
                print("RAM baja")


            print("RAM: ", self.ram.level, "CPU: ", self.cpu.count)
            yield env.timeout(1)

def proceso(no, env, compu):
    ramUse = random.seed(10)
    print(ramUse)

    print(f"Proceso {no} iniciado con {ramUse} de RAM");
    with compu.cpu.request() as req:
        yield req
        print(f"Proceso {no} ejecutandose en CPU")
        yield env.timeout(10)
    

def processGenerator(env, compu):
    for i in range(noProcesos):
        env.process(proceso(i, env, compu))
        yield env.timeout(random.expovariate(1.0/10))

env = Environment()
compu = computer(env, capacidadRAM, nucleos)
env.process(processGenerator(env, compu))
env.run(until=100)