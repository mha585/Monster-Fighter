import java.util.ArrayList;

public class MonsterManager {
	private static RandomGen rng;
	private static Player newPlayer = new Player();
	private static Battles newbattle = new Battles();
	private Trainers newTrainer;
	private static ArrayList<Trainers> trainerBattles = new ArrayList<Trainers>();
	private Shop newShop = new Shop();
	private Monster enemy;
//	private static boolean setUpDone = false;
//	private Inventory bag = newPlayer.getInventory();
	
	public void launchChooseMonsterScreen(RandomGen num) {
		ChooseMonsterScreen chooseWindow = new ChooseMonsterScreen(this, num);
	}
	
//	public void closeChooseMonsterScreen(ChooseMonsterScreen chooseWindow) {
//		chooseWindow.closeWindow();
//	}
	
	public void launchBattleScreen(boolean initialiseFight, RandomGen num) {
		if (initialiseFight) {
			Trainers newEnemy = new Trainers(getPlayer(), num);
			setEnemyTrainer(newEnemy);
			setEnemy(newEnemy.getFirstEnemy());
		}
		BattleScreen battleWindow = new BattleScreen(this, enemy, num);
	}
	
//	public void closeBattleScreen(BattleScreen battleWindow) {
//		battleWindow.closeWindow();
//	}
	
	public void launchTeamScreen(String previousPage, RandomGen num) {
		TeamScreen teamWindow = new TeamScreen(this, previousPage, num);
	}
	
//	public void closeTeamScreen(TeamScreen teamWindow) {
//		teamWindow.closeWindow();
//	}
	
	
	public void launchInventoryScreen(String previousPage, RandomGen num) {
		InventoryScreen invWindow = new InventoryScreen(this, previousPage, num);
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
	
	public void launchPrepScreen(RandomGen num) {
		PrepScreen prepWindow = new PrepScreen(this, num);
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
	
	public void launchStartUpScreen(RandomGen num) {
//		System.out.println(getRandom().randNumInRange(10, 200));
//		System.out.println(num.randNumInRange(10, 200));

		StartUpScreen startUpWindow = new StartUpScreen(this, num);
	}
	
//	public void closeStartUpScreen(StartUpScreen startUpWindow) {
//		startUpWindow.closeWindow();
//	}
	
	public void launchTodaysBattlesScreen(RandomGen num) {
		TodaysBattlesScreen todaysBattlesWindow = new TodaysBattlesScreen(this, num);
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
	
	public void launchUseItemScreen(String previousPage, int itemIndex, RandomGen num) {
		UseItemScreen useWindow = new UseItemScreen(this, previousPage, itemIndex, num);
	}
	
//	public void closeUseItemScreen(UseItemScreen useWindow) {
//		useWindow.closeWindow();
//	}
	
	public void launchItemSuccessScreen(String previousPage, int monsterIndex, int itemIndex, RandomGen num) {
		ItemSuccessScreen successWindow = new ItemSuccessScreen(this, previousPage, monsterIndex, itemIndex, num);
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
	
	public void SetRNG(String seed) {
		if (seed.isEmpty()) {
			rng = new RandomGen();
		} else {
			rng = new RandomGen(seed);
		}
//		System.out.println(getNumInRange(2, 10));
	}
	
	public int getNumInRange(int min, int max) {
		return rng.randNumInRange(min, max);
	}
	
	public RandomGen getRandom() {
		return rng;
	}
	
	
//	public void setSetUp() {
//		setUpDone = true;
//		System.out.println("setup is done after main is finished \nsetUpDone: " + setUpDone);
//	}
	
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
		newPlayer.addDay();
		manager.launchStartUpScreen(rng);
//		System.out.println(setUpDone);
//		if(setUpDone == true) {
//			System.out.println(manager.newPlayer.daysLeft());
//			while (manager.newPlayer.daysLeft() > 0) {
//				manager.newPlayer.addDay();
//				trainerBattles = newbattle.getBattles(5, newPlayer);
//				manager.launchPrepScreen();
//			}
//		}
//		System.out.println(setUpDone);
	}
}
