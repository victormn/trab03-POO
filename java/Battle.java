import java.util.*;

public class Battle{

	private Team team1;
	private Team team2;

	public Battle(Team team1, Team team2){
		this.team1 = team1;
		this.team2 = team2;

	}

	// Gerencia as thread que ocorrem nos ataques 
	public void manageFight(){

		// - Para que o ataque seja realizado por um personagem aleatorio, tem-se dois numeros randomicos (random1 e random2),
		//   gerado de 0 ao numero de personagens (de 0 a team1.size() (*ou team2.size()*)). Este numero representa
		//   a posicao do array a ser acessada, ou seja, o 'character' que realizara o ataque	

		//--------------------------------------------------------------------------------------

		// ArrayLists auxiliares de personagens de cada time (gerar ataques aleatorios)	
		ArrayList<Character> vteam1 = new ArrayList<Character>();
		ArrayList<Character> vteam2 = new ArrayList<Character>();

		// Preenchendo o vetor auxiliar com os personagens de cada time
		// os times terao 3 personagens
		for (int i = 0; i < 3; i++) {
			vteam1.add(team1.getCharacters().get(i));
			vteam2.add(team2.getCharacters().get(i));
		}

		//--------------------------------------------------------------------------------------

		// Primeira luta (primeiro thread)
		int random1 = trab3.nextInt(0, vteam1.size());
		int random2 = trab3.nextInt(0, vteam2.size());

		Character c1 = vteam1.get(random1);
		Character c2 = vteam1.get(random2);

		Fight fight1 = new Fight(c1, team1, c2, team2);
				
		vteam1.remove(random1);
		vteam2.remove(random2);

		// Segunda luta (segundo thread)
		int random1 = trab3.nextInt(0, vteam1.size());
		int random2 = trab3.nextInt(0, vteam2.size());

		Character c1 = vteam1.get(random1);
		Character c2 = vteam1.get(random2);

		Fight fight2 = new Fight(c1, team1, c2, team2);
				
		vteam1.remove(random1);
		vteam2.remove(random2);

		// Terceira luta (terceiro thread)
		int random1 = trab3.nextInt(0, vteam1.size());
		int random2 = trab3.nextInt(0, vteam2.size());

		Character c1 = vteam1.get(random1);
		Character c2 = vteam1.get(random2);

		Fight fight3 = new Fight(c1, team1, c2, team2);
				
		vteam1.remove(random1);
		vteam2.remove(random2);

		fight1.start();
		fight2.start();
		fight3.start();

		fight1.join();
		fight2.join();
		fight3.join();


	}
}