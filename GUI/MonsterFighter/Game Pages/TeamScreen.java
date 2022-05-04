import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamScreen {

	private JFrame teamScreen;
	private MonsterManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamScreen window = new TeamScreen();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TeamScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		teamScreen.setVisible(true);
	}
	
	public void closeWindow() {
		teamScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeTeamScreen(this);
	}
	
	public void setTitles(JLabel lblName, JLabel lblHealth, JLabel lblSlash, JLabel lblSpeed, 
			JLabel lblHealAmount, JLabel lblType, JLabel lblMaxExp, JLabel lblExp, JLabel lblTier) {
		lblName.setText("Name:");
		lblHealth.setText("Health:");
		lblSlash.setText("/");
		lblSpeed.setText("Speed:");
		lblHealAmount.setText("Heal Amount:");
		lblType.setText("Type:");
		lblMaxExp.setText("/   100");
		lblExp.setText("Exp:");
		lblTier.setText("Tier:");
	}
	
	public void setStats(Team playerTeam, int friendNum, JLabel lblCurrentName, JLabel lblCurrentHealth, 
			JLabel lblMaxHealth, JLabel lblCurrentSpeed, JLabel lblCurrentHealAmount, JLabel lblCurrentType,
			JLabel lblCurrentExp, JLabel lblCurrentTier) {
		
		lblCurrentName.setText(playerTeam.getFriend(friendNum).getName());
		
		Double currentHealth = (playerTeam.getFriend(friendNum).getHealth());
		lblCurrentHealth.setText(currentHealth.toString());
		
		Double maxHealth = (playerTeam.getFriend(friendNum).getMaxHealth());
		lblMaxHealth.setText(maxHealth.toString());
		
		Double currentSpeed = (playerTeam.getFriend(friendNum).getSpeed());
		lblCurrentSpeed.setText(currentSpeed.toString());
		
		Double currentHealAmount = (playerTeam.getFriend(friendNum).getHealAmount());
		lblCurrentHealAmount.setText(currentHealAmount.toString());
		
		lblCurrentType.setText(playerTeam.getFriend(friendNum).getType());
		
		Double currentExp = (playerTeam.getFriend(friendNum).getMyExperience());
		lblCurrentExp.setText(currentExp.toString());
		
		int currentTier = (playerTeam.getFriend(friendNum).getTier());
		lblCurrentTier.setText(Integer.toString(currentTier));		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		teamScreen = new JFrame();
		teamScreen.setTitle("Your Team");
		teamScreen.setBounds(100, 100, 960, 590);
		teamScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMonster1 = new JPanel();
		
		JLabel lblSpeed = new JLabel("");
		
		JLabel lblHealth = new JLabel("");
		
		JLabel lblName = new JLabel("");
		
		JLabel lblHealAmount = new JLabel("");
		
		JLabel lblType = new JLabel("");
		
		JLabel lblExp = new JLabel("");
		
		JLabel lblTier = new JLabel("");
		
		JLabel lblCurrentTier = new JLabel("");
		
		JLabel lblCurrentExp = new JLabel("");
		
		JLabel lblMaxExp = new JLabel("");
		
		JLabel lblCurrentType = new JLabel("");
		
		JLabel lblCurrentHealAmount = new JLabel("");
		
		JLabel lblCurrentName = new JLabel("");
		
		JLabel lblCurrentHealth = new JLabel("");
		
		JLabel lblSlash = new JLabel("");
		
		JLabel lblMaxHealth = new JLabel("");
		
		JLabel lblCurrentSpeed = new JLabel("");
		GroupLayout gl_panelMonster1 = new GroupLayout(panelMonster1);
		gl_panelMonster1.setHorizontalGroup(
			gl_panelMonster1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_panelMonster1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpeed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealth, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealAmount)
						.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTier, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentTier, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblCurrentExp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblCurrentSpeed, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelMonster1.setVerticalGroup(
			gl_panelMonster1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panelMonster1.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName))
					.addGap(11)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth)
						.addComponent(lblSlash, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblMaxHealth, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed)
						.addComponent(lblCurrentSpeed, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount)
						.addComponent(lblCurrentHealAmount))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblType))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExp)
						.addComponent(lblCurrentExp)
						.addComponent(lblMaxExp))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTier)
						.addComponent(lblCurrentTier, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		panelMonster1.setLayout(gl_panelMonster1);
		
		JPanel panelMonster2 = new JPanel();
		
		JLabel lblSpeed_1 = new JLabel("");
		
		JLabel lblHealth_1 = new JLabel("");
		
		JLabel lblName_1 = new JLabel("");
		
		JLabel lblHealAmount_1 = new JLabel("");
		
		JLabel lblType_1 = new JLabel("");
		
		JLabel lblExp_1 = new JLabel("");
		
		JLabel lblTier_1 = new JLabel("");
		
		JLabel lblCurrentTier_1 = new JLabel("");
		
		JLabel lblCurrentExp_1 = new JLabel("");
		
		JLabel lblMaxExp_1 = new JLabel("");
		
		JLabel lblCurrentType_1 = new JLabel("");
		
		JLabel lblCurrentHealAmount_1 = new JLabel("");
		
		JLabel lblCurrentName_1 = new JLabel("");
		
		JLabel lblCurrentHealth_1 = new JLabel("");
		
		JLabel lblSlash_1 = new JLabel("");
		
		JLabel lblMaxHealth_1 = new JLabel("");
		
		JLabel lblCurrentSpeed_1 = new JLabel("");
		GroupLayout gl_panelMonster2 = new GroupLayout(panelMonster2);
		gl_panelMonster2.setHorizontalGroup(
			gl_panelMonster2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_panelMonster2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpeed_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealth_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealAmount_1)
						.addComponent(lblType_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTier_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentTier_1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addComponent(lblCurrentExp_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount_1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentName_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addComponent(lblCurrentHealth_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addComponent(lblCurrentSpeed_1, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelMonster2.setVerticalGroup(
			gl_panelMonster2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panelMonster2.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName_1))
					.addGap(11)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth_1)
						.addComponent(lblSlash_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblMaxHealth_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed_1)
						.addComponent(lblCurrentSpeed_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_1)
						.addComponent(lblCurrentHealAmount_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblType_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExp_1)
						.addComponent(lblCurrentExp_1)
						.addComponent(lblMaxExp_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTier_1)
						.addComponent(lblCurrentTier_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		panelMonster2.setLayout(gl_panelMonster2);
		
		JPanel panelMonster3 = new JPanel();
		
		JLabel lblSpeed_2 = new JLabel("");
		
		JLabel lblHealth_2 = new JLabel("");
		
		JLabel lblName_2 = new JLabel("");
		
		JLabel lblHealAmount_2 = new JLabel("");
		
		JLabel lblType_2 = new JLabel("");
		
		JLabel lblExp_2 = new JLabel("");
		
		JLabel lblTier_2 = new JLabel("");
		
		JLabel lblCurrentTier_2 = new JLabel("");
		
		JLabel lblCurrentExp_2 = new JLabel("");
		
		JLabel lblMaxExp_2 = new JLabel("");
		
		JLabel lblCurrentType_2 = new JLabel("");
		
		JLabel lblCurrentHealAmount_2 = new JLabel("");
		
		JLabel lblCurrentName_2 = new JLabel("");
		
		JLabel lblCurrentHealth_2 = new JLabel("");
		
		JLabel lblSlash_2 = new JLabel("");
		
		JLabel lblMaxHealth_2 = new JLabel("");
		
		JLabel lblCurrentSpeed_2 = new JLabel("");
		GroupLayout gl_panelMonster3 = new GroupLayout(panelMonster3);
		gl_panelMonster3.setHorizontalGroup(
			gl_panelMonster3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_panelMonster3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpeed_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealth_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealAmount_2)
						.addComponent(lblType_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTier_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentTier_2, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addComponent(lblCurrentExp_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount_2, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentName_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addComponent(lblCurrentHealth_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addComponent(lblCurrentSpeed_2, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelMonster3.setVerticalGroup(
			gl_panelMonster3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panelMonster3.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName_2))
					.addGap(11)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth_2)
						.addComponent(lblSlash_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblMaxHealth_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed_2)
						.addComponent(lblCurrentSpeed_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_2)
						.addComponent(lblCurrentHealAmount_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblType_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExp_2)
						.addComponent(lblCurrentExp_2)
						.addComponent(lblMaxExp_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTier_2)
						.addComponent(lblCurrentTier_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		panelMonster3.setLayout(gl_panelMonster3);
		
		JPanel panelMonster4 = new JPanel();
		
		JLabel lblSpeed_3 = new JLabel("");
		
		JLabel lblHealth_3 = new JLabel("");
		
		JLabel lblName_3 = new JLabel("");
		
		JLabel lblHealAmount_3 = new JLabel("");
		
		JLabel lblType_3 = new JLabel("");
		
		JLabel lblExp_3 = new JLabel("");
		
		JLabel lblTier_3 = new JLabel("");
		
		JLabel lblCurrentTier_3 = new JLabel("");
		
		JLabel lblCurrentExp_3 = new JLabel("");
		
		JLabel lblMaxExp_3 = new JLabel("");
		
		JLabel lblCurrentType_3 = new JLabel("");
		
		JLabel lblCurrentHealAmount_3 = new JLabel("");
		
		JLabel lblCurrentName_3 = new JLabel("");
		
		JLabel lblCurrentHealth_3 = new JLabel("");
		
		JLabel lblSlash_3 = new JLabel("");
		
		JLabel lblMaxHealth_3 = new JLabel("");
		
		JLabel lblCurrentSpeed_3 = new JLabel("");
		GroupLayout gl_panelMonster4 = new GroupLayout(panelMonster4);
		gl_panelMonster4.setHorizontalGroup(
			gl_panelMonster4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_panelMonster4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpeed_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealth_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealAmount_3)
						.addComponent(lblType_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTier_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentTier_3, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addComponent(lblCurrentExp_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount_3, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentName_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addComponent(lblCurrentHealth_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addComponent(lblCurrentSpeed_3, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelMonster4.setVerticalGroup(
			gl_panelMonster4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panelMonster4.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_3, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName_3))
					.addGap(11)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth_3)
						.addComponent(lblSlash_3, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblMaxHealth_3, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth_3, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed_3)
						.addComponent(lblCurrentSpeed_3, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_3)
						.addComponent(lblCurrentHealAmount_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType_3, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblType_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExp_3)
						.addComponent(lblCurrentExp_3)
						.addComponent(lblMaxExp_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTier_3)
						.addComponent(lblCurrentTier_3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		panelMonster4.setLayout(gl_panelMonster4);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
//				Returns to the battle screen needs a if statement to get to the previous page not just battles
//				and need to ensure enemy monster is the same
				manager.launchBattleScreen(new RandomMonster(manager.getPlayer()));
			}
		});
		GroupLayout groupLayout = new GroupLayout(teamScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMonster1, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelMonster3, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
					.addGap(92)
					.addComponent(btnReturn)
					.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMonster4, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelMonster2, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReturn)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelMonster1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelMonster2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelMonster3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelMonster4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		if (manager.getPlayer().getTeam().getSize() == 1) {
			setTitles(lblName, lblHealth, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
		} else if (manager.getPlayer().getTeam().getSize() == 2) {
			setTitles(lblName, lblHealth, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
			
			setTitles(lblName_1, lblHealth_1, lblSlash_1, lblSpeed_1, lblHealAmount_1, lblType_1, lblMaxExp_1, lblExp_1, lblTier_1);
			setStats(manager.getPlayer().getTeam(), 1, lblCurrentName_1, lblCurrentHealth_1, lblMaxHealth_1, 
					lblCurrentSpeed_1, lblCurrentHealAmount_1, lblCurrentType_1, lblCurrentExp_1, lblCurrentTier_1);
		} else if (manager.getPlayer().getTeam().getSize() == 3) {
			setTitles(lblName, lblHealth, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
			
			setTitles(lblName_1, lblHealth_1, lblSlash_1, lblSpeed_1, lblHealAmount_1, lblType_1, lblMaxExp_1, lblExp_1, lblTier_1);
			setStats(manager.getPlayer().getTeam(), 1, lblCurrentName_1, lblCurrentHealth_1, lblMaxHealth_1, 
					lblCurrentSpeed_1, lblCurrentHealAmount_1, lblCurrentType_1, lblCurrentExp_1, lblCurrentTier_1);
			
			setTitles(lblName_2, lblHealth_2, lblSlash_2, lblSpeed_2, lblHealAmount_2, lblType_2, lblMaxExp_2, lblExp_2, lblTier_2);
			setStats(manager.getPlayer().getTeam(), 2, lblCurrentName_2, lblCurrentHealth_2, lblMaxHealth_2, 
					lblCurrentSpeed_2, lblCurrentHealAmount_2, lblCurrentType_2, lblCurrentExp_2, lblCurrentTier_2);
			
		} else if (manager.getPlayer().getTeam().getSize() >= 4){
			setTitles(lblName, lblHealth, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
			
			setTitles(lblName_1, lblHealth_1, lblSlash_1, lblSpeed_1, lblHealAmount_1, lblType_1, lblMaxExp_1, lblExp_1, lblTier_1);
			setStats(manager.getPlayer().getTeam(), 1, lblCurrentName_1, lblCurrentHealth_1, lblMaxHealth_1, 
					lblCurrentSpeed_1, lblCurrentHealAmount_1, lblCurrentType_1, lblCurrentExp_1, lblCurrentTier_1);
			
			setTitles(lblName_2, lblHealth_2, lblSlash_2, lblSpeed_2, lblHealAmount_2, lblType_2, lblMaxExp_2, lblExp_2, lblTier_2);
			setStats(manager.getPlayer().getTeam(), 2, lblCurrentName_2, lblCurrentHealth_2, lblMaxHealth_2, 
					lblCurrentSpeed_2, lblCurrentHealAmount_2, lblCurrentType_2, lblCurrentExp_2, lblCurrentTier_2);
			
			setTitles(lblName_3, lblHealth_3, lblSlash_3, lblSpeed_3, lblHealAmount_3, lblType_3, lblMaxExp_3, lblExp_3, lblTier_3);
			setStats(manager.getPlayer().getTeam(), 3, lblCurrentName_3, lblCurrentHealth_3, lblMaxHealth_3, 
					lblCurrentSpeed_3, lblCurrentHealAmount_3, lblCurrentType_3, lblCurrentExp_3, lblCurrentTier_3);
		}
		teamScreen.getContentPane().setLayout(groupLayout);
	}
}
