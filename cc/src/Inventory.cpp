#include <Inventory.h>

Inventory::Inventory(){
	spaces = 0;
	gold = 0.0;		
	items.clear();
	armorCounter = 0;
	weaponCounter = 0;
}

Inventory::~Inventory(){ }

double Inventory::getTotalGold(){
	return gold;
}

int Inventory::getAvailableSpace(){
	return spaces-items.size();
}

void Inventory::spendGold(double gold){
	if (this->gold -= gold >= 0)
		this->gold -= gold;
}

void Inventory::earnGold(double gold){
	this->gold += gold;
}

void Inventory::setSpaces(int spaces){
	this->spaces = spaces;
}

int Inventory::getArmorCounter(){
	return armorCounter;
}
void Inventory::setArmorCounter(int counter){
	armorCounter += counter;
}
int Inventory::getWeaponCounter(){
	return weaponCounter;
}
void Inventory::setWeaponCounter(int counter){
	weaponCounter += counter;
}

Item* Inventory::searchItem(string name){    		
	for (int i=0; i < items.size(); i++){
			if(items.at(i).first->getName() == name)
        			return items.at(i).first;
    	}
	return NULL; // quando nao existir item com esse nome retorna null	
}

Item* Inventory::searchItem(int position){
	if (position < items.size())
		return items.at(position).first;
	else return NULL; // quando nao existir item nessa posicao retorna null
}

void Inventory::insertItem(Item* item){
			
	if (getAvailableSpace() > 0) // só adiciona se existir espaco disponivel
		items.push_back(pair<Item*, bool>(item, 0));
}

void Inventory::removeItem(string name){
	int position = items.size();

	for (int i=0; i < items.size(); i++){
		if(items.at(i).first->getName() == name)
        		position = i;
    	}


	if (position != items.size())
		removeItem(position);
}

void Inventory::removeItem(int position){
	if (searchItem(position) != NULL)
		items.erase(items.begin() + position);
}

pair<Item*, bool> Inventory::getPair(int position){
	return items.at(position);
}
// algumas consideracoes sobre esse metodo em Inventory.h	
void Inventory::setBoolPair(int position, bool isUsed){
	items.at(position).second = isUsed;

}
