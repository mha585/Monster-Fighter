import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BossTest {

	private Player testPlayer;
	private Boss myBoss;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testPlayer = new Player();
		testPlayer.setDay(1);
		testPlayer.setDifficulty(7);
		testPlayer.setName("tester");
	    myBoss = new Boss();

	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void testBoss() {
	    assertEquals(4, (myBoss.getSize()));
	    assertEquals("Boss Miguel", myBoss.getFullName());
	    assertEquals("Leviathan", myBoss.getEnemies().get(2).getName());
	    myBoss.printBossFight();

	    String fight = outputStreamContent.toString();
	    assertEquals(700, fight.length());
	}
}
