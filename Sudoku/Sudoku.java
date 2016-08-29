import java.util.*;
import java.awt.*;

public class Sudoku {
    //int[][] this.board;
    int[][] board;
    Map<String, Set<Integer>> boardMap;
    
    public Sudoku(int[][] sudokuBoard) {
        board = sudokuBoard;
        boardSetup();
        for (int i = 0; i < 81; i++) {
            firstTry();
        }
        //solver(0, 0);
        boardPrint();
    }
        
    public boolean solver(int x, int y) {
        for (int i = x; i < 9; i++) {
            Stack<Integer> nums = new Stack<Integer>();
            for (int j = 1; j < 10; j++) {
                nums.push(j);
            }
            for (int j = y; j < 9; j++) {
                if (board[i][j] == 0) {
                    //System.out.println(board[i])
                    boolean conflict = conflictCheck(new Point(i, j), nums.peek());
                    while (conflict == false) {
                        if (nums.isEmpty()) {
                            return false;
                        }
                        conflict = conflictCheck(new Point(i, j), nums.peek());
                        if (conflict == false) {
                            nums.pop();
                        }
                    }
                    boolean futureBool = true;
                    if (j == 8) {
                        futureBool = solver(i+1, 0);
                    } else {
                        futureBool = solver(i, j+1);
                    }
                    
                    if (futureBool == true) {
                        board[i][j] = nums.pop();
                    } 
                }
            }
        }
        return true;
    }
    
    // returns true if there is a conflict
    public boolean conflictCheck(Point p, int num) {
        Set<Integer> neighbors = possibilities(p);
        return neighbors.contains(num);
    }
    
    public void boardPrint(){
        for (int[] row : board) {
            System.out.print("[ ");
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
    
    public void boardSetup() {
        boardMap = new TreeMap<String, Set<Integer>>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Point p = new Point(i, j);
                Set<Integer> neighbors = possibilities(p);
                boardMap.put(i + "" + j, neighbors);
            }
        } 
    }
    
    public Set<Integer> possibilities(Point p) {
        Set<Integer> numSet = new TreeSet<Integer>();
        for (int i = 1; i < 10; i++ ) {
            numSet.add(i);
        }
        Set<Integer> neighbors = new TreeSet<Integer>();
        for (int i = 0; i < 9; i++) {
            neighbors.add(board[(int) p.getX()][i]);
            neighbors.add(board[i][(int) p.getY()]);
        }
        /*
        if ((int) p.getX() < 3) {
            if ((int) p.getY() < 3) {
                neighbors.add(board[0][0]);
                neighbors.add(board[0][1]);
                neighbors.add(board[0][2]);
                neighbors.add(board[1][0]);
                neighbors.add(board[1][1]);
                neighbors.add(board[1][2]);
                neighbors.add(board[2][0]);
                neighbors.add(board[2][1]);
                neighbors.add(board[2][2]);
            } else if ((int) p.getY() < 6) {
                neighbors.add(board[3][0]);
                neighbors.add(board[3][1]);
                neighbors.add(board[3][2]);
                neighbors.add(board[4][0]);
                neighbors.add(board[4][1]);
                neighbors.add(board[4][2]);
                neighbors.add(board[5][0]);
                neighbors.add(board[5][1]);
                neighbors.add(board[5][2]);
            } else {
                neighbors.add(board[6][0]);
                neighbors.add(board[6][1]);
                neighbors.add(board[6][2]);
                neighbors.add(board[7][0]);
                neighbors.add(board[7][1]);
                neighbors.add(board[7][2]);
                neighbors.add(board[8][0]);
                neighbors.add(board[8][1]);
                neighbors.add(board[8][2]);
            }
        } else if ((int) p.getX() < 6) {
            if ((int) p.getY() < 3) {
                neighbors.add(board[0][3]);
                neighbors.add(board[0][4]);
                neighbors.add(board[0][5]);
                neighbors.add(board[1][3]);
                neighbors.add(board[1][4]);
                neighbors.add(board[1][5]);
                neighbors.add(board[2][3]);
                neighbors.add(board[2][4]);
                neighbors.add(board[2][5]);
            } else if ((int) p.getY() < 6) {
                neighbors.add(board[3][3]);
                neighbors.add(board[3][4]);
                neighbors.add(board[3][5]);
                neighbors.add(board[4][3]);
                neighbors.add(board[4][4]);
                neighbors.add(board[4][5]);
                neighbors.add(board[5][3]);
                neighbors.add(board[5][4]);
                neighbors.add(board[5][5]);
            } else {
                neighbors.add(board[6][3]);
                neighbors.add(board[6][4]);
                neighbors.add(board[6][5]);
                neighbors.add(board[7][3]);
                neighbors.add(board[7][4]);
                neighbors.add(board[7][5]);
                neighbors.add(board[8][3]);
                neighbors.add(board[8][4]);
                neighbors.add(board[8][5]);
            }
        } else {
            if ((int) p.getY() < 3) {
                neighbors.add(board[0][6]);
                neighbors.add(board[0][7]);
                neighbors.add(board[0][8]);
                neighbors.add(board[1][6]);
                neighbors.add(board[1][7]);
                neighbors.add(board[1][8]);
                neighbors.add(board[2][6]);
                neighbors.add(board[2][7]);
                neighbors.add(board[2][8]);
            } else if ((int) p.getY() < 6) {
                neighbors.add(board[3][6]);
                neighbors.add(board[3][7]);
                neighbors.add(board[3][8]);
                neighbors.add(board[4][6]);
                neighbors.add(board[4][7]);
                neighbors.add(board[4][8]);
                neighbors.add(board[5][6]);
                neighbors.add(board[5][7]);
                neighbors.add(board[5][8]);
            } else {
                neighbors.add(board[6][6]);
                neighbors.add(board[6][7]);
                neighbors.add(board[6][8]);
                neighbors.add(board[7][6]);
                neighbors.add(board[7][7]);
                neighbors.add(board[7][8]);
                neighbors.add(board[8][6]);
                neighbors.add(board[8][7]);
                neighbors.add(board[8][8]);
            }
        }
        */
        neighbors.remove(0);
        for (int value : neighbors) {
            numSet.remove(value);
        }
        return numSet;
    }
    
    public void firstTry() {
        for (String key : boardMap.keySet()) {
            int size = boardMap.get(key).size();
            int x = Character.getNumericValue(key.charAt(0));
            int y = Character.getNumericValue(key.charAt(1));
            if (size == 1 && (board[x][y] == 0)) {
                Set<Integer> tempSet = boardMap.get(key);
                int value = tempSet.iterator().next();
                board[x][y] = value;
                boardSetup();
            }
        }
    }

}