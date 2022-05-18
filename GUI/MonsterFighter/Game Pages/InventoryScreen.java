
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class InventoryScreen {

	private JFrame bagScreen;
	private MonsterManager manager;
	private String previousPage;
	private RandomGen number;

	/**
	 * Create the application.
	 */
	public InventoryScreen(MonsterManager incomingManager, String previous, RandomGen num) {
		manager = incomingManager;
		previousPage = previous;
		number = num;
		initialize();
		bagScreen.setVisible(true);
	}
	
	public void closeWindow() {
		bagScreen.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bagScreen = new JFrame();
		bagScreen.setTitle("Your inventory");
		bagScreen.setBounds(100, 100, 960, 540);
		bagScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Your Inventory:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		DefaultListModel<Object> itemList = new DefaultListModel<Object>();
		for (int i = 0; i < manager.getPlayer().getInventory().getSize(); i++) {
			Item item = (Item) manager.getPlayer().getInventory().getItem(i);
			itemList.addElement(item+": "+item.getDescription());
		}
		
		JList<Object> itemJList = new JList<Object>(itemList);
		itemJList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		itemJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> itemJList = (JList<Object>) event.getSource();
				if (event.getClickCount() >= 2) {
					int itemIndex = itemJList.locationToIndex(event.getPoint());
					closeWindow();
					manager.launchUseItemScreen(previousPage, itemIndex, number);
				}
			}
		});

		itemJList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		itemJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNewLabel_1 = new JLabel("Click on an item to use it");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				if (previousPage == "Prep") {
					manager.launchPrepScreen(number, manager.isAbleToFight());
				} else if (previousPage == "Fight") {
					manager.launchBattleScreen(false, number, "");
				} else if (previousPage == "Shop") {
					manager.launchShopScreen(number);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(bagScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton))
							.addComponent(itemJList, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 862, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(itemJList, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		bagScreen.getContentPane().setLayout(groupLayout);
	}
}
