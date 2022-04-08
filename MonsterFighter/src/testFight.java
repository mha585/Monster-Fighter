
//this is just a class to test fights between monsters delete later!!!!
public class testFight {
	public static void main(String[] args) {
		
		Team myTeam = new Team();
		Battles battle = new Battles();
//		I think these two above lines only need to be initialised once in main
		
		FireMonster friend = new FireMonster();
		Monster badGuy = new GrassMonster();

		myTeam.addFriend(friend);
		myTeam.addFriend(new WaterMonster());
//		myTeam.addFriend(new GrassMonster());
		
		if (battle.fight(myTeam, badGuy) == true) {
//			continue the game
			System.out.println("The game continues");
		} else {
//			end the game
			System.out.println("The game ends");
		}
		battle.fight(myTeam, badGuy);
	}
}
