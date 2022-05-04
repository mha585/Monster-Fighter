import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class HomeScreen {

	private JFrame homeScreen;
	private MonsterManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeScreen window = new HomeScreen();
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
	public HomeScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		homeScreen.setVisible(true);
	}
	
	public void closeWindow() {
		homeScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeHomeScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeScreen = new JFrame();
		homeScreen.setTitle("MonsterFighter");
		homeScreen.setBounds(100, 100, 960, 590);
		homeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnBattle = new JButton("Resizable button to test the battle screen");
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchBattleScreen(new RandomMonster(manager.getPlayer()));
			}
		});
		
		JButton btnResizableButtonTo = new JButton("Static button to test the choose monster screen");
		btnResizableButtonTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchChooseMonsterScreen();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Careful this crashes if team has no monsters in it!!");
		GroupLayout groupLayout = new GroupLayout(homeScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(128)
					.addComponent(btnResizableButtonTo)
					.addContainerGap(559, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(517)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBattle, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
							.addGap(194))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(211)
					.addComponent(btnResizableButtonTo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addComponent(btnBattle, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(146))
		);
		homeScreen.getContentPane().setLayout(groupLayout);
	}

}
