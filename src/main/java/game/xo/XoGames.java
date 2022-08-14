package game.xo;


import game.data.XoSymbol;
import game.service.ConsoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Данный класс содержит методы для запуска игры Крестики-нолики,
 * а также методы для проверки правильности ходов игроков на правильные координаты, занятые ячейки,
 * а также методып проверки завершения игры: проверка на победителя, на начью
 */
@Service
public class XoGames {
    private XoSymbol[][] gameField = new XoSymbol[3][3];
    private final ConsoleService consoleService;

    /**
     * Конструктор заполняет игровое поле размером 3х3 пустыми ячейками
     */

    public XoGames() {
        fillBoard();
        this.consoleService = new ConsoleService();
    }

    /**
     * Метод запускает консольное меню, где предлагает выбрать один из трех вариантов игры:
     * 1. Человек против человека
     * 2. Человек против компьютера
     * 3. Компьютер против Компьютера
     *
     */
    public void startGame() {
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");

        int input = consoleService.readInt();
        int turn = 0;
        Player player1 = null;
        Player player2 = null;
        switch (input) {
            case 1: {
                player1 = new HumanPlayer(gameField, XoSymbol.X);
                player2 = new HumanPlayer(gameField, XoSymbol.O);
                break;
            }
            case 2: {
                player1 = new HumanPlayer(gameField, XoSymbol.X);
                player2 = new ComputerPlayer(gameField, XoSymbol.O);
                break;
            }

            case 3: {
                player1 = new ComputerPlayer(gameField, XoSymbol.X);
                player2 = new ComputerPlayer(gameField, XoSymbol.O);
                break;
            }
        }
        String finishResult = null;
        Player currentPlayer = null;
        printBoard();
        do {
            if (turn % 2 == 0) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            currentPlayer.makeStep(currentPlayer.symbol);
            turn++;
            printBoard();
        } while ((finishResult = getFinishResult(currentPlayer.symbol)) == null);
        System.out.println("Игра завершилась");
        System.out.println(finishResult);
    }

    /**
     * Метод проверяет игру на наличие победителя или ничьи. Если он находит победителя или ничью, метод возвращает сообщение
     * с информацией о причине завершения игры
     * @param symbol символ игрока, который только что сделал ход
     * @return сообщение с информацией о победителе или о ничье
     */
    public String getFinishResult(XoSymbol symbol) {
        if (checkWin(symbol)) return symbol == XoSymbol.X ? "Победа кристиков" : "Победа ноликов";
        if (isDraw()) return "Ничья";
        return null;
    }

    public XoSymbol[][] getGameField() {
        return gameField;
    }


    private void fillBoard() {

        for (int i = 0; i < gameField.length; i++) {
            Arrays.fill(gameField[i], XoSymbol.EMPTY);
        }
    }

    public boolean isDraw() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == XoSymbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCellValid(int row, int col) {
        return row >= 0 && row <= 2 && col >= 0 && col <= 2;
    }

    private void printBoard() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }

    public boolean checkWin(XoSymbol xoSymbol) {
        for (int i = 0; i < gameField.length; i++) {
            if ((gameField[i][0].equals(xoSymbol) && gameField[i][1].equals(xoSymbol) &&
                    gameField[i][2].equals(xoSymbol)) ||
                    (gameField[0][i].equals(xoSymbol) && gameField[1][i].equals(xoSymbol) &&
                            gameField[2][i].equals(xoSymbol)))
                return true;
        }
        return (gameField[0][0].equals(xoSymbol) && gameField[1][1].equals(xoSymbol) &&
                gameField[2][2].equals(xoSymbol)) ||
                (gameField[2][0].equals(xoSymbol) && gameField[1][1].equals(xoSymbol) &&
                        gameField[0][2].equals(xoSymbol));
    }

    private void setStepBoard(XoSymbol board, int row, int col) {
        if (gameField[row][col] == XoSymbol.EMPTY) {
            gameField[row][col] = board;
//            return true;
        }
//        return false;
    }
//    private int[] readValidCoords(Player currentPlayer) {
//
//        while (true) {
//            int row = currentPlayer.getRow();
//            int col = currentPlayer.getCol();
//            if (Field.checkRowCol(row, col)) {
//                return new int[]{row, col};
//            }
//}
//}
}