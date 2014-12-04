import java.util.*;

public class Inventory{

	private int spaces;
	private double gold;
	private ArrayList<Pair> items;
	private int armorCounter;
	private int weaponCounter;

	// os Counter controlam a quantidade de armor e weapon no inventario,
	// sendo o maximo 1 armor e 2 weapon

	public Inventory(){
		spaces = 0;
		gold = 0.0;		
		items = new ArrayList<Pair>();
		armorCounter = 0;
		weaponCounter = 0;
	}

	public double getTotalGold(){
		return gold;
	}

	public int getAvailableSpace(){
		return spaces-items.size();
	}

	public void spendGold(double gold){
		if (this.gold - gold >= 0)
			this.gold -= gold;
	}

	public void earnGold(double gold){
		this.gold = this.gold + gold;
	}

	public void setSpaces(int spaces){
		this.spaces = spaces;
	}
	public int getArmorCounter(){
		return armorCounter;
	}
	public void setArmorCounter(int counter){
		armorCounter += counter;
	}
	public int getWeaponCounter(){
		return weaponCounter;
	}
	public void setWeaponCounter(int counter){
		weaponCounter += counter;
	}

	public Item searchItem(String name){			
		for (int i=0; i < items.size(); i++){
			if(items.get(i).first().getName().equals(name))
				return items.get(i).first();
		}
		return null; // quando nao existir item com esse nome retorna null*/	
	}

	public Item searchItem(int position){
		if (position < items.size())
			return items.get(position).first();
		else return null; // quando nao existir item nessa posicao retorna null
	}

	public void insertItem(Item item){
		if (getAvailableSpace() > 0) // só adiciona se existir espaco disponivel
			items.add(new Pair(item, false));
	}

	public void removeItem(String name){
		if (searchItem(name) != null){
			for (int i=0; i < items.size(); i++){
				if(items.get(i).first().getName().equals(name))
					removeItem(i);
			}
		}
	}

	public void removeItem(int position){
		if (searchItem(position) != null)
			items.remove(position);
	}

	public Pair getPair(int position){
		return items.get(position);
	}
}
