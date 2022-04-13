package ver1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackgroundMapFrame_sodam extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BackgroundMapFrame_sodam() {
		initObject();
		initSetting();
		initListener();

		setVisible(true);

	}

	private void initObject() {
//		backgroundMap = new JLabel(new ImageIcon("images/kit_initialState.png"));
//		setContentPane(backgroundMap);

		backgroundMap = new JLabel(new ImageIcon("images/kitService.png"));
		setContentPane(backgroundMap);

		player = new Player();
		add(player);

	}

	private void initSetting() {
		setTitle("C조의 치킨배달게임");
		setSize(1000, 900);
		setLayout(null); // CSS의 absolute개념. 좌표값으로 자유롭게 그릴 수 있다.

		setLocationRelativeTo(null);// JFrame윈도우 창의 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				System.out.println("---");
				System.out.println(e.getKeyCode());
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
					if (!player.isUp()) {
						player.up();
					}
					break;

				case KeyEvent.VK_DOWN:
					if (!player.isDown()) {
						player.down();
					}
					break;
				case KeyEvent.VK_SPACE:
					if (!player.isJumpUp() && !player.isJumpDown()) {
						System.out.println("space 점프");
						player.jumpUp();
					}

					break;

				case 71: // 상호작용 G키
					System.out.println("G 상호작용");
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
					player.setUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;
				case KeyEvent.VK_SPACE:
					break;
				case 71: // G 상호작용
					break;
				default:
					break;
				}
			}

		}); // end of addKeyListener
	}

	public static void main(String[] args) {
		new BackgroundMapFrame_sodam();

	} // end of main
} // end of class
