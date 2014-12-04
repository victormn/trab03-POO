import java.util.*;

public class Armor extends Item{

	protected int defensepts;
	protected double weight;

	public Armor(String name, double price, int defensepts, double weight){
		super(name, price);
		
		if (defensepts > 20 || defensepts < 1)
			defensepts = 1;	

		this.defensepts = defensepts;

		if (weight > 20 || weight < 1)
			weight = 1;	

		this.weight = weight;

	}

	public Armor clone() {
		return (Armor)super.clone();
	}

	public double getWeight(){
		return weight;
	}

	public int getAttackPts(){ 
		return 0;
	}

	public int getDefensePts(){ 
		return defensepts;
	}

	// explicacao do porque de ter criado esses metodos (equip e unequip) e nao aproveitado o use estao no Item.java
	public void equip(Character character){

		if (character.getInventory().searchItem(this.getName()) != null && character.getInventory().getArmorCounter() < 1){

			// procurando pela posicao do item
			int position = 0;

			for (int i=0; character.getInventory().searchItem(i) != null; i++){
					if(character.getInventory().searchItem(i).getName().equals(this.getName()))
						position = i;
		    }

		    // s' = s*e^[-(w/20)^2]
		   	// explicacao do speedArmor em Character.java
		    character.setSpeedArmor((int)(character.getSpeed() - (character.getSpeed()*Math.exp((-1)*Math.pow(this.getWeight()/20, 2)))));

			if (!character.getInventory().getPair(position).second()){
				character.getInventory().getPair(position).setSecond(true);
				character.getInventory().setArmorCounter(1);
			}
		}
	}

	public void unequip(Character character){
		if (character.getInventory().searchItem(this.getName()) != null && character.getInventory().getArmorCounter() > 0){

			// procurando pela posicao do item
			int position = 0;

			for (int i=0; character.getInventory().searchItem(i) != null; i++){
					if(character.getInventory().searchItem(i).getName().equals(this.getName()))
						position = i;
		    }

		    character.setSpeedArmor(0);
		
			if (character.getInventory().getPair(position).second()){
				character.getInventory().getPair(position).setSecond(false);
				character.getInventory().setArmorCounter(-1);
			}
		}
	}
}
