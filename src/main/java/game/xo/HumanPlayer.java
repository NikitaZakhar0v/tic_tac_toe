package game.xo;



import game.data.XoSymbol;

import java.util.Scanner;


public class HumanPlayer extends Player {
    private Scanner scn = new Scanner(System.in);

    public HumanPlayer(XoSymbol[][] arrField, XoSymbol xoSymbol) {
        super(arrField, xoSymbol);
    }

    @Override
    public boolean checkEmpty(int row, int col) {
        return super.checkEmpty(row, col);
    }

    @Override
    public void makeStep(XoSymbol symbol) {
        int row, col;
        do {
            System.out.println("Enter row");
            row = scn.nextByte();
            System.out.println("Enter col");
            col = scn.nextInt();
        }while (!checkEmpty(row, col));
        arrField[row][col] = symbol;
    }
}
