public abstract class Player {
    private final boolean white;
    private final boolean human;

    public Player(boolean white, boolean human) {
        this.white = white;
        this.human = human;
    }

    public boolean makeMove(){
        return  false;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isHuman() {
        return human;
    }
}
