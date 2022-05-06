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

public class ShopScreen {

	private JFrame shopFrame;
	private JTextField textField;
	private MonsterManager manager;

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
	public ShopScreen(MonsterManager incomingManager) {
		manager = incomingManager;
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
		
		textField = new JTextField();
		textField.setBackground(SystemColor.control);
		textField.setBorder(null);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Atk Boost");
		
		JLabel lblNewLabel_1_1 = new JLabel("Atk Plus");
		
		JLabel lblNewLabel_1_2 = new JLabel("Basic Heal");
		
		JLabel lblNewLabel_1_3 = new JLabel("Full Heal");
		
		JLabel lblNewLabel_1_4 = new JLabel("Mega Heal");
		
		JLabel lblNewLabel_1_5 = new JLabel("Speed Boost");
		
		JLabel lblNewLabel_1_6 = new JLabel("Speed Plus");
		
		JLabel lblNewLabel_1_7 = new JLabel("Tier Plus");
		
		JLabel lblNewLabel_2 = new JLabel("Purchase Successful");
		lblNewLabel_2.setForeground(Color.RED);
		
		JButton btnNewButton = new JButton("Buy");
		
		JLabel lblNewLabel_3 = new JLabel("An error will occur if they try to add something into the trolley and it makes the player go over budget");
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Item x3", "Other Item x 5", "New Item x 10"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Description:");
		
		JLabel lblNewLabel_4_1 = new JLabel("Cost:");
		
		JLabel lblNewLabel_5 = new JLabel("Clicking on an item in the trolley will prompt a pop up that'll ask the user if they want to remove the item/ copies of the item from the trolley.");
		
		JButton btnNewButton_1 = new JButton(" Monster1 including cost, description, type, and stats");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		
		JButton btnNewButton_1_1 = new JButton("Monster2");
		
		JButton btnNewButton_1_2 = new JButton("Monster3");
		
		JButton btnNewButton_1_2_1 = new JButton("Monster4");
		
		JButton btnNewButton_2 = new JButton("Sell Items: Takes you to bag");
		
		JButton btnNewButton_3 = new JButton("Next");
		GroupLayout groupLayout = new GroupLayout(shopFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(797, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton)
									.addGap(18)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
									.addGap(257))
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(124)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(84)
									.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addGap(74)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(148)
									.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_4)
					.addContainerGap(892, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE)
					.addGap(66))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(617, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(49)
					.addComponent(btnNewButton_3)
					.addGap(110))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_4)
						.addComponent(lblNewLabel_1_3)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_1))
					.addGap(17)
					.addComponent(lblNewLabel_4)
					.addGap(18)
					.addComponent(lblNewLabel_4_1)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_5)
						.addComponent(lblNewLabel_1_7)
						.addComponent(lblNewLabel_1_6))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_5)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addComponent(lblNewLabel_2))
							.addGap(55))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(17))
		);
		shopFrame.getContentPane().setLayout(groupLayout);
	}
}
