import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WinScreen {

	private JFrame winFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinScreen window = new WinScreen();
					window.winFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WinScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		winFrame = new JFrame();
		winFrame.setBounds(100, 100, 960, 590);
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblGame = new JLabel("G A M E    O V E R");
		lblGame.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblYouWin = new JLabel("YOU WIN!");
		lblYouWin.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouWin.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("Image");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblDays = new JLabel("Days Completed:");
		lblDays.setHorizontalAlignment(SwingConstants.LEFT);
		lblDays.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblMoney = new JLabel("Total Money Earned:");
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblPoints = new JLabel("Total Points Earned:");
		lblPoints.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(winFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(304)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYouWin, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGame, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDays)
								.addComponent(lblName)
								.addComponent(lblMoney)
								.addComponent(lblPoints, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(352)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(316, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGame, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblYouWin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDays, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPoints, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		winFrame.getContentPane().setLayout(groupLayout);
	}

}
