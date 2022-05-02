
public class MonsterManager {
	private static Player newPlayer = new Player();
	
	public void launchHomeScreen() {
		HomeScreen mainWindow = new HomeScreen(this);
	}
	
	public void closeHomeScreen(HomeScreen homeWindow) {
		homeWindow.closeWindow();
	}
	
	public void launchBattleScreen() {
		BattleScreen battleWindow = new BattleScreen(this);
	}
	
	public void closeBattleScreen(BattleScreen battleWindow) {
		battleWindow.closeWindow();
	}
	
	public static Player getPlayer() {
		return newPlayer;
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
//		test line delete later;
		getPlayer().getTeam().addFriend(new HolyMonster("Holy test", 50.0, 5.0, 10, 20.0, 1, 150, 100, "Holy"));
		manager.launchHomeScreen();
	}
}
