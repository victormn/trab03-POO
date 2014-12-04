import java.util.*;

public abstract class Potion extends Item{

	private int restorepts;

	public Potion(String name, double price, int restorepts){
		super(name, price);

		this.restorepts = restorepts;

	}

	public Potion clone() {
		return (Potion)super.clone();
	}

	public int getRestorePts(){
		return restorepts;
	}

	public int getAttackPts(){ 
		return 0;
	}

	public int getDefensePts(){ 
		return 0;
	}
	// usa a pocao e depois deleta ela
	public void use(Character character){ }	
	// nao eh utilizado nessa classe
	public void equip(Character character){ }	
	public void unequip(Character character){ }	


}
