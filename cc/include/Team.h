#ifndef TEAM_H_
#define TEAM_H_

#include <Color.h>
#include <Character.h>

#include <iostream>
#include <vector>
#include <sstream>

class Character;

using namespace std;

class Team{

	private:
		string name;
		Color color;
		int win;
		int lose;
		int draw;
		vector<Character*> characters;

	public:
		Team(string, Color);
		~Team();
		string getName();
		string getResults();
		string toString();
		void resolveBattle(Team*);
		void addChar(Character*);
		void removeChar(int);
		void removeChar(Character*);
		Character* searchChar(string);
		Character* searchChar(int);
		double getPoints();
		vector<Character*> getCharacters();
};

#endif
