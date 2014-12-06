import java.util.*;

public class Store{

	/* Atributos */
	
	private ArrayList<Item> itemsforsale;
	
	/* Construtor */
		
	public Store(){
		itemsforsale = new ArrayList<Item>();
		nitemsforsale = 0;		
	}

	/* Metodos */

	// Retorna a posicao do 'item' em 'itemsforsale'
	public int pickItem(String name){			
		for (int i=0; i < itemsforsale.size(); i++){
			if(itemsforsale.get(i).first().getName().equals(name))
				return i;
		}
		return null; // quando nao existir item com esse nome retorna null*/	
	}

	// Realiza a compra de um item. Retorna 'true' se ele existe e 'false' se nao existe 
	public boolean buyItem(String nameItem, Character ch){

	        posItem = pickItem(nameItem);		 

		int priceItem = itemsforsale.get(posItem).getGold();

		if(ch.getGold() >= priceItem){ // condicao para que o 'character' possa comprar um 'item'
			
			if(posItem != null){
			
				itemforsale.remove(posItem);
				ch.setGold(getGold()-priceItem);
				return true; // compra de 'item' foi bem sucedida
			}
			else{
				System.out.println("Hey!Nao existe esse negocio aqui na loja nao!\n");
				return false; // compra nao pode ser efetuada
			}			
		}
		System.out.println("Eita!Voce nao tem ouro suficiente para esta compra!\n");
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

			System.out.print(itemsforsale.get(i).first().getName() + " ");

			// imprime a quantidade certa de pontos "." de modo que os precos fiquem alinhados
			for (int j = 0; j < 20-itemsforsale.get(i).first().getName()l.ength() ; j++)
					System.out.print("."); 	
		
			System.out.println(" " + itemsforsale.get(i).first().getPrice() + " ouros");
		}

		do{
			System.out.println("\n Que item quer comprar?");

			Scanner scanner = new Scanner(System.in);
			String nameItem = scanner.nextLine();

		}while(!buyItem(nameItem, character)); 

	}
}
