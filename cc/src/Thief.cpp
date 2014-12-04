#include <Thief.h>

Thief::Thief(string alias, int stealth):Character(alias){
	this->stealth = stealth;
}

Thief::~Thief(){ }

int Thief::getDefensePoints(){
	int item_def_pts = 0;

	for (int i=0; getInventory()->searchItem(i) != NULL; i++) {
		if (getInventory()->getPair(i).second)
        		item_def_pts += getInventory()->searchItem(i)->getDefensePts();
    	}
	return (int)((constitution*0.5+dexterity*0.3+speed*0.2+item_def_pts)*(XP/2));
}	
int Thief::getAttackPoints(){
	int item_att_pts = 0;
		
	for (int i=0; getInventory()->searchItem(i) != NULL; i++) {
		if (getInventory()->getPair(i).second)
        		item_att_pts += getInventory()->searchItem(i)->getAttackPts();
    	}	
	return (int)((strenght*0.5+dexterity*0.3+speed*0.2+item_att_pts)*(XP/3)) + stealth;
}
void Thief::addStealth(int stealth){
	this->stealth += stealth;
	if (this->stealth > 100)
		this->stealth = 100;
}
