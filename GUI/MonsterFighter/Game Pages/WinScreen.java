import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WinScreen {

	private JFrame winFrame;
	private MonsterManager manager;

	/**
	 * Create the application.
	 */
	public WinScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		winFrame.setVisible(true);
	}
	
	public void closeWindow() {
		winFrame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		winFrame = new JFrame();
		winFrame.setBounds(100, 100, 960, 540);
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblGame = new JLabel("G A M E    O V E R");
		lblGame.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblYouWin = new JLabel("YOU WIN!");
		lblYouWin.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouWin.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblName = new JLabel("");
		lblName.setText("Name: " + manager.getPlayer().getPlayerName());
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblDays = new JLabel("");
		lblDays.setText("Days Completed: " + manager.getPlayer().getCurrentDay());
		lblDays.setHorizontalAlignment(SwingConstants.LEFT);
		lblDays.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblMoney = new JLabel("");
		lblMoney.setText("Total Money Earned: " + manager.getPlayer().getMoneyEarned());
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMoney.setText("Total Points Earned: " + manager.getPlayer().getPoints());
		
		JLabel lblPoints = new JLabel("");
		lblPoints.setText("Total Points Earned: " + manager.getPlayer().getPoints());
		lblPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(winFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(304)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDays, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
							.addGap(56))
						.addComponent(lblMoney, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
						.addComponent(lblYouWin, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGame, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPoints, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
							.addGap(27)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGame, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblYouWin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDays, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPoints, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		winFrame.getContentPane().setLayout(groupLayout);
	}
}
