# Simple Java Console Games

This Java program provides a simple console-based game framework with two games: `FlightSimple` and `RandomWalk`. Players can choose a game, input commands to control the game, and play until a win, loss, or game over condition is met.

## Overview

The program defines a `Game` interface with a `start` method, which is implemented by the `FlightSimple` and `RandomWalk` classes. The `GameConsole` class handles user input and runs the selected game.

## Game Rules

### FlightSimple

In `FlightSimple`, the player controls the flight speed and height with the following commands:
- `R`: Increase flight speed.
- `L`: Decrease flight speed. If speed <= 0 and height > 0, the player loses. If speed == 0 and height == 0, the player wins.
- `U`: Increase flight height if speed > 2.
- `D`: Decrease flight height. If height < 0 and speed > 0, the player loses. If height == 0 and speed == 0, the player wins.

### RandomWalk

In `RandomWalk`, the player moves on a 20x20 grid starting at position (10, 10) with the following commands:
- `U`: Move up. The player wins if they reach row 0.
- `L`: Move left if the current column is > 0.
- `R`: Move right. The player loses if they reach column 19.
- `D`: Move down. The player loses if they reach row 19.
