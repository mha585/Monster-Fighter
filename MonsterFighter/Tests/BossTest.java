import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BossTest {

	private Team testTeam;
	private Player testPlayer;
	private Monster testEnemy;
	private Shop testShop;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testTeam = new Team();
		testPlayer = new Player();
		testShop = new Shop();
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
	public void testBoss() {
	    Boss newBoss = new Boss(testPlayer);
	    assertEquals(4, (newBoss.getSize()));
	    assertEquals("Boss Miguel", newBoss.getFullName());
	    assertEquals("Leviathan", newBoss.getEnemies().get(2).getName());
	}

}
