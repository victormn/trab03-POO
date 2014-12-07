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
	
	public void run(){

		while (c1.getHP() > 0 || c2.getHP() > 0){

			if (c1.getHP() <= 0) break;

			else if (c2.getHP() <= 0) break;

			// Ataque entre os personagens;
			// O personagem so ataca quando esta vivo
			if (c1.getHP() > 0) c1.attack(c2);
			if (c2.getHP() > 0) c2.attack(c1);

			synchronized (this.team2){

				// -Funcao que imprime a vida dos personagens
				// 	mostrando a situacao da batalha

				System.out.print(c1.getName() + " (hp: " + c1.getHP() + ")");

				System.out.print("---> <---");

				System.out.print(c2.getName() + " (hp: " + c2.getHP() + ")\n");

			}
		}

	}


}