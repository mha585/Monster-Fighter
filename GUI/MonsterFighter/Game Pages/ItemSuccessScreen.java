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

public class ItemSuccessScreen {

	private JFrame ISScreen;
	private MonsterManager manager;
	private int monsterInt;
	private int itemInt;
	private String previousPage;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ItemSuccessScreen window = new ItemSuccessScreen();
//					window.ISScreen.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param monsterIndex 
	 * @param monsterManager 
	 * @param previousPage 
	 * @param itemIndex 
	 */
	public ItemSuccessScreen(MonsterManager monsterManager, String previous, int monsterIndex, int itemIndex) {
		manager = monsterManager;
		previousPage = previous;
		monsterInt = monsterIndex;
		itemInt = itemIndex;
		initialize();
		ISScreen.setVisible(true);
	}
	
	public void closeWindow() {
		ISScreen.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ISScreen = new JFrame();
		ISScreen.setBounds(100, 100, 500, 300);
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
				manager.launchInventoryScreen("Prep");
			}
		});
		
		JLabel lblPrevStat = new JLabel(String.valueOf(previousVal));
		lblPrevStat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblArrow = new JLabel("> > >");
		lblArrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrow.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewStat = new JLabel(String.valueOf(newVal));
		lblNewStat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblMStat = new JLabel(monster.getName() +" Increased "+statString+":");
		lblMStat.setHorizontalAlignment(SwingConstants.CENTER);
		lblMStat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(ISScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(417, Short.MAX_VALUE)
					.addComponent(btnOK)
					.addContainerGap())
				.addComponent(lblMStat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(82, Short.MAX_VALUE)
					.addComponent(lblPrevStat)
					.addGap(59)
					.addComponent(lblArrow)
					.addGap(60)
					.addComponent(lblNewStat)
					.addGap(85))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMStat)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblArrow)
									.addComponent(lblPrevStat))
								.addComponent(lblNewStat))
							.addContainerGap(113, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOK)
							.addContainerGap())))
		);
		ISScreen.getContentPane().setLayout(groupLayout);
	}

}
