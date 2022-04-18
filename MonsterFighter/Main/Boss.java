import java.util.*;
public class Boss extends Trainers{
	private String bossType = "Boss";
	private String bossName = "Miguel";
	private GrassMonster grassBoss = new GrassMonster("Tane ", 90, 5, 40, 9, 3, 500, 750, "God of Forests and Birds");
	private FireMonster fireBoss = new FireMonster("Ra", 80, 3, 50, 13, 3, 500, 750, "God of the Sun");
	private WaterMonster waterBoss = new WaterMonster("Leviathan", 100, 3, 50, 10, 3, 500, 750, "Water Serpent");
	private DemonMonster demonBoss = new DemonMonster("Shinigami", 100, 3, 65, 13, 3, 500, 750, "DEATH");
	private ArrayList<Monster> enemyTeam = new ArrayList<Monster>(Arrays.asList(grassBoss, fireBoss, waterBoss, demonBoss));
	
	public ArrayList<Monster> getEnemies() {
		return enemyTeam;
	}
	
	
	public int getSize() {
		return enemyTeam.size();
	}

	public String getFullName() {
		return bossType + " " + bossName;
	}
	
	public List<Monster> getBossFight() {
		return enemyTeam;
	}

	public void printBossFight() {
		System.out.println(getFullName());
	  for (int i = 0; i< enemyTeam.size(); i++) {
		  System.out.println( "Boss Monster " + (i + 1) +":\n\n"+enemyTeam.get(i).toString() + "\n\n" +"-------------------------------------\n");
	  }
	}
}
