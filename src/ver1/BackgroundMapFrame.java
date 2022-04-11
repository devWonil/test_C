package ver1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundMapFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	private JPanel panel1;
	private JPanel panel2;
	
	private JButton changeBtn;
	
	public BackgroundMapFrame() {
		initObject();
		initSetting();
		initListener();
		changePanel();
		
		
	}
	
	private void initObject() {
		setTitle("치킨배달");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		changeBtn = new JButton("change");
	}
	
	private void initSetting() {
		setVisible(true);
		//panel1.setLayout(new FlowLayout(FlowLayout.));
		add(panel1);
		
		panel1.add(changeBtn);
	}
	
	private void initListener() {
		
	}
	
	private void changePanel() {
		changeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("화면 전환");
			}
		});
	}
	

}
