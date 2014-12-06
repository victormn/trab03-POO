import java.util.*;

public class HealthPotion extends Potion{

	/* Atributos */

	private int healthpts;

	public int getRestorePts(){
		return healthpts;
	}
	
	/* Construtor */

	public HealthPotion(String name, double price, int healthpts){
		super(name, price);

		this.healthpts = healthpts;
	}

	/* Métodos */

	// Restaura o valor de 'healthpts'	
	public int getRestorePts(){
		return healthpts;
	}
	
	// Implementa metodo da interface 'Potion', indica que um item 'healthpotion' foi utilizado
	public void use(Character character){
		character.addHP(healthpts);
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
