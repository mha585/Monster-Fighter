import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PrepScreen {

	private JFrame prepScreen;
	private MonsterManager manager;
	private RandomGen num;
	private boolean canPressFight;

	/**
	 * Create the prep screen.
	 * @param incomingManager 	The manager responsible for creating this screen
	 * @param number 			The RandomGen used to generate random events
	 * @param canFight 			Checks if the player can fight yet
	 */
	public PrepScreen(MonsterManager incomingManager, RandomGen number, boolean canFight) {
		manager = incomingManager;
		num = number;
		canPressFight = canFight;
		initialize();
		prepScreen.setVisible(true);
	}
	/**
	 * Closes the window
	 */
	public void closeWindow() {
		prepScreen.dispose();
	}
	/**
	 * checks if its the final day
	 * @return 		boolean of if its the final day
	 */
	public boolean isItTheFinalDay() {
		if (manager.getPlayer().getCurrentDay() >= manager.getPlayer().getPlayerDay()) {
			return true;
		}
		return false;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		prepScreen = new JFrame();
		prepScreen.setTitle("Day prep");
		prepScreen.setBounds(100, 100, 960, 540);
		prepScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDay = new JLabel("Current Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblDayNum = new JLabel("New label");
		lblDayNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDayNum.setText(Integer.toString(manager.getPlayer().getCurrentDay()));
		
		JLabel lblPointsNum = new JLabel("New label");
		lblPointsNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPointsNum.setText(Integer.toString(manager.getPlayer().getPoints()));
		
		JLabel lblMoneyNum = new JLabel("New label");
		lblMoneyNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoneyNum.setText(Integer.toString(manager.getPlayer().getMoney()));
		
		JLabel lblViewBattlesInstructions = new JLabel("Please view battles before fighting");
		lblViewBattlesInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnTeam = new JButton("View Team");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchTeamScreen("Prep", num);
			}
		});
		btnTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnBattles = new JButton("View Battles");
		btnBattles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchTodaysBattlesScreen(num);
			}
		});
		btnBattles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnBag = new JButton("View Bag");
		btnBag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Prep", num);
			}
		});
		btnBag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnFight = new JButton("Fight");
		if (!canPressFight) {
			btnFight.setEnabled(false);
		} else {
			lblViewBattlesInstructions.setVisible(false);
			btnFight.setEnabled(true);
		}
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				if (isItTheFinalDay()) {
					manager.launchBattleScreen(true, num, "This is it the final battle!!");
				} else {
					manager.launchBattleScreen(false, num, "");
				}
//				manager.launchBattleScreen(true, num, "", false);
			}
		});
		btnFight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		if (isItTheFinalDay()) {
			lblViewBattlesInstructions.setText("Your next battle will be your last, get ready");
			btnFight.setEnabled(true);
			btnBattles.setEnabled(false);
		}

		GroupLayout groupLayout = new GroupLayout(prepScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(408)
					.addComponent(btnFight, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(379, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDay)
							.addGap(18)
							.addComponent(lblDayNum, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnTeam, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPoints)
							.addGap(18)
							.addComponent(lblPointsNum, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBag, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMoney)
							.addGap(18)
							.addComponent(lblMoneyNum, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBattles, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(366)
					.addComponent(lblViewBattlesInstructions, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(333, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDayNum, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPoints, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPointsNum, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoneyNum, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTeam, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBag, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBattles, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(lblViewBattlesInstructions, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnFight, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		prepScreen.getContentPane().setLayout(groupLayout);
	}
}
