//------------------------------------------------------------
//	Trabalho Pratico - Parte 2
//	Disciplina: SCC0204 - Programacao Orientada a Objetos
//	Prof. Moacir Ponti
//
//	Aluno: Victor Marcelino Nunes
//	NUSP: 8622381
//
//------------------------------------------------------------

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

	 srand((unsigned)time(NULL)); // semente para gerar um numero pseudo-aleatorio
 
	/* criando os itens */

	// vetores para armazenar diferentes dipos de itens
	Armor **armor = new Armor*[6];
	Weapon **weapon = new Weapon*[10];
	HealthPotion **health = new HealthPotion*[5];
	ManaPotion **mana = new ManaPotion*[3];
 
	/* armor */
	armor[0] = new Armor("BatSuit", 200000.00, 10, 20.0);
	armor[1] = new Armor("Superman's Red Underwear", 100.0, 5, 1.0);
	armor[2] = new Armor("Captain America's Helmet", 699.9, 5, 6.0);
	armor[3] = new Armor("Weird Red Costume", 0.99, 1, 5.0);
	armor[4] = new Armor("Magneto's Helmet", 799.9, 10, 8.0);
	armor[5] = new Armor("Cool Red Costume", 1.99, 2, 5.0);
 
	/* weapon */
	weapon[0] = new Weapon("Batarangs", 0.90, 7, 90.0);
	weapon[1] = new Weapon("Clark's Glass", 45.00, 5, 180.0);
	weapon[2] = new Weapon("Adamantium Shield", 800.00, 9, 100.0);
	weapon[3] = new Weapon("Uncle Ben's Grave", 00.0, 9, 1.0);
	weapon[4] = new Weapon("Magnets", 1.99, 6, 25.0);
	weapon[5] = new Weapon("Winged Shoes", 49.9, 6, 1.0);
	weapon[6] = new Weapon("Magic Book for Professionals, vol.1", 99.99, 9, 200.0);
	weapon[7] = new Weapon("Magic Book for Professionals, vol.2", 99.99, 9, 200.0);
	weapon[8] = new Weapon("Magic Book 4 Dumbs, vol.A", 4.99, 9, 2.0);
	weapon[9] = new Weapon("Magic Book 4 Dumbs, vol.B", 4.99, 9, 2.0);
 
	/* health potion */
	health[0] = new HealthPotion("Enemy's Fear", 49.99, 20);
	health[1] = new HealthPotion("Anti Kyptonite Potion", 99.99, 50);
	health[2] = new HealthPotion("40s Coke", 4.99, 15);
	health[3] = new HealthPotion("Own Tears", 00.0, 1);
	health[4] = new HealthPotion("Eletric Potion", 29.9, 10);
 
	/* mana potion */
	mana[0] = new ManaPotion("Marvel's Fans Sweat", 00.0, 2);
	mana[1] = new ManaPotion("Enemy's Blood", 29.99, 20);
	mana[2] = new ManaPotion("Water", 1.50, 1);
 
	/* criando os personagens */

	/* 3 knight */
	Knight *bruce = new Knight("Bruce Wayne", 10);
	bruce->getInventory()->earnGold(99999.99);
	bruce->getInventory()->spendGold(1.99);
	bruce->getInventory()->setSpaces(4);
	bruce->getInventory()->insertItem(armor[0]); // "BatSuit"
	bruce->getInventory()->insertItem(weapon[0]); // "Batarangs"
	bruce->getInventory()->insertItem(health[0]); // "Enemy's Fear"
	bruce->getInventory()->searchItem("BatSuit")->equip(bruce);
	bruce->getInventory()->searchItem("Batarangs")->equip(bruce);
	bruce->setStrenght(60);
	bruce->setSpeed(5);
	bruce->setDexterity(25);
	bruce->setConstitution(10);
	bruce->addXP(39);
	bruce->addMP(0);
 
	Knight *clark = new Knight("Clark Kent", 20);
	clark->getInventory()->earnGold(5000.0);
	clark->getInventory()->setSpaces(4);
	clark->getInventory()->insertItem(armor[1]); // "Superman's Red Underwear"
	clark->getInventory()->insertItem(weapon[1]); // "Clark's Glass"
	clark->getInventory()->insertItem(health[1]); // "Anti Kyptonite Potion"
	clark->getInventory()->searchItem("Superman's Red Underwear")->equip(clark);
	clark->getInventory()->searchItem("Clark's Glass")->equip(clark);
	clark->setStrenght(65);
	clark->setSpeed(12);
	clark->setDexterity(13);
	clark->setConstitution(10);
	clark->addXP(39);
	clark->addMP(0);
 
	Knight *steve = new Knight("Steve Rogers", 9);
	steve->getInventory()->earnGold(2500.79);
	steve->getInventory()->setSpaces(4);
	steve->getInventory()->insertItem(armor[2]); // "Captain America's Helmet"
	steve->getInventory()->insertItem(weapon[2]); // "Adamantium Shield"
	steve->getInventory()->insertItem(health[2]); // "40s Coke"
	steve->getInventory()->searchItem("Captain America's Helmet")->equip(steve);
	steve->getInventory()->searchItem("Adamantium Shield")->equip(steve);
	steve->setStrenght(60);
	steve->setSpeed(10);
	steve->setDexterity(20);
	steve->setConstitution(10);
	steve->addXP(39);
	steve->addMP(0);

	/* 3 thief */
	Thief *peter = new Thief("Peter Parker", 20);
	peter->getInventory()->earnGold(1.99);
	peter->getInventory()->setSpaces(4);
	peter->getInventory()->insertItem(armor[3]); // "Weird Red Costume"
	peter->getInventory()->insertItem(weapon[3]); // "Uncle Ben's Grave"
	peter->getInventory()->insertItem(health[3]); // "Own Tears"
	peter->getInventory()->searchItem("Weird Red Costume")->equip(peter);
	peter->getInventory()->searchItem("Uncle Ben's Grave")->equip(peter);
	peter->setStrenght(25);
	peter->setSpeed(50);
	peter->setDexterity(15);
	peter->setConstitution(10);
	peter->addXP(39);
	peter->addMP(0);

	Thief *erik = new Thief("Erik Lehnsherr", 20);
	erik->getInventory()->earnGold(2000.01);
	erik->getInventory()->setSpaces(4);
	erik->getInventory()->insertItem(armor[4]); // "Magneto's Helmet"
	erik->getInventory()->insertItem(weapon[4]); // "Magnets"
	erik->getInventory()->insertItem(health[4]); // "Eletric Potion"
	erik->getInventory()->searchItem("Magneto's Helmet")->equip(erik);
	erik->getInventory()->searchItem("Magnets")->equip(erik);
	erik->setStrenght(30);
	erik->setSpeed(30);
	erik->setDexterity(20);
	erik->setConstitution(20);
	erik->addXP(39);
	erik->addMP(0);

	Thief *barry = new Thief("Barry Allen", 25);
	barry->getInventory()->earnGold(99999.99);
	barry->getInventory()->setSpaces(4);
	barry->getInventory()->insertItem(armor[5]); // "Cool Red Costume"
	barry->getInventory()->insertItem(weapon[5]); // "Winged Shoes"
	barry->getInventory()->insertItem(mana[2]); // "Water"
	barry->getInventory()->searchItem("Cool Red Costume")->equip(barry);
	barry->getInventory()->searchItem("Winged Shoes")->equip(barry);
	barry->setStrenght(3);
	barry->setSpeed(90);
	barry->setDexterity(3);
	barry->setConstitution(4);
	barry->addXP(39);
	barry->addMP(0);

	/* 2 wizards */
	Wizard *john = new Wizard("John Constantine", 10);
	john->getInventory()->earnGold(1.00);
	john->getInventory()->setSpaces(4);
	john->getInventory()->insertItem(weapon[6]); // "Magic Book for Professionals, vol.1"
	john->getInventory()->insertItem(weapon[7]); // "Magic Book for Professionals, vol.2"
	john->getInventory()->insertItem(mana[1]); // "Enemy's Blood"
	john->getInventory()->searchItem("Magic Book for Professionals, vol.1")->equip(john);
	john->getInventory()->searchItem("Magic Book for Professionals, vol.2")->equip(john);
	john->setStrenght(50);
	john->setSpeed(15);
	john->setDexterity(25);
	john->setConstitution(10);
	john->addXP(39);
	john->addMP(100);

	Wizard *wanda = new Wizard("Wanda Maximoff", 10);
	wanda->getInventory()->earnGold(1000.50);
	wanda->getInventory()->setSpaces(4);
	wanda->getInventory()->insertItem(weapon[8]); // "Magic Book 4 Dumbs, vol.A"
	wanda->getInventory()->insertItem(weapon[9]); // "Magic Book 4 Dumbs, vol.B"
	wanda->getInventory()->insertItem(mana[0]); // "Marvel's Fans Sweat"
	wanda->getInventory()->searchItem("Magic Book 4 Dumbs, vol.A")->equip(wanda);
	wanda->getInventory()->searchItem("Magic Book 4 Dumbs, vol.B")->equip(wanda);
	wanda->setStrenght(50);
	wanda->setSpeed(15);
	wanda->setDexterity(25);
	wanda->setConstitution(10);
	wanda->addXP(39);
	wanda->addMP(100);

	/* criando os times */

	Team *dc = new Team("DC", blue);
	dc->addChar(bruce);
	dc->addChar(clark);
	dc->addChar(barry);
	dc->addChar(john);
	
	Team *marvel = new Team("Marvel", red);
	marvel->addChar(steve);
	marvel->addChar(peter);
	marvel->addChar(erik);
	marvel->addChar(wanda);

	/* batalha */

	vector<bool> isUsedA;
	vector<bool> isUsedB;

	// vetor para ver se o personagem ja foi usado ou nao no time(false = nao usado; true = usado), 
	// os vector serao setados como false abaixo
	for(int i=0; i<dc->getCharacters().size(); i++)
		isUsedA.push_back(false);
	for(int i=0; i<marvel->getCharacters().size(); i++)
		isUsedB.push_back(false);

	int i = 0;

	// encontra o numero minimo de personagens entre os dois times
	// sera usado no while abaixo para gerar os ataques
	int minSize;

	if(dc->getCharacters().size() > marvel->getCharacters().size()) 
		minSize = marvel->getCharacters().size();
	else 
		minSize = dc->getCharacters().size();

	while(i != minSize){

		// gera um numero pseudo-aleatorio entre 0 e o numero de personagens no time
		int randomA = rand() % (dc->getCharacters().size() );
		int randomB = rand() % (marvel->getCharacters().size() );

		// se o personagem da posicao aleatoria ja estiver sido usado, ira para o personagem da proxima posicao
		// isso ira acontecer ate encontrar uma posicao vazia (false)
		// sempre encontrara uma posicao vazia, pois o while entre 0 e minSize-1 garante isso
		// quando todas as posicoes no menor vetor forem true, i = minSize e saira do while
		while(isUsedA.at(randomA)){
			randomA++;
			if(randomA >= dc->getCharacters().size()) randomA = 0;
		}
		while(isUsedB.at(randomB)){
			randomB++;
			if(randomB >= marvel->getCharacters().size()) randomB = 0;
		}

		// o mais rapido ataca primeiro 
		// sera gerado aleatoriamente os personagens que atacarao outros
		if(dc->searchChar(randomA)->getSpeed() > marvel->searchChar(randomB)->getSpeed()){
			dc->searchChar(randomA)->attack(marvel->searchChar(randomB));
			marvel->searchChar(randomB)->attack(dc->searchChar(randomA));
		}
		else{
			marvel->searchChar(randomB)->attack(dc->searchChar(randomA));
			dc->searchChar(randomA)->attack(marvel->searchChar(randomB));
		}
		isUsedA.at(randomA) = true;
		isUsedB.at(randomB) = true;
		i++;

	}

	dc->resolveBattle(marvel);
	marvel->resolveBattle(dc);

	/* resultado */

	cout << "\n" << dc->toString() << endl << dc->getResults() << "\n\n";
	cout << marvel->toString() << endl << marvel->getResults() << "\n\n";

	/* liberando espaco */
	for (int i=0; i<6; i++)
		delete armor[i];
	delete[] armor;
	for (int i=0; i<10; i++)
		delete weapon[i];
	delete[] weapon;
	for (int i=0; i<5; i++)
		delete health[i];
	delete[] health;
	for (int i=0; i<3; i++)
		delete mana[i];
	delete[] mana;
	delete dc;
	delete marvel;

	return 0;

}
