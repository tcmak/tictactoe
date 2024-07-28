package tictactoe;

public class Game {
    private char _EMPTY = '-';
    private Board board;

    public Game(Board board) {
        this.board  = board;
    }

    public static void main(String[] args) {
        System.out.println("Hello TicTacToe");
    }

    interface checkFunction {
        char check();
    }

    checkFunction[] checkFunctions = new checkFunction[] {
        this::checkAllRows,
        this::checkAllCols,
        this::checkForeDiag,
        this::checkBackDiag
    };

    public char findWinner() {
        char winner = _EMPTY;

        for (checkFunction checkFunction: checkFunctions) {
            winner = checkFunction.check();
            if (winner != _EMPTY) return winner;
        }

        return _EMPTY;
    }

    private char checkForeDiag() {
        for (int i = 0; i < board.getWidth()-1; i++) 
            if (board.getCell(i, board.getWidth() - i - 1) != board.getCell(i + 1, board.getWidth() - i - 2))
                return _EMPTY;

        if (board.getCell(board.getWidth()-1, 0) == board.getCell(board.getWidth()-2, 1))
            return board.getCell(board.getWidth()-1,0);

        return _EMPTY;
    }

    private char checkBackDiag() {
        for (int i = 0; i < board.getWidth()-1; i++) {
            if (board.getCell(i, i) != board.getCell(i+1, i+1))  
                return _EMPTY;
        }

        if (board.getCell(board.getWidth()-2, (board.getWidth()-2)) == board.getCell(board.getWidth()-1, board.getWidth()-1)) 
            return board.getCell(0,0);

        return _EMPTY;
    }

    private char checkAllCols() {
        for (int i = 0; i < board.getWidth(); i++) {
            char winner = checkCol(i);
            if (winner != _EMPTY) return winner;
        }
        return _EMPTY;
    }

    private char checkCol(int col) {
        for (int i = 0; i < board.getWidth()-1; i++) 
            if (board.getCell(i, col) != board.getCell(i+1, col)) 
                return _EMPTY;

        if (board.getCell(board.getWidth()-1,col) == board.getCell(board.getWidth()-2, col))
            return board.getCell(0,col);

        return _EMPTY;
    }

    private char checkAllRows() {
        for (int i = 0; i < board.getWidth(); i++) {
            char winner = checkRow(i);
            if (winner != _EMPTY) return winner;
        }
        return _EMPTY;
    }

    private char checkRow(int row) {
        for (int i = 0; i < board.getWidth()-1; i++) 
            if (board.getCell(row, i) != board.getCell(row, i+1)) 
                return _EMPTY;

        if (board.getCell(row, board.getWidth() - 2) == board.getCell(row, board.getWidth()-1))
            return board.getCell(row,0);

        return _EMPTY;
    }
}
