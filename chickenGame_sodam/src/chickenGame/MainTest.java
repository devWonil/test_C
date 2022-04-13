package chickenGame;

public class MainTest {
	public static void main(String[] args) {
		Player player = new Player();
		
		player.left();
		player.right();
		player.kitchenUp();
		player.deliveryUp();
		player.kitchenDown();
		player.deliveryDown();
	}
}
