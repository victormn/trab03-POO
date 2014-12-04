import java.util.*;

public class ManaPotion extends Potion{

	public ManaPotion(String name, double price, int restorepts){
		super(name, price, restorepts);
	}
	
	public void use(Character character){
		character.addMP(getRestorePts());
		character.getInventory().removeItem(getName());
	}

}
