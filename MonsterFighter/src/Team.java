import java.util.ArrayList;

public class Team extends PartyMonster{
	
	private ArrayList<PartyMonster> myTeam = new ArrayList<PartyMonster>();
	
	public ArrayList<PartyMonster> getTeam() {
		return myTeam;
	}
	
	public int getSize() {
		return myTeam.size();
	}
	
	public PartyMonster getFriend(int index) {
		return myTeam.get(index);
	}
	
	public boolean addFriend(PartyMonster friend) {
		  if (myTeam.size() < 4) {
			  myTeam.add(friend);
			  return true;
		  } else {
			  System.out.println("team size is > 4 so do something");
			  return false;
		  }
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
