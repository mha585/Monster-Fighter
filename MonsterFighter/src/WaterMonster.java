
public class WaterMonster extends Monster{
	
	public WaterMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
	}
	
	public WaterMonster() {
		super();
		super.setType("Water");
	}
	
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
