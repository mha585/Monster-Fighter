import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NightScreen {

	private JFrame nightFrame;
	private MonsterManager manager;

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
	public NightScreen(MonsterManager incomingManager) {
		manager = incomingManager;
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
		
		JLabel lblNewLabel_1 = new JLabel("Next");
		GroupLayout groupLayout = new GroupLayout(nightFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(309)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(345, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(438, Short.MAX_VALUE)
					.addComponent(lblSummary, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(426))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(448, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBattles, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPPoints, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRandom, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
					.addGap(279))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(891, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel)
					.addGap(98)
					.addComponent(lblSummary)
					.addGap(104)
					.addComponent(lblPPoints)
					.addGap(57)
					.addComponent(lblMoney)
					.addGap(69)
					.addComponent(lblBattles)
					.addGap(56)
					.addComponent(lblRandom)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addContainerGap())
		);
		nightFrame.getContentPane().setLayout(groupLayout);
	}

}
