import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamTest {

	private Team testTeam;
	private Battles testBattle;
	private Player testPlayer;
	private Monster testEnemy;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testTeam = new Team();
		testBattle = new Battles();
		testPlayer = new Player();
		testPlayer.setDay(6);
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
	public void addFriendToTeamTest() {
	    System.setOut(savedStandardOut);
	    testTeam.addFriend(new RandomMonster(testPlayer));
	    assertEquals(1, (testTeam.getSize()));
	}
	
	@Test
	public void removeFriendFromTeamTest() {
	    System.setOut(savedStandardOut);
	    RandomMonster test = new RandomMonster(testPlayer);
	    testTeam.addFriend(test);
	    testTeam.removeFriend(test);
	    assertEquals(0, (testTeam.getSize()));
	}
	
	@Test
	public void CantHaveMoreThanFourTeammatesTest() {
	    System.setOut(savedStandardOut);
	    FireMonster monster1 = new FireMonster("Fire test1", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster2 = new FireMonster("Fire test2", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster3 = new FireMonster("Fire test3", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster4 = new FireMonster("Fire test4", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    FireMonster monster5 = new FireMonster("Fire test5", 50.0, 5.0, 5.425, 20.0, 1, 150, 250, "");
	    testTeam.addFriend(monster1);
	    testTeam.addFriend(monster2);
	    testTeam.addFriend(monster3);
	    testTeam.addFriend(monster4);
	    testTeam.addFriend(monster5);
	    System.out.println(testTeam);
	    assertEquals(testTeam.getFriend(3).getName(), "Fire test4");
	}
}
