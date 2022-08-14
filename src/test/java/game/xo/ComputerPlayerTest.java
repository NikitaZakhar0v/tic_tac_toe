package game.xo;

import game.data.XoSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {
    private Player player;
    private XoSymbol[][] gameField = new XoSymbol[3][3];


    @BeforeEach
    void setUp() {
        for (int i = 0; i < gameField.length; i++) {
            Arrays.fill(gameField[i], XoSymbol.EMPTY);
        }
        player = new ComputerPlayer(gameField, XoSymbol.X);
    }


    @Test
    void test_makeStep_normal_case() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = XoSymbol.X;
            }
        }
        gameField[0][0]= XoSymbol.EMPTY;
        assertTrue(player.checkEmpty(0,0));
        player.makeStep(XoSymbol.O);
        assertFalse(player.checkEmpty(0,0));

    }
}