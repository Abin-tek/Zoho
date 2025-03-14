public abstract class Player {
    private boolean white;
    private boolean human;

    public Player(boolean white, boolean human) {
        this.white = white;
        this.human = human;
    }

    public boolean makeMove(){
        return  false;
    }
}
