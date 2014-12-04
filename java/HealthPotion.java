import java.util.*;

public class HealthPotion extends Potion{

	private int healthpts;

	public int getRestorePts(){
		return healthpts;
	}

	public HealthPotion(String name, double price, int healthpts){
		super(name, price);

		this.healthpts = healthpts;
	}

	// metodo da interface Potion
	public void use(Character character){
		character.addHP(healthpts);
// mudamos de getRestorePts() para healthpts
		character.getInventory().removeItem(getName());
	}

	// metodos da classe Item que devem ser implementados

	// nao sao utilizados nessa classe
	public void equip(Character character){ }
	public void unequip(Character character){ }	

	public int getAttackPts(){ 
		return 0;
	}
	public int getDefensePts(){ 
		return 0;
	}
}
