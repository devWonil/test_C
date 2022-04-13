package chickenGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class BackgroundMapFrame_wonil extends JFrame implements ActionListener {

	private BufferedImage bgImage;
	private BufferedImage image2;

	private String bgImageFileName = "images/kitService2.png";
	private String image2FileName = "images/LoopyKit_left.png";

	private JButton changeBtn;
	private JPanel bottomPanel;

	private CustomJpanel customJPanel;

	int xPoint = 500;
	int yPoint = 600;
	int image3xPoint = 0;

	public BackgroundMapFrame_wonil() {
		initData();
		setInitLayout();
		addEventListener();

		// 생성자에서 Thread start 처리
		Thread thread = new Thread(customJPanel);
		thread.start();
	}

	private void initData() {
		setTitle("치킨배달");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changeBtn = new JButton("배달");

		// 파일 가져오기 todo
		try {
			bgImage = ImageIO.read(new File(bgImageFileName));
			image2 = ImageIO.read(new File(image2FileName));
		} catch (IOException e) {
			System.out.println("파일이 없습니다");
		}
		customJPanel = new CustomJpanel();

		bottomPanel = new JPanel(new FlowLayout());

	}

	private void setInitLayout() {

		bottomPanel.add(changeBtn);

		add(customJPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		setVisible(true);
		// setResizable(false);

		// add(imagePanel);
		this.requestFocusInWindow();

	}

	private void addEventListener() {

		changeBtn.addActionListener(this);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 여기서는 이미지 2번을 키 이벤트를 받아서 동작
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP) {
					// yPoint -= 10;
					yPoint = (yPoint < 0) ? 0 : yPoint - 10;
				} else if (keyCode == KeyEvent.VK_DOWN) {
					// yPoint += 10;
					yPoint = (yPoint > bgImage.getHeight()) ? bgImage.getHeight() : yPoint + 10;
				} else if (keyCode == KeyEvent.VK_LEFT) {
					xPoint = (xPoint < 0) ? 0 : xPoint - 10;
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					xPoint = (xPoint > bgImage.getHeight()) ? bgImage.getHeight() : xPoint + 10;
				}

				repaint();
			}
		});
		// 버튼 동작
		this.requestFocusInWindow();
	} // end of addEventListener

	// 내부 클래스
	private class CustomJpanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지를 3개 그리기
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(image2, xPoint, yPoint, 55, 80, null);
		}

		@Override
		public void run() {

		}
	} // end of inner class

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();
		if (changeBtn == targetBtn) {
			System.out.println("신속배달");
		}
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new BackgroundMapFrame_wonil();
	}
}
