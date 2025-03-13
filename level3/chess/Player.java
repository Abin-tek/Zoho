public abstract class Player {
    private boolean white;
    private boolean robot;

    public Player(boolean white, boolean robot) {
        this.white = white;
        this.robot = robot;
    }

    public boolean makeMove(){
        return  false;
    }
}
