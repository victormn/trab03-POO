#include <ManaPotion.h>	

ManaPotion::ManaPotion(string name, double price, int restorepts):Potion(name, price, restorepts){ }

ManaPotion::~ManaPotion(){ }

void ManaPotion::use(Character* character){

	character->addMP(getRestorePts());
	character->getInventory()->removeItem(getName());
	delete this; // deleta a pocao apos utilizar
}
