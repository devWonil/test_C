package ver1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class MyFrame1 extends BackgroundMapFrameLabel {
	
	public MyFrame1() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


public class BackgroundMapFrameLabel extends JFrame implements ActionListener {

	// 배달 맵
	private BufferedImage deliveryMapImg;
	// 주방 맵
	private BufferedImage kitchenMapImg;

	// 이미지 파일명
	private String deliveryMapFileName = "images/delService.png";
	private String kitchenMapFileName = "images/kitService2.png";

	private JButton changeDeliveryMapBtn;
	private JButton changeKitchenMapBtn;

	private Player player;


	private DeliveryPanel deliveryPanel;
	private KitchenPanel kitchenPanel;
	
	int pointX = 0;
	int pointY = 0;

	public BackgroundMapFrameLabel() {
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		setTitle("치킨배달");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		player = new Player();

		kitchenPanel = new KitchenPanel();
		deliveryPanel = new DeliveryPanel();

		
		try {
			kitchenMapImg = ImageIO.read(new File(kitchenMapFileName));
			deliveryMapImg = ImageIO.read(new File(deliveryMapFileName));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}

		changeDeliveryMapBtn = new JButton("배달하기");
		changeKitchenMapBtn = new JButton("주방으로");

		changeDeliveryMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));
		changeKitchenMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));

		setVisible(true);
		//setResizable(false);

	}

	private void initSetting() {
		changeDeliveryMapBtn.setBounds(750, 700, 100, 40);
		changeKitchenMapBtn.setBounds(750, 700, 100, 40);

//		setContentPane(deliveryMapImg);
//		setContentPane(kitchenMapImg);  
			
		setLayout(null);
		add(changeKitchenMapBtn, BorderLayout.SOUTH);
		add(changeDeliveryMapBtn, BorderLayout.SOUTH);
	}

	private void initListener() {

		changeDeliveryMapBtn.addActionListener(this);
		changeKitchenMapBtn.addActionListener(this);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP) {
					System.out.println("111111111");
					player.up();
				} else if (keyCode == KeyEvent.VK_DOWN) {
					player.down();
				} else if (keyCode == KeyEvent.VK_LEFT) {
					player.left();
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					player.right();
				}

			}
		});

		this.requestFocusInWindow();

	}

	private class DeliveryPanel extends JPanel {
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(deliveryMapImg, 0, 0, 1000, 800, null);
			add(changeKitchenMapBtn, BorderLayout.SOUTH);
			
		}

	}
	
	private class KitchenPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(kitchenMapImg, 0, 0, 1000, 800, null);
			add(changeDeliveryMapBtn, BorderLayout.SOUTH);
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();
		if (changeKitchenMapBtn == targetBtn) {
			System.out.println("주방으로");
			setContentPane(kitchenPanel);
			repaint();
			this.setVisible(true);
		} else if(changeDeliveryMapBtn == targetBtn){
			System.out.println("신속배달");
			setContentPane(deliveryPanel);
			repaint();
			this.setVisible(true);
		}
//			
//			setContentPane(new JLabel(new ImageIcon("images/kitService.png")));
//			repaint();

	}

	public static void main(String[] args) {
		new BackgroundMapFrameLabel();
	}
}
