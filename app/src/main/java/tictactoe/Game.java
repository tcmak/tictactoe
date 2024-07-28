package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private char _EMPTY = '-';
    private ArrayList<Character> board;
    private int width = 0;

    public Game(List<Character> board) {
        this.board = new ArrayList<Character>(board);
        this.width = (int)Math.sqrt(board.size());
    }

    public static void main(String[] args) {
        System.out.println("Hello TicTacToe");
    }

    public char findWinner() {
        char winner = _EMPTY;

        winner = checkAllRows();
        if (winner != _EMPTY) return winner;

        winner = checkAllCols();
        if (winner != _EMPTY) return winner;

        winner = checkBackDiag();
        if (winner != _EMPTY) return winner;

        winner = checkForeDiag();
        if (winner != _EMPTY) return winner;

        return _EMPTY;
    }

    private char checkForeDiag() {
        for (int i = 0; i < width-1; i++) 
            if (board.get(getIndex(i, width - i - 1)) != board.get(getIndex(i + 1, width - i - 2)))
                return _EMPTY;

        if (board.get(getIndex(width-1, 0)) == board.get(getIndex(width-2, 1)))
            return board.get(getIndex(width-1,0));

        return _EMPTY;
    }

    private char checkBackDiag() {
        for (int i = 0; i < width-1; i++) {
            if (board.get(getIndex(i, i)) != board.get(getIndex(i+1, i+1)))  
                return _EMPTY;
        }

        if (board.get(getIndex(width-2, (width-2))) == board.get(getIndex(width-1, width-1))) 
            return board.get(0);

        return _EMPTY;
    }

    private char checkAllCols() {
        for (int i = 0; i < width; i++) {
            char winner = checkCol(i);
            if (winner != _EMPTY) return winner;
        }
        return _EMPTY;
    }

    private char checkCol(int col) {
        for (int i = 0; i < width-1; i++) 
            if (board.get(getIndex(i, col)) != board.get(getIndex(i+1, col))) 
                return _EMPTY;

        if (board.get(getIndex(width-1,col)) == board.get(getIndex(width-2, col)))
            return board.get(col);

        return _EMPTY;
    }

    private char checkAllRows() {
        for (int i = 0; i < width; i++) {
            char winner = checkRow(i);
            if (winner != _EMPTY) return winner;
        }
        return _EMPTY;
    }

    private char checkRow(int row) {
        for (int i = 0; i < width-1; i++) 
            if (board.get(getIndex(row, i)) != board.get(getIndex(row, i+1))) 
                return _EMPTY;

        if (board.get(getIndex(row, width - 2)) == board.get(getIndex(row, width-1)))
            return board.get(getIndex(row,0));

        return _EMPTY;
    }

    private int getIndex(int row, int col) {
        return row * width + col;
    }
}
