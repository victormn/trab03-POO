import java.util.*;

public class Team{

	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private ArrayList<Character> characters;

	public Team(String name, Color color){
		characters = new ArrayList<Character>();
		this.name = name;
		this.color = color;
		win = 0;
		lose = 0;
		draw = 0;
	}

	public String getName(){	
		return name;
	}
	
	public String toString(){

		String tostring = "TEAM "+ name + " COLOR " + color.getColor();

		return tostring;
	}

	public void resolveBattle(Team teamB){

		if (this.getPoints() > teamB.getPoints()) win++;
		else if (this.getPoints() == teamB.getPoints()) draw++;
		else lose++;
	}

	public void addChar(Character character){
		characters.add(character);
	}

	public void removeChar(int position){
		if (searchChar(position) != null)
			characters.remove(position);
	}

	public void removeChar(Character character){
		int position = characters.size();

		for (int i=0; i < characters.size(); i++){
			if(characters.get(i).getName().equals(character.getName()))
				position = i;
	    	}


		if (position != characters.size())
			removeChar(position);
	}

	public Character searchChar(String name){
		for (int i=0; i < characters.size(); i++){
				if(characters.get(i).getName().equals(name))
					return characters.get(i);
	    	}
		return null; // quando nao existir character com esse nome retorna null	
	}
	public Character searchChar(int position){
		if (position < characters.size())
			return characters.get(position);
		else return null; // quando nao existir character nessa posicao retorna null
	}

	public double getPoints(){
		double points = 0;

		for(int i=0; i<characters.size(); i++)
			points += characters.get(i).getHP();

		return points/characters.size();
	}

	public ArrayList<Character> getCharacters(){
		return characters;	
	}
}
