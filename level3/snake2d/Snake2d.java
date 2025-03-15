import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Snake2d {
    public static void main(String[] args) {
        SnakeGame snake_game = new SnakeGame(10, 10);
        snake_game.start();
    }
}
