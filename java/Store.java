import java.util.*;

public class Store{

	/* Atributos */
	
	private ArrayList<Item> itemsforsale;
	
	/* Construtor */
		
	public Store(){
		itemsforsale = new ArrayList<Item>();			
	}

	/* Metodos */

	// Retorna a posicao do 'item' em 'itemsforsale'
	public int pickItem(String name){			
		for (int i=0; i < itemsforsale.size(); i++){
			if(itemsforsale.get(i).getName().equals(name))
				return i;
		}
		return -1; // quando nao existir item com esse nome retorna -1*/	
	}

	// Realiza a compra de um item. Retorna 'true' se ele existe e 'false' se nao existe 
	public boolean buyItem(String nameItem, Character ch){

	    int posItem = pickItem(nameItem);	

		if(posItem != (-1)){ // existe o item

			double priceItem = itemsforsale.get(posItem).getPrice();

			if(ch.getInventory().getTotalGold() >= priceItem){ // condicao para que o 'character' possa comprar um 'item'
 						
				ch.getInventory().insertItem(itemsforsale.get(posItem)); // adiciona item no inventario do personagem
				itemsforsale.remove(posItem);
				ch.getInventory().spendGold(priceItem);

				System.out.println("\nCompra comprada com sucesso! :D");

				return true; // compra de 'item' foi bem sucedida
			}
			else{
				System.out.println("\nEita! Voce nao tem ouro suficiente para esta compra!");
				return false; 
			}			
		}
		System.out.println("\nHey! Nao existe esse negocio aqui na loja nao!");
		return false; // compra nao pode ser efetuada
						
	}

	// Abastece a loja com 'items'
	public void supplyStore(Item itemforsale){
		
		itemsforsale.add(itemforsale);		
	}

	public void showStore(Character character){
	
		// titulo
		System.out.println("\n\tStore\n");

		for (int i = 0; i < itemsforsale.size(); i++) {

			// nome do item
			System.out.print(itemsforsale.get(i).getName() + " ");

			// imprime a quantidade certa de pontos "." de modo que os precos fiquem alinhados
			for (int j = 0; j < 50-itemsforsale.get(i).getName().length() ; j++)
					System.out.print("."); 	
		
			// preco do item
			System.out.println(" " + itemsforsale.get(i).getPrice() + " ouro");
		}

		// quantidade de golds que o persongem possui no momento
		System.out.println("\n\n!" + character.getName() + " golds: " + character.getInventory().getTotalGold());

		String nameItem;

		do{

			System.out.print("\nQual item quer comprar?  ");

			Scanner scanner = new Scanner(System.in);
			nameItem = scanner.nextLine();

		}while(!buyItem(nameItem, character)); 

	}
}
