#include <Team.h>

Team::Team(string name, Color color){
	this->name = name;
	this->color = color;
	win = 0;
	lose = 0;
	draw = 0;
}

// considerando que nao existe personagens que estao fora de um time, ao deletar o time 
// deve-se deletar os characters associados a ele
Team::~Team(){
	for (int i=0; i < characters.size(); i++)
		delete characters.at(i);

}

string Team::getName(){
	return name;
}
	
string Team::getResults(){
	stringstream tostring;

	tostring << "Win: "<< win <<"; Lose: "<< lose <<"; Draw: "<< draw;

	return tostring.str();
}

string Team::toString(){
	stringstream tostring;

	string colorString;

	switch(color){
		case 0: 
			colorString = "blue";
			break;
		case 1:
			colorString = "red";
			break;
		case 2:
			colorString = "green";
			break;
		case 3:
			colorString = "yellow";
			break;
		case 4:
			colorString = "white";
			break;
		case 5:
			colorString = "black";
			break;

	}

	tostring << "TEAM "<< name <<" COLOR "<< colorString;

	return tostring.str();
}

void Team::resolveBattle(Team* teamB){
	if (this->getPoints() > teamB->getPoints()) win++;
	else if (this->getPoints() == teamB->getPoints()) draw++;
	else lose++;
}

void Team::addChar(Character* character){
	characters.push_back(character);
}

void Team::removeChar(int position){
	if (searchChar(position) != NULL)
		characters.erase(characters.begin() + position);
}

void Team::removeChar(Character* character){
	int position = characters.size();

	for (int i=0; i < characters.size(); i++){
		if(characters.at(i)->getName() == character->getName())
        		position = i;
    	}


	if (position != characters.size())
		removeChar(position);
}

Character* Team::searchChar(string name){
	for (int i=0; i < characters.size(); i++){
			if(characters.at(i)->getName() == name)
        			return characters.at(i);
    	}
	return NULL; // quando nao existir character com esse nome retorna null	
}
Character* Team::searchChar(int position){
	if (position < characters.size())
		return characters.at(position);
	else return NULL; // quando nao existir character nessa posicao retorna null
}

double Team::getPoints(){
	double points = 0;

	for(int i=0; i<characters.size(); i++)
		points += characters.at(i)->getHP();

	return points/characters.size();
}

vector<Character*> Team::getCharacters(){
	return characters;
}

