import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoseScreen {

	private JFrame loseFrame;
	private MonsterManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoseScreen window = new LoseScreen();
//					window.loseFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public LoseScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		loseFrame.setVisible(true);
	}
	
	public void closeWindow() {
		loseFrame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loseFrame = new JFrame();
		loseFrame.getContentPane().setBackground(SystemColor.desktop);
		loseFrame.setBounds(100, 100, 960, 540);
		loseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblGame = new JLabel("G A M E    O V E R");
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setForeground(Color.WHITE);
		lblGame.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblLose = new JLabel("YOU LOSE!");
		lblLose.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose.setForeground(Color.WHITE);
		lblLose.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel("iMAGE");
		lblNewLabel.setForeground(SystemColor.window);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblDays = new JLabel("Days Completed:");
		lblDays.setHorizontalAlignment(SwingConstants.LEFT);
		lblDays.setForeground(Color.WHITE);
		lblDays.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblMoney = new JLabel("Total Money Earned:");
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblPoints = new JLabel("Total Points Earned:");
		lblPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(loseFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(311, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLose, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGame, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDays, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPoints, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
							.addGap(309))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(449))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGame, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLose, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addComponent(lblNewLabel)
					.addGap(85)
					.addComponent(lblName)
					.addGap(18)
					.addComponent(lblDays)
					.addGap(18)
					.addComponent(lblMoney)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPoints, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		loseFrame.getContentPane().setLayout(groupLayout);
	}

}
