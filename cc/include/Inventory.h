#ifndef INVENTORY_H_
#define INVENTORY_H_

#include <Character.h>
#include <Item.h>

#include <iostream>
#include <string>
#include <vector>
#include <cmath>

class Character;
class Item;

using namespace std;

class Inventory{

	private:
		int spaces;
		double gold;
		vector<pair<Item*, bool> > items;
		int armorCounter;
		int weaponCounter;

		// os Counter controlam a quantidade de armor e weapon no inventario,
		// sendo o maximo 1 armor e 2 weapon

	public:
		Inventory();
		~Inventory();
		double getTotalGold();
		int getAvailableSpace();
		void spendGold(double);
		void earnGold(double);
		void setSpaces(int);
		Item* searchItem(string); 
		Item* searchItem(int);
		void insertItem(Item*);
		void removeItem(string);
		void removeItem(int);
		pair<Item*, bool> getPair(int);
		void setBoolPair(int, bool);
		int getArmorCounter();
		void setArmorCounter(int);
		int getWeaponCounter();
		void setWeaponCounter(int);

		// setBoolPair: muda o bool do pair da posicao i do vector de pair

};
#endif
