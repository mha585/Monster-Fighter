import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NightScreen {

	private JFrame nightFrame;
	private MonsterManager manager;
	private RandomGen num;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NightScreen window = new NightScreen();
//					window.nightFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NightScreen(MonsterManager incomingManager, RandomGen number) {
		manager = incomingManager;
		num = number;
		initialize();
		nightFrame.setVisible(true);
	}
	
	public void closeWindow() {
		nightFrame.dispose();
	}	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		nightFrame = new JFrame();
		nightFrame.setTitle("Night time");
		nightFrame.setBounds(100, 100, 960, 540);
		nightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Bunch of Images + Summary of Day (stardew valley style)");
		
		JLabel lblSummary = new JLabel("Summary:");
		
		JLabel lblPPoints = new JLabel("Points:");
		
		JLabel lblMoney = new JLabel("Money:");
		
		JLabel lblBattles = new JLabel("Battles:");
		
		JLabel lblRandom = new JLabel("Random Events:");
		
		JButton btnNewButton = new JButton("Next Day");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().addDay();
				closeWindow();
				manager.launchPrepScreen(num);
			}
		});
		GroupLayout groupLayout = new GroupLayout(nightFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(309)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(343, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(401, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSummary, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(147))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 10, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBattles, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPPoints, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRandom, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))))
					.addGap(314))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(845, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel)
					.addGap(45)
					.addComponent(lblSummary)
					.addGap(104)
					.addComponent(lblPPoints)
					.addGap(57)
					.addComponent(lblMoney)
					.addGap(69)
					.addComponent(lblBattles)
					.addGap(56)
					.addComponent(lblRandom)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		nightFrame.getContentPane().setLayout(groupLayout);
	}

}
