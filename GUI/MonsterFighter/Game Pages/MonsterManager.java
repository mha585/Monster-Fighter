import java.util.ArrayList;

public class MonsterManager {
	private static RandomGen rng;
	private static Player newPlayer = new Player();
	private static Battles newbattle = new Battles();
	private Shop newShop;
	private Trainers newTrainer;
	private static ArrayList<Trainers> trainerBattles = new ArrayList<Trainers>();
	private Monster enemy;
	private boolean canFight = false;
	private int amountOfMonsterKilledToaday;
	private int amountOfFriendsWhoFaintedToday;
	
	public void launchChooseMonsterScreen(RandomGen num) {
		new ChooseMonsterScreen(this, num);
	}
	
	public void launchBattleScreen(boolean initialiseBossFight, RandomGen num, String status) {
		 if (initialiseBossFight) {
			Trainers bossEnemy = new Boss();
			System.out.println(bossEnemy.getFirstEnemy().getName());
			setEnemyTrainer(bossEnemy);
			setEnemy(bossEnemy.getFirstEnemy());
		}
		
		new BattleScreen(this, newTrainer, num, status);
	}
	
	public void launchTeamScreen(String previousPage, RandomGen num) {
		new TeamScreen(this, previousPage, num);
	}	
	
	public void launchInventoryScreen(String previousPage, RandomGen num) {
		new InventoryScreen(this, previousPage, num);
	}

	public void launchNightScreen(RandomGen num) {
		new NightScreen(this, num);
	}
	
	public void launchLoseScreen() {
		new LoseScreen(this);
	}
	
	public void launchPrepScreen(RandomGen num, boolean canFight) {
		new PrepScreen(this, num, canFight);
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
	
	public boolean isAbleToFight() {
		return canFight;
	}
	
	public void setIsAbleToFight(boolean hasChosenBattles) {
		canFight = hasChosenBattles;
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
	
	public int getAmountOfMonsterKilledToaday() {
		return amountOfMonsterKilledToaday;
	}
	
	public void gainAmountOfMonsterKilledToaday(int amountGained) {
		amountOfMonsterKilledToaday += amountGained;
	}
	
	public int getAmountOfFriendsWhoFaintedToday() {
		return amountOfFriendsWhoFaintedToday;
	}
	
	public void gainAmountOfFriendsWhoFaintedToday(int amountGained) {
		amountOfFriendsWhoFaintedToday += amountGained;
	}


	public static void main(String[] args) {
		MonsterManager manager = new MonsterManager();
		manager.launchStartUpScreen(rng);
	}
}
