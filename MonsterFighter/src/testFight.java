
//this is just a class to test fights between monsters delete later!!!!
public class testFight {
	public static void main(String[] args) {
		
//		PartyMonster test = new FireMonster("test", 100, 5, 9, 25, 2);
//		System.out.println(test);
		
//		PartyMonster test3 = new PartyMonster(new FireMonster());
//		System.out.println(test3);
		
		GrassMonster friend = new GrassMonster();
		GrassMonster friend2 = new GrassMonster();
		FireMonster friend3 = new FireMonster();
		Monster badGuy = new GrassMonster();
		
		Team myTeam = new Team();
		myTeam.addFriend(friend);
		myTeam.addFriend(friend2);
		myTeam.addFriend(friend3);
		System.out.println("Team stats before battle:\n");
		System.out.println(myTeam);
		
		Battles firstBattle = new Battles();
		firstBattle.fight(myTeam, badGuy);
	}
}
