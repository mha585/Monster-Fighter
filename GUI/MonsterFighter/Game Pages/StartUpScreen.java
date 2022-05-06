import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class StartUpScreen {

	private JFrame startupScreen;
	private JTextField tfName;
	private MonsterManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StartUpScreen window = new StartUpScreen();
//					window.startupScreen.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public StartUpScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		startupScreen.setVisible(true);
	}
	
	public void closeWindow() {
		startupScreen.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		startupScreen = new JFrame();
		startupScreen.setBounds(100, 100, 960, 540);
		startupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tfName.setColumns(10);
		
		JLabel lblName = new JLabel("What is your name?");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lbDay = new JLabel("How many days will your journey last for?");
		lbDay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JSlider sliderName = new JSlider();
		sliderName.setSnapToTicks(true);
		sliderName.setPaintLabels(true);
		sliderName.setPaintTicks(true);
		sliderName.setMajorTickSpacing(1);
		sliderName.setMinimum(5);
		sliderName.setMaximum(15);
		
		JLabel lbDiff = new JLabel("Choose a difficulty level.");
		lbDiff.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JSpinner spinnerDiff = new JSpinner();
		spinnerDiff.setToolTipText("\r\n");
		spinnerDiff.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinnerDiff.setModel(new SpinnerListModel(new String[] {"Easy ", "Normal", "Hard"}));
		
		JButton btnFinished = new JButton("Next");
		btnFinished.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblImagePlayer = new JLabel("I will Create player model");
		
		JLabel lblNewLabel = new JLabel("Welcome to Monster Fighter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(startupScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbDay)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sliderName, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lbDiff, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
										.addGap(38)
										.addComponent(spinnerDiff, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addGap(137))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfName, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
										.addGap(95)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(167)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(lblImagePlayer, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(860, Short.MAX_VALUE)
					.addComponent(btnFinished, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblName))
									.addGap(63)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lbDiff, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinnerDiff, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
									.addGap(17))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblImagePlayer, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
									.addGap(44)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(127)
									.addComponent(btnFinished, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbDay)
										.addComponent(sliderName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		startupScreen.getContentPane().setLayout(groupLayout);
	}
}
