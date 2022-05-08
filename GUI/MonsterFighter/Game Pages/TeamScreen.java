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
import java.awt.Font;
import javax.swing.JSeparator;

public class TeamScreen {

	private JFrame teamScreen;
	private MonsterManager manager;
	private String previousPage;
	private RandomGen num;

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
	public TeamScreen(MonsterManager incomingManager, String previous, RandomGen number) {
		manager = incomingManager;
		previousPage = previous;
		num = number;
		initialize();
		teamScreen.setVisible(true);
	}
	
	public void closeWindow() {
		teamScreen.dispose();
	}
	
//	public void finishedWindow() {
//		manager.closeTeamScreen(this);
//	}
	
	public void setTitles(JLabel lblHealth, JLabel lblAttack, JLabel lblSlash, JLabel lblSpeed, 
			JLabel lblHealAmount, JLabel lblType, JLabel lblMaxExp, JLabel lblExp, JLabel lblTier) {
		lblHealth.setText("Health:");
		lblAttack.setText("Attack:");
		lblSlash.setText("/ ");
		lblSpeed.setText("Speed:");
		lblHealAmount.setText("Heal:");
		lblType.setText("Type:");
		lblMaxExp.setText("/   100");
		lblExp.setText("Exp:");
		lblTier.setText("Tier:");
	}
	
