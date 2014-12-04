#ifndef MANAPOTION_H_
#define MANAPOTION_H_

#include <Potion.h>

#include <iostream>
#include <string>		

class Character;

using namespace std;

class ManaPotion : public Potion{

	public:
		ManaPotion(string, double, int);
		~ManaPotion();
		void use(Character*);

};
#endif

