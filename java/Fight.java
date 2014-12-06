import java.util.*;

public  class Fight extends Thread{

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

		for(int i=1; i<opponentTeam.getCharacters().size(); i++){
			
			// Verificando quem eh o adversario com maior 'HP', sera atacado pelo personagem ocioso   
			if(opponentTeam.getCharacters().get(i-1).getHP() >  opponentTeam.getCharacters().get(i).getHP()){
				nextOpponent = opponentTeam.getCharacters().get(i-1);
			}
			else{
				nextOpponent = opponentTeam.getCharacters().get(i);			
			}	
		}

		nextOpponent.setOpponents(nextOpponent.getOpponents()+1); // adversario que sera atacado pelo personagem ocioso, tera mais um oponente 

		return nextOpponent;				
	}

	public void run(){

		while (c1.getHP() > 0 || c2.getHP() > 0){

			//synchronized (this.team2){
				if (c1.getHP() <= 0){
					//team1.removeChar(c1);
					//c1 = helpMyBro(team1);
					//if (c1 == null) 
					break;
					//System.out.println("\nAgora " + c2.getName() + " esta atacando " + c1.getName() + "!\n");
				}
				else if (c2.getHP() <= 0){
					//team2.removeChar(c2);
					//c2 = helpMyBro(team2); 
					//if (c2 == null) 
					break;
					//System.out.println("\nAgora " + c1.getName() + " esta atacando " + c2.getName() + "!\n");
				}
			//}

			if (c1.getHP() > 0) c1.attack(c2);
			if (c2.getHP() > 0) c2.attack(c1);

			synchronized (this.team2){
				// funcao que imprime a vida dos personagens
				// mostrando a situacao da batalha

				System.out.print(c1.getName() + " (hp: " + c1.getHP() + ")");

				System.out.print("---> <---");

				System.out.print(c2.getName() + " (hp: " + c2.getHP() + ")\n");

			}
		}

	}


}