import java.util.*;
import java.io.*;

public  class Menu{

	private Team team1;
	private Team team2;

	private ArrayList<Character> allCharacters;


	// metodos que compoem o menu do jogo

	public Menu(ArrayList<Character> allCharacters){
		this.allCharacters = allCharacters;
	}

	public Team getTeam(int i){
		if (i == 1) return team1;
		else return team2;
	}

	public void setTeams(){

		Scanner scanner = new Scanner(System.in);

		System.out.println("Criando os TIMES\n");
					
		System.out.println("-TIME 1-");
		System.out.println("Nome: ");
		String name1 = scanner.nextLine();
		System.out.println("Cor: \n[1] Blue\n[2] Red\n[3] Green\n[4] Yellow\n[5] White\n[6] Black");
		int color = scanner.nextInt();

		switch(color){

			case 1: 
				team1 = new Team(name1, Color.blue);
				break;
			case 2: 
				team1 = new Team(name1, Color.red);
				break;
			case 3: 
				team1 = new Team(name1, Color.green);	
				break;				
			case 4: 
				team1 = new Team(name1, Color.yellow);
				break;
			case 5: 
				team1 = new Team(name1, Color.white);	
				break;
			case 6: 
				team1 = new Team(name1, Color.black);
				break;
			default:	
				System.out.println("Cor invalida, agora o time sera Green!");	
				team1 = new Team(name1, Color.green);	

		}

		System.out.println("\n\n------------------------------------------\n\n");

		System.out.println("-TIME 2-");
		System.out.println("Nome: ");

		scanner.nextLine(); // limpa o buffer que estava em scanner
		String name2 = scanner.nextLine();

		System.out.println("Cor: \n[1] Blue\n[2] Red\n[3] Green\n[4] Yellow\n[5] White\n[6] Black");
		color = scanner.nextInt();

		switch(color){

			case 1: 
				team2 = new Team(name2, Color.blue);
				break;
			case 2: 
				team2 = new Team(name2, Color.red);
				break;
			case 3: 
				team2 = new Team(name2, Color.green);	
				break;				
			case 4: 
				team2 = new Team(name2, Color.yellow);
				break;
			case 5: 
				team2 = new Team(name2, Color.white);	
				break;
			case 6: 
				team2 = new Team(name2, Color.black);
				break;
			default:	
				System.out.println("Cor invalida, agora o time sera Green!");	
				team2 = new Team(name2, Color.green);	

		}

	}

	// metodo que faz 1 time escolher 3 personagens 
	public void pickYourCharacters(Team team){

		System.out.println("\n\n------------------------------------------\n\n");

		Scanner scanner = new Scanner(System.in);

		System.out.println(team.toString() + "\n");

		for (int i = 0; i < allCharacters.size(); i++) {
			System.out.println("\nNome: " + allCharacters.get(i).getName());
			System.out.println("Strenght: " + allCharacters.get(i).getStrenght());
			System.out.println("Speed: " + allCharacters.get(i).getSpeed());
			System.out.println("Dexterity: " + allCharacters.get(i).getDexterity());
			System.out.println("Constitution: " + allCharacters.get(i).getConstitution());
		}

		Character auxReturn = null; // criado para verificar o retorno do metodo searchChar; se for null, significa que o nome foi inválido

		// flag para verificar se o nome do personagem foi achado
		// se nao for achado ela sera 'false' e a pergunta pelo nome do personagem
		//se repetira ate que o nome esteja certo
		boolean charAdded; 

		// adicionando o primeiro personagem no time
		do{
			charAdded = true;
			System.out.print("\nSeu primeiro personagem: ");
			String character1Name = scanner.nextLine();

			auxReturn = searchChar(character1Name);

			if (auxReturn == null){
				System.out.println("\nNome invalido!\n");
				charAdded = false;
			}

		}while(!charAdded);

		team.addChar(auxReturn);
		allCharacters.remove(auxReturn);


		// adicionando o segundo personagem no time
		do{
			charAdded = true;
			System.out.print("Seu segundo personagem: ");
			String character2Name = scanner.nextLine();

			auxReturn = searchChar(character2Name);

			if (auxReturn == null){
				System.out.println("\nNome invalido!\n");
				charAdded = false;
			}

		}while(!charAdded);

		team.addChar(auxReturn);
		allCharacters.remove(auxReturn);


		// adicionando o terceiro personagem no time
		do{
			charAdded = true;
			System.out.print("Seu terceiro personagem: ");
			String character3Name = scanner.nextLine();

			auxReturn = searchChar(character3Name);

			if (auxReturn == null){
				System.out.println("\nNome invalido!\n");
				charAdded = false;
			}

		}while(!charAdded);

		team.addChar(auxReturn);
		allCharacters.remove(auxReturn);
	}

