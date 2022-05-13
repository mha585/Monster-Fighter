import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class NightScreen {

	private JFrame nightFrame;
	private MonsterManager manager;
	private RandomGen num;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NightScreen window = new NightScreen();
//					window.nightFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NightScreen(MonsterManager incomingManager, RandomGen number) {
		manager = incomingManager;
		num = number;
		initialize();
		nightFrame.setVisible(true);
	}
	
	public void closeWindow() {
		nightFrame.dispose();
	}
	
	public String randomEvent() {
		int whatEventHappend = num.randNumInRange(1, 10);
		if ((whatEventHappend >= 1 && whatEventHappend <= 3) && (manager.getPlayer().getTeam().getSize() > 1)) {
//			monster leaves in the night
			int monsterToLeaveIndex = num.randNumInRange(0, manager.getPlayer().getTeam().getSize());
			Monster monsterThatLeaves = manager.getPlayer().getTeam().getFriend(monsterToLeaveIndex);
			manager.getPlayer().getTeam().removeFriend(monsterThatLeaves);
			return monsterThatLeaves.getName() + " left your team in the night";
		} else if ((whatEventHappend >= 4 && whatEventHappend <= 6) && (manager.getPlayer().getTeam().getSize() < 4)) {
//			monster joins in the night
			Monster newMonster = new RandomMonster(manager.getPlayer(), num);
			manager.getPlayer().getTeam().addFriend(newMonster);
			return newMonster.getName() + " joined your team in the night";
		} else {
//			monster levels up
			int monsterToLevelUpIndex = num.randNumInRange(0, manager.getPlayer().getTeam().getSize());
			Monster leveledUpMonster = manager.getPlayer().getTeam().getFriend(monsterToLevelUpIndex);
			manager.getPlayer().getTeam().getFriend(monsterToLevelUpIndex).levelUp();
			return leveledUpMonster.getName() + " gained a level";
		}
	}
	
	public void allMonsterGainHealth(Team team) {
		for (int i = 0; i < team.getSize(); i ++) {
			team.getFriend(i).gainHealth(20);
			if (team.getFriend(i).getHealth() == 0) {
				team.getFriend(i).revive();
				team.getFriend(i).gainHealth((-1 * team.getFriend(i).getMaxHealth()) + 20);
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		nightFrame = new JFrame();
		nightFrame.setTitle("Night time");
		nightFrame.setBounds(100, 100, 960, 540);
		nightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPPoints = new JLabel("Points:");
		
		JLabel lblMoney = new JLabel("Money:");
		
		JPanel panelMain = new JPanel();
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 42, Short.MAX_VALUE)
				.addGap(0, 42, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 404, Short.MAX_VALUE)
				.addGap(0, 404, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(nightFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPPoints, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(panelMain, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
							.addGap(18)))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPPoints)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMoney)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelMain, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 42, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 404, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Your monsters fainted (amount) times today");
		
		JLabel lblYourMonsterGet = new JLabel("Your monster get a good night sleep and will wake up with 20 extra health");
		
		JLabel lblSuddenlyInThe = new JLabel("Suddenly in the middle of the night...");
		
		JLabel lbleventDescriptionHere = new JLabel("(event description here)");
		lbleventDescriptionHere.setHorizontalAlignment(SwingConstants.CENTER);
		lbleventDescriptionHere.setText(randomEvent());
		
		JLabel lblSummary = new JLabel("Summary:");
		
		JButton btnNewButton = new JButton("Next Day");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allMonsterGainHealth(manager.getPlayer().getTeam());
				manager.getPlayer().addDay();
				manager.setTrainerListNotD1();
				manager.setIsAbleToFight(false);
				closeWindow();
				manager.launchPrepScreen(num, manager.isAbleToFight());
			}
		});
		
		JLabel lblRandom = new JLabel("Random Events:");
		
		JLabel lblNewLabel_1 = new JLabel("Today you defeated (amount) monsters");
		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain.setHorizontalGroup(
			gl_panelMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addContainerGap(67, Short.MAX_VALUE)
					.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelMain.createSequentialGroup()
								.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelMain.createSequentialGroup()
										.addGap(304)
										.addComponent(lblSummary, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelMain.createSequentialGroup()
										.addGap(242)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelMain.createSequentialGroup()
										.addGap(228)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
									.addComponent(lbleventDescriptionHere, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE))
								.addGap(65))
							.addGroup(gl_panelMain.createSequentialGroup()
								.addComponent(lblSuddenlyInThe, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addGap(287))
							.addGroup(gl_panelMain.createSequentialGroup()
								.addComponent(lblRandom, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addGap(335))
							.addGroup(gl_panelMain.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGap(358)))
						.addGroup(Alignment.TRAILING, gl_panelMain.createSequentialGroup()
							.addComponent(lblYourMonsterGet, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
							.addGap(173))))
		);
		gl_panelMain.setVerticalGroup(
			gl_panelMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addGap(40)
					.addComponent(lblSummary)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_1_1)
					.addGap(59)
					.addComponent(lblRandom)
					.addGap(32)
					.addComponent(lblSuddenlyInThe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbleventDescriptionHere)
					.addGap(25)
					.addComponent(lblYourMonsterGet)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		panelMain.setLayout(gl_panelMain);
		nightFrame.getContentPane().setLayout(groupLayout);
	}
}
