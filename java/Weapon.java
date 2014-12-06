import java.util.*;

public class Weapon extends Item{

	
	/* Atributos */

	protected int attackpts;
	protected double range;

	/* Construtor */
	
	public Weapon(String name, double price, int attackpts, double range){
		super(name, price);

		// Verificando os intervalos, caso esteja fora atribui-se o menor valor 
		if (attackpts > 9 || attackpts < 1)
			attackpts = 1;	

		this.attackpts = attackpts;

		this.range = range;

	}

	public Weapon clone() {
		return (Weapon)super.clone();
	}

	/* Métodos */

	// Retorna valor de ataque de 'character'
	public double getRange(){
		return range;
	}

	// Retorna valor de ataque de 'character'
	public int getAttackPts(){ 
		return attackpts;
	}

	// Retorna valor de defesa de 'character'
	public int getDefensePts(){ 
		return 0;
	}

	// Equipa um 'item'
	public boolean equip(Character character){

		try{
			character.getInventory().searchItem(this.getName())
		}catch (NullPointerException e) {
			System.out.println("Weapon nao existe no inventario!");
			return false;
		}

		// -Caso o personagem tenha estourado sua capacidade maxima de carregar weapon
		//  foi decidido que uma das weapon equipadas sera desequipadas para dar lugar
		//  para a nova weapon
		// -Caso nao seja uma weapon, ele vai ver que nao mudou o numero de weapon no
		//  inventario e vai continuar a busca pelo proximo item equipado

		int pos = -1;
		while (character.getInventory().getWeaponCounter() >= 2){

			boolean found = false;
			int pos;
			for (int i = pos+1; found = false; i++) {
				if (character.getInventory().getPair(i).second()){
					pos = i;
					found = true;
				}
			}
			character.getInventory().get(pos).unequip(character);

			if (character.getInventory().getWeaponCounter() >= 2){
				character.getInventory().get(pos).equip(character);

			}
		}

		// Procurando pela posicao do item
		int position = 0;

		for (int i=0; character.getInventory().searchItem(i) != null; i++){
				if(character.getInventory().searchItem(i).getName().equals(this.getName()))
					position = i;
	    }

		// Se item nao estiver equipado (seu boolean estara como false)
		if (!character.getInventory().getPair(position).second()){
			character.getInventory().getPair(position).setSecond(true);
			character.getInventory().setWeaponCounter(1);
		}
		return true;
		
	}

	// Desequipa um 'item'
	public void unequip(Character character){
		if (character.getInventory().searchItem(this.getName()) != null && character.getInventory().getWeaponCounter() > 0){

			// Procurando pela posicao do item
			int position = 0;

			for (int i=0; character.getInventory().searchItem(i) != null; i++){
					if(character.getInventory().searchItem(i).getName().equals(this.getName()))
						position = i;
		    }

			// Se item nao estiver desequipado (seu boolean estara como true)	
			if (character.getInventory().getPair(position).second()){
				character.getInventory().getPair(position).setSecond(false);
				character.getInventory().setWeaponCounter(-1);
			}
		}
	}
}
