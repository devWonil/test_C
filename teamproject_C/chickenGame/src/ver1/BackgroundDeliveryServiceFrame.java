package ver1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundDeliveryServiceFrame implements Runnable {

	private BufferedImage deliveryServiceImg;

	private Player player;

	boolean deliveryServiceOn;

	public BackgroundDeliveryServiceFrame(Player player) {
		this.player = player;
		deliveryServiceOn = true;
		try {
			deliveryServiceImg = ImageIO.read(new File("images/Map_delService.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		System.out.println("딜리버리 백그라운드 진행중");

		while (deliveryServiceOn) {

			Color leftColor = new Color(deliveryServiceImg.getRGB(player.getX() + 10, player.getY() + 40));
			int leftColorInt = deliveryServiceImg.getRGB(player.getX() + 10, player.getY() + 40);

			Color rightColor = new Color(
					deliveryServiceImg.getRGB(player.getX() + player.getWidth(), player.getY() + 40));
			int rightColorInt = deliveryServiceImg.getRGB(player.getX() + player.getWidth(), player.getY() + 40);

			Color topColor = new Color(deliveryServiceImg.getRGB(player.getX() + 22, player.getY()));
			int topColorInt = deliveryServiceImg.getRGB(player.getX() + 20, player.getY())
					+ deliveryServiceImg.getRGB(player.getX() + 55 - 20, player.getY());

			int bottomColorInt = deliveryServiceImg.getRGB(player.getX() + 20, player.getY() + player.getHeight())
					+ deliveryServiceImg.getRGB(player.getX() + 55 - 20, player.getY() + player.getHeight());

			/*
			System.out.println("leftColor: " + leftColor);
			System.out.println("leftColorInt: " + leftColorInt);
			System.out.println("rightColor: " + rightColor);
			System.out.println("rightColorInt: " + rightColorInt);
			System.out.println("topColor: " + topColor);

			System.out.println("bottomColorInt: " + bottomColorInt);
			System.out.println("topColorInt: " + topColorInt);
			System.out.println("x: " + player.getX() + " , y: " + player.getY());
			*/
			if (bottomColorInt != -2) { // 바닥흰색배경이 아니면
				//System.out.println("바닥과 닿았어");
				player.setBottomCrash(true);
				player.setDown(false);
				player.setJumpDownInKit(false);
				player.setJumpDownInDel(false);

			} else { // 바닥이 흰색이면
				//System.out.println("바닥이 흰색이야. 내려가져야해.");
				player.setBottomCrash(false);
				if (!player.isJumpUpInDel() && !player.isJumpDownInDel()) {
					player.jumpDownInDel();
				}

			}

			if (leftColorInt != -1) {
				//System.out.println("왼쪽벽에 충돌했어");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else {
				player.setLeftWallCrash(false);

			}
			if (rightColorInt != -1) {
				//System.out.println("오른쪽 벽에 충돌했어");
				player.setRightWallCrash(true);
				player.setRight(false);

			} else {
				player.setRightWallCrash(false);
			}

			if (topColorInt != -2) {
				if ((topColor.getRed() > 200 && topColor.getGreen() < 5 && topColor.getBlue() < 5)) {																								
					player.setTopCrash(true);
					player.setUp(false);
					player.setJumpUpInKit(false);
					player.setJumpUpInDel(false);
					
				} else { // red아니면 TopCrash(x)
					player.setTopCrash(false);

				}

			} else { // 흰색이면
				player.setTopCrash(false);
			}

			try {
				Thread.sleep(1);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} // end of while

	}

} // end of class