	public void setStats(Team playerTeam, int friendNum, JLabel lblCurrentName, JLabel lblCurrentHealth, 
			JLabel lblcurrentAttack, JLabel lblMaxHealth, JLabel lblCurrentSpeed, JLabel lblCurrentHealAmount, 
			JLabel lblCurrentType, JLabel lblCurrentExp, JLabel lblCurrentTier) {
		
		lblCurrentName.setText(playerTeam.getFriend(friendNum).getName());
		
		Double currentHealth = (playerTeam.getFriend(friendNum).getHealth());
		lblCurrentHealth.setText(currentHealth.toString());
		
		Double currentDamage = (playerTeam.getFriend(friendNum).getDamage());
		lblcurrentAttack.setText(currentDamage.toString());
		
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
		
		JPanel panelMonster2 = new JPanel();
		
		JLabel lblExp_1 = new JLabel("");
		
		JLabel lblCurrentExp_1 = new JLabel("");
		
		JLabel lblMaxExp_1 = new JLabel("");
		
		JLabel lblTier_1 = new JLabel("");
		
		JLabel lblCurrentTier_1 = new JLabel("");
		
		JLabel lblCurrentName_1 = new JLabel("None");
		lblCurrentName_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblSpeed_1 = new JLabel("");
		
		JLabel lblHealth_1 = new JLabel("");
		
		JLabel lblCurrentHealth_1 = new JLabel("");
		
		JLabel lblSlash_1 = new JLabel("");
		
		JLabel lblMaxHealth_1 = new JLabel("");
		
		JLabel lblCurrentSpeed_1 = new JLabel("");
		
		JLabel lblCurrentAttack_1 = new JLabel("");
		
		JLabel lblAttack_1 = new JLabel("");
		
		JLabel lblHealAmount_1 = new JLabel("");
		
		JLabel lblType_1 = new JLabel("");
		
		JLabel lblCurrentType_1 = new JLabel("");
		
		JLabel lblCurrentHealAmount_1 = new JLabel("");
		
		JSeparator separator_1_1 = new JSeparator();
		GroupLayout gl_panelMonster2 = new GroupLayout(panelMonster2);
		gl_panelMonster2.setHorizontalGroup(
			gl_panelMonster2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMonster2.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addComponent(lblExp_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentExp_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addComponent(lblTier_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentTier_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentName_1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
					.addGap(68)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpeed_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealth_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelMonster2.createSequentialGroup()
									.addComponent(lblCurrentHealth_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(lblSlash_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHealth_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCurrentSpeed_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentAttack_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAttack_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHealAmount_1)
								.addComponent(lblType_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurrentType_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentHealAmount_1))))
					.addGap(837))
				.addGroup(gl_panelMonster2.createSequentialGroup()
					.addComponent(separator_1_1, GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
					.addGap(396))
		);
		gl_panelMonster2.setVerticalGroup(
			gl_panelMonster2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelMonster2.createSequentialGroup()
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addComponent(lblCurrentName_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTier_1)
								.addComponent(lblCurrentTier_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblExp_1)
								.addComponent(lblCurrentExp_1)
								.addComponent(lblMaxExp_1)))
						.addGroup(gl_panelMonster2.createSequentialGroup()
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHealth_1)
								.addComponent(lblSlash_1)
								.addComponent(lblMaxHealth_1)
								.addComponent(lblCurrentHealth_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAttack_1)
								.addComponent(lblCurrentAttack_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpeed_1)
								.addComponent(lblCurrentSpeed_1))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_1)
						.addComponent(lblCurrentHealAmount_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType_1)
						.addComponent(lblCurrentType_1))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panelMonster2.setLayout(gl_panelMonster2);
		
		JPanel panelMonster3 = new JPanel();
		
		JLabel lblExp_2 = new JLabel("");
		
		JLabel lblCurrentExp_2 = new JLabel("");
		
		JLabel lblMaxExp_2 = new JLabel("");
		
		JLabel lblTier_2 = new JLabel("");
		
		JLabel lblCurrentTier_2 = new JLabel("");
		
		JLabel lblCurrentName_2 = new JLabel("None");
		lblCurrentName_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblSpeed_2 = new JLabel("");
		
		JLabel lblHealth_2 = new JLabel("");
		
		JLabel lblCurrentHealth_2 = new JLabel("");
		
		JLabel lblSlash_2 = new JLabel("");
		
		JLabel lblMaxHealth_2 = new JLabel("");
		
		JLabel lblCurrentSpeed_2 = new JLabel("");
		
		JLabel lblCurrentAttack_2 = new JLabel("");
		
		JLabel lblAttack_2 = new JLabel("");
		
		JLabel lblHealAmount_2 = new JLabel("");
		
		JLabel lblType_2 = new JLabel("");
		
		JLabel lblCurrentType_2 = new JLabel("");
		
		JLabel lblCurrentHealAmount_2 = new JLabel("");
		
		JSeparator separator_1_2 = new JSeparator();
		GroupLayout gl_panelMonster3 = new GroupLayout(panelMonster3);
		gl_panelMonster3.setHorizontalGroup(
			gl_panelMonster3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMonster3.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addComponent(lblExp_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentExp_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addComponent(lblTier_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentTier_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentName_2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
					.addGap(68)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpeed_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealth_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelMonster3.createSequentialGroup()
									.addComponent(lblCurrentHealth_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(lblSlash_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHealth_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCurrentSpeed_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentAttack_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAttack_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHealAmount_2)
								.addComponent(lblType_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurrentType_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentHealAmount_2))))
					.addGap(837))
				.addGroup(gl_panelMonster3.createSequentialGroup()
					.addComponent(separator_1_2, GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
					.addGap(396))
		);
		gl_panelMonster3.setVerticalGroup(
			gl_panelMonster3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMonster3.createSequentialGroup()
					.addComponent(separator_1_2, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addComponent(lblCurrentName_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTier_2)
								.addComponent(lblCurrentTier_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblExp_2)
								.addComponent(lblCurrentExp_2)
								.addComponent(lblMaxExp_2)))
						.addGroup(gl_panelMonster3.createSequentialGroup()
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHealth_2)
								.addComponent(lblSlash_2)
								.addComponent(lblMaxHealth_2)
								.addComponent(lblCurrentHealth_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAttack_2)
								.addComponent(lblCurrentAttack_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpeed_2)
								.addComponent(lblCurrentSpeed_2))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_2)
						.addComponent(lblCurrentHealAmount_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType_2)
						.addComponent(lblCurrentType_2))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panelMonster3.setLayout(gl_panelMonster3);
		
		JPanel panelMonster4 = new JPanel();
		
		JLabel lblExp_3 = new JLabel("");
		
		JLabel lblCurrentExp_3 = new JLabel("");
		
		JLabel lblMaxExp_3 = new JLabel("");
		
		JLabel lblTier_3 = new JLabel("");
		
		JLabel lblCurrentTier_3 = new JLabel("");
		
		JLabel lblCurrentName_3 = new JLabel("None");
		lblCurrentName_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblSpeed_3 = new JLabel("");
		
		JLabel lblHealth_3 = new JLabel("");
		
		JLabel lblCurrentHealth_3 = new JLabel("");
		
		JLabel lblSlash_3 = new JLabel("");
		
		JLabel lblMaxHealth_3 = new JLabel("");
		
		JLabel lblCurrentSpeed_3 = new JLabel("");
		
		JLabel lblCurrentAttack_3 = new JLabel("");
		
		JLabel lblAttack_3 = new JLabel("");
		
		JLabel lblHealAmount_3 = new JLabel("");
		
		JLabel lblType_3 = new JLabel("");
		
		JLabel lblCurrentType_3 = new JLabel("");
		
		JLabel lblCurrentHealAmount_3 = new JLabel("");
		
		JSeparator separator_4 = new JSeparator();
		
		JSeparator separator_1_3 = new JSeparator();
		GroupLayout gl_panelMonster4 = new GroupLayout(panelMonster4);
		gl_panelMonster4.setHorizontalGroup(
			gl_panelMonster4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMonster4.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addComponent(lblExp_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentExp_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addComponent(lblTier_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentTier_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentName_3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
					.addGap(68)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpeed_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealth_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelMonster4.createSequentialGroup()
									.addComponent(lblCurrentHealth_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(lblSlash_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHealth_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCurrentSpeed_3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentAttack_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAttack_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHealAmount_3)
								.addComponent(lblType_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurrentType_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentHealAmount_3))))
					.addGap(837))
				.addGroup(Alignment.TRAILING, gl_panelMonster4.createSequentialGroup()
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
						.addComponent(separator_1_3, GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE))
					.addGap(396))
		);
		gl_panelMonster4.setVerticalGroup(
			gl_panelMonster4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelMonster4.createSequentialGroup()
					.addComponent(separator_1_3, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addComponent(lblCurrentName_3)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTier_3)
								.addComponent(lblCurrentTier_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblExp_3)
								.addComponent(lblCurrentExp_3)
								.addComponent(lblMaxExp_3)))
						.addGroup(gl_panelMonster4.createSequentialGroup()
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHealth_3)
								.addComponent(lblSlash_3)
								.addComponent(lblMaxHealth_3)
								.addComponent(lblCurrentHealth_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAttack_3)
								.addComponent(lblCurrentAttack_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpeed_3)
								.addComponent(lblCurrentSpeed_3))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_3)
						.addComponent(lblCurrentHealAmount_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType_3)
						.addComponent(lblCurrentType_3))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panelMonster4.setLayout(gl_panelMonster4);
		
		JButton btnSwapFirstDown = new JButton("↓");
		btnSwapFirstDown.setVisible(false);
		if (manager.getPlayer().getTeam().getSize() > 1) {
			btnSwapFirstDown.setVisible(true);
			btnSwapFirstDown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manager.getPlayer().getTeam().swap(0, 1);
					closeWindow();
					manager.launchTeamScreen(previousPage, num);
				}
			});
		}
		JPanel panelMonster1 = new JPanel();
		
		JLabel lblExp = new JLabel("");
		
		JLabel lblCurrentExp = new JLabel("");
		
		JLabel lblMaxExp = new JLabel("");
		
		JLabel lblTier = new JLabel("");
		
		JLabel lblCurrentTier = new JLabel("");
		
		JLabel lblCurrentName = new JLabel("None");
		lblCurrentName.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblSpeed = new JLabel("");
		
		JLabel lblHealth = new JLabel("");
		
		JLabel lblCurrentHealth = new JLabel("");
		
		JLabel lblSlash = new JLabel("");
		
		JLabel lblMaxHealth = new JLabel("");
		
		JLabel lblCurrentSpeed = new JLabel("");
		
		JLabel lblCurrentAttack = new JLabel("");
		
		JLabel lblAttack = new JLabel("");
		
		JLabel lblHealAmount = new JLabel("");
		
		JLabel lblType = new JLabel("");
		
		JLabel lblCurrentType = new JLabel("");
		
		JLabel lblCurrentHealAmount = new JLabel("");
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panelMonster1 = new GroupLayout(panelMonster1);
		gl_panelMonster1.setHorizontalGroup(
			gl_panelMonster1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 859, Short.MAX_VALUE)
				.addGroup(gl_panelMonster1.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblExp, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentExp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblTier, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurrentTier, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentName, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
					.addGap(68)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpeed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealth, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelMonster1.createSequentialGroup()
									.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(lblSlash)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCurrentSpeed, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentAttack, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAttack, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHealAmount)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurrentType, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrentHealAmount))))
					.addGap(837))
				.addGroup(gl_panelMonster1.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
					.addGap(396))
		);
		gl_panelMonster1.setVerticalGroup(
			gl_panelMonster1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 126, Short.MAX_VALUE)
				.addGroup(gl_panelMonster1.createSequentialGroup()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblCurrentName)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTier)
								.addComponent(lblCurrentTier))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblExp)
								.addComponent(lblCurrentExp)
								.addComponent(lblMaxExp)))
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHealth)
								.addComponent(lblSlash)
								.addComponent(lblMaxHealth)
								.addComponent(lblCurrentHealth))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAttack)
								.addComponent(lblCurrentAttack))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpeed)
								.addComponent(lblCurrentSpeed))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount)
						.addComponent(lblCurrentHealAmount))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(lblCurrentType))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		panelMonster1.setLayout(gl_panelMonster1);
		
		JButton btnSwapSecondDown = new JButton("↓");
		btnSwapSecondDown.setVisible(false);
		if (manager.getPlayer().getTeam().getSize() > 2) {
			btnSwapSecondDown.setVisible(true);
			btnSwapSecondDown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manager.getPlayer().getTeam().swap(1, 2);
					closeWindow();
					manager.launchTeamScreen(previousPage, num);
				}
			});
		}
		
		JButton btnSwapSecondUp = new JButton("↑");
		btnSwapSecondUp.setVisible(false);
		if (manager.getPlayer().getTeam().getSize() > 1) {
			btnSwapSecondUp.setVisible(true);
			btnSwapSecondUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manager.getPlayer().getTeam().swap(0, 1);
					closeWindow();
					manager.launchTeamScreen(previousPage, num);
				}
			});
		}
		
		JButton btnSwapThirdDown = new JButton("↓");
		btnSwapThirdDown.setVisible(false);
		if (manager.getPlayer().getTeam().getSize() > 3) {
			btnSwapThirdDown.setVisible(true);
			btnSwapThirdDown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manager.getPlayer().getTeam().swap(2, 3);
					closeWindow();
					manager.launchTeamScreen(previousPage, num);
				}
			});
		}
		
		JButton btnSwapThirdUp = new JButton("↑");
		btnSwapThirdUp.setVisible(false);
		if (manager.getPlayer().getTeam().getSize() > 2) {
			btnSwapThirdUp.setVisible(true);
			btnSwapThirdUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manager.getPlayer().getTeam().swap(1, 2);
					closeWindow();
					manager.launchTeamScreen(previousPage, num);
				}
			});
		}
		
		JButton btnSwapFourthUp = new JButton("↑");
		btnSwapFourthUp.setVisible(false);
		if (manager.getPlayer().getTeam().getSize() > 3) {
			btnSwapFourthUp.setVisible(true);
			btnSwapFourthUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manager.getPlayer().getTeam().swap(2, 3);
					closeWindow();
					manager.launchTeamScreen(previousPage, num);
				}
			});
		}
		
		JPanel panelExitPadding = new JPanel();
		GroupLayout groupLayout = new GroupLayout(teamScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSwapFirstDown)
						.addComponent(btnSwapSecondUp, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(btnSwapSecondDown, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSwapThirdUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSwapThirdDown, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSwapFourthUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelMonster1, GroupLayout.PREFERRED_SIZE, 824, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelMonster4, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panelMonster3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 823, Short.MAX_VALUE)
								.addComponent(panelMonster2, GroupLayout.PREFERRED_SIZE, 823, Short.MAX_VALUE))
							.addGap(1)))
					.addGap(6)
					.addComponent(panelExitPadding, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
					.addGap(6))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelMonster1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(panelMonster2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelMonster3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelMonster4, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelExitPadding, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btnSwapFirstDown, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(btnSwapSecondUp, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSwapSecondDown, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(btnSwapThirdUp, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSwapThirdDown, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(btnSwapFourthUp, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JButton btnReturn_1 = new JButton("X");
		btnReturn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				if (previousPage == "Prep") {
					manager.launchPrepScreen(num);
				} else if (previousPage == "Fight") {
					manager.launchBattleScreen(false, num);
				}
			}
		});
		GroupLayout gl_panelExitPadding = new GroupLayout(panelExitPadding);
		gl_panelExitPadding.setHorizontalGroup(
			gl_panelExitPadding.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelExitPadding.createSequentialGroup()
					.addGap(1)
					.addComponent(btnReturn_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelExitPadding.setVerticalGroup(
			gl_panelExitPadding.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelExitPadding.createSequentialGroup()
					.addGap(6)
					.addComponent(btnReturn_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelExitPadding.setLayout(gl_panelExitPadding);
		
		if (manager.getPlayer().getTeam().getSize() == 1) {
			setTitles(lblHealth, lblAttack, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblCurrentAttack, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
		} else if (manager.getPlayer().getTeam().getSize() == 2) {
			setTitles(lblHealth, lblAttack, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblCurrentAttack, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
			
			setTitles(lblHealth_1, lblAttack_1, lblSlash_1, lblSpeed_1, lblHealAmount_1, lblType_1, lblMaxExp_1, lblExp_1, lblTier_1);
			setStats(manager.getPlayer().getTeam(), 1, lblCurrentName_1, lblCurrentHealth_1, lblCurrentAttack_1, lblMaxHealth_1, 
					lblCurrentSpeed_1, lblCurrentHealAmount_1, lblCurrentType_1, lblCurrentExp_1, lblCurrentTier_1);
		} else if (manager.getPlayer().getTeam().getSize() == 3) {
			setTitles(lblHealth, lblAttack, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblCurrentAttack, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
			
			setTitles(lblHealth_1, lblAttack_1, lblSlash_1, lblSpeed_1, lblHealAmount_1, lblType_1, lblMaxExp_1, lblExp_1, lblTier_1);
			setStats(manager.getPlayer().getTeam(), 1, lblCurrentName_1, lblCurrentHealth_1, lblCurrentAttack_1, lblMaxHealth_1, 
					lblCurrentSpeed_1, lblCurrentHealAmount_1, lblCurrentType_1, lblCurrentExp_1, lblCurrentTier_1);
			
			setTitles(lblHealth_2, lblAttack_2, lblSlash_2, lblSpeed_2, lblHealAmount_2, lblType_2, lblMaxExp_2, lblExp_2, lblTier_2);
			setStats(manager.getPlayer().getTeam(), 2, lblCurrentName_2, lblCurrentHealth_2, lblCurrentAttack_2, lblMaxHealth_2, 
					lblCurrentSpeed_2, lblCurrentHealAmount_2, lblCurrentType_2, lblCurrentExp_2, lblCurrentTier_2);
			
		} else if (manager.getPlayer().getTeam().getSize() >= 4){
			setTitles(lblHealth, lblAttack, lblSlash, lblSpeed, lblHealAmount, lblType, lblMaxExp, lblExp, lblTier);
			setStats(manager.getPlayer().getTeam(), 0, lblCurrentName, lblCurrentHealth, lblCurrentAttack, lblMaxHealth, 
					lblCurrentSpeed, lblCurrentHealAmount, lblCurrentType, lblCurrentExp, lblCurrentTier);
			
			setTitles(lblHealth_1, lblAttack_1, lblSlash_1, lblSpeed_1, lblHealAmount_1, lblType_1, lblMaxExp_1, lblExp_1, lblTier_1);
			setStats(manager.getPlayer().getTeam(), 1, lblCurrentName_1, lblCurrentHealth_1, lblCurrentAttack_1, lblMaxHealth_1, 
					lblCurrentSpeed_1, lblCurrentHealAmount_1, lblCurrentType_1, lblCurrentExp_1, lblCurrentTier_1);
			
			setTitles(lblHealth_2, lblAttack_2, lblSlash_2, lblSpeed_2, lblHealAmount_2, lblType_2, lblMaxExp_2, lblExp_2, lblTier_2);
			setStats(manager.getPlayer().getTeam(), 2, lblCurrentName_2, lblCurrentHealth_2, lblCurrentAttack_2, lblMaxHealth_2, 
					lblCurrentSpeed_2, lblCurrentHealAmount_2, lblCurrentType_2, lblCurrentExp_2, lblCurrentTier_2);
			
			setTitles(lblHealth_3, lblAttack_3, lblSlash_3, lblSpeed_3, lblHealAmount_3, lblType_3, lblMaxExp_3, lblExp_3, lblTier_3);
			setStats(manager.getPlayer().getTeam(), 3, lblCurrentName_3, lblCurrentHealth_3, lblCurrentAttack_3, lblMaxHealth_3, 
					lblCurrentSpeed_3, lblCurrentHealAmount_3, lblCurrentType_3, lblCurrentExp_3, lblCurrentTier_3);
		}
		teamScreen.getContentPane().setLayout(groupLayout);
	}
}
