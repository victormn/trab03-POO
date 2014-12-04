#include <HealthPotion.h>

HealthPotion::HealthPotion(string name, double price, int restorepts):Potion(name, price, restorepts){ }

HealthPotion::~HealthPotion(){ }

void HealthPotion::use(Character* character){

	character->addHP(getRestorePts());
	character->getInventory()->removeItem(getName());
	delete this; // deleta a pocao apos utilizar
}
