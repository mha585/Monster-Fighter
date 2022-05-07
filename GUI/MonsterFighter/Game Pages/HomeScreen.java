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
	
//	public void finishedWindow() {
//		manager.closeHomeScreen(this);
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeScreen = new JFrame();
		homeScreen.setTitle("MonsterFighter");
		homeScreen.setBounds(100, 100, 960, 590);
		homeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnChooseMonster = new JButton("Choose your first monster");
		btnChooseMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchChooseMonsterScreen();
			}
		});
		GroupLayout groupLayout = new GroupLayout(homeScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(338)
					.addComponent(btnChooseMonster, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(333))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(258)
					.addComponent(btnChooseMonster, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(270))
		);
		homeScreen.getContentPane().setLayout(groupLayout);
	}

}
