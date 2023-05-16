import numpy as np
from scipy.integrate import odeint
import matplotlib.pyplot as plt

# Define the Lotka-Volterra equations
def lotka_volterra_model(state, t, alpha, beta, delta, gamma):
    resources, users = state
    dresources_dt = alpha * resources - beta * resources * users
    dusers_dt = delta * resources * users - gamma * users
    return [dresources_dt, dusers_dt]

# Set initial conditions and parameters
initial_state = [40, 9]  # [resources, users]
alpha = 0.1  # Resource growth rate
beta = 0.02  # Rate at which users consume resources
delta = 0.01  # Rate at which users increase their count by consuming resources
gamma = 0.1  # User "death" rate

params = (alpha, beta, delta, gamma)

# Time span for simulation
t = np.linspace(0, 100, 1000)

# Solve the differential equations
solution = odeint(lotka_volterra_model, initial_state, t, args=params)
resources, users = solution.T

def custom_simulation(initial_resources, initial_users, alpha, beta, delta, gamma, timesteps):
    resources = [initial_resources]
    users = [initial_users]

    for _ in range(1, timesteps):
        delta_resources = alpha * resources[-1] - beta * resources[-1] * users[-1]
        delta_users = delta * resources[-1] * users[-1] - gamma * users[-1]

        resources.append(resources[-1] + delta_resources)
        users.append(users[-1] + delta_users)

    return resources, users

# Run the custom simulation
timesteps = 1000
simulated_resources, simulated_users = custom_simulation(initial_state[0], initial_state[1], alpha, beta, delta, gamma, timesteps)

import numpy as np
import matplotlib.pyplot as plt

# Calculate the time values for the custom simulation
sim_t = np.linspace(0, 100, timesteps)

# Plot the results from the custom simulation
plt.figure()
plt.plot(sim_t, simulated_resources, label="Simulated Resources")
plt.plot(sim_t, simulated_users, label="Simulated Users")
plt.xlabel("Time")
plt.ylabel("Population")
plt.legend()
plt.title("Custom Simulation")
plt.show()

# Plot the results from the scipy solution (Lotka-Volterra)
plt.figure()
plt.plot(t, resources, label="Resources (Lotka-Volterra)")
plt.plot(t, users, label="Users (Lotka-Volterra)")
plt.xlabel("Time")
plt.ylabel("Population")
plt.legend()
plt.title("Lotka-Volterra (scipy)")
plt.show()
