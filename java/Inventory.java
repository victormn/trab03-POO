import java.util.*;

public class Inventory{

	/* Atributos */	

	private int spaces;
	private double gold;
	// atributo auxiliar que indica a quantidade de 'armor's equipados(max=1)
	private int armorCounter;		
	// atributo auxiliar que indica a quantidade de 'weapon's equipados(max=2)	
	private int weaponCounter;		
	// armazena 'item's existentes em 'inventory' em formato de um pair(associacao
	// de dois valores). A implementacao de pair foi feita atraves da classe 'Pair'
	private ArrayList<Pair<Item, Boolean>> items;

	/* Construtor */

	public Inventory(){
		spaces = 0;
		gold = 0.0;		
		items = new ArrayList<Pair<Item, Boolean>>();
		armorCounter = 0;
		weaponCounter = 0;
	}

	
	/* Métodos Getters */

	public double getTotalGold(){
		return gold;
	}

	public int getAvailableSpace(){
		return spaces-items.size();
	}

	public int getArmorCounter(){
		return armorCounter;
	}

	public int getWeaponCounter(){
		return weaponCounter;
	}

	// Retorna um pair de 'inventory'
	public Pair<Item, Boolean> getPair(int position){
		return items.get(position);
	}

	/* Métodos Setters */

	public void setSpaces(int spaces){
		this.spaces = spaces;
	}
	
	public void setArmorCounter(int counter){
		armorCounter += counter;
	}
	
	public void setWeaponCounter(int counter){
		weaponCounter += counter;
	}

	
	/* Métodos referentes a 'gold' */

	// Deduz do total existente o valor de ouro gasto e imprime o novo valor para o total
	public void spendGold(double gold){
		if (this.gold - gold >= 0)
			this.gold -= gold;
	}

	// Acrescenta o valor de ouro ganho no total existente e imprime seu novo valor
	public void earnGold(double gold){
		this.gold = this.gold + gold;
	}

	// Procura por um objeto 'Item' através de seu nome
	public Item searchItem(String name){			
		for (int i=0; i < items.size(); i++){
			if(items.get(i).first().getName().equals(name))
				return items.get(i).first();
		}
		return null; // quando nao existir item com esse nome retorna null	
	}

	// Procura por um objeto 'Item' através de sua posição no vetor
	public Item searchItem(int position){
		if (position < items.size())
			return items.get(position).first();
		else return null; // quando nao existir item nessa posicao retorna null
	}

	// Insere um objeto 'Item' no array de Pair 
	public void insertItem(Item item){
		if (getAvailableSpace() > 0) // só adiciona se existir espaco disponivel
			items.add(new Pair<Item, Boolean>(item, false));
	}

	// Remove um objeto 'Item' através de seu nome
	public void removeItem(String name){
		if (searchItem(name) != null){
			for (int i=0; i < items.size(); i++){
				if(items.get(i).first().getName().equals(name))
					removeItem(i);
			}
		}
	}

	// Remove um objeto 'Item' através de sua posição no vetor e o imprime
	public void removeItem(int position){
		if (searchItem(position) != null)
			items.remove(position);
	}	
}
