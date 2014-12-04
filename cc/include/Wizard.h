#ifndef WIZARD_H_
#define WIZARD_H_

#include <Item.h>
#include <Character.h>

#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

class Wizard : public Character{
	
	protected: 
		int wisdom;
		int getDefensePoints();
		int getAttackPoints();

	public: 
		Wizard(string, int);
		~Wizard();
		void addWisdom(int);
};
#endif
