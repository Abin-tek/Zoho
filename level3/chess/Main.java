public class Main {

   public static void main(String[] args) {
        Robot robot = new Robot(false);
        Human human = new Human(true);
        Game game = new Game(human, robot);
        game.start();
    }

}