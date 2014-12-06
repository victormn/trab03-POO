import java.util.*;

public class Armor extends Item{

	/* Atributos */

	protected int defensepts;		// deve estar entre 1 e 20
	protected double weight;		// deve estar entre 1 e 20

	
	/* Construtor */
	
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

	/* Métodos */

	// Retorna o valor de 'weight' do item 'armor'
	public double getWeight(){
		return weight;
	}

	// Retorna valor de ataque de 'character'
	public int getAttackPts(){ 
		return 0;
	}

	// Retorna valor de defesa de 'character'
	public int getDefensePts(){ 
		return defensepts;
	}

	// Equipa um 'item'
	public void equip(Character character){

		if (character.getInventory().searchItem(this.getName()) != null && character.getInventory().getArmorCounter() < 1){

			// Procurando pela posicao do item
			int position = 0;

			for (int i=0; character.getInventory().searchItem(i) != null; i++){
					if(character.getInventory().searchItem(i).getName().equals(this.getName()))
						position = i;
		    }

		    // Reduzindo velocidade pelo uso de 'armor'(s' = s*e^[-(w/20)^2])
		    character.setSpeedArmor((int)(character.getSpeed() - (character.getSpeed()*Math.exp((-1)*Math.pow(this.getWeight()/20, 2)))));

			if (!character.getInventory().getPair(position).second()){
				character.getInventory().getPair(position).setSecond(true);
				character.getInventory().setArmorCounter(1);
			}
		}
	}

	// Desequipa um 'item'
	public void unequip(Character character){
		if (character.getInventory().searchItem(this.getName()) != null && character.getInventory().getArmorCounter() > 0){

			// Procurando pela posicao do item
			int position = 0;

			for (int i=0; character.getInventory().searchItem(i) != null; i++){
					if(character.getInventory().searchItem(i).getName().equals(this.getName()))
						position = i;
		    }

		    character.setSpeedArmor(0);	// voltando a velocidade sem o 'armor'
		
			if (character.getInventory().getPair(position).second()){
				character.getInventory().getPair(position).setSecond(false);
				character.getInventory().setArmorCounter(-1);
			}
		}
	}
}
