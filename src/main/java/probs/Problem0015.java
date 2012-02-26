package probs;

import utils.euler.EulerProblem;

/**
 * Project Euler problem 15
 * 
 * Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.
 * 
 * How many routes are there through a 20×20 grid?
 * 
 * @author Lord Torgamus
 */
public class Problem0015 extends EulerProblem {
    public static final int ROWS;
    public static final int COLS;

    static {
        ROWS = 20;
        COLS = 20;
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0015());
    }

    @Override
    protected long doProblemSpecificStuff() {
        long[][] pathArray = new long[ROWS + 1][COLS + 1];

        // Right and bottom edges can only reach end via one path
        for(int row = ROWS; row >= 0; row--) {
            pathArray[row][COLS] = 1;
        }
        for(int col = COLS; col >= 0; col--) {
            pathArray[ROWS][col] = 1;
        }

        // Rest of cells can reach end via a number of paths equal to the sum of their two potential "children"
        for(int row = ROWS - 1; row >= 0; row--) {
            for(int col = COLS - 1; col >= 0; col--) {
                pathArray[row][col] = pathArray[row + 1][col] + pathArray[row][col + 1];
            }
        }

        return pathArray[0][0];
    }
}
