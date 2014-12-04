#include <Armor.h>

Armor::Armor(string name, double price, int defensepts, double weight):Item(name, price){

	/* verificando os intervalos, caso esteja fora atribui-se o menor valor */
	if (defensepts > 20 || defensepts < 1)
		defensepts = 1;	

	this->defensepts = defensepts;

	if (weight > 20 || weight < 1)
		weight = 1;	

	this->weight = weight;

}

Armor::Armor(const Armor& armor) : Item(armor){
	this->defensepts = armor.defensepts;
	this->weight = armor.weight;
}

double Armor::getWeight(){
	return weight;
}

int Armor::getAttackPts(){ 
	return 0;
}

int Armor::getDefensePts(){ 
	return defensepts;
}

void Armor::use(Character* character){ }

// explicacao do porque de ter criado esses metodos (equip e unequip) e nao aproveitado o use estao no Item.h
void Armor::equip(Character* character){
 
	if (character->getInventory()->searchItem(this->getName()) != NULL && character->getInventory()->getArmorCounter() < 1){
 
		// procurando pela posicao do item
		int position;
 
		for (int i=0; character->getInventory()->searchItem(i) != NULL; i++){
				if(character->getInventory()->searchItem(i)->getName() == this->getName())
					position = i;
	    }
 
	    // s' = s*e^[-(w/20)^2]
	    // explicacao do speedArmor em Character.h
		character->setSpeedArmor((int) (character->getSpeed() - (character->getSpeed()*exp((-1)*pow(this->getWeight()/20, 2)))));
 
		if (!character->getInventory()->getPair(position).second){
			character->getInventory()->setBoolPair(position, true);
			character->getInventory()->setArmorCounter(1);
		}
	}
}

void Armor::unequip(Character* character){

	if (character->getInventory()->searchItem(this->getName()) != NULL && character->getInventory()->getArmorCounter() > 0){

		// procurando pela posicao do item
		int position;

		for (int i=0; character->getInventory()->searchItem(i) != NULL; i++){
				if(character->getInventory()->searchItem(i)->getName() == this->getName())
					position = i;
	    }

		character->setSpeedArmor(0);

		if (character->getInventory()->getPair(position).second){
			character->getInventory()->setBoolPair(position, false);
			character->getInventory()->setArmorCounter(-1);
		}
	}
}

