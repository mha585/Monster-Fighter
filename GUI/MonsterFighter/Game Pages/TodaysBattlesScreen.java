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

public class TodaysBattlesScreen {

	private JFrame newBattleFrames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TodaysBattlesScreen window = new TodaysBattlesScreen();
					window.newBattleFrames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TodaysBattlesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		newBattleFrames = new JFrame();
		newBattleFrames.setBounds(100, 100, 960, 590);
		newBattleFrames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Check the Trainers you want to Fight today.");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
		
		JTextArea textArea = new JTextArea();
		
		JTextArea textArea_1 = new JTextArea();
		
		JTextArea textArea_2 = new JTextArea();
		
		JTextArea textArea_3 = new JTextArea();
		
		JButton btnNewButton = new JButton("Next");
		GroupLayout groupLayout = new GroupLayout(newBattleFrames.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxNewCheckBox_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxNewCheckBox_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(132)
									.addComponent(chckbxNewCheckBox_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(851, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(423)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxNewCheckBox)
								.addComponent(chckbxNewCheckBox_1)
								.addComponent(chckbxNewCheckBox_2)
								.addComponent(chckbxNewCheckBox_3)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		newBattleFrames.getContentPane().setLayout(groupLayout);
	}
}
