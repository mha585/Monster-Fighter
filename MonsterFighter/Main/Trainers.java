import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Trainers {
	private String name;
	private String type;
	private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
	
	private List<String> trainerType = Arrays.asList("Officer", "Doctor", "Dentist", "Telemarketer", "Magician", "Gymnast",
			"Criminial", "Judge", "Construction Worker", "Athlete", "Actor", "Singer", "Monster Fanatic", "University Student", 
			"Pre Schooler", "Baker", "Dog Trainer", "Accountant");
	
	private List<String> trainerName = Arrays.asList("Lucinda", "Augusto", "Diona", "Belle", "Alex", "Asia", "Tatianna", 
			"Eric", "Ali", "Beatriz", "Charlies", "Gabriel", "Hanna", "Netta", "Grant", "Fidel", "Emmie", "Ally", "Minnie",
			"Jeanette", "Dre", "Franz", "Izumi", "Naomi", "Xiulan", "Hu Tao", "Miki", "Walter", "Doug", "Shelly", "Jasmine", "Ariel",
			"Ben", "Ken", "Denzel", "Mary", "Peter", "Jeanette", "Lily", "Ysabel", "Rem", "Mandy", "Billie");
	
	public Trainers() {
		randomGen randomNum = new randomGen();
		name = trainerName.get(randomNum.randNumInRange(0, trainerName.size()));
		type = trainerType.get(randomNum.randNumInRange(0, trainerType.size()));
		int monsters = randomNum.randNumInRange(1, 4);
		int i = 0;
		while (i <= monsters) {
			RandomMonster monster = new RandomMonster();
			enemyTeam.add(monster);
			i++;
		}
	}
	
	public String getFullName() {
		return type +" "+ name;
	}
	
	public String printEnemyTeam() {
		String friendString = "";

	  if (enemyTeam.size() == 0) {
		  return "No monsters in current team";
	  }
	  for (int i = 0; i< enemyTeam.size(); i++) {
		  friendString += "Team member " + (i + 1) +
				  ":\n\n"+enemyTeam.get(i).toString() + "\n\n" +
				  "-------------------------------------\n";
	  }
	  return friendString;
} 
}
