#ifndef CHARACTER_H_
#define CHARACTER_H_

#include <Inventory.h>
#include <Item.h>

#include <iostream>
#include <string>
#include <cstdlib>
#include <time.h> 

class Inventory;
class Item;

using namespace std;

class Character{
	
	private:
		string alias;
		Inventory *myitems;
		int HP;
		int MP;

	protected: 
		int XP;
		int strenght;
		int speed;
		int speedArmor;
		int dexterity;
		int constitution;
		virtual int getDefensePoints() = 0; 
		virtual int getAttackPoints() = 0;

	public: 
		Character(string);
		virtual ~Character();
		string getName();
		int getSpeed();
		int getHP();
		Inventory* getInventory();
		void attack(Character*);
		void addXP(int);
		void addMP(int);
		void addHP(int);	
		/* setters */
		void setStrenght(int);
		void setSpeed(int);
		void setDexterity(int);
		void setConstitution(int);
		void setSpeedArmor(int);

	// explicacao sobre o speedArmor:
	// com a intencao de restaurar o speed anterior apos remover a armor (com o metodo unequip, Item.h)
	// criei o atributo speedArmor e modifiquei o metodo getSpeed()

	// quando equipar uma armor:
	// speedArmor = speed - formula_da_nova_speed (speedArmor = s - s'     ;sendo s' = s*e^[-(w/20)^2])
	// o getSpeed() retorna speed - speedArmor, ou seja, s - (s - s') = s - s + s' = s'
	
	// quando desequipamos uma armor:
	// speedArmor = 0
	// o getSpeed() retorna speed - speedArmor, ou seja, s - (0) = s

	// entao, getSpeed retornara ou a speed normal, s, quando nao tem armor equipado
	// ou a nova formula da speed, s', com o armor equipado
};
#endif
