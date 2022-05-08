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
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TodaysBattlesScreen {

	private JFrame newBattleFrames;
	private MonsterManager manager;
	private RandomGen num;

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
	 * @param previousPage 
	 */
	public TodaysBattlesScreen(MonsterManager incomingManager, RandomGen number) {
		manager = incomingManager;
		num = number;
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
		
		JLabel lblInstrct = new JLabel("Click the checkboxes of the trainers you want to fight.");
		lblInstrct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox chckbxTrainer1 = new JCheckBox("FightTrainerName\r\n");
		
		JCheckBox chckbxTrainer3 = new JCheckBox("FightTrainerName");
		
		JCheckBox chckbxTrainer4 = new JCheckBox("FightTrainerName");
		
		JCheckBox chckbxTrainer5 = new JCheckBox("FightTrainerName");
		
		JTextArea TADiplayTrainer1 = new JTextArea();
		TADiplayTrainer1.setEditable(false);
		TADiplayTrainer1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JTextArea TADiplayTrainer3 = new JTextArea();
		TADiplayTrainer3.setEditable(false);
		TADiplayTrainer3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JTextArea TADiplayTrainer4 = new JTextArea();
		TADiplayTrainer4.setEditable(false);
		TADiplayTrainer4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JTextArea TADiplayTrainer5 = new JTextArea();
		TADiplayTrainer5.setEditable(false);
		TADiplayTrainer5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchPrepScreen(num);
				
			}
		});
		
		JTextArea TADiplayTrainer2 = new JTextArea();
		TADiplayTrainer2.setEditable(false);
		TADiplayTrainer2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox chckbxTrainer2 = new JCheckBox("FightTrainerName");
		GroupLayout groupLayout = new GroupLayout(newBattleFrames.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(TADiplayTrainer1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxTrainer1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxTrainer2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(TADiplayTrainer2, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
							.addComponent(chckbxTrainer3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(138)
							.addComponent(chckbxTrainer4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(138)
							.addComponent(chckbxTrainer5, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(136))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBack)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(TADiplayTrainer3, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(TADiplayTrainer4, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(TADiplayTrainer5, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(14))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInstrct, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(469, Short.MAX_VALUE))
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
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxTrainer5)
								.addComponent(chckbxTrainer4)
								.addComponent(chckbxTrainer3)
								.addComponent(chckbxTrainer1)
								.addComponent(chckbxTrainer2))
							.addContainerGap(11, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBack)
							.addContainerGap())))
		);
		newBattleFrames.getContentPane().setLayout(groupLayout);
	}
}
