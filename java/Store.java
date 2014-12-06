import java.util.*;

public class Store{

	private ArrayList<Item> itemsforsale;
		
	public Store(){
		itemsforsale = new ArrayList<Item>();
		nitemsforsale = 0;		
	}

	// Retorna a posicao do 'item' em 'itemsforsale'
	public int pickItem(String name){			
		for (int i=0; i < itemsforsale.size(); i++){
			if(itemsforsale.get(i).first().getName().equals(name))
				return i;
		}
		return -1; // quando nao existir item com esse nome retorna -1*/	
	}

	// Realiza a compra de um item. Retorna 'true' se ele existe e 'false' se nao existe 
	public boolean buyItem(String nameItem, Character ch){

	    int posItem = pickItem(nameItem);		 

		int priceItem = itemsforsale.get(posItem).getGold();

		if(ch.getGold() >= priceItem){ // condicao para que o 'character' possa comprar um 'item'
			
			if(posItem != -1){
			
				ch.getInventory().insertItem(itemsforsale.get(posItem)); // adiciona item no inventario do personagem
				itemforsale.remove(posItem);
				ch.setGold(getGold()-priceItem);

				return true; // compra de 'item' foi bem sucedida
			}
			else{
				System.out.println("Hey! Nao existe esse negocio aqui na loja nao!\n");
				return false; // compra nao pode ser efetuada
			}			
		}
		System.out.println("Eita! Voce nao tem ouro suficiente para esta compra!\n");
		return false; 						
	}

	// Abastece a loja com 'items'
	public void supplyStore(Item itemforsale){
		
		itemsforsale.push(itemforsale);		
	}

	public void showStore(Character character){
	
		// titulo
		System.out.println("\n\tStore\n");

		for (int i = 0; i < itemsforsale.size(); i++) {

			// nome do item
			System.out.print(itemsforsale.get(i).first().getName() + " ");

			// imprime a quantidade certa de pontos "." de modo que os precos fiquem alinhados
			for (int j = 0; j < 20-itemsforsale.get(i).first().getName()l.ength() ; j++)
					System.out.print("."); 	
		
			// preco do item
			System.out.println(" " + itemsforsale.get(i).first().getPrice() + " ouro");
		}

		// quantidade de golds que o persongem possui no momento
		System.out.println(character.getName() + " golds: " + character.getInventory().getTotalGolds());

		do{

			System.out.println("\n Que item quer comprar? ");

			Scanner scanner = new Scanner(System.in);
			String nameItem = scanner.nextLine();

		}while(!buyItem(nameItem, character)); 

	}
}
