#ifndef POTION_H_
#define POTION_H_

#include <Item.h>
#include <Character.h>

#include <iostream>
#include <string>		

class Character;

using namespace std;

class Potion : public Item{

	private:
		int restorepts;
	
	public:
		Potion(string, double, int);
		Potion(const Potion&);
		virtual ~Potion();
		int getAttackPts();
		int getDefensePts();
		int getRestorePts();
		virtual void use(Character*) = 0;
		// nao possui funcao nessa clase
		void equip(Character*);
		void unequip(Character*);

};
#endif

