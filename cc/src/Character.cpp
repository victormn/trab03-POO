#include <Character.h>

Character::Character(string alias){
	this->alias = alias;
	myitems = new Inventory();
	HP = 100;
	XP = 1;
	strenght = 1;
	speed = 1;
	speedArmor = 0;
	dexterity = 1;
	constitution = 1;
}

Character::~Character(){
	delete(myitems);
}

string Character::getName(){
	return alias;
}

Inventory* Character::getInventory(){
	return myitems;
}

// mandei retornar 0 para remover os warning
int Character::getDefensePoints(){return 0;}	
int Character::getAttackPoints(){return 0;}

int Character::getSpeed(){
	return speed - speedArmor;
}

void Character::setSpeedArmor(int speedArmor){
	this->speedArmor = speedArmor;
}

int Character::getHP(){
	return HP;
}

void Character::attack(Character* oponente){ 

	int peso = 1; // se for um ataque critico: peso = 2; se ele errar o ataque: peso = 0; se for um ataque normal: peso continua 1 

	// rand()/double(RAND_MAX) gera um numero aleatorio entre 0.0 e 1.0
	// a chance dele estar no intervalo [0 , (0.1/XP)] eh (0.1/XP) = "miss" 
	// a chance dele estar no intervalo [0 , (0.01*XP)] eh (0.01*XP) = "critical strike"

	double random = rand()/double(RAND_MAX);

	if (random <= (0.1/XP)) 
		peso = 0;
	else if (random <= (0.01*XP)) 
		peso = 2;

	// (rand() % 11 - 5) equivale a um numero aleatorio entre -5 e 5 (11 numeros nesse intervalo)

	int dano = (int)(peso*(getAttackPoints() - oponente->getDefensePoints() + (rand() % 11 - 5)));

	if (dano <= 0) dano = 1;

	oponente->addHP(dano*(-1));
}

void Character::addXP(int XP){
	this->XP += XP;
	if (this->XP > 100)
		this->XP = 100;
}

void Character::addMP(int MP){
	this->MP += MP;
	if (this->MP > 100)
		this->MP = 100;
	if (this->MP < 0)
		this->MP = 0;
}

void Character::addHP(int HP){
	this->HP += HP;
	if (this->HP > 100)
		this->HP = 100;
	if (this->HP < 0)
		this->HP = 0;
}
	
/* setters */

// a somatoria dos atributos tem que dar 100

void Character::setStrenght(int strenght){
	this->strenght = strenght;
	if (strenght < 1)
		this->strenght = 1;
	if (strenght > 100 - speed - dexterity - constitution)
		this->strenght = 100 - speed - dexterity - constitution;
}

void Character::setSpeed(int speed){
	this->speed = speed;
	if (speed < 1)
		this->speed = 1;
	if (speed > 100 - strenght - dexterity - constitution)
		this->speed = 100 - strenght - dexterity - constitution;
}

void Character::setDexterity(int dexterity){
	this->dexterity = dexterity;
	if (dexterity < 1)
		this->dexterity = 1;
	if (dexterity > 100 - speed - strenght - constitution)
		this->dexterity = 100 - speed - strenght - constitution;
}

void Character::setConstitution(int constitution){
	this->constitution = constitution;
	if (constitution < 1)
		this->constitution = 1;
	if (constitution > 100 - speed - dexterity - strenght)
		this->constitution = 100 - speed - dexterity - strenght;
}
