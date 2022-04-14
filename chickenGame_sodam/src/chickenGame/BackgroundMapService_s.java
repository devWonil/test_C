package chickenGame;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapService_s implements Runnable {

	private BufferedImage serviceImg;
	private Player_s player;

	public BackgroundMapService_s(Player_s player) {
		this.player = player;
		try {
			serviceImg = ImageIO.read(new File("images/kitServiceRed.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		

	} // end of 생성자

	@Override
	public void run() { // class가 Runnable이라서 자동 override
		// 색상 확인
		while (true) { // 무한루프

			int pWidth = player.getWidth();
			int pHeight = player.getHeight();

			Color leftColor = new Color(serviceImg.getRGB(player.getX() + 5, player.getY() + 10));
			int leftColorInt = serviceImg.getRGB(player.getX() + 5, player.getY() + 10);

			Color rightColor = new Color(serviceImg.getRGB(player.getX() + pWidth, player.getY() + 10));
			int rightColorInt = serviceImg.getRGB(player.getX() + pWidth, player.getY() + 10);

//			Color topColor = new Color(serviceImg.getRGB(player.getX() + (pWidth / 2), player.getY()));
			int topColorInt = serviceImg.getRGB(player.getX() + 10, player.getY())
					+serviceImg.getRGB(player.getX() + 50-10, player.getY());
			
//			Color bottomColor = new Color(
//					serviceImg.getRGB(player.getX() + (pWidth / 2), player.getY() + (pHeight - 13)));
			int bottomColorInt = serviceImg.getRGB(player.getX() + 10, player.getY() + pHeight - 13)
					+ serviceImg.getRGB(player.getX() + 50 - 10, player.getY() + pHeight - 13);

			// 외벽 및 바닥충돌
			System.out.println("===========================");
			System.out.println(pWidth + "," + pHeight);
			System.out.println("leftColor: " + leftColor);
			System.out.println("leftColorInt: " + leftColorInt);
			System.out.println("rightColor: " + rightColor);
			System.out.println("rightColorInt: " + rightColorInt);

//			System.out.println("bottomColor: " + bottomColor);
			System.out.println("bottomColorInt: " + bottomColorInt);
//			System.out.println("topColor: " + topColor);
			System.out.println("topColorInt: " + topColorInt);

			if (bottomColorInt != -2) { // 바닥흰색배경이 아니면
				player.setJumpDown(false);
				player.setDown(false);
				System.out.println("바닥과 닿았어");

			} else if(topColorInt != -2){ 
				player.setUp(false);
				System.out.println("천장과 닿았어");
			}else {

			}
			
			
			
			if (leftColorInt != -1) {
				System.out.println("왼쪽벽에 충돌했어");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColorInt != -1) {
				System.out.println("오른쪽 벽에 충돌했어");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			try {
				Thread.sleep(3);// thread가 길면.. check해야하는애가 기다리고 있어서 컬러값 check못하고 떨어짐
				// 캐릭터가 이동될 때 color값을 못찾는 경우가 있다.
				// 이동속도보다 더 빠르게 움직여야 해결 가능.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end of while

	} // end of run()

} // end of class
