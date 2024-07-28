package tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class GameTest {
    private Character EMPTY = Character.valueOf('-');
    private Character _PC_X = Character.valueOf('X');
    private Character _PC_Y = Character.valueOf('Y');

    @Test void emptyBoardHasNoWinner() {
        List<Character> board = Arrays.asList(
            EMPTY, EMPTY, 
            EMPTY, EMPTY 
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void horizontalWin() {
        List<Character> board = Arrays.asList(
            EMPTY, EMPTY, 
            _PC_X, _PC_X 
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void horizontalIntercepted() {
        List<Character> board = Arrays.asList(
            EMPTY, EMPTY, EMPTY, 
            EMPTY, EMPTY, EMPTY, 
            _PC_X, _PC_X, EMPTY
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void VerticalWin() {
        List<Character> board = Arrays.asList(
            EMPTY, _PC_X, 
            EMPTY, _PC_X 
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void VerticalIntercepted() {
        List<Character> board = Arrays.asList(
            EMPTY, _PC_X, 
            EMPTY, EMPTY 
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void diagonalBackWin() {
        List<Character> board = Arrays.asList(
            _PC_X, EMPTY, 
            EMPTY, _PC_X 
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void diagonalBackIntercepted() {
        List<Character> board = Arrays.asList(
            _PC_X, EMPTY, EMPTY,
            EMPTY, _PC_X, EMPTY, 
            EMPTY, _PC_X, EMPTY 
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void diagonalForwardWin() {
        List<Character> board = Arrays.asList(
            EMPTY, EMPTY, _PC_X, _PC_X,
            EMPTY, _PC_X, _PC_X, EMPTY,
            _PC_X, _PC_X, EMPTY, EMPTY,
            _PC_X, _PC_X, EMPTY, EMPTY 
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_X,tictactoe.findWinner());
    }

    @Test void diagonalForwardIntercepted() {
        List<Character> board = Arrays.asList(
            EMPTY, EMPTY, EMPTY, _PC_X,
            EMPTY, EMPTY, _PC_X, EMPTY,
            EMPTY, EMPTY, EMPTY, EMPTY,
            _PC_X, _PC_X, EMPTY, EMPTY
        );
        Game tictactoe = new Game(board);
        assertEquals(EMPTY,tictactoe.findWinner());
    }

    @Test void anRandomGame() {
        List<Character> board = Arrays.asList(
            EMPTY, EMPTY, EMPTY, _PC_X,
            EMPTY, EMPTY, _PC_X, EMPTY,
            _PC_Y, _PC_Y, _PC_Y, _PC_Y,
            _PC_X, _PC_X, EMPTY, EMPTY
        );
        Game tictactoe = new Game(board);
        assertEquals(_PC_Y,tictactoe.findWinner());
    }
}
