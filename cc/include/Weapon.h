#ifndef WEAPON_H_
#define WEAPON_H_

#include <Item.h>
#include <Character.h>

#include <iostream>
#include <string>	

class Character;	

using namespace std;

class Weapon : public Item{

	protected:
		int attackpts;
		double range;
	
	public:
		Weapon(string, double, int, double);
		Weapon(Weapon&);
		double getRange();
		int getAttackPts();
		int getDefensePts();
		void use(Character*);
		// explicacao do porque de ter criado esses metodos (equip e unequip) e nao aproveitado o use estao no Item.h
		void equip(Character*);
		void unequip(Character*);
};
#endif

