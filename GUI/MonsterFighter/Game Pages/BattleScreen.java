import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class BattleScreen {

	private JFrame battleScreen;
	private MonsterManager manager;
	private Monster LeadingMonster;
	private Monster enemyMonster;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MonsterManager test = new MonsterManager();
//					BattleScreen window = new BattleScreen(test);
//					window.battleScreen.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BattleScreen(MonsterManager incomingManager, Monster enemy) {
		manager = incomingManager;
		enemyMonster = enemy;
		LeadingMonster = manager.getPlayer().getTeam().getFriend(0);
		initialize();
		battleScreen.setVisible(true);
	}
	
	public void closeWindow() {
		battleScreen.dispose();
	}
	public void finishedWindow() {
		manager.closeBattleScreen(this);
	}
	
	public void setStatLabels(Monster monster, JLabel lblCurrentName, JLabel lblCurrentHealth, JLabel lblMaxHealth) {
		lblCurrentName.setText(monster.getName());
		
		Double currentHealth = (monster.getHealth());
		
		Double maxHealth = (monster.getMaxHealth());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		battleScreen = new JFrame();
		battleScreen.setTitle("Fight!");
		battleScreen.setBounds(100, 100, 960, 540);
		battleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelButtons = new JPanel();
		
		JPanel pannelMonsters = new JPanel();
		
		JButton btnTempMonsterImage = new JButton("Friend image goes here");
		
		JButton btnEnemyImageGoes = new JButton("Enemy image goes here");
		
		JLabel lblCurrentHealth = new JLabel("0.0");
		Double currentHealth = (LeadingMonster.getHealth());
		lblCurrentHealth.setText(currentHealth.toString());
		
		JLabel lblSlash = new JLabel("/");
		
		JLabel lblMaxHealth = new JLabel("0.0");
		Double maxHealth = (LeadingMonster.getMaxHealth());
		lblMaxHealth.setText(maxHealth.toString());

		JLabel lblCurrentHealth_1 = new JLabel("0.0");
		lblCurrentHealth_1.setHorizontalAlignment(SwingConstants.RIGHT);
		Double enemyCurrentHealth = (enemyMonster.getHealth());
		lblCurrentHealth_1.setText(enemyCurrentHealth.toString());
		
		JLabel lblSlash_1 = new JLabel("/");
		
		JLabel lblMaxHealth_1 = new JLabel("0.0");
		Double enemyMaxHealth = (enemyMonster.getMaxHealth());
		lblMaxHealth_1.setText(enemyMaxHealth.toString());
		
		GroupLayout gl_pannelMonsters = new GroupLayout(pannelMonsters);
		gl_pannelMonsters.setHorizontalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addGap(40)
							.addComponent(btnTempMonsterImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addGap(66)
							.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblSlash, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(37)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEnemyImageGoes, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addGap(28)
							.addComponent(lblCurrentHealth_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSlash_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMaxHealth_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(50)))
					.addGap(53))
		);
		gl_pannelMonsters.setVerticalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addComponent(btnEnemyImageGoes, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addGap(29)
							.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSlash_1)
									.addComponent(lblCurrentHealth_1))
								.addComponent(lblMaxHealth_1)))
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addComponent(btnTempMonsterImage, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addGap(29)
							.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurrentHealth)
								.addComponent(lblSlash)
								.addComponent(lblMaxHealth))))
					.addGap(36))
		);
		pannelMonsters.setLayout(gl_pannelMonsters);
		
		JPanel panelWords = new JPanel();
		
		JLabel lblFirstAction = new JLabel("");
		
		JLabel lblSecondAction = new JLabel("");
		
		JButton btnQuit = new JButton("Run from battle?");
		
		GroupLayout gl_panelWords = new GroupLayout(panelWords);
		gl_panelWords.setHorizontalGroup(
			gl_panelWords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSecondAction, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addComponent(lblFirstAction, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
					.addGap(81))
				.addGroup(Alignment.TRAILING, gl_panelWords.createSequentialGroup()
					.addContainerGap(426, Short.MAX_VALUE)
					.addComponent(btnQuit)
					.addGap(19))
		);
		gl_panelWords.setVerticalGroup(
			gl_panelWords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(31)
					.addComponent(lblFirstAction)
					.addGap(18)
					.addComponent(lblSecondAction)
					.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
					.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		panelWords.setLayout(gl_panelWords);
		
		JPanel panelPaddingLeft = new JPanel();
		
		JPanel panelPaddingRight = new JPanel();
		GroupLayout groupLayout = new GroupLayout(battleScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
					.addGap(114))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelPaddingLeft, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(pannelMonsters, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPaddingRight, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelPaddingRight, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
							.addGap(32))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(pannelMonsters, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addGap(37))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelPaddingLeft, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
								.addGap(32))))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				LeadingMonster.gainHealth(-10);
				Double intialFriendHealth = LeadingMonster.getHealth();
				Double intialEnemyHealth = enemyMonster.getHealth();
				
				manager.getBattle().attack(LeadingMonster, enemyMonster, manager.getPlayer().getTeam(), true);
				Double currentFriendHealth = (LeadingMonster.getHealth());
				Double currentEnemyHealth = (enemyMonster.getHealth());
				lblCurrentHealth.setText(currentFriendHealth.toString());
				lblCurrentHealth_1.setText(currentEnemyHealth.toString());
				
				Double changeInFriendHealth = intialFriendHealth - currentFriendHealth;
				Double changeInEnemyHealth = intialEnemyHealth - currentEnemyHealth;
				
				if (LeadingMonster.getSpeed() >= enemyMonster.getSpeed()) {
					lblFirstAction.setText("First " + LeadingMonster.getName() + " attacked " + enemyMonster.getName() + " dealing " + (changeInEnemyHealth.toString()) + " points of damage, then:");
					lblSecondAction.setText(enemyMonster.getName() + " attacked " + LeadingMonster.getName() + " dealing " + (changeInFriendHealth.toString()) + " points of damage");
				} else {
					lblFirstAction.setText("First " + enemyMonster.getName() + " attacked " + LeadingMonster.getName() + " dealing " + (changeInFriendHealth.toString()) + " points of damage, then:");
					lblSecondAction.setText(LeadingMonster.getName() + " attacked " + enemyMonster.getName() + " dealing " + (changeInEnemyHealth.toString()) + " points of damage");
				}

			}
		});
		
		JButton btnHeal = new JButton("Heal");
		
		JButton btnTeam = new JButton("Monsters");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchTeamScreen();
			}
		});
		
		JButton btnItems = new JButton("Inventory");
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelButtons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelButtons.createSequentialGroup()
							.addComponent(btnFight, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnHeal, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
						.addGroup(gl_panelButtons.createSequentialGroup()
							.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnItems, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
					.addGap(9))
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelButtons.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFight, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(btnHeal, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
					.addGap(6)
					.addGroup(gl_panelButtons.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(btnItems, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
					.addGap(12))
		);
		panelButtons.setLayout(gl_panelButtons);
		battleScreen.getContentPane().setLayout(groupLayout);
	}
}
