import java.util.*;
public class Boss {
	
	private GrassMonster grassBoss = new GrassMonster("Tane ", 90, 5, 40, 9, 3, 500, 750, "God of Forests and Birds");
	private FireMonster fireBoss = new FireMonster("Ra", 80, 3, 50, 13, 3, 500, 750, "God of the Sun");
	private WaterMonster waterBoss = new WaterMonster("Leviathan", 100, 3, 50, 10, 3, 500, 750, "Water Serpent");
	private DemonMonster demonBoss = new DemonMonster("Shinigami", 100, 3, 65, 13, 3, 500, 750, "DEATH");
	private List<Monster> bossMonsters = new ArrayList<Monster>(Arrays.asList(grassBoss, fireBoss, waterBoss, demonBoss));

	
	public List<Monster> getBossFight() {
		return bossMonsters;
	}

	public void printBossFight() {
		System.out.println("Boss Miguel");
	  for (int i = 0; i< bossMonsters.size(); i++) {
		  System.out.println( "Boss Monster " + (i + 1) +":\n\n"+bossMonsters.get(i).toString() + "\n\n" +"-------------------------------------\n");
	  }
	}
}
