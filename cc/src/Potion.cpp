#include <Potion.h>

Potion::Potion(string name, double price, int restorepts):Item(name, price){

	this->restorepts = restorepts;

}

Potion::Potion(const Potion& potion):Item(potion){ 
	this->restorepts = potion.restorepts;
}

Potion::~Potion(){ }

int Potion::getRestorePts(){
	return restorepts;
}

int Potion::getAttackPts(){ 
	return 0;
}

int Potion::getDefensePts(){ 
	return 0;
}
// usa a pocao e depois deleta ela
void Potion::use(Character* character){ }
// nao eh utilizado nessa classe
void Potion::equip(Character* character){ }
void Potion::unequip(Character* character){ }
