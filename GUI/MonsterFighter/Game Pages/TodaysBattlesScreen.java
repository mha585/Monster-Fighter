import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class TodaysBattlesScreen {

	private JFrame newBattleFrames;
	private MonsterManager manager;
	private RandomGen num;
	private ArrayList<Trainers> possibleTrainers;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TodaysBattlesScreen window = new TodaysBattlesScreen();
//					window.newBattleFrames.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param trainerBattles 
	 * @param previousPage 
	 */
	public TodaysBattlesScreen(MonsterManager incomingManager, RandomGen number, ArrayList<Trainers> trainerBattles) {
		manager = incomingManager;
		num = number;
		possibleTrainers = trainerBattles;
		initialize();
		newBattleFrames.setVisible(true);
	}
	
	public void closeWindow() {
		newBattleFrames.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		newBattleFrames = new JFrame();
		newBattleFrames.setBounds(100, 100, 1187, 540);
		newBattleFrames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String trainer1String = "";
		String trainer2String = "";
		String trainer3String = "";
		String trainer4String = "";
		String trainer5String = "";
		for (int i = 0; i < possibleTrainers.get(0).getEnemies().size(); i++) {
			Monster monster = possibleTrainers.get(0).getEnemies().get(i);
			System.out.println(monster.getName());
			trainer1String = trainer1String + '\n' + '\n' + monster.getName() + '\n' + "Type: " + monster.getType() + '\n' +  "Health: "
			+ monster.getHealth() + " / " + monster.getMaxHealth() + '\n' + "Damage: " + monster.getDamage() + '\n' +
					"Speed: " + monster.getSpeed() + '\n' + "Tier: " + monster.getTier();
		}
		JCheckBox chckbxTrainer1 = new JCheckBox("Fight " + possibleTrainers.get(0).getFullName()+"?");
		chckbxTrainer1.setSelected(true);
		JTextArea TADiplayTrainer1 = new JTextArea();
		TADiplayTrainer1.setText(possibleTrainers.get(0).getFullName()+'\n'+"Monsters: " + trainer1String);
		TADiplayTrainer1.setEditable(false);
		TADiplayTrainer1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		if (manager.getPlayer().getCurrentDay() > 1) {
			ArrayList<Monster> trainer2Team = possibleTrainers.get(1).getEnemies();
			for (int i = 0; i < trainer2Team.size(); i++) {
				Monster monster = trainer2Team.get(i);
				trainer2String += '\n' + '\n' + monster.getName() + '\n' + "Type: " + monster.getType() + '\n' +  "Health: "
				+ monster.getHealth() + " / " + monster.getMaxHealth() + '\n' + "Damage: " + monster.getDamage() + '\n' +
						"Speed: " + monster.getSpeed() + '\n' + "Tier: " + monster.getTier();
			}
			ArrayList<Monster> trainer3Team = possibleTrainers.get(2).getEnemies();
			for (int i = 0; i < trainer3Team.size(); i++) {
				Monster monster = trainer3Team.get(i);
				trainer3String += '\n' + '\n' + monster.getName() + '\n' + "Type: " + monster.getType() + '\n' +  "Health: "
				+ monster.getHealth() + " / " + monster.getMaxHealth() + '\n' + "Damage: " + monster.getDamage() + '\n' +
						"Speed: " + monster.getSpeed() + '\n' + "Tier: " + monster.getTier();
			}
			ArrayList<Monster> trainer4Team = possibleTrainers.get(3).getEnemies();
			for (int i = 0; i < trainer4Team.size(); i++) {
				Monster monster = trainer4Team.get(i);
				trainer4String += '\n' + '\n' + monster.getName() + '\n' + "Type: " + monster.getType() + '\n' + "Health: "
				+ monster.getHealth() + " / " + monster.getMaxHealth() + '\n' + "Damage: " + monster.getDamage() + '\n' +
						"Speed: " + monster.getSpeed() + '\n' + "Tier: " + monster.getTier();
			}
			ArrayList<Monster> trainer5Team = possibleTrainers.get(4).getEnemies();
			for (int i = 0; i < trainer5Team.size(); i++) {
				Monster monster = trainer5Team.get(i);
				trainer5String += '\n' + '\n' + monster.getName() + '\n' + "Type: " + monster.getType() + '\n' +  "Health: "
				+ monster.getHealth() + " / " + monster.getMaxHealth() + '\n' + "Damage: " + monster.getDamage() + '\n' +
						"Speed: " + monster.getSpeed() + '\n' + "Tier: " + monster.getTier();
			}
		}
		
		
		JLabel lblInstrct = new JLabel("Click the checkboxes of the trainers you want to fight.");
		lblInstrct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		String chkbox2Label = "";
		String chkbox3Label = "";
		String chkbox4Label = "";
		String chkbox5Label = "";
		
		if (manager.getPlayer().getCurrentDay() > 1) {
			chkbox2Label += "Fight " + possibleTrainers.get(1).getFullName()+"?";
			chkbox3Label += "Fight " + possibleTrainers.get(2).getFullName()+"?";
			chkbox4Label += "Fight " + possibleTrainers.get(3).getFullName()+"?";
			chkbox5Label += "Fight " + possibleTrainers.get(4).getFullName()+"?";
		}
		JCheckBox chckbxTrainer2 = new JCheckBox(chkbox2Label);
		chckbxTrainer2.setEnabled(false);
		if (manager.getPlayer().getCurrentDay() > 1) {
			chckbxTrainer2.setEnabled(true);
			chckbxTrainer2.setSelected(true);
		}
		JCheckBox chckbxTrainer3 = new JCheckBox(chkbox3Label);
		chckbxTrainer3.setEnabled(false);
		if (manager.getPlayer().getCurrentDay() > 1) {
			chckbxTrainer3.setEnabled(true);
			chckbxTrainer3.setSelected(true);
		}
		JCheckBox chckbxTrainer4 = new JCheckBox(chkbox4Label);
		chckbxTrainer4.setEnabled(false);
		if (manager.getPlayer().getCurrentDay() > 1) {
			chckbxTrainer4.setEnabled(true);
			chckbxTrainer4.setSelected(true);
		}
		JCheckBox chckbxTrainer5 = new JCheckBox(chkbox5Label);
		chckbxTrainer5.setEnabled(false);
		if (manager.getPlayer().getCurrentDay() > 1) {
			chckbxTrainer5.setEnabled(true);
			chckbxTrainer5.setSelected(true);
		}

		
		JTextArea TADiplayTrainer2 = new JTextArea();
		if (manager.getPlayer().getCurrentDay() > 1) {
			TADiplayTrainer2.setText(possibleTrainers.get(1).getFullName()+'\n'+"Monsters: " + trainer2String);
			TADiplayTrainer2.setEditable(false);
			TADiplayTrainer2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		else {
			TADiplayTrainer2.setEditable(false);
		}
		
		JTextArea TADiplayTrainer3 = new JTextArea();
		if (manager.getPlayer().getCurrentDay() > 1) {
			TADiplayTrainer3.setText(possibleTrainers.get(2).getFullName()+'\n'+"Monsters: " + trainer3String);
			TADiplayTrainer3.setEditable(false);
			TADiplayTrainer3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		else {
			TADiplayTrainer3.setEditable(false);
		}
		
		JTextArea TADiplayTrainer4 = new JTextArea();
		if (manager.getPlayer().getCurrentDay() > 1) {
			TADiplayTrainer4.setText(possibleTrainers.get(3).getFullName()+'\n'+"Monsters: " + trainer4String);
			TADiplayTrainer4.setEditable(false);
			TADiplayTrainer4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		else {
			TADiplayTrainer4.setEditable(false);
		
		}
		
		JTextArea TADiplayTrainer5 = new JTextArea();
		if (manager.getPlayer().getCurrentDay() > 1) {
			TADiplayTrainer5.setText(possibleTrainers.get(4).getFullName()+'\n'+"Monsters: " + trainer5String);
			TADiplayTrainer5.setEditable(false);
			TADiplayTrainer5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		} else {
			TADiplayTrainer5.setEditable(false);
		}
		
		
		int numBattles;
		if (manager.getPlayer().getCurrentDay() == 1) {
			numBattles = 1;
		}
		else {
			numBattles = 3;
		}
		JLabel lblReq = new JLabel("You need to fight atleast " + numBattles +" battle/s.");
		lblReq.setForeground(Color.RED);
		lblReq.setVisible(false);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			int fightsNeeded = 0;
			public void actionPerformed(ActionEvent e) {
				Trainers trainer = new Trainers();
				if (manager.getPlayer().getCurrentDay() == 1) {
					fightsNeeded = 1;
					if (chckbxTrainer1.isSelected() == true) {
						trainer.addMonster(possibleTrainers.get(0).getEnemies().get(0));
					}
				}
				else {
					fightsNeeded = 3;
					if (chckbxTrainer1.isSelected() == true) {
						trainer.addMonster(possibleTrainers.get(0).getFirstEnemy());
					}
					if (chckbxTrainer2.isSelected() == true) {
						trainer.addMonster(possibleTrainers.get(1).getFirstEnemy());
					}
					if (chckbxTrainer3.isSelected() == true) {
						trainer.addMonster(possibleTrainers.get(2).getFirstEnemy());
					}
					if (chckbxTrainer4.isSelected() == true) {
						trainer.addMonster(possibleTrainers.get(3).getFirstEnemy());
					}
					if (chckbxTrainer5.isSelected() == true) {
						trainer.addMonster(possibleTrainers.get(4).getFirstEnemy());
					}
				}
				if (trainer.getSize() < fightsNeeded) {
					lblReq.setVisible(true);
				}
				else {
					manager.setEnemyTrainer(trainer);
					manager.setIsAbleToFight(true);
					closeWindow();
					System.out.println(possibleTrainers);
					System.out.println(trainer.getEnemies().toString());
					manager.launchPrepScreen(num, manager.isAbleToFight());
				}
			}
		});


		
		
		GroupLayout groupLayout = new GroupLayout(newBattleFrames.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(chckbxTrainer1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(TADiplayTrainer1, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(chckbxTrainer2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(TADiplayTrainer2, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxTrainer3, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxTrainer4, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxTrainer5, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblReq)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBack))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(TADiplayTrainer3, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(TADiplayTrainer4, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(TADiplayTrainer5, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblInstrct, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblInstrct)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(TADiplayTrainer1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addComponent(TADiplayTrainer2, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addComponent(TADiplayTrainer3, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addComponent(TADiplayTrainer4, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addComponent(TADiplayTrainer5, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxTrainer5)
								.addComponent(chckbxTrainer1)
								.addComponent(chckbxTrainer2)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(chckbxTrainer3)
									.addComponent(chckbxTrainer4)))
							.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBack)
								.addComponent(lblReq, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		newBattleFrames.getContentPane().setLayout(groupLayout);
	}
}
