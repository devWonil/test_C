package chickenGame;
//배치관리자

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundMapFrame_s extends JFrame implements ActionListener {

	// 배달 맵
	private JLabel deliveryMapImg;
	// 주방 맵
	private JLabel kitchenMapImg;

	// 이미지 파일명
	private String deliveryMapFileName = "images/del.png";
	private String kitchenMapFileName = "images/kit_initialState.png";

	private JButton changeDeliveryMapBtn;
	private JButton changeKitchenMapBtn;

	private JPanel deliveryMapPanel;
	private JPanel kitchenMapPanel;

	private Player_s player;

	public BackgroundMapFrame_s() {
		initData();
		setInitLayout();
		addEventListener();

//			new ScoreCalculator();
	}

	private void initData() {
		setTitle("치킨배달");
		setSize(1000, 900);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		kitchenMapImg = new JLabel(new ImageIcon(kitchenMapFileName));
		deliveryMapImg = new JLabel(new ImageIcon(deliveryMapFileName));

		changeDeliveryMapBtn = new JButton("배달하기");
		changeKitchenMapBtn = new JButton("주방으로");

		changeDeliveryMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));
		changeKitchenMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));

		deliveryMapPanel = new JPanel();
		kitchenMapPanel = new JPanel();
		player = new Player_s();
	}

	private void setInitLayout() {
		changeDeliveryMapBtn.setBounds(750, 700, 100, 40);
		changeKitchenMapBtn.setBounds(750, 700, 100, 40);

		kitchenMapImg.add(changeDeliveryMapBtn); // 주방맵에 버튼붙이기
		deliveryMapImg.add(changeKitchenMapBtn); // 배달맵에 버튼붙이기
		kitchenMapPanel.add(kitchenMapImg); // 주방맵(패널)에 주방이미지(label)붙이기
		deliveryMapPanel.add(deliveryMapImg); // 배달맵(패널)에 배달이미지(label)붙이기

		setContentPane(kitchenMapPanel); // JFrame패널에 주방맵(패널)붙이기

	
//		setResizable(false);
		kitchenMapImg.add(player);
		setVisible(true);
	 

		// TODO 왜 player안뜰깝숑??
//		setContentPane(player);
//			setIconImage((Image)player.getKitPlayerR());
//			setIconImage(player.getKitPlayerR());
//			setIcon(player.getKitPlayerR());
//			delPlayerR = new ImageIcon("images/LoopyDel_right.png");

	}

	private void addEventListener() { // 버튼누르면 패널전환하는 거 구현

		changeDeliveryMapBtn.addActionListener(this);
		changeKitchenMapBtn.addActionListener(this);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP) {
					System.out.println("111111111");

				} else if (keyCode == KeyEvent.VK_DOWN) {

				} else if (keyCode == KeyEvent.VK_LEFT) {
					player.left();
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					player.right();
				}

			}
		});

		this.requestFocusInWindow();
	} // end of addEventListener

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();
		if (changeDeliveryMapBtn == targetBtn) {
			System.out.println("신속배달");
			setContentPane(deliveryMapPanel);
			repaint();
			setVisible(true);

		} else if (changeKitchenMapBtn == targetBtn) {
			System.out.println("주방으로");
			setContentPane(kitchenMapPanel);
			repaint();
			setVisible(true);
		}
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new BackgroundMapFrame_s();
	}

} // end of class

////<소담 테스트 코드>

//package chickenGame;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//public class BackgroundMapFrame_s extends JFrame {
//
//	private JLabel backgroundMap;
//	private Player_s player;
//
//	public BackgroundMapFrame_s() {
//		initObject();
//		initSetting();
//		initListener();
//
//		setVisible(true);
//		setResizable(false);
//
//	}
//
//	private void initObject() {
////		backgroundMap = new JLabel(new ImageIcon("images/kit_initialState.png"));
////		setContentPane(backgroundMap);
//
//		backgroundMap = new JLabel(new ImageIcon("images/kitServiceRed.jpg"));
//		setContentPane(backgroundMap);
//
//		player = new Player_s();
//		add(player);
//		setContentPane(backgroundMap);
//
//
//	}
//
//	private void initSetting() {
//		setTitle("C조의 치킨배달게임");
//		setSize(1000, 900); // 원래 이미지 사이즈는 1000* 800임
//		
//		//player y좌표: 720
//		setLayout(null); // CSS의 absolute개념. 좌표값으로 자유롭게 그릴 수 있다.
//
//		setLocationRelativeTo(null);// JFrame윈도우 창의 가운데에 배치
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//	private void initListener() {
//		addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//
//				System.out.println("---");
//				System.out.println(e.getKeyCode());
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_LEFT:
//					if (!player.isLeft()) {
//						player.left();
//					}
//					break;
//				case KeyEvent.VK_RIGHT:
//					if (!player.isRight()) {
//						player.right();
//					}
//					break;
//
//				case KeyEvent.VK_UP:
//					if (!player.isUp()) {
//						player.up();
//					}
//					break;
//
//				case KeyEvent.VK_DOWN:
//					if (!player.isDown()) {
//						player.down();
//					}
//					break;
//				case KeyEvent.VK_SPACE:
//					if (!player.isJumpUp() && !player.isJumpDown()) {
//						System.out.println("space 점프");
//						player.jumpUp();
//					}
//
//					break;
//
//				case 71: // 상호작용 G키
//					System.out.println("G 상호작용");
//					break;
//				default:
//					break;
//
//				} // end of switch
//			} // end of keyPressed
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_LEFT:
//					player.setLeft(false);
//					break;
//				case KeyEvent.VK_RIGHT:
//					player.setRight(false);
//					break;
//				case KeyEvent.VK_UP:
//					player.setUp(false);
//					break;
//				case KeyEvent.VK_DOWN:
//					player.setDown(false);
//					break;
//				case KeyEvent.VK_SPACE:
//					break;
//				case 71: // G 상호작용
//					break;
//				default:
//					break;
//				}
//			}
//
//		}); // end of addKeyListener
//	}
//
//	public static void main(String[] args) {
//		new BackgroundMapFrame_s();
//
//	} // end of main
//} // end of class