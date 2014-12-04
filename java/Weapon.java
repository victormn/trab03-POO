import java.util.*;

public class Weapon extends Item{
	protected int attackpts;
	protected double range;

	public Weapon(String name, double price, int attackpts, double range){
		super(name, price);

		/* verificando os intervalos, caso esteja fora atribui-se o menor valor */
		if (attackpts > 9 || attackpts < 1)
			attackpts = 1;	

		this.attackpts = attackpts;

		this.range = range;

	}

	public Weapon clone() {
		return (Weapon)super.clone();
	}


	public double getRange(){
		return range;
	}

	public int getAttackPts(){ 
		return attackpts;
	}

	public int getDefensePts(){ 
		return 0;
	}

	public void use(Character character){ }

	// explicacao do porque de ter criado esses metodos (equip e unequip) e nao aproveitado o use estao no Item.java
	public void equip(Character character){

		if (character.getInventory().searchItem(this.getName()) != null && character.getInventory().getWeaponCounter() < 2){

			// procurando pela posicao do item
			int position = 0;

			for (int i=0; character.getInventory().searchItem(i) != null; i++){
					if(character.getInventory().searchItem(i).getName().equals(this.getName()))
						position = i;
		    }

			if (!character.getInventory().getPair(position).second()){
				character.getInventory().getPair(position).setSecond(true);
				character.getInventory().setWeaponCounter(1);
			}
		}
	}

	public void unequip(Character character){
		if (character.getInventory().searchItem(this.getName()) != null && character.getInventory().getWeaponCounter() > 0){

			// procurando pela posicao do item
			int position = 0;

			for (int i=0; character.getInventory().searchItem(i) != null; i++){
					if(character.getInventory().searchItem(i).getName().equals(this.getName()))
						position = i;
		    }

		
			if (character.getInventory().getPair(position).second()){
				character.getInventory().getPair(position).setSecond(false);
				character.getInventory().setWeaponCounter(-1);
			}
		}
	}
}
