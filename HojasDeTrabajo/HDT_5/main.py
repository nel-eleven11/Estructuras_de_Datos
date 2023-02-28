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




RANDO_SEED = 42

CICLOS = 1

tiempos_procesos = {}


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
            ahora_ = round(self.env.now)
            print(f'Proceso No. {self.name} terminado en t={ahora_}')
            tiempos_procesos[self.name].append(ahora_)
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
        tiempos_procesos[i] = []
        process = Process(env,i,ramUsage)
        yield ram.get(ramUsage)
        ahora = round(env.now)
        print(f'Proceso No. {process.name} generado en t={ahora}')
        tiempos_procesos[i].append(ahora)
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

def calcTiempos():
        times = []
        for i in tiempos_procesos:
            time_in_system = tiempos_procesos[i][1] - tiempos_procesos[i][0]
            times.append(time_in_system)    

        mean_time = np.mean(times)
        std_dev = np.std(times)

        print(f"Tiempo promedio: {mean_time}")
        print(f"Desviación estándar: {std_dev}")

        

for i in [25,50,100,150,200]:
    for j in [1,2]:
        for x in [100,200]:
            for n in [10,5,1]:
                NUCLEOS = j
                CAPACIDADRAM= x
                NOPROCESOS = i
                INTERVALO = n
                print(i)
                print(j)
                print(x)
                print(n)
                seed(RANDO_SEED)
                env = Environment()
                ram = Container(env, init=CAPACIDADRAM, capacity=CAPACIDADRAM)
                cpu = Resource(env, capacity=NUCLEOS)

                env.process(genProcess(env, ram))
                env.process(cpuScheduler(env,cpu))
                env.process(ioScheduler(env))

                env.run(until=3000)
                calcTiempos()



""""

#Graficas
data = [3, 4, 5, 6, 7]
labels = ['A', 'B', 'C', 'D', 'E']
std_dev = np.std(data)
mean = np.mean(data)

bar(labels, data)
show()
"""