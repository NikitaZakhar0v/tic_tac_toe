package game.xo;

import game.data.XoSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class XoGamesTest {
    private XoGames game;


    @BeforeEach
    void setUp() {

        game =new XoGames();
    }



    @Test
    void test_isDraw() {
        assertFalse(game.isDraw());
        XoSymbol[][] gameField = game.getGameField();
        gameField[0][0] = XoSymbol.X;
        gameField[1][0] = XoSymbol.O;
        gameField[2][0] = XoSymbol.X;

        gameField[0][1] = XoSymbol.O;
        gameField[1][1] = XoSymbol.X;
        gameField[2][1] = XoSymbol.O;

        gameField[0][2] = XoSymbol.X;
        gameField[1][2] = XoSymbol.O;
        gameField[2][2] = XoSymbol.X;

        assertTrue(game.isDraw());
    }

    @Test
    void test_isCellValid_normal_case() {
        XoSymbol[][] gameField = game.getGameField();
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                assertTrue(game.isCellValid(i, j));
            }
        }

    }

    @Test
    void test_isCellValid_not_existing_cells() {
        XoSymbol[][] gameField = game.getGameField();
        assertFalse(game.isCellValid(-1, -1));
        assertFalse(game.isCellValid(gameField.length, 0));
        assertFalse(game.isCellValid(0, gameField[0].length));
        assertFalse(game.isCellValid(gameField.length, gameField[0].length));

    }


    @Test
    void test_checkWin_diagonal_winner() {
        XoSymbol[][] gameField = game.getGameField();
        gameField[0][0] = XoSymbol.X;
        gameField[1][1] = XoSymbol.X;
        gameField[2][2] = XoSymbol.X;
        assertTrue(game.checkWin(XoSymbol.X));

        gameField[0][0] = XoSymbol.O;
        gameField[1][1] = XoSymbol.O;
        gameField[2][2] = XoSymbol.O;
        assertTrue(game.checkWin(XoSymbol.O));


    }

    @Test
    void test_checkWin_vertical_winner() {
        XoSymbol[][] gameField = game.getGameField();
        gameField[0][0] = XoSymbol.X;
        gameField[1][0] = XoSymbol.X;
        gameField[2][0] = XoSymbol.X;
        assertTrue(game.checkWin(XoSymbol.X));
        gameField[0][0] = XoSymbol.O;
        gameField[1][0] = XoSymbol.O;
        gameField[2][0] = XoSymbol.O;
        assertTrue(game.checkWin(XoSymbol.O));

    }

    @Test
    void test_checkWin_horizontal_winner() {
        XoSymbol[][] gameField = game.getGameField();
        gameField[0][0] = XoSymbol.X;
        gameField[0][1] = XoSymbol.X;
        gameField[0][2] = XoSymbol.X;
        assertTrue(game.checkWin(XoSymbol.X));
        gameField[0][0] = XoSymbol.O;
        gameField[0][1] = XoSymbol.O;
        gameField[0][2] = XoSymbol.O;
        assertTrue(game.checkWin(XoSymbol.O));

    }

}