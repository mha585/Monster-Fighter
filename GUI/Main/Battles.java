import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements a Battle between a team of monsters and an enemy.
 *
 * @author Matthew Harper
 * @version 1.4, Apr 2022.
 */
public class Battles {
	/**
	 * Generates all the possible battles the player can fight in a day
	 * @param numBattles			The number of battles the player wants to fight in a day
	 * @param player				The current stats of the player
	 * @return ArrayList			An array list containing all the possible battles
	 */
	public ArrayList<Trainers> getBattles (int numBattles, Player player, RandomGen randomNum) {
		ArrayList<Trainers> trainerToBattle = new ArrayList<Trainers>();
		int num = 1;
		while (num <= numBattles) {
			Trainers newTrainer = new Trainers(player, randomNum);
			trainerToBattle.add(newTrainer);
			num++;
		}
		return trainerToBattle;
	}
	/**
	 * Gets called when the user clicks btnFight.
	 * Checks the effectiveness of the current attack then multiplies the damage by that
	 * If the attack is one sided (aka the friend is either healing, switching or using an item)
	 * then only the enemy attack as the player has already used their turn.
	 * @param friend		The friend that does the attack
	 * @param badGuy		The enemy that responds to the attack
	 * @param friends		The current team of monsters the player has
	 * @param evenFight		Used to check if the fight is one sided or not
	 */
	public void attack(Monster friend, Monster badGuy, Team friends, boolean evenFight) {
		double friendAttackMultiplier = howEffective(friend, badGuy);
		double enemyAttackMultiplier = howEffective(badGuy, friend);
		if (evenFight == true) {
			speedAttacks(friend, badGuy, friends, friendAttackMultiplier, enemyAttackMultiplier);
		} else {
			oneSidedAttack(friend, badGuy, friends, enemyAttackMultiplier);
		}
	}
	/**
	 * Gets called when the user clicks btnHeal.
	 * Allows the monster in position 1 to heal any monster (including itself) in the team
	 * This will use the players turn and cause a one sided attack by the enemy monster against the friend
	 * Checks that the index of the monster to heal is in a valid range else will ask the user to input another valid command
	 * @param friend		The friend that does the healing
	 * @param badGuy		The enemy that attacks while the healing is happening
	 * @param friends		The current team of monsters the player has
	 */
	public void heal(Monster friend, Monster badGuy, Team friends) {
		friends.getFriend(0).gainHealth(friend.getHealAmount());
		attack(friend, badGuy, friends, false);
	}
	/**
	 * Checks the health of the friend.
	 * If the health of the friend is less than or equal to 0 it removes the friend from the team.
	 * Returns false if the friend is dead or returns true if it's still alive.
	 * @param friend		The friend that is being checked
	 * @param friends		The current team of monsters the player has
	 */
	public boolean checkFriendsHealth(Monster friend, Team friends) {
		if (friend.getHealth() <= 0) {
			friend.gainDeaths();
			return false;
		} 
		return true;
	}
	/**
	 * Checks the health of an enemy.
	 * If the health of the enemy is less than or equal to 0 it returns false else returns true.
	 * @param badGuy		The enemy that is being checked
	 * @param friend		The friend that will gain the experience at the end of the battle
	 * @param friends		The current team of monsters the player has
	 */
	public boolean checkEnemysHealth(Monster badGuy, Monster friend, Team friends) {
		if (badGuy.getHealth() <= 0) {
			friend.gainExperience(badGuy.getReward());
			return false;
		}
		return true;
	}
	/**
	 * Considers the speed of the enemy and friend before performing an attack.
	 * The monster with the fastest speed will attack first.
	 * If the Monster that gets attacked first dies then the other monster does not get attacked.
	 * @param friend			The friend that will attack first if its speed is faster than the enemy
	 * @param badGuy			The enemy that will attack first if its speed is faster than the friend
	 * @param friends			The current team of monsters the player has
	 * @param attackMultiplier	The amount that the attack will be multiplied by.
	 */
	public void speedAttacks(Monster friend, Monster badGuy, Team friends, double friendAttackMultiplier, 
			double enemyAttackMultiplier) {
		if (friend.getSpeed() > badGuy.getSpeed()) {
			badGuy.gainHealth((-1 * friend.getDamage()) * friendAttackMultiplier);
			if (checkEnemysHealth(badGuy, friend, friends) == true) {
				friend.gainHealth((-1 * badGuy.getDamage()) * enemyAttackMultiplier);
				checkFriendsHealth(friend, friends);
			}
		} else {
			friend.gainHealth((-1 * badGuy.getDamage()) * enemyAttackMultiplier);
			if (checkFriendsHealth(friend, friends) == true) {
				badGuy.gainHealth((-1 * friend.getDamage()) * friendAttackMultiplier);
				checkEnemysHealth(badGuy, friend, friends);
			}
		} 
	}
	/**
	 * Performs a one sided attack so that only the badGuy gets to attack the friend.
	 * This only gets called when the user wastes their turn healing, using an item or switching.
	 * Considers the type of attack (e.g. super effective) to scale the damage appropriately. 
	 * @param friend			The friend that will be attacked by the enemy
	 * @param badGuy			The enemy that will attack the friend
	 * @param friends			The current team of monsters the player has
	 * @param attackMultiplier	The amount that the attack will be multiplied by.
	 */
	public void oneSidedAttack(Monster friend, Monster badGuy, Team friends, double enemyAttackMultiplier) {
		friend.gainHealth((-1 * badGuy.getDamage()) * enemyAttackMultiplier);
		checkFriendsHealth(friend, friends);
	}
	/**
	 * Returns the respective index of the type of monster from the howEffective
	 * array in class Monster.
	 * Returns 0 for type Fire, 1 for type Water, 2 for type Grass,
	 * 3 for type glass and 4 for type Medical
	 * @param type		The type of the Monster.
	 * @return int		an integer representation of the type of monster
	 */
	public int monsterTypeToIndex(String type) {
		if (type == "Fire") {
			return 0;
		} else if (type == "Water") {
			return 1;
		} else if (type == "Grass") {
			return 2;
		} else if (type == "Glass") {
			return 3;
		} else if (type == "Medical") {
			return 4;
		} else if (type == "Holy") {
			return 5;
		} else {
			return 6;
		}
	}
	/**
	 * Checks how effective a type of attack is using the matrix howEffective in class Monster.
	 * e.g if a fire monster attacks a grass monster then the attack will be super effective so * 2.
	 * @param attacker		The Monster that is doing the attack.
	 * @param attacked		The Monster that is being attacked.
	 * @return double		returns how effective an attack is on a monster
	 */
	public double howEffective(Monster attacker, Monster attacked) {
		int attackerTypeIndex = monsterTypeToIndex(attacker.getType());
		int attackedTypeIndex = monsterTypeToIndex(attacked.getType());
		return attacker.getEffectiveness(attackerTypeIndex, attackedTypeIndex);
	}
}