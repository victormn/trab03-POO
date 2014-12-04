import java.util.*;

public class ManaPotion extends Item implements Potion{

	private int manapts;

	public int getRestorePts(){
		return manapts;
	}

	public ManaPotion(String name, double price, int manapts){
		super(name, price);

		this.manapts = manapts;
	}
	
	// metodo da interface Potion
	public void use(Character character){
		character.addMP(manapts); 
// mudamos de getRestorePts() para manapts
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
