import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

public class ChooseMonsterScreen {

	private JFrame chooseMonsterScreen;
	private MonsterManager manager;
	private FireMonster fireMonsterToAdd = new FireMonster("Fireguy", 50.0, 5.0, 20.0, 20.0, 1, 150, 250, "A strong fire type Monster capable of burning down buildings.");
	private GrassMonster grassMonsterToAdd = new GrassMonster("Grassdude", 70, 5.0, 10.0, 20.0, 1, 150, 250, "A strong grass type Monster. It is said that they dwell in the deapest parts of the jungle.");
	private WaterMonster waterMonsterToAdd = new WaterMonster("Waterman", 60, 5.0, 15.0, 20.0, 1, 150, 250, "A strong water type Monster. These streamline monsters are known to have existed before humans.");
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChooseMonsterScreen window = new ChooseMonsterScreen();
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
	public ChooseMonsterScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		chooseMonsterScreen.setVisible(true);
	}
	
	public void closeWindow() {
		chooseMonsterScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeChooseMonsterScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chooseMonsterScreen = new JFrame();
		chooseMonsterScreen.setTitle("Choose your monster!");
		chooseMonsterScreen.setBounds(100, 100, 960, 590);
		chooseMonsterScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnChooseGrass = new JButton("Grass Monster");
		btnChooseGrass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(grassMonsterToAdd);
				closeWindow();
				manager.launchBattleScreen(new RandomMonster(manager.getPlayer()));
			}
		});
		
		JButton btnChooseFire = new JButton("Fire Monster");
		btnChooseFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(fireMonsterToAdd);
				closeWindow();
				manager.launchBattleScreen(new RandomMonster(manager.getPlayer()));
			}
		});
		
		JButton btnChooseWater = new JButton("Water Monster");
		btnChooseWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(waterMonsterToAdd);
				closeWindow();
				manager.launchBattleScreen(new RandomMonster(manager.getPlayer()));
			}
		});
		
		JLabel lblNewLabel = new JLabel("Select your first monster!");
		
		JPanel panelChoiceMonster1 = new JPanel();
		
		JLabel lblSpeed = new JLabel("Speed");
		
		JLabel lblHealth = new JLabel("Health:");
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblHealAmount = new JLabel("Heal Amount:");
		
		JLabel lblType = new JLabel("Type:");
		
		JLabel lblExp = new JLabel("Exp:");
		
		JLabel lblTier = new JLabel("Tier");
		
		JLabel lblCurrentTier = new JLabel("");
		int currentTier = (waterMonsterToAdd.getTier());
		lblCurrentTier.setText(Integer.toString(currentTier));
		
		JLabel lblCurrentExp = new JLabel("");
		Double currentExp = (waterMonsterToAdd.getMyExperience());
		lblCurrentExp.setText(currentExp.toString());
		
		JLabel lblMaxExp = new JLabel("/   100");
		
		JLabel lblCurrentType = new JLabel("");
		lblCurrentType.setText(waterMonsterToAdd.getType());
		
		JLabel lblCurrentHealAmount = new JLabel("");
		Double currentHealAmount = (waterMonsterToAdd.getHealAmount());
		lblCurrentHealAmount.setText(currentHealAmount.toString());
		
		JLabel lblCurrentName = new JLabel("");
		lblCurrentName.setText(waterMonsterToAdd.getName());
		
		JLabel lblCurrentHealth = new JLabel("");
		Double currentHealth = (waterMonsterToAdd.getHealth());
		lblCurrentHealth.setText(currentHealth.toString());
		
		JLabel lblSlash = new JLabel("/");
		
		JLabel lblMaxHealth = new JLabel("");
		Double maxHealth = (waterMonsterToAdd.getMaxHealth());
		lblMaxHealth.setText(maxHealth.toString());
		
		JLabel lblCurrentSpeed = new JLabel("");
		Double currentSpeed = (waterMonsterToAdd.getSpeed());
		lblCurrentSpeed.setText(currentSpeed.toString());
		
		GroupLayout gl_panelChoiceMonster1 = new GroupLayout(panelChoiceMonster1);
		gl_panelChoiceMonster1.setHorizontalGroup(
			gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpeed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealth, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealAmount)
						.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTier, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentTier, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addComponent(lblCurrentExp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(lblCurrentName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addComponent(lblCurrentSpeed, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelChoiceMonster1.setVerticalGroup(
			gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName))
					.addGap(11)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth)
						.addComponent(lblSlash, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblMaxHealth, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed)
						.addComponent(lblCurrentSpeed, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount)
						.addComponent(lblCurrentHealAmount))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblType))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExp)
						.addComponent(lblCurrentExp)
						.addComponent(lblMaxExp))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTier)
						.addComponent(lblCurrentTier, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		panelChoiceMonster1.setLayout(gl_panelChoiceMonster1);
		
		JPanel panelMonsterChoice3 = new JPanel();
		
		JLabel lblSpeed_2 = new JLabel("Speed");
		
		JLabel lblHealth_2 = new JLabel("Health:");
		
		JLabel lblName_2 = new JLabel("Name:");
		
		JLabel lblHealAmount_2 = new JLabel("Heal Amount:");
		
		JLabel lblType_2 = new JLabel("Type:");
		
		JLabel lblExp_2 = new JLabel("Exp:");
		
		JLabel lblTier_2 = new JLabel("Tier");
		
		JLabel lblCurrentTier_2 = new JLabel("");
		int currentTier_2 = (fireMonsterToAdd.getTier());
		lblCurrentTier_2.setText(Integer.toString(currentTier_2));
		
		JLabel lblCurrentExp_2 = new JLabel("");
		Double currentExp_2 = (fireMonsterToAdd.getMyExperience());
		lblCurrentExp_2.setText(currentExp_2.toString());
		
		JLabel lblMaxExp_2 = new JLabel("/   100");
		
		JLabel lblCurrentType_2 = new JLabel("");
		lblCurrentType_2.setText(fireMonsterToAdd.getType());
		
		JLabel lblCurrentHealAmount_2 = new JLabel("");
		Double currentHealAmount_2 = (fireMonsterToAdd.getHealAmount());
		lblCurrentHealAmount_2.setText(currentHealAmount_2.toString());
		
		JLabel lblCurrentName_2 = new JLabel("");
		lblCurrentName_2.setText(fireMonsterToAdd.getName());
		
		JLabel lblCurrentHealth_2 = new JLabel("");
		Double currentHealth_2 = (fireMonsterToAdd.getHealth());
		lblCurrentHealth_2.setText(currentHealth_2.toString());
		
		JLabel lblSlash_2 = new JLabel("/");
		
		JLabel lblMaxHealth_2 = new JLabel("");
		Double maxHealth_2 = (fireMonsterToAdd.getMaxHealth());
		lblMaxHealth_2.setText(maxHealth_2.toString());
		
		JLabel lblCurrentSpeed_2 = new JLabel("");
		Double currentSpeed_2 = (fireMonsterToAdd.getSpeed());
		lblCurrentSpeed_2.setText(currentSpeed_2.toString());
		
		GroupLayout gl_panelMonsterChoice3 = new GroupLayout(panelMonsterChoice3);
		gl_panelMonsterChoice3.setHorizontalGroup(
			gl_panelMonsterChoice3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_panelMonsterChoice3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpeed_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealth_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealAmount_2)
						.addComponent(lblType_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTier_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentTier_2, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addGroup(gl_panelMonsterChoice3.createSequentialGroup()
							.addComponent(lblCurrentExp_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount_2, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(lblCurrentName_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addGroup(gl_panelMonsterChoice3.createSequentialGroup()
							.addComponent(lblCurrentHealth_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonsterChoice3.createSequentialGroup()
							.addComponent(lblCurrentSpeed_2, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelMonsterChoice3.setVerticalGroup(
			gl_panelMonsterChoice3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panelMonsterChoice3.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName_2))
					.addGap(11)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth_2)
						.addComponent(lblSlash_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblMaxHealth_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed_2)
						.addComponent(lblCurrentSpeed_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_2)
						.addComponent(lblCurrentHealAmount_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblType_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExp_2)
						.addComponent(lblCurrentExp_2)
						.addComponent(lblMaxExp_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTier_2)
						.addComponent(lblCurrentTier_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		panelMonsterChoice3.setLayout(gl_panelMonsterChoice3);
		
		JPanel panelMonsterChoice2 = new JPanel();
		
		JLabel lblSpeed_1 = new JLabel("Speed");
		
		JLabel lblHealth_1 = new JLabel("Health:");
		
		JLabel lblName_1 = new JLabel("Name:");
		
		JLabel lblHealAmount_1 = new JLabel("Heal Amount:");
		
		JLabel lblType_1 = new JLabel("Type:");
		
		JLabel lblExp_1 = new JLabel("Exp:");
		
		JLabel lblTier_1 = new JLabel("Tier");
		
		JLabel lblCurrentTier_1 = new JLabel("");
		int currentTier_1 = (grassMonsterToAdd.getTier());
		lblCurrentTier_1.setText(Integer.toString(currentTier_1));
		
		JLabel lblCurrentExp_1 = new JLabel("");
		Double currentExp_1 = (grassMonsterToAdd.getMyExperience());
		lblCurrentExp_1.setText(currentExp_1.toString());
		
		JLabel lblMaxExp_1 = new JLabel("/   100");
		
		JLabel lblCurrentType_1 = new JLabel("");
		lblCurrentType_1.setText(grassMonsterToAdd.getType());
		
		JLabel lblCurrentHealAmount_1 = new JLabel("");
		Double currentHealAmount_1 = (grassMonsterToAdd.getHealAmount());
		lblCurrentHealAmount_1.setText(currentHealAmount_1.toString());
		
		JLabel lblCurrentName_1 = new JLabel("");
		lblCurrentName_1.setText(grassMonsterToAdd.getName());
		
		JLabel lblCurrentHealth_1 = new JLabel("");
		Double currentHealth_1 = (grassMonsterToAdd.getHealth());
		lblCurrentHealth_1.setText(currentHealth_1.toString());
		
		JLabel lblSlash_1 = new JLabel("/");
		
		JLabel lblMaxHealth_1 = new JLabel("");
		Double maxHealth_1 = (grassMonsterToAdd.getMaxHealth());
		lblMaxHealth_1.setText(maxHealth_1.toString());
		
		JLabel lblCurrentSpeed_1 = new JLabel("");
		Double currentSpeed_1 = (grassMonsterToAdd.getSpeed());
		lblCurrentSpeed_1.setText(currentSpeed_1.toString());
		
		
		GroupLayout gl_panelMonsterChoice2 = new GroupLayout(panelMonsterChoice2);
		gl_panelMonsterChoice2.setHorizontalGroup(
			gl_panelMonsterChoice2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_panelMonsterChoice2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpeed_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealth_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHealAmount_1)
						.addComponent(lblType_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTier_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentTier_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addGroup(gl_panelMonsterChoice2.createSequentialGroup()
							.addComponent(lblCurrentExp_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblMaxExp_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentType_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(lblCurrentHealAmount_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(lblCurrentName_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addGroup(gl_panelMonsterChoice2.createSequentialGroup()
							.addComponent(lblCurrentHealth_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblSlash_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMonsterChoice2.createSequentialGroup()
							.addComponent(lblCurrentSpeed_1, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
		);
		gl_panelMonsterChoice2.setVerticalGroup(
			gl_panelMonsterChoice2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panelMonsterChoice2.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName_1))
					.addGap(11)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth_1)
						.addComponent(lblSlash_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblMaxHealth_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentHealth_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeed_1)
						.addComponent(lblCurrentSpeed_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealAmount_1)
						.addComponent(lblCurrentHealAmount_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentType_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblType_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExp_1)
						.addComponent(lblCurrentExp_1)
						.addComponent(lblMaxExp_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMonsterChoice2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTier_1)
						.addComponent(lblCurrentTier_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		panelMonsterChoice2.setLayout(gl_panelMonsterChoice2);
		
		JButton btnDeleteLater = new JButton("RandomMonster Test");
		btnDeleteLater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(new RandomMonster(manager.getPlayer()));
			}
		});
		GroupLayout groupLayout = new GroupLayout(chooseMonsterScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(btnChooseWater, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(161)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(140)
					.addComponent(btnChooseGrass, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addGap(59))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelChoiceMonster1, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelMonsterChoice3, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDeleteLater, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnChooseFire, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
									.addGap(82)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMonsterChoice2, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addGap(4))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(btnChooseFire, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(panelMonsterChoice3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChooseWater, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(btnChooseGrass, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelChoiceMonster1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelMonsterChoice2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addGap(137))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addComponent(btnDeleteLater, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(374))
		);
		chooseMonsterScreen.getContentPane().setLayout(groupLayout);
	}
}
