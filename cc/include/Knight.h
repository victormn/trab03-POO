#ifndef KNIGHT_H_
#define KNIGHT_H_

#include <Item.h>
#include <Character.h>

#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

class Knight : public Character{
	
	protected: 
		int power;
		int getDefensePoints();
		int getAttackPoints();

	public: 
		Knight(string, int);
		~Knight();
		void addPower(int);
};
#endif
