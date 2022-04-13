package chickenGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackgroundMapFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BackgroundMapFrame() {
		initObject();
		initSetting();
		initListener();

		setVisible(true);

	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/kit_notOrder.png"));
		setContentPane(backgroundMap);

		player = new Player();
		add(player);

	}

	private void initSetting() {
		setSize(1200, 1000);
		setLayout(null); // CSS의 absolute개념. 좌표값으로 자유롭게 그릴 수 있다.

		setLocationRelativeTo(null);// JFrame윈도우 창의 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight()) {
						player.right();
					}
					break;

				case KeyEvent.VK_UP:
					if (!player.isKitchenUp()) {
						player.kitchenUp();
					}
					break;

				case KeyEvent.VK_DOWN:
					if (!player.isKitchenDown()) {
						player.kitchenDown();
					}
					break;

				default:
					break;

				} // end of switch
			} // end of keyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setKitchenUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player.setKitchenDown(false);
					break;
				default:
					break;
				}
			}

		}); // end of addKeyListener
	}

	public static void main(String[] args) {
		new BackgroundMapFrame();

	} // end of main
} // end of class
