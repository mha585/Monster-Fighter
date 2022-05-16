import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {

	private Inventory testBag;
	private Player testPlayer;
	private RandomGen num;
	
	private ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
	private InputStream savedStandardInputStream = System.in;
	private PrintStream savedStandardOut = System.out;

	
	@BeforeEach
	public void init() {
		testBag = new Inventory();
		testPlayer = new Player();
		num = new RandomGen();
	    System.setOut(new PrintStream(outputStreamContent));
    }
	
	@AfterEach
	public void tearDown() {
	    System.setIn(savedStandardInputStream);
	    System.setOut(savedStandardOut);
	}
	
	@Test
	public void addItemToBagTest() {
	    Item testItemToAdd = new BasicHeal();
	    testBag.addtoBag(testItemToAdd, 3);
	    assertEquals(1, (testBag.getSize()));
	    assertEquals(3, testBag.getItem(0).getFrequency());
	}
	
	@Test
	public void addExistingItemToBagTest() {
//	    System.setOut(savedStandardOut);
		System.out.println("hiii");
	    Item testItemToAdd = new BasicHeal();
	    testBag.addtoBag(testItemToAdd, 3);
	    testBag.addtoBag(testItemToAdd, 5);
	    assertEquals(1, (testBag.getSize()));
	    assertEquals(8, testBag.getItem(0).getFrequency());
	}
	
	@Test
	public void removeItemFromBagTest() {
	    Item testItemToAdd = new BasicHeal();
	    testBag.addtoBag(testItemToAdd, 3);
	    testBag.removeBag(0, 2);
	    assertEquals(1, (testBag.getSize()));
	    assertEquals(1, testBag.getItem(0).getFrequency());
	    testBag.removeBag(0, 1);
	    assertEquals(0, (testBag.getSize()));
	}
	
	@Test
	public void clearBagTest() {
	    Item testItemToAddOne = new BasicHeal();
	    Item testItemToAddTwo = new Revive();
	    Item testItemToAddThree = new FullHeal();

	    testBag.addtoBag(testItemToAddOne, 92);
	    testBag.addtoBag(testItemToAddTwo, -12);
	    testBag.addtoBag(testItemToAddThree, 2);
	    assertEquals(3, (testBag.getSize()));
	    testBag.clear();
	    assertEquals(0, (testBag.getSize()));
	}
	
	@Test
	public void buyItemTest() {
	    Item testItemToBuyOne = new Revive();

	    testBag.buyItem(1, testItemToBuyOne, testPlayer);
	    assertEquals(3, (testPlayer.getInventory().getSize()));
	    assertEquals(0, testPlayer.getMoney());
	}
	
	@Test
	public void notEnoughMoneyToBuyItemTest() {
		testPlayer.addMoney(-250);
	    Item testItemToBuyOne = new Revive();
	    testBag.buyItem(2, testItemToBuyOne, testPlayer);
	    assertEquals(2, (testPlayer.getInventory().getSize()));
	}
	
	@Test
	public void sellItemsTest() {
		testPlayer.addMoney(-250);
		testBag = testPlayer.getInventory();
	    int indexOfItemToSell = testBag.getIndex(testPlayer.getInventory().getItem(1).getName());
	    testBag.sellItem(1, indexOfItemToSell, testPlayer, testPlayer.getInventory());
	    assertEquals(40, testPlayer.getMoney());
	}

}
