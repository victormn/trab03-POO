#include <Item.h>

Item::Item(string name, double price){

	/* verificando os intervalos, caso esteja fora atribui-se o menor valor */
	if (price < 1)
		price = 1;		

	this->name = name;
	this->price = price;
}

Item::Item(const Item& item){ 
	this->name = item.name;
	this->price = item.price;	

}
Item::~Item(){ }

string Item::getName(){
	return name;
}

double Item::getPrice(){
	return price;
}

// explicacao do porque de ter criado esses metodos e nao aproveitado o use estao no Item.h
void Item::equip(Character* character){ }
void Item::unequip(Character* character){ }

// mandei retornar 0 para tirar os warning
int Item::getAttackPts(){return 0;}
int Item::getDefensePts(){return 0;}
double Item::getWeight(){return 0.0;}


