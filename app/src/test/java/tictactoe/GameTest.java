package tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Character EMPTY = Character.valueOf('-');
    private Character _PC_X = Character.valueOf('X');
    private Character _PC_Y = Character.valueOf('Y');

    @Test void emptyBoardHasNoWinner() {
        Board board = new Board(
            new char[][] {
                {'-', '-'},
                {'-', '-'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void horizontalWin() {
        Board board = new Board(
            new char[][] {
                {'-', '-'},
                {'X', 'X'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void horizontalIntercepted() {
        Board board = new Board(
            new char[][] {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'X', 'X', '-'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void VerticalWin() {
        Board board = new Board(
            new char[][] {
                {'-', 'X'},
                {'-', 'X'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void VerticalIntercepted() {
        Board board = new Board(
            new char[][] {
                {'-', 'X'},
                {'-', 'Y'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void diagonalBackWin() {
        Board board = new Board(
            new char[][] {
                {'X', '-'},
                {'-', 'X'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void diagonalBackIntercepted() {
        Board board = new Board(
            new char[][] {
                {'X', '-', '-'},
                {'-', 'X', '-'},
                {'-', 'X', '-'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void diagonalForwardWin() {
        Board board = new Board(
            new char[][] {
                {'-', '-', 'X', 'X'},
                {'-', 'X', 'X', '-'},
                {'X', 'X', '-', '-'},
                {'X', 'X', '-', '-'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void diagonalForwardIntercepted() {
        Board board = new Board(
            new char[][] {
                {'-', '-', '-', 'X'},
                {'-', '-', 'X', '-'},
                {'-', '-', '-', '-'},
                {'X', 'X', '-', '-'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void anRandomGame() {
        Board board = new Board(
            new char[][] {
                {'-', '-', '-', 'X'},
                {'-', '-', 'X', '-'},
                {'Y', 'Y', 'Y', 'Y'},
                {'X', 'X', '-', '-'}
            }
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_Y,tictactoe.findWinner());
    }
}
