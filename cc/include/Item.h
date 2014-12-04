#ifndef ITEM_H_
#define ITEM_H_

#include <Inventory.h>
#include <Character.h>

#include <iostream>
#include <string>	

class Character;
class Inventory;	

using namespace std;

class Item{

	private:
		string name;
		double price;
	
	public:
		Item(string, double);
		Item(const Item&);
		virtual ~Item();
		string getName();
		double getPrice();
		virtual int getAttackPts() = 0;
		virtual int getDefensePts() = 0;
		virtual void use(Character*) = 0;
		virtual void equip(Character*) = 0;
		virtual void unequip(Character*) = 0;
		// so sera implementado em armor
		virtual double getWeight();

	// sobre criar um metodo equip e unequip ao inves de utilizar o metodo use:
	// mesmo que o metodo use possa ser usado em armor e weapon como equipar o character, e em potion como usar a pocao
	// eu resolvi criar separadamente um metodo de equip para armor e weapon. 
	// assim, o nome faz sentido ("use" parece que o objeto sera descartado depois, como acontece com as potion)
	// e para fazer sentido meu metodo unequip, que criei caso o character queira trocar de armadura/arma

};
#endif

