import java.util.ArrayList;

public class MonsterManager {
	private static RandomGen rng;
	private static Player newPlayer = new Player();
	private static Battles newbattle = new Battles();
	private Trainers newTrainer;
	private static ArrayList<Trainers> trainerBattles = new ArrayList<Trainers>();
	private Monster enemy;
	
	public void launchChooseMonsterScreen(RandomGen num) {
		new ChooseMonsterScreen(this, num);
	}
	
	public void launchBattleScreen(boolean initialiseFight, RandomGen num, String status) {
		if (initialiseFight) {
			Trainers newEnemy = new Trainers(getPlayer(), num);
			setEnemyTrainer(newEnemy);
			setEnemy(newEnemy.getFirstEnemy());
		}
		new BattleScreen(this, newTrainer, num, status);
	}
	
	public void launchTeamScreen(String previousPage, RandomGen num) {
		new TeamScreen(this, previousPage, num);
	}	
	
	public void launchInventoryScreen(String previousPage, RandomGen num) {
		new InventoryScreen(this, previousPage, num);
	}

	public void launchNightScreen() {
		new NightScreen(this);
	}
	
	public void launchLoseScreen() {
		new LoseScreen(this);
	}
	
	public void launchPrepScreen(RandomGen num) {
		new PrepScreen(this, num);
	}
	
	public void launchShopScreen(RandomGen num) {
		new ShopScreen(this, num);
	}
	
	public void launchStartUpScreen(RandomGen num) {
		new StartUpScreen(this, num);
	}
	
	public void launchTodaysBattlesScreen(RandomGen num) {
		new TodaysBattlesScreen(this, num, trainerBattles);
	}
	
	public void launchWelcomeScreen() {
		new WelcomeScreen(this);
	}
	
	public void launchWinScreen() {
		new WinScreen(this);
	}
	
	public void launchUseItemScreen(String previousPage, int itemIndex, RandomGen num) {
		new UseItemScreen(this, previousPage, itemIndex, num);
	}
	
	public void launchItemSuccessScreen(String previousPage, int monsterIndex, int itemIndex, RandomGen num) {
		new ItemSuccessScreen(this, previousPage, monsterIndex, itemIndex, num);
	}
	
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
	}
	
	public RandomGen getRandom() {
		return rng;
	}
	
	public void setEnemyTrainer(Trainers enemyTrainer) {
		newTrainer = enemyTrainer;
	}
	
	public void setTrainerListD1() {
		trainerBattles = newbattle.getBattles(1, newPlayer, rng);
	}
	
	public void setTrainerListNotD1() {
		trainerBattles = newbattle.getBattles(5, newPlayer, rng);
	}
	
	public static void main(String[] args) {
		MonsterManager manager = new MonsterManager();
		newPlayer.addDay();
		manager.launchStartUpScreen(rng);
	}
}
