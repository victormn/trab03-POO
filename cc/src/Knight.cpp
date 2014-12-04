#include <Knight.h>

Knight::Knight(string alias, int power):Character(alias){
	this->power = power;
}

Knight::~Knight(){ }

int Knight::getDefensePoints(){
	int item_def_pts = 0;

	for (int i=0; getInventory()->searchItem(i) != NULL; i++) {
		if (getInventory()->getPair(i).second)
        		item_def_pts += getInventory()->searchItem(i)->getDefensePts();
    }
	return (int)((constitution*0.5+dexterity*0.3+speed*0.2+item_def_pts)*(XP/2)) + power;
}	
int Knight::getAttackPoints(){
	int item_att_pts = 0;
		
	for (int i=0; getInventory()->searchItem(i) != NULL; i++) {
		if (getInventory()->getPair(i).second)
        		item_att_pts += getInventory()->searchItem(i)->getAttackPts();
    }	
	return (int)((strenght*0.5+dexterity*0.3+speed*0.2+item_att_pts)*(XP/3));
}
void Knight::addPower(int power){
	this->power += power;
	if (this->power > 100)
		this->power = 100;
}
