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
		lblCurrentHealth.setText(currentHealth.toString());
		
		Double maxHealth = (monster.getMaxHealth());
		lblMaxHealth.setText(maxHealth.toString());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		battleScreen = new JFrame();
		battleScreen.setTitle("Fight!");
		battleScreen.setBounds(100, 100, 960, 540);
		battleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Double currentHealth = (LeadingMonster.getHealth());
		Double maxHealth = (LeadingMonster.getMaxHealth());
		
		JPanel panelButtons = new JPanel();
		
		JPanel pannelMonsters = new JPanel();
		
		JButton btnTempMonsterImage = new JButton("Friend image goes here");
		
		JButton btnQuit = new JButton("Run from battle?");
		
		JButton btnEnemyImageGoes = new JButton("Enemy image goes here");
		GroupLayout gl_pannelMonsters = new GroupLayout(pannelMonsters);
		gl_pannelMonsters.setHorizontalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addGap(40)
					.addComponent(btnTempMonsterImage)
					.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
					.addComponent(btnEnemyImageGoes, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addComponent(btnQuit)
					.addGap(55))
		);
		gl_pannelMonsters.setVerticalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnTempMonsterImage, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEnemyImageGoes, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(99))
		);
		pannelMonsters.setLayout(gl_pannelMonsters);
		
		JPanel panelWords = new JPanel();
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblCurrentName = new JLabel("");
		
		JLabel lblMyHealth = new JLabel("Health:");
		
		JLabel lblCurrentHealth = new JLabel("0.0");
		
		JLabel lblSlash = new JLabel("/");
		
		JLabel lblMaxHealth = new JLabel("0.0");
		
		setStatLabels(LeadingMonster, lblCurrentName, lblCurrentHealth, lblMaxHealth);
		
		JLabel lblName_1 = new JLabel("Name:");
		
		JLabel lblMyHealth_1 = new JLabel("Health:");
		
		JLabel lblCurrentName_1 = new JLabel((String) null);
		
		JLabel lblCurrentHealth_1 = new JLabel("0.0");
		
		JLabel lblSlash_1 = new JLabel("/");
		
		JLabel lblMaxHealth_1 = new JLabel("0.0");
		
		setStatLabels(enemyMonster, lblCurrentName_1, lblCurrentHealth_1, lblMaxHealth_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		GroupLayout gl_panelWords = new GroupLayout(panelWords);
		gl_panelWords.setHorizontalGroup(
			gl_panelWords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblMyHealth, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWords.createSequentialGroup()
							.addComponent(lblCurrentName, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
							.addGap(96))
						.addGroup(gl_panelWords.createSequentialGroup()
							.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblSlash, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(79)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelWords.createSequentialGroup()
							.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblCurrentName_1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
							.addGap(17))
						.addGroup(gl_panelWords.createSequentialGroup()
							.addComponent(lblMyHealth_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCurrentHealth_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblSlash_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMaxHealth_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(76))
		);
		gl_panelWords.setVerticalGroup(
			gl_panelWords.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panelWords.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelWords.createSequentialGroup()
							.addGroup(gl_panelWords.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(lblCurrentName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMyHealth)
								.addComponent(lblCurrentHealth)
								.addComponent(lblSlash)
								.addComponent(lblMaxHealth)))
						.addGroup(gl_panelWords.createSequentialGroup()
							.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurrentName_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(11)
							.addGroup(gl_panelWords.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMyHealth_1)
								.addComponent(lblCurrentHealth_1)
								.addComponent(lblSlash_1)
								.addComponent(lblMaxHealth_1))))
					.addGap(163))
				.addGroup(gl_panelWords.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
		);
		panelWords.setLayout(gl_panelWords);
		GroupLayout groupLayout = new GroupLayout(battleScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(171))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(pannelMonsters, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(pannelMonsters, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
					.addGap(0))
		);
		
		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				LeadingMonster.gainHealth(-10);
				manager.getBattle().attack(LeadingMonster, enemyMonster, manager.getPlayer().getTeam(), true);
				Double currentHealth = (LeadingMonster.getHealth());
				lblCurrentHealth.setText(currentHealth.toString());
			}
		});
		
		JButton btnHeal = new JButton("Heal");
		
		JButton btnTeam = new JButton("Monsters");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchTeamScreen();
//				lblCurrentName.setText(manager.getPlayer().getTeam().getFriend(0).getName());
//				lblName.setText("this is a test");
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
