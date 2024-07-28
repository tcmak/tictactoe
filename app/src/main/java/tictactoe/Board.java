package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Character> board = new ArrayList<Character>();

    public Board (List<Character> board) {
        this.board = board;
    }

    public Board (char[][] board) {
        for (char[] row: board) 
            for (char cell: row) 
                this.board.add(cell);
    }

    public int getWidth() {
        return (int)Math.sqrt(board.size());
    }

    public Character getCell(int row, int col) {
        return board.get(row * getWidth() + col);
    }
}
