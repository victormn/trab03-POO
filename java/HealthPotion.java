import java.util.*;

public class HealthPotion extends Potion{

	public HealthPotion(String name, double price, int restorepts){
		super(name, price, restorepts);
	}
	
	public void use(Character character){
		character.addHP(getRestorePts());
		character.getInventory().removeItem(getName());
	}

}
