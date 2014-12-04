// SOMENTE PARA TESTES
// ela pode ser utilizada atraves dos comandos make test; make runT; make cleanT
// ela testa todos os metodos das classes

#include <Item.h>
#include <Weapon.h>
#include <Armor.h>
#include <Potion.h>
#include <ManaPotion.h>
#include <HealthPotion.h>
#include <Inventory.h>
#include <Character.h>
#include <Knight.h>
#include <Wizard.h>
#include <Thief.h>
#include <Team.h>
#include <Color.h>

#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <time.h> 

using namespace std;

int main (int argc, char*argv[]) {

	/* criando os itens */
	Armor *armor1, *armor2;
	Weapon *weapon1, *weapon2;
	HealthPotion *health1, *health2, *health0;
	ManaPotion *mana1, *mana2;
	
	/* armor */
	armor1 = new Armor("armor1", 200000.00, 20, 20.0);
	armor2 = new Armor("armor2", 100.0, 15, 1.0);

	/* weapon */
	weapon1 = new Weapon("weapon1", 0.90, 7, 90.0);
	weapon2 = new Weapon("weapon2", 45.00, 1, 180.0);

	/* health potion */
	health0 = new HealthPotion("health0", 49.99, 20);
	health1 = new HealthPotion("health1", 49.99, 20);
	health2 = new HealthPotion("health2", 99.99, 50);

	/* mana potion */
	mana1 = new ManaPotion("mana1", 00.0, 2);
	mana2 = new ManaPotion("mana2", 29.99, 20);

	/* criando o 2 personagens */
	/* 2 wizards */

	Wizard *john = new Wizard("John Constantine", 100);
	john->getInventory()->setSpaces(10);

	john->getInventory()->insertItem(armor1);
	john->getInventory()->insertItem(armor2); 
	john->getInventory()->insertItem(weapon1); 
	john->getInventory()->insertItem(weapon2); 
	john->getInventory()->insertItem(health1); 
	john->getInventory()->insertItem(health2); 
	john->getInventory()->insertItem(mana1); 
	john->getInventory()->insertItem(mana2); 

	john->getInventory()->earnGold(1.00);
	john->setStrenght(50);
	john->setSpeed(48);
	john->setDexterity(10);
	john->setConstitution(2);
	john->addXP(2);
	john->addMP(100);

	Wizard *wanda = new Wizard("Wanda Maximoff", 100);
	wanda->getInventory()->setSpaces(10);

	wanda->getInventory()->insertItem(armor1);
	wanda->getInventory()->insertItem(armor2); 
	wanda->getInventory()->insertItem(weapon1); 
	wanda->getInventory()->insertItem(weapon2); 
	wanda->getInventory()->insertItem(health0); 
	wanda->getInventory()->insertItem(health2); 
	wanda->getInventory()->insertItem(mana1); 
	wanda->getInventory()->insertItem(mana2); 

	wanda->getInventory()->searchItem("armor1")->equip(wanda);
	wanda->getInventory()->searchItem("armor2")->equip(wanda);
	wanda->getInventory()->searchItem("weapon1")->equip(wanda);
	wanda->getInventory()->searchItem("weapon2")->equip(wanda);
	wanda->getInventory()->searchItem("health0")->equip(wanda);
	wanda->getInventory()->searchItem("health2")->equip(wanda);
	wanda->getInventory()->searchItem("mana1")->equip(wanda);
	wanda->getInventory()->searchItem("mana2")->equip(wanda);


	wanda->getInventory()->earnGold(1.00);
	wanda->setStrenght(50);
	wanda->setSpeed(48);
	wanda->setDexterity(10);
	wanda->setConstitution(2);
	wanda->addXP(2);
	wanda->addMP(100);

	/* criando os times */

	Team *dc = new Team("DC", blue);
	dc->addChar(john);
	
	Team *marvel = new Team("Marvel", red);
	marvel->addChar(wanda);

	/* TESTES 1 */

	cout << "Character: " << john->getName() << endl;
	cout << "\tSpeed antes de equipar armor: " << john->getSpeed() << endl;
	
	john->getInventory()->searchItem("armor1")->equip(john);

	cout << "\tSpeed depois que equipou armor: " << john->getSpeed() << endl;

	john->getInventory()->searchItem("armor1")->unequip(john);

	cout << "\tSpeed depois que desequipou armor: " << john->getSpeed() << endl;

	cout << "\tHP antes de ser atacado: " << john->getHP() << endl;

	wanda->attack(john);
	
	cout << "\tHP depois de ser atacado: " << john->getHP() << endl;
	
	john->getInventory()->searchItem("health1")->use(john);

	cout << "\tHP depois de ter tomado a HealthPotion: " << john->getHP() << endl;

	if (john->getInventory()->searchItem("health1") == NULL)
		cout << "\tHealthPotion foi excluido com sucesso do inventario" << endl;
	else
		cout << "\tHealthPotion NAO foi excluido do inventario" << endl;

	cout << "\tGold antes de gastar: " << john->getInventory()->getTotalGold() << endl;

	john->getInventory()->spendGold(1.99);	

	cout << "\tGold depois de gastar 1.99: " << john->getInventory()->getTotalGold() << endl;

	/* TESTES 2 */

	cout << "Character: " << wanda->getName() << endl;

	cout << "\tItens no inventario (testa searchItem(int)): " << endl;

	for (int i=0; wanda->getInventory()->searchItem(i) != NULL; i++)
		cout << "\t" << wanda->getInventory()->searchItem(i)->getName() << endl;

	cout << "\t!OBS: todos os itens do inventario foram equipados!" << endl;

	cout << "\tItens equipados: " << endl;

	for (int i=0; wanda->getInventory()->searchItem(i) != NULL; i++)
		if(wanda->getInventory()->getPair(i).second)
			cout << "\t" << wanda->getInventory()->searchItem(i)->getName() << endl;

	cout << "\tDesequipando o item Armor2 (testa searchItem(string)) " << endl;
	
	wanda->getInventory()->searchItem("armor2")->unequip(wanda);

	cout << "\tRemovendo o item Health2 e o primeiro (Armor1) item " << endl;
	
	wanda->getInventory()->removeItem("health2");
	wanda->getInventory()->removeItem(0);

	cout << "\tItens no inventario (depois das remocoes): " << endl;

	for (int i=0; wanda->getInventory()->searchItem(i) != NULL; i++)
		cout << "\t" << wanda->getInventory()->searchItem(i)->getName() << endl;

	cout << "\tItens equipados (depois das remocoes): " << endl;

	for (int i=0; wanda->getInventory()->searchItem(i) != NULL; i++)
		if(wanda->getInventory()->getPair(i).second)
			cout << "\t" << wanda->getInventory()->searchItem(i)->getName() << endl;

	//usar na main de trab2.cpp para ver se esta controlando certo o uso de personagens
	/*-----------------------------------------------------------------------------------------
	cout << "random A: " << randomA << endl;
	cout << "random B: " << randomB << endl;
	for(int e=0; e<dc->getCharacters().size(); e++)
		cout << isUsedA.at(e) << " ";
	cout << endl;
	for(int e=0; e<marvel->getCharacters().size(); e++)
		cout << isUsedB.at(e)<< " ";
	cout << endl;
	-----------------------------------------------------------------------------------------*/

	delete wanda;
	delete john;

	delete armor1;
	delete armor2;
	delete weapon1;
	delete weapon2;
	delete health0;
	delete health2;
	delete mana1;
	delete mana2;

	delete dc;
	delete marvel;

	return 0;

}
