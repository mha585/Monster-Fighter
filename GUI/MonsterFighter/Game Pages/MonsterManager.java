import java.util.ArrayList;

public class MonsterManager {
	private static Player newPlayer = new Player();
	private static Battles newbattle = new Battles();
	private Trainers newTrainer = new Trainers(getPlayer());
	private static ArrayList<Trainers> trainerBattles = new ArrayList<Trainers>();
	private Shop newShop = new Shop();
	private Monster enemy;
	private static boolean setUpDone = false;
//	private Inventory bag = newPlayer.getInventory();
	
	public void launchChooseMonsterScreen() {
		ChooseMonsterScreen chooseWindow = new ChooseMonsterScreen(this);
	}
	
//	public void closeChooseMonsterScreen(ChooseMonsterScreen chooseWindow) {
//		chooseWindow.closeWindow();
//	}
	
	public void launchBattleScreen(boolean initialiseFight) {
		if (initialiseFight) {
			Trainers newEnemy = new Trainers(getPlayer());
			setEnemyTrainer(newEnemy);
			setEnemy(newEnemy.getFirstEnemy());
		}
		BattleScreen battleWindow = new BattleScreen(this, enemy);
	}
	
//	public void closeBattleScreen(BattleScreen battleWindow) {
//		battleWindow.closeWindow();
//	}
	
	public void launchTeamScreen(String previousPage) {
		TeamScreen teamWindow = new TeamScreen(this, previousPage);
	}
	
//	public void closeTeamScreen(TeamScreen teamWindow) {
//		teamWindow.closeWindow();
//	}
	
	
	public void launchInventoryScreen(String previousPage) {
		InventoryScreen invWindow = new InventoryScreen(this, previousPage);
	}
	
//	public void closeInventoryScreen(InventoryScreen invWindow) {
//		invWindow.closeWindow();
//	}
	
	public void launchNightScreen() {
		NightScreen nightWindow = new NightScreen(this);
	}
	
//	public void closeNightScreen(NightScreen nightWindow) {
//		nightWindow.closeWindow();
//	}
	
	public void launchLoseScreen() {
		LoseScreen loseWindow = new LoseScreen(this);
	}
	
//	public void closeLoseScreen(LoseScreen loseWindow) {
//		loseWindow.closeWindow();
//	}
	
	public void launchPrepScreen() {
		PrepScreen prepWindow = new PrepScreen(this);
	}
	
//	public void closePrepScreen(PrepScreen prepWindow) {
//		prepWindow.closeWindow();
//	}
	
	public void launchShopScreen() {
		ShopScreen shopWindow = new ShopScreen(this);
	}
	
//	public void closeShopScreen(ShopScreen shopWindow) {
//		shopWindow.closeWindow();
//	}
	
	public void launchStartUpScreen() {
		StartUpScreen startUpWindow = new StartUpScreen(this);
	}
	
//	public void closeStartUpScreen(StartUpScreen startUpWindow) {
//		startUpWindow.closeWindow();
//	}
	
	public void launchTodaysBattlesScreen() {
		TodaysBattlesScreen todaysBattlesWindow = new TodaysBattlesScreen(this);
	}
	
//	public void closeTodaysBattlesScreen(TodaysBattlesScreen todaysBattlesWindow) {
//		todaysBattlesWindow.closeWindow();
//	}
	
	public void launchWelcomeScreen() {
		WelcomeScreen welcomeWindow = new WelcomeScreen(this);
	}
	
//	public void closeWelcomeScreen(WelcomeScreen welcomeWindow) {
//		welcomeWindow.closeWindow();
//	}
	
	public void launchWinScreen() {
		WinScreen winWindow = new WinScreen(this);
	}
	
//	public void closeWinScreen(WinScreen winWindow) {
//		winWindow.closeWindow();
//	}
	
	public void launchUseItemScreen(String previousPage, int itemIndex) {
		UseItemScreen useWindow = new UseItemScreen(this, previousPage, itemIndex);
	}
	
//	public void closeUseItemScreen(UseItemScreen useWindow) {
//		useWindow.closeWindow();
//	}
	
	public void launchItemSuccessScreen(String previousPage, int monsterIndex, int itemIndex) {
		ItemSuccessScreen successWindow = new ItemSuccessScreen(this, previousPage, monsterIndex, itemIndex);
	}
	
//	public void closeUseItemScreen(UseItemScreen useWindow) {
//		useWindow.closeWindow();
//	}
	
	public Player getPlayer() {
		return newPlayer;
	}
	
	public Battles getBattle() {
		return newbattle;
	}
	
	public void setEnemy(Monster myEnemy) {
		enemy = myEnemy;
	}
	
	public Trainers getTrainer() {
		return newTrainer;
	}
	
	public void setSetUp() {
		setUpDone = true;
	}
	public void setEnemyTrainer(Trainers enemyTrainer) {
		newTrainer = enemyTrainer;
	}
	
//	public void launchSetupScreen() {
//		SetupScreen mainWindow = new SetupScreen(this);
//	}
//	
//	public void closeSetupScreen(MainScreen mainWindow) {
//		mainWindow.closeWindow();
//	}
	
	public static void main(String[] args) {
		MonsterManager manager = new MonsterManager();
		manager.launchStartUpScreen();
		System.out.println(setUpDone);
		if(setUpDone == true) {
			while (manager.newPlayer.daysLeft() > 0) {
				manager.newPlayer.addDay();
				trainerBattles = newbattle.getBattles(5, newPlayer);
				manager.launchPrepScreen();
			}
		}
	}
}
