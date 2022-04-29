import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {

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
	public void useHealItem() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    itemUser.gainHealth(-20);
	    assertEquals(80, (itemUser.getHealth()));
	    Item itemToUse = new BasicHeal();
	    itemToUse.useItem(itemUser);
	    assertEquals(100, (itemUser.getHealth()));
	}
	
//	@Test
//	public void megaHealHeals50() {
//	}
	
//	@Test
//	public void fullHealHealsToMax() {
//	}
	
//	@Test
//	public void cantHealPastMax() {
//	}
	
//	@Test
//	public void cantHealADeadMonster() {
//	}

	@Test
	public void useAtkPlusItem() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    assertEquals(10, (itemUser.getDamage()));
	    Item itemToUse = new AtkPlus();
	    itemToUse.useItem(itemUser);
	    assertEquals(20, (itemUser.getDamage()));
	}
	
//	@Test
//	public void atkBoostIncreaseGoesAwayAfterBattle() {
//	}
	
	@Test
	public void useSpeedPlusItem() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    assertEquals(19, (itemUser.getSpeed()));
	    Item itemToUse = new SpeedPlus();
	    itemToUse.useItem(itemUser);
	    assertEquals(29, (itemUser.getSpeed()));
	}
	
//	@Test
//	public void speedBoostIncreaseGoesAwayAfterBattle() {
//	}
	
//	@Test
//	public void tierPlusTest() {
//	check both the stats increase and the tier increases
//	}
	
//	@Test
//	public void reviveTest() {
//	}
	
//	@Test
//	public void reviveDontWorkOnLivingMonsterTest() {
//	}
	
//	@Test
//	public void itemGoesFromInventoryAfterUse() {
//	}
}
