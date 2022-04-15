

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattlesTest {
	private Team testTeam;
	private Battles testBattle;
	private Player testPlayer;
	private Monster testEnemy;
	
	@BeforeEach
	public void init() {
		testTeam = new Team();
		testBattle = new Battles();
		testPlayer = new Player();
		testPlayer.setDay(6);
		testPlayer.setDifficulty(1);
		testPlayer.setName("tester");
		testTeam.addFriend(new FireMonster("Fire test", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "fire"));
		testTeam.addFriend(new GrassMonster("Grass test", 100.0, 5.0, 20.0, 25.0, 1, 150, 250, "grass"));
		testTeam.addFriend(new WaterMonster("Water test", 50.0, 5.0, 20.0, 20.0, 1, 150, 250, "water"));
		testTeam.addFriend(new MedicalMonster("Medic test", 150.0, 5.0, 20.0, 20.0, 1, 150, 250, "medic"));
		testEnemy = new GlassMonster("Glass test", 50.0, 5.0, 24.75, 21.0, 1, 150, 250, "glass");
    }
	
	@Test
	public void attackTest() {
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 0.5);
		assertEquals(testEnemy.getHealth(), 39.15);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(3).getHealth(), 0);
		assertEquals(testEnemy.getHealth(), 39.15);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
		assertEquals(testTeam.getFriend(0).getHealth(), 50.5);
		assertEquals(testEnemy.getHealth(), 39.15);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 50.5);
		assertEquals(testEnemy.getHealth(), 0);
	}
	
	
}
