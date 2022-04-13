package chickenGame;

import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class changePanel_sodam {
	// 버튼
	private BufferedImage backgroundImage;
	static JButton b1 = new JButton("버튼1");

	// 패널
	static JPanel page1 = new JPanel() {
		// 이미지
		backgroundImage = ImageIO.read(new File("images/kitService2.png"));

		public void paint(Graphics g) {
			g.drawImage(background, 0, 0, null);
		}



} // end of class
