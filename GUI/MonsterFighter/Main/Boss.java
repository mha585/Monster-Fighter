import java.util.*;
/**
 * This class creates an instance of a Trainer of type Boss.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Boss extends Trainers{
	/**
	 * The type of the trainer.
	 */
	private String bossType = "Boss";
	/**
	 * The trainer's name.
	 */
	private String bossName = "Miguel";
	/**
	 * Boss' grass type monster.
	 */
	private static GrassMonster grassBoss = new GrassMonster("Tane", 90, 5, 40, 9, 3, 500, 750, "God of Forests and Birds");
	/**
	 * Boss' fire type monster.
	 */
	private static FireMonster fireBoss = new FireMonster("Ra", 80, 3, 50, 13, 3, 500, 750, "God of the Sun");
	/**
	 * Boss' water type monster.
	 */
	private static WaterMonster waterBoss = new WaterMonster("Leviathan", 100, 3, 50, 10, 3, 500, 750, "Water Serpent");
	/**
	 * Boss' demon type monster.
	 */
	private static DemonMonster demonBoss = new DemonMonster("Shinigami", 100, 3, 65, 13, 3, 500, 750, "DEATH");
	/**
	 * Boss' party.
	 */
	private static ArrayList<Monster> enemyTeam = new ArrayList<Monster>(Arrays.asList(grassBoss, fireBoss, waterBoss, demonBoss));
	/**
	 * Returns the Boss' party.
	 * 
	 * @return ArrayList containing Boss' monsters
	 */
	public ArrayList<Monster> getEnemies() {
		return enemyTeam;
	}
	/**
	 * Creates and instance of a Trainer of type Boss.
	 * 
	 * @param player		User player
	 */
	public Boss() {
		super(enemyTeam);
	}
	/**
	 * Returns the size of the Boss' team
	 * 
	 * @return enemyTeam size
	 */
	public int getSize() {
		return enemyTeam.size();
	}
	/**
	 * Removes the first enemy from the team
	 */
	public void removeEnemy() {
		if (enemyTeam.size() > 0) {
			enemyTeam.remove(0);
		}
	}
	/**
	 * Returns the first monster that belong to the trainer.
	 * 
	 * @return The first Monster in the trainers team (the one the player fights)
	 */
	public Monster getFirstEnemy() {
		return enemyTeam.get(0);
	}
	/**
	 * Returns the type and name of the trainer
	 * 
	 * @return type and name
	 */
	public String getFullName() {
		return bossType + " " + bossName;
	}
	/**
	 * Returns the boss and represents them as a string.
	 * 
	 * @return string of boss and boss' monsters
	 */
	public void printBossFight() {
		System.out.println(getFullName());
		for (int i = 0; i< enemyTeam.size(); i++) {
		  System.out.println( "Boss Monster " + (i + 1) +":\n\n"+enemyTeam.get(i).toString() + "\n\n" +"-------------------------------------\n");
		}
	}
}