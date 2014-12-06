public class Menu{

	private Team team1;
	private Team team2;
	private ArrayList<Character> allCharacters;


	// metodos que compoem o menu do jogo

	public void buildMenu(Team team1, Team team2, ArrayList<Character> allCharacters){
		this.team1 = team1;
		this.team2 = team2;
		this.allCharacters = allCharacters;
	}

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

	public void battleStart(){

			Battle battle = new Battle(team1, team2);
			battle.manageFight();
	}

	public void battleResults(){

		team1.resolveBattle(team2);

		team1.getResults();
		team1.getResults();

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