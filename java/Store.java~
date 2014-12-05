import java.util.*;

public class Store<T>{

	private ArrayList<T> itemsforsale;
		
	public Store(){
		itemsforsale = new ArrayList<T>();
		nitemsforsale = 0;		
	}

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
	public void supplyStore(T itemforsale){
		
		itemsforsale.push(itemforsale);		
	}
}
