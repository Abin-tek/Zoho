
public class Main {


	public static void main(String[] args) {
		Robot robot = new Robot();
		Human human = new Human();
		Game game = new Game(robot, human);

		game.start();

		System.out.println("Game over!");
	}

}

