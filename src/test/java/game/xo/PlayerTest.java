package game.xo;

import game.data.XoSymbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    private Player player;
    private XoSymbol[][] gameField = new XoSymbol[3][3];


    @BeforeEach
    void setUp() {
        for (int i = 0; i < gameField.length; i++) {
            Arrays.fill(gameField[i], XoSymbol.EMPTY);
        }
        player = new Player(gameField, XoSymbol.X);
    }



    @Test
    void test_checkEmpty_normal_case() {

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                assertTrue(player.checkEmpty(2, 2));
            }
        }
    }

    @Test
    void test_checkEmpty_not_empty_cells() {
        gameField[0][0] = XoSymbol.X;
        gameField[1][1] = XoSymbol.O;
        assertFalse(player.checkEmpty(0, 0));
        assertFalse(player.checkEmpty(1, 1));
    }




}