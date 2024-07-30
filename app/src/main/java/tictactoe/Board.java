package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Character> board = new ArrayList<Character>();
    private int width = 0;

    public Board (char[][] board) {
        for (char[] row: board) 
            for (char cell: row) 
                this.board.add(cell);
        setWidth();
    }

    private void setWidth() {
        this.width = (int)Math.sqrt(board.size());
    }

    public int getWidth() {
        return this.width;
    }

    public Character getCell(int row, int col) {
        return board.get(row * getWidth() + col);
    }
}
