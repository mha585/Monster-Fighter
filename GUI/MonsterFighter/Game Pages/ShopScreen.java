import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopScreen {

	private JFrame shopFrame;
	private MonsterManager manager;
	private RandomGen num;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShopScreen window = new ShopScreen();
//					window.shopFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ShopScreen(MonsterManager incomingManager, RandomGen number) {
		manager = incomingManager;
		num = number;
		initialize();
		shopFrame.setVisible(true);
	}
	
	public void closeWindow() {
		shopFrame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shopFrame = new JFrame();
		shopFrame.setBounds(100, 100, 960, 540);
		shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Money:");
		
		JLabel lblPlayerMoney = new JLabel("$0");
		lblPlayerMoney.setText("$" + manager.getPlayer().getMoney());
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel_3 = new JLabel("An error will occur if they try to add something into the trolley and it makes the player go over budget");
		
		JButton btnNewButton_2 = new JButton("Sell Items");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen("Shop", num);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Next");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchNightScreen(num);
			}
		});
		GroupLayout groupLayout = new GroupLayout(shopFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPlayerMoney, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 890, GroupLayout.PREFERRED_SIZE)
								.addGap(23))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
								.addGap(89)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addGap(33))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblPlayerMoney))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_3)
							.addComponent(btnNewButton_2)))
					.addGap(85))
		);
		
		JList itemList = new JList();
		
		JButton btnExit = new JButton("Exit");
		
		JButton btnNewButton = new JButton("Buy");
		
		JLabel lblNewLabel_2 = new JLabel("Purchase Successful");
		lblNewLabel_2.setForeground(Color.RED);
		
		JLabel lblNewLabel_1_5 = new JLabel("Speed Boost");
		
		JLabel lblNewLabel_1 = new JLabel("Atk Boost");
		
		JButton btnNewButton_1 = new JButton(" Monster1 including cost, description, type, and stats");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		
		JLabel lblNewLabel_1_1 = new JLabel("Atk Plus");
		
		JLabel lblNewLabel_1_6 = new JLabel("Speed Plus");
		
		JButton btnNewButton_1_1 = new JButton("Monster2");
		
		JButton btnNewButton_1_2 = new JButton("Monster3");
		
		JLabel lblNewLabel_1_2 = new JLabel("Basic Heal");
		
		JButton btnNewButton_1_2_1 = new JButton("Monster4");
		
		JLabel lblNewLabel_4 = new JLabel("Description:");
		
		JLabel lblNewLabel_5 = new JLabel("Clicking on an item in the trolley will prompt a pop up that'll ask the user if they want to remove the item/ copies of the item from the trolley.");
		
		JLabel lblNewLabel_4_1 = new JLabel("Cost:");
		
		JLabel lblNewLabel_1_4 = new JLabel("Mega Heal");
		
		JLabel lblNewLabel_1_3 = new JLabel("Full Heal");
		
		JLabel lblNewLabel_1_7 = new JLabel("Tier Plus");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(103)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addGap(165)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addGap(110)
											.addComponent(lblNewLabel_1_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))))
							.addGap(40)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(86)
									.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(31)
									.addComponent(lblNewLabel_1_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(53)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
										.addComponent(itemList, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(58)
											.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
											.addGap(84)
											.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(28)
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))))
							.addGap(97))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_1_1)
								.addComponent(lblNewLabel_1_2)
								.addComponent(lblNewLabel_4))
							.addGap(49)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4_1)
								.addComponent(lblNewLabel_1_6)
								.addComponent(lblNewLabel_1_5)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_3)
								.addComponent(lblNewLabel_1_4))
							.addGap(49)
							.addComponent(lblNewLabel_1_7)))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblNewLabel_5)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(itemList, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExit)))
					.addGap(31))
		);
		panel.setLayout(gl_panel);
		shopFrame.getContentPane().setLayout(groupLayout);
	}
}
