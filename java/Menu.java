public class Menu{

	private ArrayList<Team> teams;
	private ArrayList<Character> allCharacters;


	// metodos que compoem o menu do jogo

	public Menu(ArrayList<Character> allCharacters){
		this.allCharacters = allCharacters;
	}

	public Team getTeam(int i){
		return teams.get(i);
	}

	public void setTeams(){

		Scanner scanner = new Scanner(System.in);
		Color color;

		System.out.println("Criando os TIMES\n\n\n");

		for (int i = 1; i <= 2; i ++) {
					
			System.out.println("-TIME " + i + ":");
			System.out.println("Nome: ");
			String name = scanner.nextLine();
			System.out.println("Cor: \n[1] Blue\n[2] Red\n[3] Green\n[4] Yellow\n [5] White\n [6] Black");
			int color1 = scanner.nextInt();

			switch(color){

				case 1: 
					teams.get(i) = new Team(name, Color.blue);
				case 2: 
					teams.get(i) = new Team(name, Color.red);
				case 3: 
					teams.get(i) = new Team(name, Color.green);					
				case 4: 
					teams.get(i) = new Team(name, Color.yellow);
				case 5: 
					teams.get(i) = new Team(name, Color.white);	
				case 6: 
					teams.get(i) = new Team(name, Color.black);
				default:	
					System.out.println("Cor invalida, agora o time sera Green!");	
					teams.get(i) = new Team(name, Color.green);	
			}
		}


	}

	// metodo que faz 1 time escolher 3 personagens 
	public void pickYourCharacters(Team team){

		Scanner scanner = new Scanner(System.in);

		System.out.println(team.toString());

		for (int i = 0; i < allCharacters.size(); i++) {
			System.out.println("Nome: " + allCharacters.get(i).getName());
			System.out.println("Strenght: " + allCharacters.get(i).getStrenght());
			System.out.println("Speed: " + allCharacters.get(i).getSpeed());
			System.out.println("Dexterity: " + allCharacters.get(i).getDexterity());
			System.out.println("Constitution: " + allCharacters.get(i).getConstitution());
			System.out.println("Gold: " + allCharacters.get(i).getInventory().getTotalGold() + "\n");
		}

		Character auxReturn; // criado para verificar o retorno do metodo searchChar; se for null, significa que o nome foi inválido

		// flag para verificar se o nome do personagem foi achado
		// se nao for achado ela sera 'false' e a pergunta pelo nome do personagem
		//se repetira ate que o nome esteja certo
		boolean charAdded = true; 

		// adicionando o primeiro personagem no time
		do{
			System.out.println("\nSeu primeiro personagem: ");
			String character1Name = scanner.nextLine();

			try{

				auxReturn = searchChar(character1Name);

			}catch (NullPointerException e) {
				System.out.println("\nNome invalido!\n");
				charAdded = false;
			}

		}while(!charAdded)

		team.addChar(auxReturn);
		team.removeChar(auxReturn);


		// adicionando o segundo personagem no time
		charAdded = true;
		do{
			System.out.println("\nSeu segundo personagem: ");
			String character2Name = scanner.nextLine();

			try{

				auxReturn = searchChar(character2Name);

			}catch (NullPointerException e) {
				System.out.println("\nNome invalido!\n");
				charAdded = false;
			}

		}while(!charAdded)

		team.addChar(auxReturn);
		team.removeChar(auxReturn);


		// adicionando o terceiro personagem no time
		charAdded = true;
		do{
			System.out.println("\nSeu terceiro personagem: ");
			String character3Name = scanner.nextLine();

			try{

				auxReturn = searchChar(character3Name);

			}catch (NullPointerException e) {
				System.out.println("\nNome invalido!\n");
				charAdded = false;
			}

		}while(!charAdded)

		team.addChar(auxReturn);
		team.removeChar(auxReturn);
	}

	public void letsGoShop(Team team, Store store){

		for (int i = 0; i < 3; i++) {
			System.out.println(team.getCharacters().get(i).getName() + " gostaria de comprar itens?");

			boolean validOption = true;
			do{
				System.out.println("\n[1] Sim\n[2] Nao");	
				int shopOption = scanner.nextInt();

				if (shopOption != 1 && shopOption != 2){
					System.out.println("\nOpcao invalida!");
					validOption = false;
				}

			}while(!validOption)

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
						case 2:
							validOption = true; // quer sair da loja
						default:
							System.out.println("\nOpcao invalida!");
							validOption = false;

					}

				}while(!validOption)

			}
			// o else seria uma resposta 'Nao', portanto eh ignorado a parte do personagem comprar itens
		}

	}

	public void equipItems(Team team){

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			
			System.out.println("Itens de " + team.getCharacters().get(i).getName() + " que podem ser equipados:");

			while (team.getCharacters().get(i).getInventory().searchItem(i) != null){

				System.out.println(team.getCharacters().get(i).getInventory().searchItem(i).getName());
			}

			boolean done = true;

			while(!done){

				System.out.println("Qual item deseja equipar? ");
				String nameItem = scanner.nextLine();

				Item item = team.getCharacters().get(i).getInventory().searchItem(nameItem);

				if (item == null)
					System.out.println("Nao existe esse item no inventario!");
				else
					item.equip(team.getCharacters().get(i));
				
				System.out.println("Deseja equipar mais itens?\n [1] Sim\n[2] Nao");
				int itemOption = scanner.nextInt();		

				switch(itemOption){

					case 1: done = false;
					case 2: done = true;
					default: 
						System.out.println("Opcao invalida! Nao vai equipar mais nada por isso!");
						done = true;

				}		
			}
		}
	}

	public void battleStart(){

			Battle battle = new Battle(teams.get(1), teams.get(2));
			battle.manageFight();
	}

	public void battleResults(){

		teams.get(1).resolveBattle(teams.get(2));

		teams.get(1).getResults();
		teams.get(1).getResults();

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