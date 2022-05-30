import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class ItemSuccessScreen {

	private JFrame ISScreen;
	private MonsterManager manager;
	private int monsterInt;
	private int itemInt;
	private String previousPage;
	private RandomGen num;

	/**
	 * Creates the item success screen
	 * @param monsterManager 	The manager responsible for creating this screen
	 * @param previous 			The previous page the player was on
	 * @param monsterIndex 		The index of the monster that used the item from the players team
	 * @param itemIndex 		The index of the item that was used on the monster from the players inventory
	 * @param number 			The RandomGen used to generate random numbers
	 */
	public ItemSuccessScreen(MonsterManager monsterManager, String previous, int monsterIndex, int itemIndex, RandomGen number) {
		manager = monsterManager;
		previousPage = previous;
		monsterInt = monsterIndex;
		itemInt = itemIndex;
		num = number;
		initialize();
		ISScreen.setVisible(true);
	}
	/**
	 * Closes the window
	 */
	public void closeWindow() {
		ISScreen.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ISScreen = new JFrame();
		ISScreen.setTitle("Item used");
		ISScreen.setBounds(100, 100, 960, 540);
		ISScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Monster monster = manager.getPlayer().getTeam().getFriend(monsterInt);
		String stat = manager.getPlayer().getInventory().getItem(itemInt).getStat();
		String statString = "";
		double previousVal = 0;
		double newVal = 0;
		if (stat == "atk") {
			statString = "Attack";
			previousVal = monster.getDamage();
			manager.getPlayer().getInventory().getItem(itemInt).useItem(monster);
			newVal = monster.getDamage();
		}
		else if (stat == "hp") {
			statString = "Health";
			previousVal = monster.getHealth();
			manager.getPlayer().getInventory().getItem(itemInt).useItem(monster);
			newVal = monster.getHealth();
		}
		else if (stat == "spd") {
			statString = "Speed";
			previousVal = monster.getSpeed();
			manager.getPlayer().getInventory().getItem(itemInt).useItem(monster);
			newVal = monster.getSpeed();
		}
		else if (stat == "tier") {
			statString = "Tier";
			previousVal = monster.getTier();
			manager.getPlayer().getInventory().getItem(itemInt).useItem(monster);
			newVal = monster.getTier();
		}
		else if (stat == "fainted") {
			statString = "Health";
			previousVal = monster.getHealth();
			manager.getPlayer().getInventory().getItem(itemInt).useItem(monster);
			newVal = monster.getHealth();
		}
		
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchInventoryScreen(previousPage, num);
			}
		});
		
		JLabel lblPrevStat = new JLabel(String.valueOf(previousVal));
		lblPrevStat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrevStat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblArrow = new JLabel("> > >");
		lblArrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrow.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewStat = new JLabel(String.valueOf(newVal));
		lblNewStat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblMStat = new JLabel(monster.getName() +" Increased "+statString+":");
		lblMStat.setHorizontalAlignment(SwingConstants.CENTER);
		lblMStat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel paddingLeft = new JPanel();
		
		JPanel paddingRight = new JPanel();
		
		JPanel paddingBottomRight = new JPanel();
		
		JPanel paddingBottomLeft = new JPanel();
		GroupLayout groupLayout = new GroupLayout(ISScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMStat, GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(paddingLeft, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrevStat, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblArrow, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewStat, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(paddingRight, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(paddingBottomLeft, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(paddingBottomRight, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMStat)
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPrevStat)
							.addComponent(lblArrow)
							.addComponent(lblNewStat))
						.addComponent(paddingLeft, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(paddingRight, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(paddingBottomLeft, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(paddingBottomRight, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(159))
		);
		ISScreen.getContentPane().setLayout(groupLayout);
	}
}
