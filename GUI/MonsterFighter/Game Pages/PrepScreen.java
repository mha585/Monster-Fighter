import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PrepScreen {

	private JFrame prepScreen;
	private MonsterManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PrepScreen window = new PrepScreen();
//					window.prepScreen.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PrepScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		prepScreen.setVisible(true);
	}
	
	public void closeWindow() {
		prepScreen.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		prepScreen = new JFrame();
		prepScreen.setBounds(100, 100, 960, 540);
		prepScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDay = new JLabel("Current Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("View Team");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("View Battles");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_1_1 = new JButton("View Bag");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("Fight");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(prepScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDay)
							.addGap(18)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblPoints)
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(56)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMoney)
							.addGap(18)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(396, Short.MAX_VALUE)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(379))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPoints, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		prepScreen.getContentPane().setLayout(groupLayout);
	}

}
