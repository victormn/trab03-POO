// SOMENTE PARA TESTES
// ela pode ser utilizada atraves dos comandos make test; make runT
// ela testa todos os metodos das classes

import java.util.*;

public class mainTest{
	
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
		Armor armor1, armor2;
		Weapon weapon1, weapon2;
		HealthPotion health1, health2, health0;
		ManaPotion mana1, mana2;
		
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

		Wizard john = new Wizard("John Constantine", 100);
		john.getInventory().setSpaces(10);

		john.getInventory().insertItem(armor1);
		john.getInventory().insertItem(armor2); 
		john.getInventory().insertItem(weapon1); 
		john.getInventory().insertItem(weapon2); 
		john.getInventory().insertItem(health1); 
		john.getInventory().insertItem(health2); 
		john.getInventory().insertItem(mana1); 
		john.getInventory().insertItem(mana2); 

		john.getInventory().earnGold(1.00);
		john.setStrenght(50);
		john.setSpeed(48);
		john.setDexterity(10);
		john.setConstitution(2);
		john.addXP(2);
		john.addMP(100);

		Wizard wanda = new Wizard("Wanda Maximoff", 100);
		wanda.getInventory().setSpaces(10);

		wanda.getInventory().insertItem(armor1);
		wanda.getInventory().insertItem(armor2); 
		wanda.getInventory().insertItem(weapon1); 
		wanda.getInventory().insertItem(weapon2); 
		wanda.getInventory().insertItem(health0); 
		wanda.getInventory().insertItem(health2); 
		wanda.getInventory().insertItem(mana1); 
		wanda.getInventory().insertItem(mana2); 

		wanda.getInventory().searchItem("armor1").equip(wanda);
		wanda.getInventory().searchItem("armor2").equip(wanda);
		wanda.getInventory().searchItem("weapon1").equip(wanda);
		wanda.getInventory().searchItem("weapon2").equip(wanda);
		wanda.getInventory().searchItem("health0").equip(wanda);
		wanda.getInventory().searchItem("health2").equip(wanda);
		wanda.getInventory().searchItem("mana1").equip(wanda);
		wanda.getInventory().searchItem("mana2").equip(wanda);


		wanda.getInventory().earnGold(1.00);
		wanda.setStrenght(50);
		wanda.setSpeed(48);
		wanda.setDexterity(10);
		wanda.setConstitution(2);
		wanda.addXP(2);
		wanda.addMP(100);

		/* criando os times */

		Team dc = new Team("DC", Color.blue);
		dc.addChar(john);
		
		Team marvel = new Team("Marvel", Color.red);
		marvel.addChar(wanda);

		/* TESTES 1 */

		System.out.println("Character: " + john.getName());
		System.out.println("\tSpeed antes de equipar armor: " + john.getSpeed());
		
		john.getInventory().searchItem("armor1").equip(john);

		System.out.println("\tSpeed depois que equipou armor: " + john.getSpeed());

		john.getInventory().searchItem("armor1").unequip(john);

		System.out.println("\tSpeed depois que desequipou armor: " + john.getSpeed());

		System.out.println("\tHP antes de ser atacado: " + john.getHP());

		wanda.attack(john);
		
		System.out.println("\tHP depois de ser atacado: " + john.getHP());
		
		john.getInventory().searchItem("health1").use(john);

		System.out.println("\tHP depois de ter tomado a HealthPotion: " + john.getHP());

		if (john.getInventory().searchItem("health1") == null)
			System.out.println("\tHealthPotion foi excluido com sucesso do inventario");
		else
			System.out.println("\tHealthPotion NAO foi excluido do inventario");

		System.out.println("\tGold antes de gastar: " + john.getInventory().getTotalGold());

		john.getInventory().spendGold(1.99);	

		System.out.println("\tGold depois de gastar 1.99: " + john.getInventory().getTotalGold());

		/* TESTES 2 */

		System.out.println("Character: " + wanda.getName());

		System.out.println("\tItens no inventario (testa searchItem(int)): ");

		for (int i=0; wanda.getInventory().searchItem(i) != null; i++)
			System.out.println("\t" + wanda.getInventory().searchItem(i).getName());

		System.out.println("\t!OBS: todos os itens do inventario foram equipados!");

		System.out.println("\tItens equipados: ");

		for (int i=0; wanda.getInventory().searchItem(i) != null; i++)
			if(wanda.getInventory().getPair(i).second())
				System.out.println("\t" + wanda.getInventory().searchItem(i).getName());

		System.out.println("\tDesequipando o item Armor2 (testa searchItem(string)) ");
		
		wanda.getInventory().searchItem("armor2").unequip(wanda);

		System.out.println("\tRemovendo o item Health2 e o primeiro (Armor1) item ");
		
		wanda.getInventory().removeItem("health2");
		wanda.getInventory().removeItem(0);

		System.out.println("\tItens no inventario (depois das remocoes): ");

		for (int i=0; wanda.getInventory().searchItem(i) != null; i++)
			System.out.println("\t" + wanda.getInventory().searchItem(i).getName());

		System.out.println("\tItens equipados (depois das remocoes): ");

		for (int i=0; wanda.getInventory().searchItem(i) != null; i++)
			if(wanda.getInventory().getPair(i).second())
				System.out.println("\t" + wanda.getInventory().searchItem(i).getName());

		//usar na main de trab2.cpp para ver se esta controlando certo o uso de personagens
		/*-----------------------------------------------------------------------------------------
		System.out.println("random A: " + randomA);
		System.out.println("random B: " + randomB);
		for(int e=0; e<dc.getCharacters().size(); e++)
			System.out.println(isUsedA.get(e) + " ";
		System.out.println(endl;
		for(int e=0; e<marvel.getCharacters().size(); e++)
			System.out.println(isUsedB.get(e)+ " ";
		System.out.println(endl;
		-----------------------------------------------------------------------------------------*/

	}
}
