#ifndef ARMOR_H_
#define ARMOR_H_

#include <Item.h>
#include <Character.h>

#include <iostream>
#include <string>		

class Character;

using namespace std;

class Armor : public Item{

	protected:
		int defensepts;
		double weight;
	
	public:
		Armor(string, double, int, double);
		Armor(const Armor&);
		double getWeight();
		int getAttackPts();
		int getDefensePts();
		void use(Character*);
		// explicacao do porque de ter criado esses metodos (equip e unequip) e nao aproveitado o use estao no Item.h
		void equip(Character*);
		void unequip(Character*);
};
#endif

