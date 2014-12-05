public class Fight extends Thread{

	private Character c1;
	private Character c2;

	private Team team1;
	private Team team2;

	private int lifeBar1;
	private int lifeBar2;

	public Fight(Character c1, Team team1, Character c2, Team team2){
		this.c1 = c1;
		this.team1 = team1;
		this.c2 = c2;
		this.team2 = team2;

	}
	
	/* Escolhe proximo adversario que sera atacado quando um personagem ja estiver ocioso (terminado sua luta) */
	public Character helpMyBro(Team opponentTeam){

		Character nextOpponent = null;

		for(int i=1; i<opponentTeam.size(); i++){
			
			// Verificando quem eh o adversario com maior 'HP', sera atacado pelo personagem ocioso   
			if(opponentTeam.getCharacters().get(i-1) <  opponentTeam.getCharacters().get(i)){
				nextOpponent = opponentTeam.getCharacters().get(i-1);
			}
			else{
				nextOpponent = opponentTeam.getCharacters().get(i);			
			}	
		}

		nextOpponent.setOpponents(getOpponents()+1); // adversario que sera atacado pelo personagem ocioso, tera mais um oponente 

		return nextOpponent;				
	}

	public void run(){

		while (c1.getHP() > 0 || c2.getHP() > 0){

			if (c1.hetHP() <= 0){
				c1 = helpMyBro(team2);
				if (c1 == null) break;
			}
			else if (c2.hetHP() <= 0){
				c2 = helpMyBro(team1); 
				if (c2 == null) break;
			}

			c1.attack(c2);
			c2.attack(c1);

			// funcao que imprime a barra de vida dos personagens
			// dado que a soma dos hp eh 100%, a porcentagem de cada hp de cada personagem
			// eh representada por "-",  a quantidade de cada "-" eh calculado considerando
			// o total de hp e o hp do personagem
			// eh usado synchronized para nao dar interrupcao de outras impressoes das 
			// outras lutas
			synchronized (this){

				int totalHP = c1.getHP() + c2.getHP();

				lifeBar1 = (int)((c1.getHP()*10)/totalHP);
				lifeBar2 = 10 - lifeBar1;

				System.out.println(c1.getName());

				for (int i = 0; i<lifeBar1; i++) {
					System.out.println("-");
				}
				System.out.println("><");

				for (int i = 0; i<lifeBar2; i++) {
					System.out.println("-");
				}

				System.out.println(c1.getName() + "\n");

			}
		}

	}


}