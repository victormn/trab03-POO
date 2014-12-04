#ifndef THIEF_H_
#define THIEF_H_

#include <Character.h>
#include <Item.h>

#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

class Thief : public Character{
	
	protected: 
		int stealth;
		int getDefensePoints();
		int getAttackPoints();

	public: 
		Thief(string, int);
		~Thief();
		void addStealth(int);
};
#endif
