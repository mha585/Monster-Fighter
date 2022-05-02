import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		teamScreen = new JFrame();
		teamScreen.setBounds(100, 100, 960, 590);
		teamScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMonster1 = new JPanel();
		
		JPanel panelMonster2 = new JPanel();
		
		JPanel panelMonster4 = new JPanel();
		
		JPanel panelMonster3 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(teamScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelMonster1, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
							.addGap(324)
							.addComponent(panelMonster2, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelMonster3, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
							.addGap(324)
							.addComponent(panelMonster4, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelMonster1, 0, 0, Short.MAX_VALUE)
						.addComponent(panelMonster2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMonster4, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addComponent(panelMonster3, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		GroupLayout gl_panelMonster3 = new GroupLayout(panelMonster3);
		gl_panelMonster3.setHorizontalGroup(
			gl_panelMonster3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
		);
		gl_panelMonster3.setVerticalGroup(
			gl_panelMonster3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 246, Short.MAX_VALUE)
		);
		panelMonster3.setLayout(gl_panelMonster3);
		GroupLayout gl_panelMonster4 = new GroupLayout(panelMonster4);
		gl_panelMonster4.setHorizontalGroup(
			gl_panelMonster4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
		);
		gl_panelMonster4.setVerticalGroup(
			gl_panelMonster4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 246, Short.MAX_VALUE)
		);
		panelMonster4.setLayout(gl_panelMonster4);
		GroupLayout gl_panelMonster2 = new GroupLayout(panelMonster2);
		gl_panelMonster2.setHorizontalGroup(
			gl_panelMonster2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
		);
		gl_panelMonster2.setVerticalGroup(
			gl_panelMonster2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 246, Short.MAX_VALUE)
		);
		panelMonster2.setLayout(gl_panelMonster2);
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblCurrentName = new JLabel((String) null);
		lblCurrentName.setText(manager.getPlayer().getTeam().getFriend(0).getName());
		
		JLabel lblHealth = new JLabel("Health:");
		
		JLabel lblCurrentHealth = new JLabel("");
		Double currentHealth = (manager.getPlayer().getTeam().getFriend(0).getHealth());
		lblCurrentHealth.setText(currentHealth.toString());
		
		JLabel lblSlash = new JLabel("/");
		
		JLabel lblMaxHealth = new JLabel("");
		Double maxHealth = (manager.getPlayer().getTeam().getFriend(0).getMaxHealth());
		lblMaxHealth.setText(maxHealth.toString());
		
		JLabel lblSpeed = new JLabel("Speed:");
		
		JLabel lblCurrentSpeed = new JLabel((String) null);
		Double currentSpeed = (manager.getPlayer().getTeam().getFriend(0).getSpeed());
		lblCurrentSpeed.setText(currentSpeed.toString());
		
		JLabel lblHealAmount = new JLabel("Heal Amount:");
		
		JLabel lblCurrentHealAmount = new JLabel("0.0");
		Double currentHealAmount = (manager.getPlayer().getTeam().getFriend(0).getHealAmount());
		lblCurrentHealAmount.setText(currentHealAmount.toString());
		
		JLabel lblType = new JLabel("Type:");
		
		JLabel lblCurrentType = new JLabel("");
		lblCurrentType.setText(manager.getPlayer().getTeam().getFriend(0).getType());
		
		JLabel lblCurrentExp = new JLabel("0.0");
		Double currentExp = (manager.getPlayer().getTeam().getFriend(0).getMyExperience());
		lblCurrentExp.setText(currentExp.toString());
		
		JLabel lblMaxExp = new JLabel("/   100");
		
		JLabel lblExp = new JLabel("Exp:");
		
		JLabel lblTier = new JLabel("Tier:");
		
		JLabel lblCurrentTier = new JLabel((String) null);
		int currentTier = (manager.getPlayer().getTeam().getFriend(0).getTier());
		lblCurrentTier.setText(Integer.toString(currentTier));
		
		GroupLayout gl_panelMonster1 = new GroupLayout(panelMonster1);
		gl_panelMonster1.setHorizontalGroup(
			gl_panelMonster1.createParallelGroup(Alignment.LEADING)
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
						.addComponent(lblCurrentTier, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblCurrentExp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(lblCurrentName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonster1.createSequentialGroup()
							.addComponent(lblCurrentSpeed, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelMonster1.setVerticalGroup(
			gl_panelMonster1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMonster1.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCurrentName))
					.addGap(11)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth)
						.addComponent(lblSlash, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblMaxHealth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed)
						.addComponent(lblCurrentSpeed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount)
						.addComponent(lblCurrentHealAmount))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
		teamScreen.getContentPane().setLayout(groupLayout);
	}
}
