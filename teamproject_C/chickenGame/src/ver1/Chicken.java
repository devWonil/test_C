package ver1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Chicken extends JLabel implements Moveable {

	// 의존성 컴포지션
	private Player player;
	// 위치 상태
	private int x;
	private int y;

	private Chicken chickenContext = this;
	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어가 가진 상태
	private int state;

	private final int CHICKEN_PRICE = 19000;

	private ImageIcon raw; // 생닭
	private ImageIcon pos1; // 주문없음
	private ImageIcon pos2; // 주문들어옴
	private ImageIcon sauce; // 양념통
	private ImageIcon sauceP; // 양념방울
	private ImageIcon oilP; // 기름방울
	private ImageIcon plate; // 접시
	private ImageIcon box1; // 빈박스
	private ImageIcon box2; // 치킨담은 박스
	private ImageIcon box3; // 포장된 박스
	private ImageIcon chicDummy1; // 치킨반죽더미
	private ImageIcon chicDummy2; // 후라이드치킨더미
	private ImageIcon chicDummy3; // 양념치킨더미
	private ImageIcon chicP1; // 치킨반죽 1조각
	private ImageIcon chicP2; // 후라이드치킨 1조각
	private ImageIcon chicP3; // 양념치킨 1조각
	private ImageIcon frying1; // 튀겨지는 중
	private ImageIcon frying2; // 튀기기 완료
	private ImageIcon emptyNet; // 빈 튀김통
	private ImageIcon order; // 빈 튀김통

	Sales sales = new Sales();
	// 의존 주입 --> 생성자에 주입을 받는다
	public Chicken(Player player) {
		this.player = player;
		initObject();
		initSetting();
		initThread();
	}

	private void initObject() {
		raw = new ImageIcon("images/raw.png");
		pos1 = new ImageIcon("images/pos1.png");
		pos2 = new ImageIcon("images/pos2.png");
		sauce = new ImageIcon("images/sauce.png");
		sauceP = new ImageIcon("images/sauceP.png");
		oilP = new ImageIcon("images/oilP.png");
		plate = new ImageIcon("images/plate.png");
		box1 = new ImageIcon("images/box1.png");
		box2 = new ImageIcon("images/box2.png");
		box3 = new ImageIcon("images/box3.png");
		chicDummy1 = new ImageIcon("images/chicDummy1.png");
		chicDummy2 = new ImageIcon("images/chicDummy2.png");
		chicDummy3 = new ImageIcon("images/chicDummy3.png");
		chicP1 = new ImageIcon("images/chicP1.png");
		chicP2 = new ImageIcon("images/chicP2.png");
		chicP3 = new ImageIcon("images/chicP3.png");
		frying1 = new ImageIcon("images/frying1.png");
		frying2 = new ImageIcon("images/frying2.png");
		emptyNet = new ImageIcon("images/emptyNet.png");
		order = new ImageIcon("images/order.png");

	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;
		down = false;

		x = player.getX();
		y = player.getY();
		Sales sales = new Sales();
		
		if (player.getBackgroundKitchenService().kitchenServiceOn) {

			if (x <= 240 && (508 <= y && y <= 604)) { // order
				setIcon(order);
				setSize(135, 27);
				System.out.println("주문을 받습니다");
				System.out.println("배달지는 " + sales.getRandomAddress() + "번집");
				
			} else if (x >= 700 && (400 <= y && y <= 504)) { // 냉장고
				setIcon(raw);
				setSize(40, 44);
				System.out.println("냉장고에서 생닭을 꺼냅니다");
			} else if (x <= 280 && (332 <= y && y <= 420)) { // 반죽
				setIcon(chicDummy1);
				setSize(100, 55);
				System.out.println("생닭을 반죽합니다");
			} else if (x <= 280 && (172 <= y && y <= 228)) {
				setIcon(frying1);
				setSize(200, 98);
				System.out.println("반죽을 튀깁니다");
			} else if (x <= 280 && (24 <= y && y <= 72)) {
				setIcon(frying2);
				setSize(200, 95);
				System.out.println("한 번 더 튀깁니다");
			} else if ((550 <= x && x <= 658) && (24 <= y && y <= 96)) {
				setIcon(chicDummy3);
				setSize(80, 50);
				System.out.println("양념합니다");
			} else if ((550 <= x && x <= 658) && (212 <= y && y <= 308)) {
				setIcon(box3);
				setSize(100, 87);
				System.out.println("포장합니다");
				
			}
		} else if(player.getBackgroundDeliveryService().deliveryServiceOn){
			
			if ((0 <= x && x < 173) && (0 <= y && y < 181)) {
				if(sales.address == 1) {
					System.out.println("1번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("1번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}
			if ((0 <= x && x < 141) && (182 <= y && y < 384)) {
				if(sales.address == 2) {
					System.out.println("2번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("2번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}

			if ((400 <= x && x < 631) && (0 <= y && y < 167)) {
				if(sales.address == 3) {
					System.out.println("3번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("3번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}

			if ((360 <= x && x < 422) && (240 <= y && y < 400)) {
				if(sales.address == 4) {
					System.out.println("4번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("4번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}

			if ((356 <= x && x < 487) && (393 <= y && y < 570)) {
				if(sales.address == 5) {
					System.out.println("5번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("5번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}

			if ((402 <= x && x < 648) && (240 <= y && y < 392)) {
				if(sales.address == 6) {
					System.out.println("6번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("6번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}

			if ((830 <= x && x < 945) && (0 <= y && y < 112)) {
				if(sales.address == 7) {
					System.out.println("7번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("7번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}

			if ((820 <= x && x < 945) && (408 <= y && y < 568)) {
				if(sales.address == 8) {
					System.out.println("8번집 배달");
					setIcon(box3);
					setSize(100, 87);
					player.setCompleteDelivery(true);
					System.out.println("8번집 배달완료");
					//new BackgroundMapFrame();
				}else {
					System.out.println("잘 못된 배달주소입니다");
					player.setCompleteDelivery(false);
				}
				
			}
		} else {
			System.out.println("맵 오류");
		}

		state = 0;
	}

	
	
	private void initThread() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (player.getPlayerWay() == PlayerWay.LEFT) {
					left();
				} else {
					right();
				}
			}
		}).start();

	}

	@Override
	public void left() {
		left = true;
		if (player.getBackgroundKitchenService().kitchenServiceOn) {
			for (int i = 0; i < 180; i++) {
				x--;
				setLocation(x, y);
			}
		}else {
			for (int i = 0; i < 50; i++) {
				x--;
				setLocation(x, y);
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		left = false; // 상태변수 초기화
		removeChicken();
	}

	@Override
	public void right() {
		right = true;
		if (player.getBackgroundKitchenService().kitchenServiceOn) {
			for (int i = 0; i < 180; i++) {
				x++;
				setLocation(x, y);
			}
		}else {
			for (int i = 0; i < 50; i++) {
				x++;
				setLocation(x, y);
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		right = false; // 상태변수 초기화
		removeChicken();
	}

	private void removeChicken() {
		
		try {
			
			Thread.sleep(1000);
			chickenContext = null;
			setIcon(null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void up() {
		// TODO Auto-generated method stub

	}

	@Override
	public void down() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jumpUpInKit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jumpDownInKit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jumpUpInDel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jumpDownInDel() {
		// TODO Auto-generated method stub

	}

}