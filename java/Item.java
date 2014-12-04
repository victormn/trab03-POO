import java.util.*;

public abstract class Item{

	private String name;
	private double price; 


	public Item(String name, double price){

		/* verificando os intervalos, caso esteja fora atribui-se o menor valor */
		if (price < 1)
			price = 1;		

		this.name = name;
		this.price = price;
	}

	public Item clone() {
		return (Item)this.clone();
	}

	/* getters */
	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	public abstract void use(Character character);
	public abstract void equip(Character character);
	public abstract void unequip(Character character);
	public abstract int getAttackPts();
	public abstract int getDefensePts();
	public double getWeight(){ return 0.0; }

	// sobre criar um metodo equip e unequip ao inves de utilizar o metodo use:
	// mesmo que o metodo use possa ser usado em armor e weapon como equipar o character, e em potion como usar a pocao
	// eu resolvi criar separadamente um metodo de equip para armor e weapon. 
	// assim, o nome faz sentido ("use" parece que o objeto sera descartado depois, como acontece com as potion)
	// e para fazer sentido meu metodo unequip, que criei caso o character queira trocar de armadura/arma

}
