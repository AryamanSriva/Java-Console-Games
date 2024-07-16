import java.util.Scanner;

interface Game {
    String start(char input);
}

class FlightSimple implements Game {
    private int flightSpeed;
    private int flightHeight;
    private int maxKeyStrokes;

    public FlightSimple(int maxKeyStrokes) {
        this.flightSpeed = 0;
        this.flightHeight = 0;
        this.maxKeyStrokes = maxKeyStrokes;
    }

    @Override
    public String start(char input) {
        maxKeyStrokes--;

        if (input == 'R') {
            flightSpeed++;
        } else if (input == 'L') {
            flightSpeed--;
            if (flightSpeed <= 0 && flightHeight > 0) {
                return "Lost";
            } else if (flightSpeed == 0 && flightHeight == 0) {
                return "Win";
            }
        } else if (input == 'U') {
            if (flightSpeed > 2) {
                flightHeight++;
            }

        } else if (input == 'D') {
            flightHeight--;
            if (flightHeight < 0 && flightSpeed > 0) {
                return "Lost";
            } else if (flightHeight == 0 && flightSpeed == 0) {
                return "Win";
            }
        }
        if (maxKeyStrokes <= 0) {
            return "Game Over";
        }

        return "None";
    }
}

class RandomWalk implements Game {
    private int maxKeyStrokes;
    private int currentRow;
    private int currentCol;

    public RandomWalk(int maxKeyStrokes) {
        this.maxKeyStrokes = maxKeyStrokes;
        this.currentRow = 10;
        this.currentCol = 10;
    }

    @Override
    public String start(char input) {
        maxKeyStrokes--;

        if (input == 'U') {
            currentRow--;
            if (currentRow == 0) {
                return "Win";
            }
        } else if (input == 'L') {
            if (currentCol > 0) {
                currentCol--;
            }
        } else if (input == 'R') {
            currentCol++;
            if (currentCol == 19) {
                return "Lost";
            }
        } else if (input == 'D') {
            currentRow++;
            if (currentRow == 19) {
                return "Lost";
            }
        }
        if (maxKeyStrokes <= 0) {
            return "Game Over";
        }

        return "None";
    }
}

public class GameConsole {
    private Scanner scanner;
    private Game currentGame;

    public GameConsole() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            String gameName = scanner.next();
            if (gameName.equalsIgnoreCase("end")) {
                break;
            }
            int maxKeyStrokes = scanner.nextInt();
            if (gameName.equalsIgnoreCase("flightsimple")) {
                currentGame = new FlightSimple(maxKeyStrokes);
            } else {
                currentGame = new RandomWalk(maxKeyStrokes);
            }

            String actions = scanner.next();  

            for (char action : actions.toCharArray()) {
                String result = currentGame.start(action);
                if (result.equalsIgnoreCase("win")) {
                    System.out.println(currentGame.getClass().getSimpleName() + ": Win");
                    break;
                } else if (result.equalsIgnoreCase("lost")) {
                    System.out.println(currentGame.getClass().getSimpleName() + ": Lost");
                    break;
                } else if (result.equalsIgnoreCase("game over")) {
                    System.out.println(currentGame.getClass().getSimpleName() + ": GameOver");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        GameConsole console = new GameConsole();
        console.start();
    }
}