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
	private Trainers enemy;
	private RandomGen num;
	private String whoKilledWho;

	/**
	 * Create the application.
	 */
	public BattleScreen(MonsterManager incomingManager, Trainers myEnemy, RandomGen randomNumber, String status) {
		manager = incomingManager;
		enemy = manager.getTrainer();
		enemyMonster = enemy.getFirstEnemy();
		
		whoKilledWho = status;
		LeadingMonster = manager.getPlayer().getTeam().getFriend(0);
		num = randomNumber;
		initialize();
		battleScreen.setVisible(true);
	}
	
	public void closeWindow() {
		battleScreen.dispose();
	}
	
	public void getPrizes(Player player) {
		if (manager.getPlayer().getDifficulty() == "easy") {
			manager.getPlayer().addMoney(75);
			manager.getPlayer().addPoints(45);
		}
		else if (manager.getPlayer().getDifficulty() == "normal") {
			manager.getPlayer().addMoney(50);
			manager.getPlayer().addPoints(50);
		}
		else if (manager.getPlayer().getDifficulty() == "hard") {
			manager.getPlayer().addMoney(50);
			manager.getPlayer().addPoints(100);
		}
	}
	
	public void checkIfBattleEnds(Team playerTeam, Monster enemy, Trainers enemyTrainer) {
//		if and only if the final boss's enemy is killed the game ends
		if (enemy.getName() == "Shinigami" && enemy.getHealth() <= 0) { 
			closeWindow();
			manager.launchWinScreen();
		}
//		if the enemy is dead
		else if (enemy.getHealth() <= 0) {
			enemyTrainer.removeEnemy();
			getPrizes(manager.getPlayer());
			closeWindow();
			if (playerTeam.getFriend(0).getHealth() == 0) {
				String status = "Your friend " + playerTeam.getFriend(0).getName() + " just died rip :(\n"
						+ "But in the process they killed " + enemy.getName();
				manager.launchBattleScreen(false, num, status, false);
			} else if (enemyTrainer.getSize() == 0 && enemyTrainer.getFullName() != "Boss Miguel"){
				manager.launchShopScreen(num);
			} else {
				String status = "Congrats you killed " + enemyMonster.getName() + " great job!";
				manager.launchBattleScreen(false, num, status, false);
			}
//		if the player is out of usable monsters the game ends
		}  else if (playerTeam.sumTeamHealth() <= 0) {
			double tenPercent = manager.getPlayer().getMoney() * 0.1;
			int lost = (int) (-1 * Math.floor(tenPercent));
			manager.getPlayer().deductMoney(lost);
			closeWindow();	
			manager.launchLoseScreen();
//		if the players monster dies
		} else if (playerTeam.getFriend(0).getHealth() <= 0) {
			String status = "Your friend " + playerTeam.getFriend(0).getName() + " just died rip :(";
			playerTeam.pushFrontToBack();
			closeWindow();
			manager.launchBattleScreen(false, num, status, false);
		}
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
		lblCurrentHealth.setHorizontalAlignment(SwingConstants.RIGHT);
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
		
		JLabel lblEnemysLeft = new JLabel("Enemies left:");
		
		JLabel lblCurrentEnemysLeft = new JLabel("1");
		int enemiesLeft = manager.getTrainer().getSize();
		lblCurrentEnemysLeft.setText(Integer.toString(enemiesLeft));
		
		JLabel lblPlayerName = new JLabel("New label");
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setText(LeadingMonster.getName());
		
		JLabel lblEnemyName = new JLabel("New label");
		lblEnemyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyName.setText(enemyMonster.getName());
		
		GroupLayout gl_pannelMonsters = new GroupLayout(pannelMonsters);
		gl_pannelMonsters.setHorizontalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addGap(18)
					.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSlash, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPlayerName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnTempMonsterImage, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addGap(8)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEnemyName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEnemyImageGoes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addComponent(lblEnemysLeft, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblCurrentEnemysLeft, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addComponent(lblCurrentHealth_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSlash_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMaxHealth_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pannelMonsters.setVerticalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCurrentEnemysLeft)
								.addComponent(lblEnemysLeft)))
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnemyName)
								.addComponent(lblPlayerName))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnTempMonsterImage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(btnEnemyImageGoes, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(lblSlash, Alignment.LEADING)
								.addComponent(lblCurrentHealth, Alignment.LEADING)
								.addComponent(lblMaxHealth, Alignment.LEADING))
							.addGap(74))
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSlash_1)
									.addComponent(lblCurrentHealth_1))
								.addComponent(lblMaxHealth_1))
							.addContainerGap())))
		);
		pannelMonsters.setLayout(gl_pannelMonsters);
		
		JPanel panelWords = new JPanel();
		
		JLabel lblFirstAction = new JLabel("");
		
		JLabel lblSecondAction = new JLabel("");
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setText(whoKilledWho);
		
		GroupLayout gl_panelWords = new GroupLayout(panelWords);
		gl_panelWords.setHorizontalGroup(
			gl_panelWords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWords.createSequentialGroup()
							.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelWords.createSequentialGroup()
							.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSecondAction, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
								.addComponent(lblFirstAction, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
							.addGap(81))))
		);
		gl_panelWords.setVerticalGroup(
			gl_panelWords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(31)
					.addComponent(lblFirstAction)
					.addGap(18)
					.addComponent(lblSecondAction)
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		panelWords.setLayout(gl_panelWords);
		
		JPanel panelPaddingLeft = new JPanel();
		
		JPanel panelPaddingRight = new JPanel();
		GroupLayout groupLayout = new GroupLayout(battleScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
					.addGap(114))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelPaddingLeft, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(pannelMonsters, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPaddingRight, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPaddingLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelPaddingRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pannelMonsters, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double intialFriendHealth = LeadingMonster.getHealth();
				Double intialEnemyHealth = enemyMonster.getHealth();
				
				manager.getBattle().attack(LeadingMonster, enemyMonster, manager.getPlayer().getTeam(), true);
				Double currentFriendHealth = (LeadingMonster.getHealth());
				Double currentEnemyHealth = (enemyMonster.getHealth());
				lblCurrentHealth.setText(currentFriendHealth.toString());
				lblCurrentHealth_1.setText(currentEnemyHealth.toString());
				
				
//				if (enemyMonster.getHealth() == 0) {
//					getPrizes(manager.getPlayer());
//					String status = "Congrats you killed " + enemyMonster.getName() + " great job!";
//					manager.getTrainer().removeEnemy();
//					closeWindow();
//					manager.launchBattleScreen(false, num, status);
//				}
				
				Double changeInFriendHealth = intialFriendHealth - currentFriendHealth;
				Double changeInEnemyHealth = intialEnemyHealth - currentEnemyHealth;
				
				if (LeadingMonster.getSpeed() >= enemyMonster.getSpeed()) {
					lblFirstAction.setText("First " + LeadingMonster.getName() + " attacked " + enemyMonster.getName() + " dealing " + (changeInEnemyHealth.toString()) + " points of damage, then:");
					lblSecondAction.setText(enemyMonster.getName() + " attacked " + LeadingMonster.getName() + " dealing " + (changeInFriendHealth.toString()) + " points of damage");
				} else {
					lblFirstAction.setText("First " + enemyMonster.getName() + " attacked " + LeadingMonster.getName() + " dealing " + (changeInFriendHealth.toString()) + " points of damage, then:");
					lblSecondAction.setText(LeadingMonster.getName() + " attacked " + enemyMonster.getName() + " dealing " + (changeInEnemyHealth.toString()) + " points of damage");
				}
				lblStatus.setText("");				
				checkIfBattleEnds(manager.getPlayer().getTeam(), enemyMonster, manager.getTrainer());
			}
		});
		
		JButton btnHeal = new JButton("Heal");
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double intialFriendHealth = LeadingMonster.getHealth();
				
				manager.getBattle().heal(LeadingMonster, enemyMonster, manager.getPlayer().getTeam());
								
				manager.getBattle().attack(LeadingMonster, enemyMonster, manager.getPlayer().getTeam(), false);
				Double currentFriendHealth = (LeadingMonster.getHealth());
				
				lblCurrentHealth.setText(currentFriendHealth.toString());
				
				Double changeInFriendHealth = intialFriendHealth - currentFriendHealth;
				
				lblFirstAction.setText("First " + LeadingMonster.getName() + " healed itself by " + LeadingMonster.getHealAmount() + " points of health");
				lblSecondAction.setText(enemyMonster.getName() + " took the opportunity to attack " + LeadingMonster.getName() + " dealing " + (changeInFriendHealth.toString()) + " points of damage");
				lblStatus.setText("");

				checkIfBattleEnds(manager.getPlayer().getTeam(), enemyMonster, manager.getTrainer());

			}
		});
		
		JButton btnTeam = new JButton("Monsters");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchTeamScreen("Fight", num);
			}
		});
		
		JButton btnItems = new JButton("Inventory");
		btnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Fight", num);
			}
		});
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
