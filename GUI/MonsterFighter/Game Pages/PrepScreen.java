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

public class PrepScreen {

	private JFrame prepScreen;
	private MonsterManager manager;
	private RandomGen num;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PrepScreen window = new PrepScreen();
//					window.prepScreen.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PrepScreen(MonsterManager incomingManager, RandomGen number) {
		manager = incomingManager;
		num = number;
		initialize();
		prepScreen.setVisible(true);
	}
	
	public void closeWindow() {
		prepScreen.dispose();
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
		lblDayNum.setText(Integer.toString(manager.getPlayer().getDayCompleted()));
		
		JLabel lblPointsNum = new JLabel("New label");
		lblPointsNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPointsNum.setText(Integer.toString(manager.getPlayer().getPoints()));
		
		JLabel lblMoneyNum = new JLabel("New label");
		lblMoneyNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoneyNum.setText(Integer.toString(manager.getPlayer().getMoney()));

		
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
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				if (manager.getPlayer().getDayCompleted() >= manager.getPlayer().getPlayerDayCompleted()) {
					manager.launchBattleScreen(true, num, "This is it the final battle!!", true);
				} else {
					manager.launchBattleScreen(true, num, "", false);
				}
//				manager.launchBattleScreen(true, num, "", false);
			}
		});
		btnFight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(prepScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDay)
							.addGap(18)
							.addComponent(lblDayNum, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnTeam, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblPoints)
							.addGap(18)
							.addComponent(lblPointsNum, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBag, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(56)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMoney)
							.addGap(18)
							.addComponent(lblMoneyNum, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBattles, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(396, Short.MAX_VALUE)
					.addComponent(btnFight, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(379))
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
					.addGap(61)
					.addComponent(btnFight, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		prepScreen.getContentPane().setLayout(groupLayout);
	}

}
