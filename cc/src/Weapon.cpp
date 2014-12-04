#include <Weapon.h>	

Weapon::Weapon(string name, double price, int attackpts, double range):Item(name, price){

	/* verificando os intervalos, caso esteja fora atribui-se o menor valor */
	if (attackpts > 9 || attackpts < 1)
		attackpts = 1;	

	this->attackpts = attackpts;
	this->range = range;

}

Weapon::Weapon(Weapon& weapon):Item(weapon){ 
	this->attackpts = weapon.attackpts;
	this->range = weapon.range;
}

double Weapon::getRange(){
	return range;
}

int Weapon::getAttackPts(){ 
	return attackpts;
}

int Weapon::getDefensePts(){ 
	return 0;
}

void Weapon::use(Character* character){ }

// explicacao do porque de ter criado esses metodos (equip e unequip) e nao aproveitado o use estao no Item.h
void Weapon::equip(Character* character){

	if (character->getInventory()->searchItem(this->getName()) != NULL && character->getInventory()->getWeaponCounter() < 2){

		// procurando pela posicao do item
		int position;

		for (int i=0; character->getInventory()->searchItem(i) != NULL; i++){
				if(character->getInventory()->searchItem(i)->getName() == this->getName())
					position = i;
	    }

		if (!character->getInventory()->getPair(position).second){
			character->getInventory()->setBoolPair(position, true);
			character->getInventory()->setWeaponCounter(1);
		}
	}
}

void Weapon::unequip(Character* character){
	
	if (character->getInventory()->searchItem(this->getName()) != NULL && character->getInventory()->getWeaponCounter() > 0){

		// procurando pela posicao do item
		int position;

		for (int i=0; character->getInventory()->searchItem(i) != NULL; i++){
				if(character->getInventory()->searchItem(i)->getName() == this->getName())
					position = i;
	    }

	
		if (character->getInventory()->getPair(position).second){
			character->getInventory()->setBoolPair(position, false);
			character->getInventory()->setWeaponCounter(-1);
		}
	}
}

