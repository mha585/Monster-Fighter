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
import javax.swing.JSpinner;

public class ChooseMonsterScreen {

	private JFrame chooseMonsterScreen;
	private MonsterManager manager;
	private FireMonster fireMonsterToAdd = new FireMonster("Fireguy", 50.0, 5.0, 20.0, 20.0, 1, 150, 250, "A strong fire type Monster capable of burning down buildings.");
	private GrassMonster grassMonsterToAdd = new GrassMonster("Grassdude", 70, 5.0, 10.0, 20.0, 1, 150, 250, "A strong grass type Monster. It is said that they dwell in the deapest parts of the jungle.");
	private WaterMonster waterMonsterToAdd = new WaterMonster("Waterman", 60, 5.0, 150.0, 20.0, 1, 150, 250, "A strong water type Monster. These streamline monsters are known to have existed before humans.");
	private RandomGen num;

	/**
	 * Create the choose monster screen at the start of the game.
	 * @param incomingManager 	The manager responsible for creating this screen
	 * @param number 			The RandomGen used to generate random numbers
	 */
	public ChooseMonsterScreen(MonsterManager incomingManager, RandomGen number) {
		manager = incomingManager;
		num = manager.getRandom();
		initialize();
		chooseMonsterScreen.setVisible(true);
	}
	/**
	 * closes the window
	 */
	public void closeWindow() {
		chooseMonsterScreen.dispose();
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
				manager.setTrainerListD1();
				manager.launchPrepScreen(num, manager.isAbleToFight());
				
			}
		});
		
		JButton btnChooseFire = new JButton("Fire Monster");
		btnChooseFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(fireMonsterToAdd);
				closeWindow();
				manager.setTrainerListD1();
				manager.launchPrepScreen(num, manager.isAbleToFight());
			}
		});
		
		JButton btnChooseWater = new JButton("Water Monster");
		btnChooseWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(waterMonsterToAdd);
				closeWindow();
				manager.setTrainerListD1();
				manager.launchPrepScreen(num, manager.isAbleToFight());
			}
		});
		
		JLabel lblNewLabel = new JLabel("Select your first monster!");
		
		JPanel panelChoiceMonster1 = new JPanel();
		
		JLabel lblSpeed = new JLabel("Speed");
		
		JLabel lblHealth = new JLabel("Health:");
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblHealAmount = new JLabel("Heal:");
		
		JLabel lblType = new JLabel("Type:");
		
		JLabel lblTier = new JLabel("Tier");
		
		JLabel lblDamage = new JLabel("Damage");
		
		JLabel lblCurrentTier = new JLabel("");
		
		int currentTier = (waterMonsterToAdd.getTier());
		lblCurrentTier.setText(Integer.toString(currentTier));
		
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
		
		JLabel lblCurrentDamage = new JLabel("");
		Double currentDamage = (waterMonsterToAdd.getDamage());
		lblCurrentDamage.setText(currentDamage.toString());
		
		GroupLayout gl_panelChoiceMonster1 = new GroupLayout(panelChoiceMonster1);
		gl_panelChoiceMonster1.setHorizontalGroup(
			gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblCurrentName, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpeed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealAmount)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTier, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealth, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDamage, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
									.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(lblSlash)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHealth, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
								.addComponent(lblCurrentDamage, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(lblCurrentTier, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(lblCurrentType, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(lblCurrentHealAmount, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(lblCurrentSpeed, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelChoiceMonster1.setVerticalGroup(
			gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth)
						.addComponent(lblSlash)
						.addComponent(lblMaxHealth)
						.addComponent(lblCurrentHealth))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentDamage)
						.addComponent(lblDamage))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addComponent(lblCurrentSpeed, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCurrentHealAmount)
								.addComponent(lblHealAmount)))
						.addComponent(lblSpeed))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addComponent(lblCurrentType, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCurrentTier, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelChoiceMonster1.createSequentialGroup()
							.addComponent(lblType)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTier)))
					.addGap(90))
		);
		panelChoiceMonster1.setLayout(gl_panelChoiceMonster1);
		
		JPanel panelChoiceMonster2 = new JPanel();
		
		JLabel lblName_1 = new JLabel("Name:");
				
		JLabel lblSpeed_1 = new JLabel("Speed");
		
		JLabel lblHealAmount_1 = new JLabel("Heal:");
		
		JLabel lblType_1 = new JLabel("Type:");
		
		JLabel lblTier_1 = new JLabel("Tier");
		
		JLabel lblDamage_1 = new JLabel("Damage");
		
		JLabel lblHealth_1 = new JLabel("Health:");
																		
		JLabel lblCurrentTier_1 = new JLabel("");
		int currentTier_1 = (grassMonsterToAdd.getTier());
		lblCurrentTier_1.setText(Integer.toString(currentTier_1));
		
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
		
		JLabel lblCurrentDamage_1 = new JLabel("");
		Double currentDamage_1 = (grassMonsterToAdd.getDamage());
		lblCurrentDamage_1.setText(currentDamage_1.toString());
		
		GroupLayout gl_panelChoiceMonster2 = new GroupLayout(panelChoiceMonster2);
		gl_panelChoiceMonster2.setHorizontalGroup(
			gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
							.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblCurrentName_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
						.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
							.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpeed_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealAmount_1)
								.addComponent(lblType_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTier_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealth_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDamage_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
									.addComponent(lblCurrentHealth_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(lblSlash_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHealth_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
								.addComponent(lblCurrentDamage_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
								.addComponent(lblCurrentTier_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
								.addComponent(lblCurrentType_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
								.addComponent(lblCurrentHealAmount_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
								.addComponent(lblCurrentSpeed_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelChoiceMonster2.setVerticalGroup(
			gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth_1)
						.addComponent(lblSlash_1)
						.addComponent(lblMaxHealth_1)
						.addComponent(lblCurrentHealth_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentDamage_1)
						.addComponent(lblDamage_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
							.addComponent(lblCurrentSpeed_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCurrentHealAmount_1)
								.addComponent(lblHealAmount_1)))
						.addComponent(lblSpeed_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
							.addComponent(lblCurrentType_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCurrentTier_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelChoiceMonster2.createSequentialGroup()
							.addComponent(lblType_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTier_1)))
					.addGap(82))
		);
		panelChoiceMonster2.setLayout(gl_panelChoiceMonster2);
		
		JPanel panelChoiceMonster3 = new JPanel();
		
		JLabel lblName_2 = new JLabel("Name:");
				
		JLabel lblSpeed_2 = new JLabel("Speed");
		
		JLabel lblHealAmount_2 = new JLabel("Heal:");
		
		JLabel lblType_2 = new JLabel("Type:");
		
		JLabel lblTier_2 = new JLabel("Tier");
		
		JLabel lblDamage_2 = new JLabel("Damage");
		
		JLabel lblHealth_2 = new JLabel("Health:");
																		
		JLabel lblCurrentTier_2 = new JLabel("");
		int currentTier_2 = (fireMonsterToAdd.getTier());
		lblCurrentTier_2.setText(Integer.toString(currentTier_2));
		
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
		
		JLabel lblCurrentDamage_2 = new JLabel("");
		Double currentDamage_2 = (waterMonsterToAdd.getDamage());
		lblCurrentDamage_2.setText(currentDamage_2.toString());
		
		GroupLayout gl_panelChoiceMonster3 = new GroupLayout(panelChoiceMonster3);
		gl_panelChoiceMonster3.setHorizontalGroup(
			gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
							.addComponent(lblName_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblCurrentName_2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
						.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
							.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpeed_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealAmount_2)
								.addComponent(lblType_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTier_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHealth_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDamage_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
									.addComponent(lblCurrentHealth_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(lblSlash_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHealth_2))
								.addComponent(lblCurrentDamage_2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(lblCurrentTier_2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(lblCurrentType_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(lblCurrentHealAmount_2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(lblCurrentSpeed_2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panelChoiceMonster3.setVerticalGroup(
			gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_2, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblCurrentName_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHealth_2)
						.addComponent(lblSlash_2)
						.addComponent(lblMaxHealth_2)
						.addComponent(lblCurrentHealth_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrentDamage_2)
						.addComponent(lblDamage_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
							.addComponent(lblCurrentSpeed_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCurrentHealAmount_2)
								.addComponent(lblHealAmount_2)))
						.addComponent(lblSpeed_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelChoiceMonster3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
							.addComponent(lblCurrentType_2, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCurrentTier_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelChoiceMonster3.createSequentialGroup()
							.addComponent(lblType_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTier_2)))
					.addGap(90))
		);
		panelChoiceMonster3.setLayout(gl_panelChoiceMonster3);
		GroupLayout groupLayout = new GroupLayout(chooseMonsterScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnChooseWater, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(161)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelChoiceMonster1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addGap(117)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnChooseFire, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelChoiceMonster3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(140)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelChoiceMonster2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChooseGrass, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnChooseWater, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChooseGrass, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelChoiceMonster1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelChoiceMonster2, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
					.addGap(132))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(btnChooseFire, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelChoiceMonster3, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(7, Short.MAX_VALUE))
		);
		chooseMonsterScreen.getContentPane().setLayout(groupLayout);
	}
}
