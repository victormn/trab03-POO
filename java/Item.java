import java.util.*;

public abstract class Item{

	/* Atributos */

	private String name;
	private double price; 

	/* Construtor */

	public Item(String name, double price){

		// Verificando os intervalos, caso esteja fora atribui-se o menor valor
		if (price < 1)
			price = 1;		

		this.name = name;
		this.price = price;
	}

	public Item clone() {
		return (Item)this.clone();
	}

	/* Métodos Getters */

	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	/* Métodos */

	// Equipa um 'item'(implementado em Armor e Weapon, itens que podem ser equipados)
	public abstract void equip(Character character);

	// Desequipa um 'item'(implementado em Armor e Weapon, itens que podem ser equipados)
	public abstract void unequip(Character character);

	// Retorna valor de ataque de 'character'(implementado em Armor e Weapon)
	public abstract int getAttackPts();

	// Retorna valor de defesa de 'character'(implementado em Armor e Weapon)
	public abstract int getDefensePts();

	// Retorna o valor de 'weight' do item 'armor'(implementado em Armor)
	public double getWeight(){ return 0.0; }	

}
