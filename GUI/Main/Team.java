import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This class creates a new object Team
 * The team holds the player's/ trainer's Monsters.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Team{
	/**
	 * Creates a new instance of an ArrayList that will hold the player's monsters.
	 */
	private ArrayList<Object> myTeam = new ArrayList <>();
	/**
	 * Returns the team
	 * 
	 * @return an ArrayList holding Monsters
	 */
	public ArrayList<Object> getTeam() {
		return myTeam;
	}
	/**
	 * Returns the size of the team.
	 * 
	 * @return an integer indicating the size of the team
	 */
	public int getSize() {
		return myTeam.size();
	}
	/**
	 * Returns the monster in the Team at the given index.
	 * 
	 * @param index			The index of the monster in the Team
	 * @return the monster at a given index
	 */
	public Monster getFriend(int index) {
		return (Monster) myTeam.get(index);
	}
	/**
	 * Returns true or false. Returns true if the given monster was successfully added into the team.
	 * 
	 * @param friend		The monster to be added
	 * @return boolean for if the given monster was successfully added to the team
	 */
	public boolean addFriend(Monster friend) {
		  if (myTeam.size() < 4) {
			  myTeam.add(friend);
			  return true;
		  } else {
			  return false;
		  }
	}
	/**
	 * Returns true or false. Returns true if the given monster was successfully removed.
	 * 
	 * @param friend		The monster to be removed
	 * @return boolean for if the given monster was successfully removed from the team
	 */
	public boolean removeFriend(Monster friend) {
		  if (myTeam.size() > 0) {
			  myTeam.remove(friend);
			  return true;
		  } else {
			  return false;
		  }
	}
	/**
	 * Removes all items in myTeam
	 */
	public void clear() {
		myTeam.clear();
	}
	/**
	 * Adds a monster to the party. Deducts money from the player accordingly.
	 * 
	 * @param monsterNum	The index of the number in the shop
	 * @param shop			The shop, used to get the list of randomMonsters
	 * @param player		The player
	 */
	public void buyMonster(int monsterNum, Shop shop, Player player) {
		int funds = player.getMoney();
		List<Integer> buy = shop.getBuy();
		List<RandomMonster> randMonList = shop.getMonsters();
		RandomMonster randMon = randMonList.get(monsterNum - 1);
		int m1Price = (randMonList.get(monsterNum - 1).getPrice());
		if ((m1Price <= funds) && (player.playerTeam.getSize() < 4)) {
			player.playerTeam.addFriend(randMonList.get(monsterNum - 1));
			player.deductMoney(m1Price);
		}
	}
	/**
	 * Removes a monster from the party. Gives money to the player accordingly.
	 * 
	 * @param MonsterNum	The index of the monster to be sold
	 * @param costIndex		The index of the monsters selling price
	 * @param shop			The shop, used to get the list of selling prices
	 * @param player		The player
	 */
	public void sellMonster(int MonsterNum, int costIndex, Shop shop, Player player) {
		if ((getSize() > 1) &&
				(MonsterNum < getSize() && MonsterNum < getSize()) && (MonsterNum >= 0 && MonsterNum >= 0)) {
			List<Integer> sell = shop.getSell();
			Object monster = getFriend(MonsterNum);
			removeFriend(getFriend(MonsterNum));
			player.addMoney(sell.get(costIndex));
		}
	}
	/**
	 * Swaps the position of two monsters in your party.
	 * 
	 * @param index1		The first monster to be swapped
	 * @param index2		The second monster to be swapped
	 */
	public void swap(int index1, int index2) {
		if ((index1 < getSize() && index2 < getSize()) && (index1 >= 0 && index2 >= 0) && 
				((getFriend(index1).getHealth() > 0) && (getFriend(index2).getHealth() > 0))) {
			Collections.swap(myTeam, index1, index2);
		}
	}
	/**
	 * Pushes the first monster to the last index in the team.
	 * Each other monster is pushed one spot ahead.
	 */
	public void pushFrontToBack() {
		for (int i = 0; i < (myTeam.size() - 1); i++) {
			Collections.swap(myTeam, i, i + 1);
		}
	}
	/**
	 * Returns the sum of all monsters' health in the team
	 * 
	 * @return an integer of the sum of all of the monster's healths that are in the team
	 */
	public double sumTeamHealth() {
		double currentHealthSum = 0;
		for (int i = 0; i < (myTeam.size()); i++) {
			currentHealthSum += ((Monster) myTeam.get(i)).getHealth();
		  }
		return currentHealthSum;
	}
	/**
	 * gets the index of a monster
	 * 
	 * @param name	The name of the Monster that is being searched for
	 * @return an string representation of the team
	 */
	public int getIndex(String name) {
		int index = 0;
		for (int i = 0; i < myTeam.size(); i++) {
			Monster current = (Monster) myTeam.get(i);	
			if (current.getName() == name) {
				index = i;
			}
		}
		return index;
	}
}