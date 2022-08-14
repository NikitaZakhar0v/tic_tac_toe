package game.data;

public enum XoSymbol {
    X("|X|"), O("|O|"), EMPTY("|_|");

    private final String title;

    XoSymbol(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
