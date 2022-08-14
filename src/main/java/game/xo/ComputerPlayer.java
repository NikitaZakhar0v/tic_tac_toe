package game.xo;


import game.data.XoSymbol;

public class ComputerPlayer extends Player {


    public ComputerPlayer(XoSymbol[][] arrField, XoSymbol symbol) {
        super(arrField, symbol);
    }



    @Override
    public void makeStep(XoSymbol symbol) {
        int row, col;
         do{
            row = (int) (Math.random() * arrField.length);
            col = (int) (Math.random() * arrField.length);
        }while (!checkEmpty(row, col));
        System.out.println("Ход компьютера:");
        arrField[row][col] = symbol;
    }
}
