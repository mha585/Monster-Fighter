import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class StartUpScreen {

	private JFrame startupScreen;
	private JTextField tfName;
	private MonsterManager manager;
	private Player user;
	

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
	 * @param newPlayer 
	 */
	public StartUpScreen(MonsterManager incomingManager, Player newPlayer) {
		user = newPlayer;
		manager = incomingManager;
		initialize();
		startupScreen.setVisible(true);
	}
	
	public void closeWindow() {
		startupScreen.dispose();
	}
	
	public void finishedWindow() {
		manager.closeStartScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		startupScreen = new JFrame();
		startupScreen.setBounds(100, 100, 960, 590);
		startupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tfName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Welcome to Monster Fighter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 30));
		
		JLabel lblName = new JLabel("What is your name?");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblReqLen = new JLabel("Name must be 3-15 characters long.");
		lblReqLen.setVisible(false);
		lblReqLen.setForeground(Color.RED);
		
		JLabel lblReqAlpha = new JLabel("Name must only contain alphabet characters.");
		lblReqAlpha.setVisible(false);
		lblReqAlpha.setForeground(Color.RED);
		
		JLabel lblSuccess = new JLabel("Success");
		lblSuccess.setForeground(Color.GREEN);
		lblSuccess.setVisible(false);
		
		JLabel lblDay = new JLabel("How many days will your journey last for?");
		lblDay.setVisible(false);
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JSlider sliderDay = new JSlider();
		sliderDay.setVisible(false);
		sliderDay.setSnapToTicks(true);
		sliderDay.setPaintLabels(true);
		sliderDay.setPaintTicks(true);
		sliderDay.setMajorTickSpacing(1);
		sliderDay.setMinimum(5);
		sliderDay.setMaximum(15);
		
		JLabel lblDiff = new JLabel("Choose a difficulty level.");
		lblDiff.setVisible(false);
		lblDiff.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JSpinner spinnerDiff = new JSpinner();
		spinnerDiff.setVisible(false);
		spinnerDiff.setToolTipText("\r\n");
		spinnerDiff.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinnerDiff.setModel(new SpinnerListModel(new String[] {"Easy", "Normal", "Hard"}));
		
		JButton btnFinished = new JButton("Next");
		btnFinished.setVisible(false);
		btnFinished.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int intDay = sliderDay.getValue();
				Object strDiff = spinnerDiff.getValue();
				int intDiff = 1;
				if (strDiff == "Easy") {
					intDiff = 1;
				}
				else if (strDiff == "Normal") {
					intDiff = 2;
				}
				else if (strDiff == "Hard") {
					intDiff = 3;
				}
				user.setDay(intDay);
				user.setDifficulty(intDiff);
				closeWindow();
				manager.launchHomeScreen();
			}
		});
		
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String stringName = tfName.getText();
				if (user.checkName(stringName) == true) {
					lblReqLen.setVisible(false);
					lblReqAlpha.setVisible(false);
					lblSuccess.setVisible(true);
					user.setName(stringName);
					lblDay.setVisible(true);
					sliderDay.setVisible(true);
					lblDiff.setVisible(true);
					spinnerDiff.setVisible(true);
					btnFinished.setVisible(true);
				}
				else {
					lblReqLen.setVisible(true);
					lblReqAlpha.setVisible(true);
					lblSuccess.setVisible(false);
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(startupScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
							.addGap(255))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnFinished, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDay)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(sliderDay, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDiff, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(spinnerDiff, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(420, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblReqLen)
									.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
									.addComponent(lblSuccess, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfName, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(lblReqAlpha, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSubmitButton)
							.addGap(259))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblName)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSubmitButton)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReqLen)
						.addComponent(lblSuccess))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReqAlpha)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiff, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerDiff, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(sliderDay, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDay))
					.addGap(48)
					.addComponent(btnFinished, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		startupScreen.getContentPane().setLayout(groupLayout);
	}
}
