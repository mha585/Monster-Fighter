import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonstersTest {
	private Team testTeam;
	private Battles testBattle;
	private Player testPlayer;
	private Monster testEnemy;
	private RandomGen num;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testTeam = new Team();
		testBattle = new Battles();
		testPlayer = new Player();
		num = new RandomGen();
		testPlayer.setDay(1);
		testPlayer.setDifficulty(1);
		testPlayer.setName("tester");
		
	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void randomMonsterIsRandomTest() {
		RandomMonster random = new RandomMonster(testPlayer, num);
		RandomMonster original = random;
		
		for (int i = 0; i < 10; i++) {
			random = new RandomMonster(testPlayer, num);
		}
		assertNotEquals(random, original);
	}
	
	@Test
	public void randomMonsterCantBeGlassOrMedicalIfDayIsTooSmallTest() {
		RandomMonster random = new RandomMonster(testPlayer, num);
		
		for (int i = 0; i < 10; i++) {
			assertNotEquals(random.getType(), "Medical");
			assertNotEquals(random.getType(), "Glass");
			random = new RandomMonster(testPlayer, num);
		}
	}
	
	@Test
	public void randomMonsterCanBeGlassIfDayIsLargeEnoughTest() {
		for (int i = 0; i <= 4; i++) {
			testPlayer.addDay();
		}
		RandomMonster random = new RandomMonster(testPlayer, num);
		
		while (random.getType() != "Glass") {
			random = new RandomMonster(testPlayer, num);
		}
		return;
	}

	
	@Test
	public void randomMonsterCanBeMedicalIfDayIsLargeEnoughTest() {
		for (int i = 0; i <= 3; i++) {
			testPlayer.addDay();
		}
		RandomMonster random = new RandomMonster(testPlayer, num);
		
		while (random.getType() != "Medical") {
			random = new RandomMonster(testPlayer, num);
		}
		return;
	}
	
	@Test
	public void randomMonsterCantBeHolyIfDayIsTooSmallTest() {
		RandomMonster random = new RandomMonster(testPlayer, num);
		
		for (int i = 0; i < 10; i++) {
			assertNotEquals(random.getType(), "Holy");
			random = new RandomMonster(testPlayer, num);
		}
	}
	
	@Test
	public void randomMonsterCanBeHolyIfDayIsLargeEnoughTest() {
		for (int i = 0; i <= 5; i++) {
			testPlayer.addDay();
		}
		RandomMonster random = new RandomMonster(testPlayer, num);
		
		while (random.getType() != "Holy") {
			random = new RandomMonster(testPlayer, num);
		}
		return;
	}
	
	@Test
	public void holyDemonEffectivenessTest() {
		testTeam.addFriend(new HolyMonster("Holy test", 100.0, 5.0, 5, 20.0, 1, 150, 250, "holy"));
		testTeam.addFriend(new DemonMonster(num));
		testTeam.addFriend(new HolyMonster(num));
		testEnemy = new DemonMonster("demon test", 50.0, 5.0, 10, 19.0, 1, 150, 250, "demon");
		
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 80);
		assertEquals(testEnemy.getHealth(), 40);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, false);
		assertEquals(testTeam.getFriend(0).getHealth(), 60);
		assertEquals(testEnemy.getHealth(), 40);
		testBattle.attack(testEnemy, testTeam.getFriend(0), testTeam, false);
		testBattle.attack(testEnemy, testTeam.getFriend(0), testTeam, false);
		testBattle.attack(testEnemy, testTeam.getFriend(0), testTeam, false);
		testBattle.attack(testTeam.getFriend(0), testEnemy, testTeam, true);
		assertEquals(testTeam.getFriend(0).getHealth(), 60);
		assertEquals(testEnemy.getHealth(), 0);
	}
}
