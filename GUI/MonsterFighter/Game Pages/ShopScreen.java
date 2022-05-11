import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.CardLayout;

public class ShopScreen {

	private JFrame shopFrame;
	private MonsterManager manager;
	private RandomGen num;
	private Player user;
	private Shop newShop; 
	List<Item> items = new ArrayList<Item>();
	List<RandomMonster> monsters = new ArrayList<RandomMonster>();
	int totalCost = 0;
	private String current = "BI";

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShopScreen window = new ShopScreen();
//					window.shopFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param number 
	 */
	public ShopScreen(MonsterManager incomingManager, RandomGen number) {
		manager = incomingManager;
		num = number;
		newShop = new Shop(incomingManager.getPlayer(), num);
		initialize();
		shopFrame.setVisible(true);
	}
	
	public void closeWindow() {
		shopFrame.dispose();
	}
	
	public void setZero() {
		totalCost = 0;
	}
	
	public void addCost(int num) {
		totalCost += num;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shopFrame = new JFrame();
		shopFrame.setBounds(100, 100, 960, 540);
		shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JLabel lblPlyrMoney = new JLabel("Money:");
		lblPlyrMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JLabel lblCost = new JLabel("Total Cost:");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCostOfCart = new JLabel(""+totalCost);
		lblCostOfCart.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel shopPanel = new JPanel();
		CardLayout CL = new CardLayout(0,0);
		shopPanel.setLayout(CL);
		
		DefaultListModel<Object> cart = new DefaultListModel<Object>();
		DefaultListModel<Object> cartObjects = new DefaultListModel<Object>();
		
		JList<Object> JLShoppingCart = new JList<Object>(cart);
		JLShoppingCart.setEnabled(true);
		JLShoppingCart.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLShoppingCart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> JLShoppingCart = (JList<Object>) event.getSource();
				if (event.getClickCount() == 2) {
					int index = JLShoppingCart.locationToIndex(event.getPoint());
					if (current == "BI") {
						Item item = (Item) cartObjects.get(index);
						System.out.println(item.toString());
						if (item.getFrequency() > 1) {
							item.addFreq(-1);
						}
						else if (item.getFrequency() == 1) {
							cart.remove(index);
							cartObjects.remove(index);
						}
					}
					else if (current == "BM") {
						Monster monster = (Monster) cart.get(index);
					}
					else if (current == "SI") {
						Item item = (Item) cart.get(index);
					}
					else if (current == "SM") {
						Monster monster = (Monster) cart.get(index);
					}
					if (cart.isEmpty()) {
						JLShoppingCart.setEnabled(true);
					}
				}
			}
		});

		items = newShop.getItems();
		monsters = newShop.getMonsters();

		DefaultListModel<Object> itemDisplay = new DefaultListModel<Object>();
		for (int i = 0; i < newShop.getItems().size(); i++) {
			Item item = (Item) newShop.getItems().get(i);
			itemDisplay.addElement("<html>" + item.getName() + ": " + item.getDescription() + 
											"<br>Cost: $"+item.getPrice() +
											"<br> ----------" + 
											"</span></html>");
		}
		
		DefaultListModel<Object> monsterDisplay = new DefaultListModel<Object>();
		for (int i = 0; i < newShop.getMonsters().size(); i++) {
			Monster monster = (Monster) newShop.getMonsters().get(i);
			monsterDisplay.addElement("<html>Name: " + monster.getName() +
										"<br>Type: " + monster.getType() +
										"<br>Health: " + monster.getHealth() + " / " + monster.getMaxHealth() +
										"<br>Damage: " + monster.getDamage() +
										"<br>Speed: " + monster.getSpeed() +
										"<br>Tier: " + monster.getTier() +
										"<br>Cost: $" + monster.getPrice() +
										"<br> ----------" + 
										"</span></html>");
		}
		DefaultListModel<Object> itemUsrDisplay = new DefaultListModel<Object>();
		for (int i = 0; i < manager.getPlayer().getInventory().getSize(); i++) {
			Item item = (Item) manager.getPlayer().getInventory().getItem(i);
			itemUsrDisplay.addElement("<html>" + item.getName() + ": " + item.getDescription() + 
												"<br>Selling Price: " + item.sellPrice() + 
												"<br>Amount in bag: " + item.getFrequency() +
												"<br> ----------" + 
												"</span></html>");
		}
		
		DefaultListModel<Object> monsterUsrDisplay = new DefaultListModel<Object>();
		for (int i = 0; i < manager.getPlayer().getTeam().getSize(); i++) {
			Monster monster = (Monster) manager.getPlayer().getTeam().getFriend(i);
			monsterUsrDisplay.addElement("<html>Name: " + monster.getName() +
					"<br>Type: " + monster.getType() +
					"<br>Health: " + monster.getHealth() + " / " + monster.getMaxHealth() +
					"<br>Damage: " + monster.getDamage() +
					"<br>Speed: " + monster.getSpeed() +
					"<br>Tier: " + monster.getTier() +
					"<br>Selling Price: $" + monster.sellPrice() +
					"<br> ----------" + 
					"</span></html>");
		}
		
		JList listBuyItm = new JList((ListModel) itemDisplay);
		listBuyItm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listBuyItm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> listBuyItm  = (JList<Object>) event.getSource();
				if (event.getClickCount() == 2) {
					int cartCost = totalCost;
					int itemIndex = listBuyItm.locationToIndex(event.getPoint());
					if (cartObjects.contains(items.get(itemIndex))) {
						int cartIndex = cart.indexOf(items.get(itemIndex));
						Item item = ((Item) cart.get(cartIndex));
						cart.remove(cartIndex);
						item.addFreq(1);
						cart.add(0, item);
						cartCost += item.getPrice();
						lblCostOfCart.setText(""+cartCost);
						totalCost = cartCost;
						Item cartItem = (Item) cartObjects.get(cartIndex);
						cartItem.addFreq(1);
					}
					else {
						Item item = items.get(itemIndex);
						item.addFreq(1);
						cart.add(0, item);
						cartCost += item.getPrice();
						lblCostOfCart.setText(""+cartCost);
						totalCost = cartCost;
						cartObjects.add(0, item);
					}
				}
			}
		});
		shopPanel.add(new JScrollPane(listBuyItm), "BuyItems");
		
		JList listBuyMnstr = new JList((ListModel) monsterDisplay);
		listBuyMnstr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listBuyMnstr.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> listBuyMnstr = (JList<Object>) event.getSource();
				if (event.getClickCount() == 2) {
					int cartCost = totalCost;
					int mnstrIndex = listBuyMnstr.locationToIndex(event.getPoint());
					if (cart.contains(monsters.get(mnstrIndex).getName()) == false) {
						cart.add(0, monsters.get(mnstrIndex).getName());
						cartCost += monsters.get(mnstrIndex).getPrice();
						lblCostOfCart.setText(""+cartCost);
						totalCost = cartCost;
						cartObjects.add(0, monsters.get(mnstrIndex));
					}
					else {
						System.out.println("Monster already in cart");
						
					}
				}
			}
		});
		shopPanel.add(new JScrollPane(listBuyMnstr), "BuyMonsters");
		
		JList listSellMnstr = new JList(monsterUsrDisplay);
		listSellMnstr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listSellMnstr.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> listSellMnstr = (JList<Object>) event.getSource();
				if (event.getClickCount() == 2) {
					int mnstrIndex = listSellMnstr.locationToIndex(event.getPoint());
					if (cart.contains(monsters.get(mnstrIndex).getName()) == false && manager.getPlayer().getTeam().getSize() > 1) {
						cart.add(0,  monsters.get(mnstrIndex).getName());
						cartObjects.add(0,  monsters.get(mnstrIndex));
						
					}
					else if(cart.contains(monsters.get(mnstrIndex).getName())) {
						System.out.println("You cannot sell the same monster twice");
					}
					else if(manager.getPlayer().getTeam().getSize() == 1) {
						System.out.println("You cannot sell your last monster");
					}
					
				}
			}
		});
		
		shopPanel.add(new JScrollPane(listSellMnstr), "SellMonsters");


		
		JList listSellItm = new JList(itemUsrDisplay);
		listSellItm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listSellItm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> listSellItm = (JList<Object>) event.getSource();
				if (event.getClickCount() == 2) {
					Inventory PlayerBag = new Inventory();
					for (int i = 0; i < manager.getPlayer().getInventory().getSize(); i++) {
						PlayerBag.addtoBag(manager.getPlayer().getInventory().getItem(i), 0);
					}
					System.out.println(PlayerBag);
					int itemIndex = listSellItm.locationToIndex(event.getPoint());
					Inventory updatedBag = PlayerBag;
					if (updatedBag.getItem(itemIndex).getFrequency() > 0) {
						cart.add(0,  items.get(itemIndex).getName());
						updatedBag.removeBag(itemIndex, 1);
						PlayerBag = updatedBag;
						System.out.println(updatedBag);
						cartObjects.add(0, items.get(itemIndex));
					}
					else {
						System.out.println("KEKW");
					}
				}
			}
		});
		
		shopPanel.add(new JScrollPane(listSellItm), "SellItems");
		
		JButton btnBuyItm = new JButton("Buy Items");
		btnBuyItm.setEnabled(false);
		btnBuyItm.setSelected(true);

		JButton btnSellMnstr = new JButton("Sell Monsters");
		
		JButton btnSellItm = new JButton("Sell Items");

		JButton btnBuyMnstr = new JButton("Buy Monsters\r\n");

		btnBuyItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CL.show(shopPanel, "BuyItems");
				btnBuyItm.setEnabled(false);
				btnBuyItm.setSelected(true);
				btnBuyMnstr.setEnabled(true);
				btnBuyMnstr.setSelected(false);
				btnSellItm.setEnabled(true);
				btnSellItm.setSelected(false);
				btnSellMnstr.setEnabled(true);
				btnSellMnstr.setSelected(false);
				totalCost = 0;
				lblCost.setVisible(true);
				lblCostOfCart.setVisible(true);
				cart.clear();
				current = "BI";
			}
		});
		btnBuyMnstr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CL.show(shopPanel, "BuyMonsters");
				btnBuyItm.setEnabled(true);
				btnBuyItm.setSelected(false);
				btnBuyMnstr.setEnabled(false);
				btnBuyMnstr.setSelected(true);
				btnSellItm.setEnabled(true);
				btnSellItm.setSelected(false);
				btnSellMnstr.setEnabled(true);
				btnSellMnstr.setSelected(false);
				totalCost = 0;
				lblCost.setVisible(true);
				lblCostOfCart.setVisible(true);
				cart.clear();
				current = "BM";
			}
		});
		btnSellItm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CL.show(shopPanel, "SellItems");
				btnBuyItm.setEnabled(true);
				btnBuyItm.setSelected(false);
				btnBuyMnstr.setEnabled(true);
				btnBuyMnstr.setSelected(false);
				btnSellItm.setEnabled(false);
				btnSellItm.setSelected(true);
				btnSellMnstr.setEnabled(true);
				btnSellMnstr.setSelected(false);
				totalCost = 0;
				lblCost.setVisible(false);
				lblCostOfCart.setVisible(false);
				cart.clear();
				current = "SI";
			}
		});
		btnSellMnstr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CL.show(shopPanel, "SellMonsters");
				btnBuyItm.setEnabled(true);
				btnBuyItm.setSelected(false);
				btnBuyMnstr.setEnabled(true);
				btnBuyMnstr.setSelected(false);
				btnSellItm.setEnabled(true);
				btnSellItm.setSelected(false);
				btnSellMnstr.setEnabled(false);
				btnSellMnstr.setSelected(true);
				totalCost = 0;
				lblCost.setVisible(false);
				lblCostOfCart.setVisible(false);
				cart.clear();
				current = "SM";
			}
		});
		JButton btnExitShop = new JButton("Exit");
		btnExitShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchNightScreen();
			}
		});
		
		JPanel panelfill1 = new JPanel();
		JPanel panelfill2 = new JPanel();
		
		JLabel lblUserMoney = new JLabel("$"+manager.getPlayer().getMoney());
		lblUserMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAddItem = new JLabel("Double click on an item/ monster to add it to your cart");
		
		JLabel lblStart = new JLabel("");
		JLabel lblSuccuess = new JLabel("Success");
		JLabel lblError = new JLabel("Error");
		JPanel panelVerify = new JPanel();
		CardLayout verify = new CardLayout(0, 0);
		panelVerify.setLayout(verify);
		panelVerify.add(lblStart);
		panelVerify.add(lblSuccuess);
		panelVerify.add(lblError);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalCost = 0;
				for (int i = 0; i < JLShoppingCart.getModel().getSize(); i++) {
					totalCost += ((Purchasable) JLShoppingCart.getModel().getElementAt(i)).getPrice();
				}
				if (manager.getPlayer().getMoney() >= totalCost) {
					for (int i = 0; i < JLShoppingCart.getModel().getSize(); i++) {
						Item item = (Item) JLShoppingCart.getModel().getElementAt(i);
						int frequency = 0;
					}
				}
			}
		});
		
		JLabel lblRemoveItem = new JLabel("Double click on an item/monster to remove it from your cart");

		

		


		

		GroupLayout groupLayout = new GroupLayout(shopFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPlyrMoney, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblUserMoney, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(202)
							.addComponent(lblAddItem, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblRemoveItem)
									.addComponent(JLShoppingCart, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblCostOfCart, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
											.addComponent(lblCost, GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnConfirm))
									.addComponent(panelVerify, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGap(42)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnBuyItm, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBuyMnstr, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSellItm, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSellMnstr, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
								.addGap(63)
								.addComponent(btnExitShop, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelfill1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addGap(2)
								.addComponent(shopPanel, GroupLayout.PREFERRED_SIZE, 838, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelfill2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPlyrMoney)
							.addComponent(lblUserMoney))
						.addComponent(lblAddItem))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(shopPanel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelfill1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelfill2, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblRemoveItem, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(JLShoppingCart, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(panelVerify, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblCost)
											.addGap(12)
											.addComponent(btnExitShop, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblCostOfCart)
											.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuyItm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuyMnstr, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSellMnstr, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSellItm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);

		shopFrame.getContentPane().setLayout(groupLayout);;
	}
}
