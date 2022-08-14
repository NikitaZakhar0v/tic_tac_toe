package game.xo;


import game.data.XoSymbol;

public class Player {
    protected XoSymbol[][] arrField;
    protected XoSymbol symbol;

    public Player(XoSymbol[][] arrField, XoSymbol symbol) {
        this.arrField = arrField;
        this.symbol = symbol;
    }



    public boolean checkEmpty(int row, int col) {
         return arrField[row][col] == XoSymbol.EMPTY;
    }


    public void makeStep(XoSymbol symbol) {
        System.out.println("Нужно переопределить");
    }

}
