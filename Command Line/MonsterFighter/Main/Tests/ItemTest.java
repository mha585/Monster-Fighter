import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
	private Player testPlayer;
	private RandomGen num;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testPlayer = new Player();
		num = new RandomGen();
		testPlayer.setDay(1);
		testPlayer.setDifficulty(3);
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
	
	@Test
	public void megaHealHeals50() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    itemUser.gainHealth(-90);
	    Item itemToUse = new MegaHeal();
	    itemToUse.useItem(itemUser);
	    assertEquals(60, (itemUser.getHealth()));
	}
	
	@Test
	public void fullHealHealsToMax() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 98224.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    itemUser.gainHealth(-98223);
	    Item itemToUse = new FullHeal();
	    itemToUse.useItem(itemUser);
	    assertEquals(98224, (itemUser.getHealth()));
	}
	
	@Test
	public void cantHealPastMax() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 15.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    itemUser.gainHealth(-14);
	    Item itemToUse1 = new BasicHeal();
	    Item itemToUse2 = new MegaHeal();
	    Item itemToUse3 = new FullHeal();
	    itemToUse1.useItem(itemUser);
	    itemToUse2.useItem(itemUser);
	    itemToUse3.useItem(itemUser);
	    assertEquals(15, (itemUser.getHealth()));
	}

	@Test
	public void useAtkPlusItemTest() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    assertEquals(10, (itemUser.getDamage()));
	    Item itemToUse = new AtkPlus();
	    itemToUse.useItem(itemUser);
	    assertEquals(30, (itemUser.getDamage()));
	}
	
	@Test
	public void atkBoostTest() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    assertEquals(10, (itemUser.getDamage()));
	    Item itemToUse = new AtkBoost();
	    itemToUse.useItem(itemUser);
	    assertEquals(20, (itemUser.getDamage()));
	}
	
	@Test
	public void useSpeedPlusItem() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    assertEquals(19, (itemUser.getSpeed()));
	    Item itemToUse = new SpeedPlus();
	    itemToUse.useItem(itemUser);
	    assertEquals(39, (itemUser.getSpeed()));
	}
	
	@Test
	public void speedBoostTest() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    assertEquals(19, (itemUser.getSpeed()));
	    Item itemToUse = new SpeedBoost();
	    itemToUse.useItem(itemUser);
	    assertEquals(29, (itemUser.getSpeed()));
	}
	
	@Test
	public void tierPlusTest() {
//	check both the stats increase and the tier increases
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    assertEquals(100, (itemUser.getMaxHealth()));
	    assertEquals(10, (itemUser.getDamage()));
	    assertEquals(19, (itemUser.getSpeed()));
	    assertEquals(1, (itemUser.getTier()));
	    Item itemToUse = new TierPlus();
	    itemToUse.useItem(itemUser);
	    assertEquals(104, (itemUser.getMaxHealth()));
	    assertEquals(10.8, (itemUser.getDamage()));
	    assertEquals(19.5, (itemUser.getSpeed()));
	    assertEquals(2, (itemUser.getTier()));
	}
	
	@Test
	public void reviveTest() {
	    Monster itemUser = new MedicalMonster("UseItemOnMe", 100.0, 5.0, 10, 19.0, 1, 150, 250, "");
	    itemUser.gainHealth(-100);
	    assertEquals(0, (itemUser.getHealth()));
	    Item itemToUse = new Revive();
	    itemToUse.useItem(itemUser);
	    assertEquals(100, (itemUser.getHealth()));
	}
}
