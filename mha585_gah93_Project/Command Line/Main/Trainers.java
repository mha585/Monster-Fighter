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
	/**
	 * Basic constructor for Trainer class.
	 * 
	 * @param player		The player
	 */
	public Trainers(Player player) {
		randomGen randomNum = new randomGen();
		name = trainerName.get(randomNum.randNumInRange(0, trainerName.size()));
		type = trainerType.get(randomNum.randNumInRange(0, trainerType.size()));
		if (player.getDayCompleted() == 1) {
			RandomMonster monster = new RandomMonster(player);
			enemyTeam.add(monster);
		}
		else if (player.getDayCompleted() > 1 && player.getDayCompleted() <= 3) {
			int monsters = randomNum.randNumInRange(0, 2);
			int i = 0;
			while (i <= monsters) {
				RandomMonster monster = new RandomMonster(player);
				enemyTeam.add(monster);
				i++;
			}
		}
		else if (player.getDayCompleted() > 3 && player.getDayCompleted() <= 5) {
			int monsters = randomNum.randNumInRange(1, 3);
			int i = 0;
			while (i <= monsters) {
				RandomMonster monster = new RandomMonster(player);
				enemyTeam.add(monster);
				i++;
			}
		}
		else if (player.getDayCompleted() > 5) {
			int monsters = randomNum.randNumInRange(1, 4);
			int i = 0;
			while (i <= monsters) {
				RandomMonster monster = new RandomMonster(player);
				enemyTeam.add(monster);
				i++;
			}
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