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
import javax.swing.JScrollBar;
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

	/**
	 * Create the application.
	 * @param incomingManager the manager that manages all the data across the pages 
	 * @param number the randomGen used to generate random numbers
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

	public Item createItem(Item item) {
		String itemName = item.getName();
		int itemCost = item.getPrice();
		int itemSell = item.sellPrice();
		String itemDescription = item.getDescription();
		int itemEffect = item.getEffect();
		String itemStat = item.getStat();
		return new Item(itemName, itemCost, itemSell, itemDescription, itemEffect, itemStat);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shopFrame = new JFrame();
		shopFrame.setBounds(100, 100, 960, 540);
		shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		items = newShop.getItems();
		monsters = newShop.getMonsters();
		
		JLabel lblPlyrMoney = new JLabel("Money:");
		lblPlyrMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JLabel lblCost = new JLabel("Total Cost:");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCostOfCart = new JLabel("$"+totalCost);
		lblCostOfCart.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel shopPanel = new JPanel();
		CardLayout CL = new CardLayout(0,0);
		shopPanel.setLayout(CL);
		
		DefaultListModel<Object> cartDisplay = new DefaultListModel<Object>();
		Inventory cart = new Inventory();
		Team kennel = new Team();
		
		JPanel panelfill1 = new JPanel();
		JPanel panelfill2 = new JPanel();
		
		JLabel lblUserMoney = new JLabel("$"+manager.getPlayer().getMoney());
		lblUserMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAddItem = new JLabel("Double click on an item/ monster to add it to your cart");
		
		JLabel lblStart = new JLabel("");
		JLabel lblSuccuess = new JLabel("Success");
		JLabel lblBroke = new JLabel("Insufficient Funds");
		JPanel panelVerify = new JPanel();
		CardLayout verify = new CardLayout(0, 0);
		panelVerify.setLayout(verify);
		panelVerify.add(lblStart," ");
		panelVerify.add(lblSuccuess, "Success");
		panelVerify.add(lblBroke, "Broke");
		
		
		JList<Object> JLShoppingCart = new JList<Object>(cartDisplay);
		JLShoppingCart.setEnabled(true);
		JLShoppingCart.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLShoppingCart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<Object> JLShoppingCart = (JList<Object>) event.getSource();
				if (event.getClickCount() == 2) {
					int index = JLShoppingCart.locationToIndex(event.getPoint());
					if (current == "BI") {
						Item item = (Item) cart.getItem(index);
						if (item.getFrequency() > 1) {
							item.addFreq(-1);
							JLShoppingCart.setModel(cartDisplay);
							totalCost -= item.getPrice();
							lblCostOfCart.setText("$"+totalCost);
						}
						else if (item.getFrequency() == 1) {
							cart.removeBag(index, 1);
							cartDisplay.remove(index);
							JLShoppingCart.setModel(cartDisplay);
							totalCost -= item.getPrice();
							lblCostOfCart.setText("$"+totalCost);
						}
					}
					else if (current == "BM") {
						Monster monster = (Monster) kennel.getFriend(index);
						kennel.removeFriend(monster);
						cartDisplay.remove(index);
						JLShoppingCart.setModel(cartDisplay);
						totalCost -= monster.getPrice();
						lblCostOfCart.setText("$"+totalCost);
					}
					else if (current == "SI") {
						Item item = (Item) cart.getItem(index);
						if (item.getFrequency() > 1) {
							item.addFreq(-1);
							JLShoppingCart.setModel(cartDisplay);
							totalCost += item.sellPrice();
							lblCostOfCart.setText("$"+totalCost);
						}
						else if (item.getFrequency() == 1) {
							cart.removeBag(index, 1);
							cartDisplay.remove(index);
							JLShoppingCart.setModel(cartDisplay);
							totalCost += item.sellPrice();
							lblCostOfCart.setText("$"+totalCost);
						}
					}
					else if (current == "SM") {
						Monster monster = (Monster) kennel.getFriend(index);
						kennel.removeFriend(monster);
						cartDisplay.remove(index);
						JLShoppingCart.setModel(cartDisplay);
						totalCost += monster.sellPrice();
						lblCostOfCart.setText("$"+totalCost);
					}
					if (cart.getSize() == 0) {
						JLShoppingCart.setEnabled(true);
					}
				}
			}
		});


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
					if (cartDisplay.contains(items.get(itemIndex).getName())) {
						int cartIndex = cart.getIndex(items.get(itemIndex).getName());
						cart.getItem(cartIndex).addFreq(1);
						cartCost += items.get(itemIndex).getPrice();
						lblCostOfCart.setText("$"+cartCost);
						totalCost = cartCost;
					}
					else {
						cartDisplay.addElement(items.get(itemIndex).getName());
						cart.addtoBag(items.get(itemIndex), 1);
						cartCost += items.get(itemIndex).getPrice();
						lblCostOfCart.setText("$"+cartCost);
						totalCost = cartCost;
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
					if (kennel.getSize() + 1 + manager.getPlayer().getTeam().getSize() <= 4 ) {
						if (cartDisplay.contains(monsters.get(mnstrIndex).getName()) == false) {
							cartDisplay.addElement(monsters.get(mnstrIndex).getName());
							kennel.addFriend(monsters.get(mnstrIndex));
							cartCost += monsters.get(mnstrIndex).getPrice();
							lblCostOfCart.setText("$"+cartCost);
							totalCost = cartCost;
						}
						else {
							System.out.println("Monster already in cart");
						}
					}	
					else {
						System.out.println("There are too many monsters");
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
					if (cartDisplay.contains(manager.getPlayer().getTeam().getFriend(mnstrIndex).getName()) == false && manager.getPlayer().getTeam().getSize() > 1) {
						cartDisplay.addElement(manager.getPlayer().getTeam().getFriend(mnstrIndex).getName());
						kennel.addFriend(manager.getPlayer().getTeam().getFriend(mnstrIndex));
					}
					else if(((List<Monster>) kennel).contains(manager.getPlayer().getTeam().getFriend(mnstrIndex))) {
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
					int itemIndex = listSellItm.locationToIndex(event.getPoint());
					Item item = manager.getPlayer().getInventory().getItem(itemIndex);
					if (cartDisplay.contains(item.getName())) {
						int cartIndex = cart.getIndex(item.getName());
						int bagIndex = manager.getPlayer().getInventory().getIndex(item.getName());
						if (cart.getItem(cartIndex).getFrequency() < manager.getPlayer().getInventory().getItem(itemIndex).getFrequency()) {
							cart.getItem(cartIndex).addFreq(1);
						}
						else {
							System.out.println("you've got no more items mate");
						}
					}
					else if (cartDisplay.contains(item.getName()) == false) {
						cartDisplay.addElement(item.getName());
						Item sellItem = createItem(manager.getPlayer().getInventory().getItem(itemIndex));
						cart.addtoBag(sellItem, 0);
						cart.getItem(cart.getSize() - 1).setFrequency(1);
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
				cartDisplay.clear();
				kennel.clear();
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
				cartDisplay.clear();
				kennel.clear();
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
				cartDisplay.clear();
				kennel.clear();
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
				cartDisplay.clear();
				kennel.clear();
				cart.clear();
				current = "SM";
				
			}
		});
		JButton btnExitShop = new JButton("Exit");
		btnExitShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				newShop.clearMonsters();
				manager.launchNightScreen(num);
			}
		});
		

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalCost = 0;
				for (int i = 0; i < cart.getSize(); i++) {
					totalCost += cart.getItem(i).getPrice();
				}
				for (int i = 0; i < kennel.getSize(); i++) {
					totalCost += kennel.getFriend(i).getPrice();
				}
				if (manager.getPlayer().getMoney() >= totalCost && current == "BI") {
					for (int i = 0; i < cart.getSize(); i++) {
						for (int j = 0; j < cart.getItem(i).getFrequency(); j++) {
							Item item = (Item) cart.getItem(i);
							int oldFreq = item.getFrequency();
							item.setFrequency(1);
							manager.getPlayer().getInventory().buyItem(1, item, manager.getPlayer());
							item.setFrequency(oldFreq);
						}
					}
					lblUserMoney.setText("$"+manager.getPlayer().getMoney());
					lblCostOfCart.setText("$"+0);
					totalCost = 0;
					setZero();
					lblCost.setVisible(true);
					lblCostOfCart.setVisible(true);
					cartDisplay.clear();
					cart.clear();
					verify.show(panelVerify, "Success");
				}
				else if (manager.getPlayer().getMoney() >= totalCost && current == "BM") {
					for (int i = 0; i < kennel.getSize(); i++) {
						Monster monster = kennel.getFriend(i);
						manager.getPlayer().getTeam().addFriend(monster);
						manager.getPlayer().addMoney(-1 * monster.getPrice());
						lblUserMoney.setText("$"+manager.getPlayer().getMoney());
						lblCostOfCart.setText("$"+0);
						totalCost = 0;
						setZero();
						lblCost.setVisible(true);
						lblCostOfCart.setVisible(true);
						int remove = monsters.indexOf(monster);
						monsters.remove(remove);
						monsterDisplay.remove(remove);
						cartDisplay.clear();
						kennel.clear();
						verify.show(panelVerify, "Success");
					}
				}
				else if (manager.getPlayer().getMoney() >= totalCost && current == "SI") {
					for (int i = 0; i < cart.getSize(); i++) {
						Item item = cart.getItem(i);
						int frequency = item.getFrequency();
						int index = manager.getPlayer().getInventory().getIndex(item.getName());
						manager.getPlayer().getInventory().sellItem(frequency, index, manager.getPlayer(), manager.getPlayer().getInventory());
						lblUserMoney.setText("$"+manager.getPlayer().getMoney());
						lblCostOfCart.setText("$"+0);
						totalCost = 0;
						setZero();
						lblCost.setVisible(true);
						lblCostOfCart.setVisible(true);
						cartDisplay.clear();
						cart.clear();
						verify.show(panelVerify, "Success");
					}
				}
				else if (manager.getPlayer().getMoney() >= totalCost && current == "SM") {
					for (int i = 0; i < kennel.getSize(); i++) {
						Monster monster = kennel.getFriend(i);
						int index = manager.getPlayer().getTeam().getIndex(monster.getName());
						manager.getPlayer().getTeam().sellMonster(index, monster.getTier() - 1, newShop, manager.getPlayer());
						lblUserMoney.setText("$"+manager.getPlayer().getMoney());
						lblCostOfCart.setText("$"+0);
						totalCost = 0;
						setZero();
						lblCost.setVisible(true);
						lblCostOfCart.setVisible(true);
						int remove = monsterUsrDisplay.indexOf(monster);
						monsterUsrDisplay.remove(remove);
						cartDisplay.clear();
						kennel.clear();
						verify.show(panelVerify, "Success");
						
					}
				}
				else if (manager.getPlayer().getMoney() < totalCost) {
					verify.show(panelVerify, "Broke");
				}
				closeWindow();
				manager.launchShopScreen(num);
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
							.addComponent(lblUserMoney, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
							.addGap(62)
							.addComponent(lblAddItem, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addGap(246))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelfill1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(shopPanel, GroupLayout.PREFERRED_SIZE, 838, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelfill2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRemoveItem)
								.addComponent(JLShoppingCart, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCostOfCart, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCost, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnConfirm)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(panelVerify, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBuyItm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSellItm, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSellMnstr, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuyMnstr, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExitShop, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addGap(10))
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
						.addComponent(shopPanel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelfill1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelfill2, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblRemoveItem, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(JLShoppingCart, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelVerify, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(11)
										.addComponent(lblCost)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblCostOfCart))
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuyItm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuyMnstr, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSellMnstr, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSellItm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExitShop, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);

		shopFrame.getContentPane().setLayout(groupLayout);;
	}
}
