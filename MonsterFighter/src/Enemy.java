
public class Enemy extends Monster{
	
	private int myReward;
	/**
	 * The basic constructor for the Enemy class
	 * @param name			The name of the Enemy
	 * @param maxHealth		The maxHealth of the Enemy
	 * @param healAmount	The healAmount of the Enemy
	 * @param damage		The amount of damage the Enemy does
	 * @param speed			The speed of the Enemy
	 * @param reward		The reward for killing the Enemy
	 * @param Tier			The level of the Enemy
	 */
	public Enemy(String name, double maxHealth, double healAmount, double damage, double speed, int reward, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
		myReward = reward;
	}
	/**
	 * The constructor for the Enemy class
	 * this gets called when no params are entered.
	 */
	public Enemy() {
		super();
		randomGen number = new randomGen();
		myReward = number.randNumInRange(0, 100);
	}
	/**
	 * Returns the reward for killing the Enemy
	 */
	public int getReward() {
		return myReward;
	}
}
