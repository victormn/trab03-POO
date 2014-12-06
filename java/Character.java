import java.util.*;

public abstract class Character{
	
	/* Atributos */	

	private String alias;
	private Inventory myitems;
	private int opponents;
	private int HP;
	private int MP;

	protected int XP;
	protected int strenght;
	protected int speed;
	protected int speedArmor;
	protected int dexterity;
	protected int constitution;
	protected abstract int getDefensePoints();
	protected abstract int getAttackPoints();

	/* Construtor */

	public Character(String alias){
		this.alias = alias;
		myitems = new Inventory();
		HP = 100;
		XP = 1;
		strenght = 1;
		speed = 1;
		speedArmor = 0;
		dexterity = 1;
		constitution = 1;
	}

	/* Métodos Getters */

	// Retorna o valor de 'HP' do personagem	
	public int getHP(){
		return HP;
	}

	// Retorna a quantidade de oponentes que um 'character' tem 
	public int getOpponents(){
		return opponents;
	}
	
	// Retorna o valor de 'dexterity' do personagem
	public int getDexterity(){
		return dexterity;
	}

	// Retorna o valor de 'strenght' do personagem
	public int getStrenght(){
		return strenght;
	}

	// Retorna o valor de 'constitution' do personagem
	public int getConstitution(){
		return constitution;
	}

	// Retorna 'name' do personagem
	public String getName(){
		return alias;
	}

	// Retorna 'inventory' associado a 'character'
	public Inventory getInventory(){
		return myitems;
	}

	// Retorna valor de ataque de 'character'
	public int getSpeed(){
		return speed - speedArmor;
	}

	// Retorna valor de defesa de 'character'
	protected abstract int getDefensePoints();

	protected abstract int getAttackPoints();

	// Calcula chances de ataques e deduz o valor obtido de 'HP'(ataque realizado)
	public void attack(Character oponente){ 

		int peso = 1; // se for um ataque critico: peso = 2; se ele errar o ataque: peso = 0; se for um ataque normal: peso continua 1 

		// .nextDouble() gera um numero aleatorio entre 0.0 e 1.0
		// a chance dele estar no intervalo [0 , (0.1/XP)] eh (0.1/XP) = "miss" 
		// a chance dele estar no intervalo [0 , (0.01*XP)] eh (0.01*XP) = "critical strike"
		
		double rand1 = trab2.nextDouble(0.0, 1.0);

		if (rand1 <= (0.1/XP)) 
			peso = 0;
		else if (rand1 <= (0.01*XP)) 
			peso = 2;

	        int rand2 = trab2.nextInt(0, 11) - 5; // rand equivale a um numero aleatorio entre -5 e 5 (11 numeros nesse intervalo)

		int dano = (int)(peso*(getAttackPoints() - oponente.getDefensePoints() + rand2));

		if (dano <= 0) dano = 1;

		oponente.addHP(dano*(-1));
	}

	// Indica experiencia do 'character', deve estar limitada em [1,100]
	public void addXP(int XP){
		this.XP += XP;
		if (this.XP > 100)
			this.XP = 100;
	}

	// Indica unidade de poder mágico do 'character'
	public void addMP(int MP){
		this.MP += MP;
		if (this.MP > 100)
			this.MP = 100;
		if (this.MP < 0)
			this.MP = 0;
	}

	// Indica vitalidade do 'character'
	public void addHP(int HP){
		this.HP += HP;
		if (this.HP > 100)
			this.HP = 100;
		if (this.HP < 0)
			this.HP = 0;
	}
	
	/* Métodos Setters */

	public void setOpponents(int opponents){
		this.opponents = opponents;
	}

	// Atributos que, somados, devem dar 100
	public void setStrenght(int strenght){
		this.strenght = strenght;
		if (strenght < 1)
			this.strenght = 1;
		if (strenght > 100 - speed - dexterity - constitution)
			this.strenght = 100 - speed - dexterity - constitution;
	}

	public void setSpeed(int speed){
		this.speed = speed;
		if (speed < 1)
			this.speed = 1;
		if (speed > 100 - strenght - dexterity - constitution)
			this.speed = 100 - strenght - dexterity - constitution;
	}

	public void setDexterity(int dexterity){
		this.dexterity = dexterity;
		if (dexterity < 1)
			this.dexterity = 1;
		if (dexterity > 100 - speed - strenght - constitution)
			this.dexterity = 100 - speed - strenght - constitution;
	}

	public void setConstitution(int constitution){
		this.constitution = constitution;
		if (constitution < 1)
			this.constitution = 1;
		if (constitution > 100 - speed - dexterity - strenght)
			this.constitution = 100 - speed - dexterity - strenght;
	}

	// Indica a velocidade alterada ao se equipar um 'armor'
	public void setSpeedArmor(int speedArmor){
		this.speedArmor = speedArmor;
	}
}
