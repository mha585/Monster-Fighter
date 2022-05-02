import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ChooseMonsterScreen {

	private JFrame chooseMonsterScreen;
	private MonsterManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChooseMonsterScreen window = new ChooseMonsterScreen();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ChooseMonsterScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		chooseMonsterScreen.setVisible(true);
	}
	
	public void closeWindow() {
		chooseMonsterScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeChooseMonsterScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chooseMonsterScreen = new JFrame();
		chooseMonsterScreen.setBounds(100, 100, 960, 590);
		chooseMonsterScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnChooseGrass = new JButton("Grass Monster");
		btnChooseGrass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(new GrassMonster("Grassdude", 70, 5.0, 10.0, 20.0, 1, 150, 250, "A strong grass type Monster. It is said that they dwell in the deapest parts of the jungle."));
			}
		});
		
		JButton btnChooseFire = new JButton("Fire Monster");
		btnChooseFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(new FireMonster("Fireguy", 50.0, 5.0, 20.0, 20.0, 1, 150, 250, "A strong fire type Monster capable of burning down buildings."));
			}
		});
		
		JButton btnChooseWater = new JButton("Water Monster");
		btnChooseWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getTeam().addFriend(new WaterMonster("Waterman", 60, 5.0, 15.0, 20.0, 1, 150, 250, "A strong water type Monster. These streamline monsters are known to have existed before humans."));
				closeWindow();
				manager.launchBattleScreen();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Only this one takes you out at the moment for testing");
		GroupLayout groupLayout = new GroupLayout(chooseMonsterScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(btnChooseWater, GroupLayout.PREFERRED_SIZE, 99, Short.MAX_VALUE)
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(btnChooseFire, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(51)
							.addComponent(btnChooseGrass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(20))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(btnChooseGrass, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(btnChooseFire, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(157))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(170)
					.addComponent(btnChooseWater, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addContainerGap())
		);
		chooseMonsterScreen.getContentPane().setLayout(groupLayout);
	}
}
