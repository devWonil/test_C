package ver1;

import java.util.Random;

import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreCalculator extends JLabel {

	private Player player;
	
	private JLabel scoreLabel;
	
	private int grade; // 평점
	private int totalSales; // 총 매출
	
	public ScoreCalculator() {
		scoreLabel = new JLabel("SCORE");
		scoreLabel.setSize(100, 40);
		add(scoreLabel);
		setVisible(true);
	}
	
	private void completeDelivery() {
		
	}
	
	private void getDayGoal() {
		Random random = new Random();
		int goalSales = random.nextInt(10) * 10000;
	}
	
	public static void main(String[] args) {
		new ScoreCalculator();
	}
	
}
