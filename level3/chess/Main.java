import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        Robot robot = new Robot(false);
        Human human = new Human(true);
        Game game = new Game(human, robot);

        System.out.println(game.getStatus());
        SwingUtilities.invokeLater(ChessBoard::new);
        game.start();
        System.out.println(game.getStatus());
    }

}

