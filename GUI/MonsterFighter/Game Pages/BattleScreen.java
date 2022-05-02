import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleScreen {

	private JFrame battleScreen;
	private MonsterManager manager;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MonsterManager test = new MonsterManager();
//					BattleScreen window = new BattleScreen(test);
//					window.battleScreen.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BattleScreen(MonsterManager incomingManager) {
		manager = incomingManager;
		initialize();
		battleScreen.setVisible(true);
	}
	
	public void closeWindow() {
		battleScreen.dispose();
	}
	public void finishedWindow() {
		manager.closeBattleScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		battleScreen = new JFrame();
		battleScreen.setTitle("MonsterFighter Battle");
		battleScreen.setBounds(100, 100, 960, 540);
		battleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCurrentHealth = new JLabel("99");
		
		JLabel lblMaxHealth = new JLabel("100");
		
		JPanel panelButtons = new JPanel();
		
		JLabel lblSlash = new JLabel("/");
		
		JPanel pannelMonsters = new JPanel();
		
		JButton btnTempMonsterImage = new JButton("Friend image goes here");
		
		JButton btnQuit = new JButton("Run from battle?");
		
		JButton btnEnemyImageGoes = new JButton("Enemy image goes here");
		GroupLayout gl_pannelMonsters = new GroupLayout(pannelMonsters);
		gl_pannelMonsters.setHorizontalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pannelMonsters.createSequentialGroup()
							.addComponent(btnTempMonsterImage)
							.addGap(150)
							.addComponent(btnEnemyImageGoes, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(252))
						.addGroup(Alignment.TRAILING, gl_pannelMonsters.createSequentialGroup()
							.addComponent(btnQuit)
							.addGap(55))))
		);
		gl_pannelMonsters.setVerticalGroup(
			gl_pannelMonsters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelMonsters.createSequentialGroup()
					.addGap(10)
					.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pannelMonsters.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnemyImageGoes, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTempMonsterImage, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
		);
		pannelMonsters.setLayout(gl_pannelMonsters);
		
		JPanel panelWords = new JPanel();
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblCurrentName = new JLabel("");
		lblCurrentName.setText(manager.getPlayer().getTeam().getFriend(0).getName());
		
		GroupLayout gl_panelWords = new GroupLayout(panelWords);
		gl_panelWords.setHorizontalGroup(
			gl_panelWords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(22)
					.addComponent(lblName)
					.addGap(18)
					.addComponent(lblCurrentName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(429))
		);
		gl_panelWords.setVerticalGroup(
			gl_panelWords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelWords.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panelWords.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(lblCurrentName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(161, Short.MAX_VALUE))
		);
		panelWords.setLayout(gl_panelWords);
		GroupLayout groupLayout = new GroupLayout(battleScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCurrentHealth, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSlash)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMaxHealth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(171)))
					.addGap(0))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(pannelMonsters, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCurrentHealth)
						.addComponent(lblSlash)
						.addComponent(lblMaxHealth))
					.addGap(8)
					.addComponent(pannelMonsters, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelWords, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
					.addGap(0))
		);
		
		JButton btnFight = new JButton("Fight");
		
		JButton btnHeal = new JButton("Heal");
		
		JButton btnTeam = new JButton("Monsters");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentName.setText(manager.getPlayer().getTeam().getFriend(0).getName());
				lblName.setText("this is a test");
			}
		});
		
		JButton btnItems = new JButton("Inventory");
		GroupLayout gl_panelButtons = new GroupLayout(panelButtons);
		gl_panelButtons.setHorizontalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelButtons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelButtons.createSequentialGroup()
							.addComponent(btnFight, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnHeal, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
						.addGroup(gl_panelButtons.createSequentialGroup()
							.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnItems, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
					.addGap(9))
		);
		gl_panelButtons.setVerticalGroup(
			gl_panelButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtons.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelButtons.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFight, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(btnHeal, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
					.addGap(6)
					.addGroup(gl_panelButtons.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTeam, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(btnItems, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
					.addGap(12))
		);
		panelButtons.setLayout(gl_panelButtons);
		battleScreen.getContentPane().setLayout(groupLayout);
	}
}
