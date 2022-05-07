public class MonsterManager {
	private Player newPlayer = new Player();
	private Battles newbattle = new Battles();
	private Trainers newTrainer = new Trainers(getPlayer());
	private Shop newShop = new Shop();
	private Monster enemy;
//	private Inventory bag = newPlayer.getInventory();
	
	public void launchHomeScreen() {
		HomeScreen mainWindow = new HomeScreen(this);
	}
	
//	public void closeHomeScreen(HomeScreen homeWindow) {
//		homeWindow.closeWindow();
//	}
	
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
		StartUpScreen startUpWindow = new StartUpScreen(this, newPlayer);
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
//		test
		manager.getPlayer().addDay();

		manager.getPlayer().setDifficulty(1);
		manager.launchHomeScreen();
	}
}
