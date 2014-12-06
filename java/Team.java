import java.util.*;

public class Team{

	/* Atributos */

	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private ArrayList<Character> characters;

	/* Construtor */

	public Team(String name, Color color){
		characters = new ArrayList<Character>();
		this.name = name;
		this.color = color;
		win = 0;
		lose = 0;
		draw = 0;
	}

	/* Métodos */

	// Retorna nome do time
	public String getName(){	
		return name;
	}
	
	// Retorna string com nome e cor do time
	public String toString(){

		String tostring = "TEAM "+ name + " COLOR " + color.getColor();

		return tostring;
	}

	// Resolve batalha entre dois times 
	public void resolveBattle(Team teamB){

		if (this.getPoints() > teamB.getPoints()) win++;
		else if (this.getPoints() == teamB.getPoints()) draw++;
		else lose++;
	}

	// Adiciona um 'character'ao time	
	public void addChar(Character character){
		characters.add(character);
	}

	// Remove um 'character' do time atraves de sua posicao
	public void removeChar(int position){
		if (searchChar(position) != null)
			characters.remove(position);
	}

	// Remove um 'character' do time atraves de seu nome
	public void removeChar(Character character){
		int position = characters.size();

		for (int i=0; i < characters.size(); i++){
			if(characters.get(i).getName().equals(character.getName()))
				position = i;
	    	}


		if (position != characters.size())
			removeChar(position);
	}


	// Procura por um 'character' no time atraves de seu nome
	public Character searchChar(String name){
		for (int i=0; i < characters.size(); i++){
				if(characters.get(i).getName().equals(name))
					return characters.get(i);
	    	}
		return null; // quando nao existir character com esse nome retorna null	
	}

	// Procura por um 'character' no time atraves de sua posicao
	public Character searchChar(int position){
		if (position < characters.size())
			return characters.get(position);
		else return null; // quando nao existir character nessa posicao retorna null
	}

	// Retorna inteiro com pontuação atual do time, indicada pela média de HP de todos os personagens
	public double getPoints(){
		double points = 0;

		for(int i=0; i<characters.size(); i++)
			points += characters.get(i).getHP();

		return points/characters.size();
	}

	// Retorna o array de 'character' de um time 
	public ArrayList<Character> getCharacters(){
		return characters;	
	}
}
