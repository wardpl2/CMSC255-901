package Games.Battleship;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    State[][] playField;
    ArrayList<Ship> ships;

    public Grid() {
        ships = new ArrayList<>();
        playField = new State[10][10];
        for (State[] row : playField) {
            Arrays.fill(row, State.OCEAN);
        }
    }

    public boolean addShip(Ship ship, String coordinate) {
        //C4 || D10 || F8
        int row = (coordinate.charAt(0) - 'A' + 1) - 1;
        int col = Integer.parseInt(coordinate.substring(1)) - 1;

        //check if the ship can fit on the grid
        if (row < 0 || row > 9 || col < 0 || col > 9) {
            return false;
        }
        else if (!ship.isVertical() && col + ship.getSize() > 10) {
            return false;
        }
        else if (ship.isVertical() && row + ship.getSize() > 10) {
            return false;
        }

        if (ship.isVertical()) {
            for (int i = row; i < row + ship.getSize(); i++) {
                if (playField[i][col] != State.OCEAN) {
                    return false;
                }
            }
            for (int i = row; i < row + ship.getSize(); i++) {
                playField[i][col] = State.SHIP;
            }
        } else {
            for (int i = col; i < col + ship.getSize(); i++) {
                if (playField[row][i] != State.OCEAN) {
                    return false;
                }
            }
            for (int i = col; i < col + ship.getSize(); i++) {
                playField[row][i] = State.SHIP;
            }
        }

        ship.setCoordinate(coordinate);
        ships.add(ship);
        return true;
    }

    public State fire(String coordinate) {
        int row = (coordinate.charAt(0) - 'A' + 1) - 1;
        int col = Integer.parseInt(coordinate.substring(1)) - 1;

        if (row < 0 || row > 9 || col < 0 || col > 9) {
            return State.MISS;
        }

        if (playField[row][col] == State.SHIP) {
            playField[row][col] = State.HIT;
            return State.SHIP;
        }
        else if (playField[row][col] == State.HIT) {
            return State.HIT;
        } else {
            playField[row][col] = State.MISS;
        }
        return State.MISS;
    }

    public String didShipSink() {

    }
}
