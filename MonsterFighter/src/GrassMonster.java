
public class GrassMonster extends Monster{
	
	public GrassMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
	}
	
	public GrassMonster() {
		super();
		super.setType("Grass");
	}
	
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
