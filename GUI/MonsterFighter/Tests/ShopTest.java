import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopTest {
	private Player testPlayer = new Player();
	private RandomGen num = new RandomGen();
//    private Shop testShop;
    private Shop testShop;

	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testShop = new Shop(testPlayer, num);
//		testPlayer = new Player();
//		num = new RandomGen();
//		testPlayer.setDay(1);
//		testPlayer.setDifficulty(1);
//		testPlayer.setName("tester");
		
	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void shopGeneratesExactlyFourRandomMonstersTest() {
	    RandomMonster isDefinetlyARandomMonster = new RandomMonster(testPlayer, num);

	    assertEquals(4, testShop.getMonsters().size());
		assertEquals(isDefinetlyARandomMonster.getClass(), testShop.getMonsters().get(0).getClass());
		assertEquals(isDefinetlyARandomMonster.getClass(), testShop.getMonsters().get(1).getClass());
		assertEquals(isDefinetlyARandomMonster.getClass(), testShop.getMonsters().get(2).getClass());
		assertEquals(isDefinetlyARandomMonster.getClass(), testShop.getMonsters().get(3).getClass());
	}
	
	@Test
	public void shopWontGeneratesHolyMonstersTest() {

		for (int i = 1; i < 8; i++) {
			testPlayer.addDay();
		}
	    assertEquals(4, testShop.getMonsters().size());
		assertNotEquals("Holy", testShop.getMonsters().get(0).getType());
		assertNotEquals("Holy", testShop.getMonsters().get(1).getType());
		assertNotEquals("Holy", testShop.getMonsters().get(2).getType());
		assertNotEquals("Holy", testShop.getMonsters().get(3).getType());
	}
	
	@Test
	public void shopGeneratesAllTheItems() {
	    assertEquals(9, testShop.getItems().size());
		assertEquals(new AtkBoost().getClass(), testShop.getItems().get(0).getClass());
		assertEquals(new AtkPlus().getClass(), testShop.getItems().get(1).getClass());
		assertEquals(new BasicHeal().getClass(), testShop.getItems().get(2).getClass());
		assertEquals(new FullHeal().getClass(), testShop.getItems().get(3).getClass());
		assertEquals(new MegaHeal().getClass(), testShop.getItems().get(4).getClass());
		assertEquals(new Revive().getClass(), testShop.getItems().get(5).getClass());
		assertEquals(new SpeedBoost().getClass(), testShop.getItems().get(6).getClass());
		assertEquals(new SpeedPlus().getClass(), testShop.getItems().get(7).getClass());
		assertEquals(new TierPlus().getClass(), testShop.getItems().get(8).getClass());
	}

}