	public void letsGoShop(Team team, Store store){

		Scanner scanner = new Scanner(System.in);
		int shopOption;

		for (int i = 0; i < 3; i++) {

			System.out.println("\n\n------------------------------------------\n\n");

			System.out.println("TIME " + team.getName() + "\n" + team.getCharacters().get(i).getName() + " gostaria de comprar itens?");

			boolean validOption = true;
			do{
				System.out.println("\n[1] Sim\n[2] Nao");	
				shopOption = scanner.nextInt();

				if (shopOption != 1 && shopOption != 2){
					System.out.println("\nOpcao invalida!");
					validOption = false;
				}

			}while(!validOption);

			if (shopOption == 1){ // quer ir para loja

				validOption = true;
				do{

					// chama a funcao de aparecer a loja na tela e manda um personagem como parametro
					store.showStore(team.getCharacters().get(i));

					System.out.println("\n[1] Comprar outro item\n[2] Sair da loja");
					int buyItemOption = scanner.nextInt();

					switch(buyItemOption){

						case 1: 
							validOption = false; // quer comprar outro item
							break;
						case 2:
							validOption = true; // quer sair da loja
							break;
						default:
							System.out.println("\nOpcao invalida!");
							validOption = false;
							
					}

				}while(!validOption);

			}
			// o else seria uma resposta 'Nao', portanto eh ignorado a parte do personagem comprar itens
		}

	}

	public void equipItems(Team team){

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {

			System.out.println("\n\n------------------------------------------\n\n");
			
			System.out.println("Itens de " + team.getCharacters().get(i).getName() + " que podem ser equipados:");

			for (int j = 0; team.getCharacters().get(i).getInventory().searchItem(j) != null; j++){

				if (!team.getCharacters().get(i).getInventory().getPair(j).second())
					System.out.println(team.getCharacters().get(i).getInventory().searchItem(j).getName());
			}

			boolean done = false;

			while(!done){

				System.out.println("Deseja equipar itens?\n[1] Sim\n[2] Nao");
				int itemOption = scanner.nextInt();	

				switch(itemOption){

					case 1: 
						done = false;
						break;
					case 2: 
						done = true;
						break;
					default: 
						System.out.println("Opcao invalida! Nao vai equipar mais nada por isso!");
						done = true;

				}

				scanner.nextLine();	

				if (done) break;

				System.out.print("Qual item deseja equipar? ");
				String nameItem = scanner.nextLine();
System.out.println("1");
				Item item = team.getCharacters().get(i).getInventory().searchItem(nameItem);
System.out.println("2");
				if (item == null)
					System.out.println("\n!Nao existe esse item no inventario!\n");
				else{
					boolean returnFunction = item.equip(team.getCharacters().get(i));
					if (!returnFunction)// significa que eh nao pode equipar
						System.out.println("\n!Esse item nao pode ser equipado!\n");
				}		
			}
		}
	}

	public void battleStart(){

			Battle battle = new Battle(team1, team2);
			try{
				battle.manageFight();
			}catch (InterruptedException e) {}
	}

	public void battleResults(){

		team1.resolveBattle(team2);
		team2.resolveBattle(team1);

		System.out.println();

		team1.getResults();

		System.out.println();

		team2.getResults();

		System.out.println();

	}

	// metodo auxiliar
	public Character searchChar(String name){
		for (int i=0; i < allCharacters.size(); i++){
				if(allCharacters.get(i).getName().equals(name))
					return allCharacters.get(i);
	    	}
		return null; // quando nao existir character com esse nome retorna null	
	}
}