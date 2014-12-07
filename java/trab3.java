//------------------------------------------------------------
//	Trabalho Pratico - Parte Final
//	Disciplina: SCC0204 - Programacao Orientada a Objetos
//	Prof. Moacir Ponti
//
//	Aluno: Elisa Jorge Marcatto
//	NUSP: 7961965
//
//	Aluno: Victor Marcelino Nunes
//	NUSP: 8622381
//
//------------------------------------------------------------

// OBS: o package Items foi retirado por problemas ao passar um objeto de uma classe como parametro para um 
// metodo de outra classe. Foi consultado o profesor Moacir e ele concordou que poderia retirar o package Items
// Mesmo trocando o nome da classe Character, o problema continuou...

import java.util.*;

public class trab3{
	
	/* criando um gerador de aleatorios */
	private static Random generator;

	public static int nextInt(int x, int y){
		return generator.nextInt(y-x); 
	}
	public static double nextDouble(double x, double y){
		return generator.nextDouble()*(y-x) + x;
	}
	static{
		generator = new Random();
	}
	/*----------------------------------*/

	public static void main (String args[]) {

		/* criando os itens */

		// vetores para armazenar todos itens e personagens
		ArrayList<Item> allItems = new ArrayList<Item>();
		ArrayList<Character> allCharacters = new ArrayList<Character>();

		/* default */

		Armor armor = new Armor("Helmet", 0.0, 10, 20.0);
		Weapon weapon = new Weapon("Sword", 0.0, 7, 90.0);
		HealthPotion health = new HealthPotion("Health", 0.0, 1000);
		ManaPotion mana = new ManaPotion("Mana", 0.0, 1000);


		/* armor */
		allItems.add(new Armor("BatSuit", 500.00, 10, 20.0));
		allItems.add(new Armor("Tiffany's Earrings", 350.00, 19, 2));
		allItems.add(new Armor("Louis XIV's shoes", 300.00, 15, 10));
		allItems.add(new Armor("Weird Red Costume", 0.99, 1, 5.0));
		allItems.add(new Armor("Magneto's Helmet", 800.0, 10, 8.0));
		allItems.add(new Armor("Fancy glasses", 100.00, 12, 7));
	 
		/* weapon */
		allItems.add(new Weapon("Batarangs", 20.00, 7, 90.0));
		allItems.add(new Weapon("Poisoned Bubbles", 50.00, 2, 20));
		allItems.add(new Weapon("Adamantium Shield", 800.00, 9, 100.0));
		allItems.add(new Weapon("Nuclear Tomatoes", 30, 2, 9));
		allItems.add(new Weapon("Magnets", 1.99, 6, 25.0));
		allItems.add(new Weapon("Gaga's Microphone", 147, 4, 25));
		allItems.add(new Weapon("Golden Arrow", 400.00, 8, 42));
		allItems.add(new Weapon("Flufy Pillow", 130, 5, 10));
		allItems.add(new Weapon("Magic Book 4 Dumbs, vol.A", 4.99, 9, 2.0));
		allItems.add(new Weapon("Elder Wand", 800.0, 9, 50));
	 
		/* health potion */
		allItems.add(new HealthPotion("Health", 100, 1000));
		allItems.add(new HealthPotion("Health", 100, 1000));
		allItems.add(new HealthPotion("Health", 100, 1000));
		allItems.add(new HealthPotion("Health", 100, 1000));
		allItems.add(new HealthPotion("Health", 100, 1000));
	 
		/* mana potion */
		allItems.add(new ManaPotion("Mana", 100, 200));
		allItems.add(new ManaPotion("Mana", 100, 200));
		allItems.add(new ManaPotion("Mana", 100, 200));


		/* criando os personagens */

		/* 2 knight */
		Knight bruce = new Knight("Bruce Wayne", 10);
		bruce.getInventory().earnGold(1000.0);
		bruce.getInventory().setSpaces(15);
	 
		bruce.getInventory().insertItem(armor); 
		bruce.getInventory().insertItem(weapon); 
		bruce.getInventory().insertItem(health); 
	 
		bruce.getInventory().searchItem("Helmet").equip(bruce);
		bruce.getInventory().searchItem("Sword").equip(bruce);
		bruce.getInventory().searchItem("Health").equip(bruce);
	 
		bruce.setStrenght(60);
		bruce.setSpeed(5);
		bruce.setDexterity(25);
		bruce.setConstitution(10);
		bruce.addXP(39);
		bruce.addMP(0);
		allCharacters.add(bruce);

		Knight bodolski = new Knight("Sir Bodolski", 30);
		bodolski.getInventory().earnGold(1000.0);
		bodolski.getInventory().setSpaces(15);
	 
		bodolski.getInventory().insertItem(armor); 
		bodolski.getInventory().insertItem(weapon); 
		bodolski.getInventory().insertItem(health); 
	 
		bodolski.getInventory().searchItem("Helmet").equip(bodolski);
		bodolski.getInventory().searchItem("Sword").equip(bodolski);
		bodolski.getInventory().searchItem("Health").equip(bodolski);
	 
		bodolski.setStrenght(50);
		bodolski.setSpeed(30);
		bodolski.setDexterity(5);
		bodolski.setConstitution(15);
		bodolski.addXP(39);
		bodolski.addMP(0);
		allCharacters.add(bodolski);

		/* 2 thief */
		Thief barry = new Thief("Barry Allen", 25);
		barry.getInventory().earnGold(1000.0);
		barry.getInventory().setSpaces(15);

		barry.getInventory().insertItem(armor); 
		barry.getInventory().insertItem(weapon); 
		barry.getInventory().insertItem(health); 
	 
		barry.getInventory().searchItem("Helmet").equip(barry);
		barry.getInventory().searchItem("Sword").equip(barry);
		barry.getInventory().searchItem("Health").equip(barry);

		barry.setStrenght(3);
		barry.setSpeed(90);
		barry.setDexterity(3);
		barry.setConstitution(4);
		barry.addXP(39);
		barry.addMP(0);
		allCharacters.add(barry);

		Thief goultier = new Thief("Mr. Goultier", 47);
		goultier.getInventory().earnGold(1000.0);
		goultier.getInventory().setSpaces(15);

		goultier.getInventory().insertItem(armor); 
		goultier.getInventory().insertItem(weapon); 
		goultier.getInventory().insertItem(health); 
	 
		goultier.getInventory().searchItem("Helmet").equip(goultier);
		goultier.getInventory().searchItem("Sword").equip(goultier);
		goultier.getInventory().searchItem("Health").equip(goultier);

		goultier.setStrenght(10);
		goultier.setSpeed(30);
		goultier.setDexterity(50);
		goultier.setConstitution(10);
		goultier.addXP(39);
		goultier.addMP(100);
		allCharacters.add(goultier);

		/* 2 wizards */
		Wizard john = new Wizard("John Constantine", 10);
		john.getInventory().earnGold(1000.0);
		john.getInventory().setSpaces(15);

		john.getInventory().insertItem(armor); 
		john.getInventory().insertItem(weapon); 
		john.getInventory().insertItem(health); 
	 
		john.getInventory().searchItem("Helmet").equip(john);
		john.getInventory().searchItem("Sword").equip(john);
		john.getInventory().searchItem("Health").equip(john);
		
		john.setStrenght(50);
		john.setSpeed(15);
		john.setDexterity(25);
		john.setConstitution(10);
		john.addXP(39);
		john.addMP(100);
		allCharacters.add(john);

		Wizard violet = new Wizard("Lady Violet", 16);
		violet.getInventory().earnGold(1000.0);
		violet.getInventory().setSpaces(15);

		violet.getInventory().insertItem(armor); 
		violet.getInventory().insertItem(weapon); 
		violet.getInventory().insertItem(health); 
	 
		violet.getInventory().searchItem("Helmet").equip(violet);
		violet.getInventory().searchItem("Sword").equip(violet);
		violet.getInventory().searchItem("Health").equip(violet);

		violet.setStrenght(2);
		violet.setSpeed(70);
		violet.setDexterity(18);
		violet.setConstitution(10);
		violet.addXP(39);
		violet.addMP(100);
		allCharacters.add(violet);

		Store store = new Store();

		for (int i = 0; i < allItems.size(); i++) {
			store.supplyStore(allItems.get(i));
		}

		Menu menu = new Menu(allCharacters);

		menu.setTeams();

		for (int i = 1; i <= 2; i++)
			menu.pickYourCharacters(menu.getTeam(i));
		for (int i = 1; i <= 2; i++)
			menu.letsGoShop(menu.getTeam(i), store);
		for (int i = 1; i <= 2; i++)
			menu.equipItems(menu.getTeam(i));
		menu.battleStart();
		menu.battleResults();
	}
}
