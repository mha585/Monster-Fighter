import java.util.ArrayList;

public class Team extends Monster{
	
	private ArrayList<Object> myTeam = new ArrayList <>();
	
	public ArrayList<Object> getTeam() {
		return myTeam;
	}
	
	public int getSize() {
		return myTeam.size();
	}
	
	public Monster getFriend(int index) {
		return (Monster) myTeam.get(index);
	}
	
	public boolean addFriend(Monster friend) {
		  if (myTeam.size() < 4) {
			  myTeam.add(friend);
			  return true;
		  } else {
			  System.out.println("team size is > 4 so do something");
			  return false;
		  }
	}
	
	public boolean removeFriend(Monster friend) {
		  if (myTeam.size() > 0) {
			  myTeam.remove(friend);
			  return true;
		  } else {
			  System.out.println("could not remove");
			  return false;
		  }
	}
	
	public void swapFriends(int indexMonster1, int indexMonster2) {
		Object firstMonster = myTeam.get(indexMonster1);
		Object secondMonster = myTeam.get(indexMonster2);
		myTeam.set(indexMonster1, secondMonster);
		myTeam.set(indexMonster2, firstMonster);
		
	}
	
	  public String printFriends() {
		  String friendString = "";
		  
		  if (myTeam.size() == 0) {
			  return "No monsters in current team";
		  }
		  for (int i = 0; i< myTeam.size(); i++) {
			  friendString += "Team member " + (i + 1) +
					  ":\n\n"+myTeam.get(i).toString() + "\n\n" +
					  "-------------------------------------\n";
		  }
		  return friendString;
	  }
	  
	  
	public String toString() {		
		return printFriends();
	}
}
