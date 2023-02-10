# Drone Delivery Service

A squad of drones is tasked with delivering packages for a major online retailer in a
world where time and distance do not matter.

Each drone can carry a specific weight and can make multiple deliveries before
returning to home base to pick up additional packages; however, the goal is to make
the fewest number of trips, as each time the drone returns to home base, it is
extremely costly to refuel and reload the drone.

The software shall accept input which will include: the name of each drone, the
maximum weight it can carry, along with a series of locations and the total weight
needed to be delivered to that specific location. The software should highlight the most
efficient deliveries for each drone to make on each trip.

Assume that time and distance to each location do not matter, and that the size of
each package is irrelevant. It is also assumed that the cost to refuel and restock each
drone is a constant and does not vary between drones.
The maximum number of drones in a squad is 100, and there is no maximum number
of required deliveries.

Given Input

```Line 1: [Drone #1 Name], [#1 Maximum Weight], [Drone #2 Name], [#2 Maximum Weight], etc.
Line 2: [Location #1 Name], [Location #1 Package Weight]
Line 3: [Location #2 Name], [Location #2 Package Weight]
Line 4: [Location #3 Name], [Location #3 Package Weight]
Etc.
```

Expected Output

```[Drone #1 Name]
Trip #1
[Location #2 Name], [Location #3 Name]
Trip #2
[Location #1 Name]
[Drone #2 Name]
Trip #1
[Location #4 Name], [Location #7 Name]
Trip #2
[Location #5 Name], [Location #6 Name]
```

## Summary

### Greedy Algorithm

Greedy is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. So the problems where choosing locally optimal also leads to global solution are the best fit for Greedy.

## Approach

This implementation uses greedy approach to fill up the drone's maximum weight with packages from the locations list, whenever the weight of a location is less than or equal to the remaining weight of the drone. The result is a map, where each item of map represents a drone and its trips, including the weight of each trip and the names of the locations visited in that trip.

## Quick Start

To run project:

### Run code from IntelliJ IDEA

IntelliJ IDEA allows you to run applications right from the editor. You don't need to worry about the technical aspect because IntelliJ IDEA automatically does all the necessary preparations behind the scenes.

- Click the Run icon in the gutter and select Run 'MainKt'

<img width="345" alt="kotlin_create_first_app_run_1" src="https://user-images.githubusercontent.com/11658088/218026554-a371aaf5-5ede-4400-bb83-057e25f3b7ae.png">

When the program has started, the Run tool window opens, where you can review the output and interact with the program.



