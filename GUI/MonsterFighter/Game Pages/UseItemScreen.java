import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JList;

public class UseItemScreen {

	private JFrame useItemScreen;
	private int item;
	private MonsterManager manager;
	private String previous;
	private RandomGen num;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UseItemScreen window = new UseItemScreen();
//					window.useItemScreen.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param itemIndex 
	 * @param monsterManager 
	 * @param previousPage 
	 */
	public UseItemScreen(MonsterManager monsterManager, String previousPage, int itemIndex, RandomGen number) {
		item = itemIndex;
		manager = monsterManager;
		previous = previousPage;
		num = number;
		initialize();
		useItemScreen.setVisible(true);
	}
	
	public void closeWindow() {
		useItemScreen.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		useItemScreen = new JFrame();
		useItemScreen.setBounds(100, 100, 960, 540);
		useItemScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblInstruct = new JLabel("Select a monster to use " +manager.getPlayer().getInventory().getItem(item).getName()+" on.");
		lblInstruct.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(previous);
				closeWindow();
				manager.launchInventoryScreen(previous, num);
			}
		});
		
		DefaultListModel<Object> monsterList = new DefaultListModel<Object>();
		for (int i = 0; i < manager.getPlayer().getTeam().getSize(); i++) {
			Monster monster = (Monster) manager.getPlayer().getTeam().getFriend(i);
			String stat = manager.getPlayer().getInventory().getItem(item).getStat();
			if (stat == "atk") {
				monsterList.addElement(monster.getName() + "Attack: "+monster.getDamage());
			}
			else if (stat == "hp") {
				monsterList.addElement(monster.getName() + "Health: "+monster.getHealth()+"/ "+monster.getMaxHealth());
			}
			else if (stat == "spd") {
				monsterList.addElement(monster.getName() + "Speed: "+monster.getSpeed());
			}
			else if (stat == "tier") {
				monsterList.addElement(monster.getName() + "Tier: "+monster.getTier());
			}
			else if (stat == "fainted") {
				monsterList.addElement(monster.getName() + "Health: "+monster.getHealth()+"/ "+monster.getMaxHealth());
			}
		}
		
		JList<Object> listMonsters = new JList<Object>(monsterList);
		listMonsters.setFont(new Font("Tahoma", Font.PLAIN, 33));
		listMonsters.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> itemJList = (JList<Object>) event.getSource();
				if (event.getClickCount() >= 1) {
					int monsterIndex = listMonsters.locationToIndex(event.getPoint());
					manager.launchItemSuccessScreen(previous, monsterIndex, item, num);
					manager.getPlayer().getInventory().getItem(item).addFreq(manager.getPlayer().getInventory().getItem(item), -1);
					closeWindow();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(useItemScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInstruct)
					.addContainerGap(539, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(845, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(listMonsters, GroupLayout.PREFERRED_SIZE, 903, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInstruct)
					.addGap(18)
					.addComponent(listMonsters, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addContainerGap())
		);
		useItemScreen.getContentPane().setLayout(groupLayout);
	}
}
