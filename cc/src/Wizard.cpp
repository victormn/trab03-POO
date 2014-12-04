#include <Wizard.h>

Wizard::Wizard(string alias, int wisdom):Character(alias){
	this->wisdom = wisdom;
}

Wizard::~Wizard(){ }

int Wizard::getDefensePoints(){
	int item_def_pts = 0;

	for (int i=0; getInventory()->searchItem(i) != NULL; i++) {
		if (getInventory()->getPair(i).second)
        		item_def_pts += getInventory()->searchItem(i)->getDefensePts();
    	}
	return (int)((constitution*0.5+dexterity*0.3+speed*0.2+item_def_pts)*(XP/2)) + (wisdom/2);
}	
int Wizard::getAttackPoints(){
	int item_att_pts = 0;
		
	for (int i=0; getInventory()->searchItem(i) != NULL; i++) {
		if (getInventory()->getPair(i).second)
        		item_att_pts += getInventory()->searchItem(i)->getAttackPts();
    	}	
	return (int)((strenght*0.5+dexterity*0.3+speed*0.2+item_att_pts)*(XP/3));
}
void Wizard::addWisdom(int wisdom){
	this->wisdom += wisdom;
	if (this->wisdom > 100)
		this->wisdom = 100;
}
