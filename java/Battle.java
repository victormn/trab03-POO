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

/* Rodada de ataques */ 
		
		// - Inicio da rodada definido atraves de um numero randomico(random_begin). Se ele for par, 'team2' inicia
		//   rodada; se impar, 'team1' inicia (decisao adotada para comecar ataque aleatoriamente);
		// - Para que o ataque seja realizado por um personagem aleatorio, tem-se um numero randomico (random_char),
		//   gerado de 0 ao numero de personagens (de 0 a team1.size() (*ou team2.size()*)). Este numero representa
		//   a posicao do array a ser acessada, ou seja, o 'character' que realizara o ataque		

		int random_begin = 0;		// referente ao inicio do ataque
		int random_char1 = 0;		// referente a 'team1'
		int random_char2 = 0;		// referente a 'team2'
	
		// A cada ataque realizado, os personagens que participaram serao removidos do respectivo array do time que
		// foram inseridos, assim o loop sera realizado ate que todos os arrays estejam vazios (team1.size()!=0)	
		
		while(team1.size()!=0){				// condicao para que ataques serao cessados		
		
			random_begin = (int)(Math.random()*11);		// para gerar inicio aleatorio(numero entre 0 e 10)					

			random_char1 = (int)(Math.random()*(team1.size()));	// para gerar 'character' aleatorio 'team1'
			random_char2 = (int)(Math.random()*(team2.size()));	// para gerar 'character' aleatorio 'team2'
						
			// random = impar -> 'team1' realiza ataque;
			if((random_begin%2) != 0){							
			
				// Ataque 				
				team1.get(random_char1).attack(team2.get(random_char2));	
					
				// Removendo personagens participantes do ArrayList
				team1.remove(random_char1);
				team2.remove(random_char2);			
			}
			// random = par -> 'team2' realiza ataque;
			else{
				// Ataque 				
				team2.get(random_char2).attack(team1.get(random_char1));	
					
				// Removendo personagens participantes do ArrayList
				team1.remove(random_char1);
				team2.remove(random_char2);	
			}		
		}