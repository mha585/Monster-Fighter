import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 * This class creates an object of type Trainer. Trainers are the primary opponents used to battle the player.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Trainers {
	/**
	 * The name of the trainer.
	 */
	private String name;
	/**
	 * The type of trainer.
	 */
	private String type;
	/**
	 * The trainer's party of monsters.
	 */
	private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	/**
	 * The possible types of trainers.
	 */
	private List<String> trainerType = Arrays.asList("Officer", "Doctor", "Dentist", "Telemarketer", "Magician", "Gymnast",
			"Criminial", "Judge", "Construction Worker", "Athlete", "Actor", "Singer", "Monster Fanatic", "University Student", 
			"Pre Schooler", "Baker", "Dog Trainer", "Accountant");
	/**
	 * The possible names of trainers.
	 */
	private List<String> trainerName = Arrays.asList("Lucinda", "Augusto", "Diona", "Belle", "Alex", "Asia", "Tatianna", 
			"Eric", "Ali", "Beatriz", "Charlies", "Gabriel", "Hanna", "Netta", "Grant", "Fidel", "Emmie", "Ally", "Minnie",
			"Jeanette", "Dre", "Franz", "Izumi", "Naomi", "Xiulan", "Hu Tao", "Miki", "Walter", "Doug", "Shelly", "Jasmine", "Ariel",
			"Ben", "Ken", "Denzel", "Mary", "Peter", "Jeanette", "Lily", "Ysabel", "Rem", "Mandy", "Billie");
	
	private RandomGen number;
	/**
	 * Basic constructor for Trainer class.
	 * 
	 * @param player		The player
	 */
	public Trainers(Player player, RandomGen randomNum) {
		int randomName = randomNum.randNumInRange(0, trainerName.size());
		int randomType = randomNum.randNumInRange(0, trainerType.size());
		name = trainerName.get(randomName);
		type = trainerType.get(randomType);
		RandomMonster monster = new RandomMonster(player, randomNum);
		enemyTeam.add(monster);
	}
	
		
	public Trainers() {}
	
	
	public void addMonster(Monster monster) {
		enemyTeam.add(monster);
	}
	/**
	 * Used for generating a boss trainer
	 */
	public Trainers(ArrayList<Monster> boss) {
		name = trainerName.get(2);
		type = trainerType.get(2);
		for (Monster mon : boss) {
			enemyTeam.add(mon);
		}
	}
	/**
	 * Returns the monsters that belong to the trainer.
	 * 
	 * @return ArrayList containing objects of type Monster that belong to the trainer
	 */
	public ArrayList<Monster> getEnemies() {
		return enemyTeam;
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
	 * Removes the first enemy from the team
	 */
	public void removeEnemy() {
		if (enemyTeam.size() > 0) {
			enemyTeam.remove(0);
		}
	}
	/**
	 * Returns the size of the trainer's party.
	 * 
	 * @return int size of the trainer's party
	 */
	public int getSize() {
		return enemyTeam.size();
	}
	/**
	 * Returns the trainer's type and name as a string.
	 * 
	 * @return String of trainer's type and name
	 */
	public String getFullName() {
		return type +" "+ name;
	}
	/**
	 * Returns the trainer's party of monsters as a string.
	 * 
	 * @return String of trainer's monsters.
	 */
	public String printEnemyTeam() {
	    String friendString = "";
	    for (int i = 0; i< enemyTeam.size(); i++) {
		    friendString += "Team member " + (i + 1) +
				  ":\n\n"+enemyTeam.get(i).toString() + "\n\n" +
				  "-------------------------------------\n";
	  }
	  return friendString;
	} 
}