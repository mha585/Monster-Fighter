import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				manager.launchBattleScreen();
			}
		});
		GroupLayout groupLayout = new GroupLayout(homeScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(346)
					.addComponent(btnBattle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(365))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(238)
					.addComponent(btnBattle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(290))
		);
		homeScreen.getContentPane().setLayout(groupLayout);
	}

}
