//this is just a class to test fights between monsters delete later!!!!
public class testFight {
	public static void main(String[] args) {
		PartyMonsters goodGuy = new PartyMonsters("friend", 100, 5, 9, 25, 2);
		Monster badGuy = new Monster("enemy", 18, 5, 80, 10, 2);
		System.out.println("Initial goodGuy stats: ");
		System.out.println("------------------------------------------------------------");
		System.out.println(goodGuy);
		System.out.println("------------------------------------------------------------ turn 1:");
		System.out.println("enemy attacks friend for " + badGuy.getDamage());
		goodGuy.gainHealth(-1 * badGuy.getDamage()); 
//		could do the above line with a seperate looseHealth method if this is too complicated
		System.out.println("friend's stats after the attack:\n");
		System.out.println(goodGuy);
		System.out.println("------------------------------------------------------------ turn 2:");
		System.out.println("friend uses an item to double their attack (for this turn so need to remove it at the end of turn)");
		goodGuy.gainDamage(goodGuy.getDamage());
		System.out.println("Now friend cheats and attacks enemy the same turn as using an item\n");
		badGuy.gainHealth(-1 * goodGuy.getDamage()); 
		System.out.println(badGuy);
		goodGuy.gainDamage(-1 * (goodGuy.getDamage() / 2));
//		this above line is to remove the effects of the items (bit confusing)
		System.out.println("------------------------------------------------------------ battle end:");
		System.out.println("now that friend one friend gains 1256 experience");
		goodGuy.gainExperience(1256);
		System.out.println("friends final stats: \n");
		System.out.println(goodGuy);
	}
}
