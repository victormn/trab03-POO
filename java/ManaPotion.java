import java.util.*;

public class ManaPotion extends Item implements Potion{

	/* Atributos */
	
	private int manapts;

	/* Construtor */

	public ManaPotion(String name, double price, int manapts){
		super(name, price);

		this.manapts = manapts;
	}

	/* Metodos */	

	public int getRestorePts(){
		return manapts;
	}

	
	// Implementa metodo da interface 'Potion', indica que um item 'healthpotion' foi utilizado
	public void use(Character character){
		character.addMP(manapts);
		character.getInventory().removeItem(getName());
	}

	/* Metodos da classe 'Item' que devem ser implementados */

	public int getAttackPts(){ 
		return 0;
	}
	public int getDefensePts(){ 
		return 0;
	}
	
	// Equipa um 'item'(implementado em Armor e Weapon, itens que podem ser equipados)
	public void equip(Character character){ }

	// Desequipa um 'item'(implementado em Armor e Weapon, itens que podem ser equipados)
	public void unequip(Character character){ }	
}
