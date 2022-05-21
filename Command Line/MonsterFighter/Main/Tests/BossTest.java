import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BossTest {

	private Boss myBoss;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
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
	}
	
	@Test
	public void testFirstEnemy() {
		Monster firstBossMonster = myBoss.getFirstEnemy();
		assertEquals("Ra", firstBossMonster.getName());
	}
	
	@Test
	public void testRemoveEnemy() {
		myBoss.removeEnemy();
		assertEquals(3, myBoss.getSize());
	}
}
