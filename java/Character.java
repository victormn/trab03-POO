import java.util.*;

public abstract class Character{
	
	/* Atributos */	

	private String alias;
	private Inventory myitems;
	private int HP;
	private int MP;

	protected int XP;
	protected int strenght;
	protected int speed;
	protected int speedArmor;
	protected int dexterity;
	protected int constitution;
	
	/* Construtor */

	public Character(String alias){
		this.alias = alias;
		myitems = new Inventory();
		HP = 5000;
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

	// Calcula chances de ataques e reduz o valor obtido de 'HP'(ataque realizado)
	public void attack(Character oponente){ 

		int peso = 1; // se for um ataque critico: peso = 2; se ele errar o ataque: peso = 0; se for um ataque normal: peso continua 1 

		// .nextDouble() gera um numero aleatorio entre 0.0 e 1.0
		// a chance dele estar no intervalo [0 , (0.1/XP)] eh (0.1/XP) = "miss" 
		// a chance dele estar no intervalo [0 , (0.01*XP)] eh (0.01*XP) = "critical strike"
		
		double rand1 = trab3.nextDouble(0.0, 1.0);

		if (rand1 <= (0.1/XP)) 
			peso = 0;
		else if (rand1 <= (0.1*XP)) 
			peso = 2;

	    int rand2 = trab3.nextInt(0, 21) + 10; // rand equivale a um numero aleatorio entre 10 e 30 (11 numeros nesse intervalo)

	    // O MP é utilizado como some no ataque, e após isso, é zerado
	    // MP pode ser recuperado atraves de pocoes que sao usadas na beira da morte do personagem
		int dano = (int)(peso*(getAttackPoints() - oponente.getDefensePoints()/3 + rand2 + MP));
		this.MP = 0;

		if (dano <= 0) dano = 1;

		// -Se o oponente for morrer, ou seja, seu HP <= 0, ele tentara tomar pocoes "Health" para
		//	recuperar vida e pocoes "Mana" para aumentar o MP
		synchronized(oponente){

			if (oponente.getHP() - dano <= 0){

				Potion health = (Potion)oponente.getInventory().searchItem("Health");
				Potion mana = (Potion)oponente.getInventory().searchItem("Mana");

				// -Usa uma pocao de recuperar vida e outra de recuperar MP (caso tenha no inventario).
				// -Precisa estar a beira da morte para pode usa-las, por decisao de projeto, ela eh
				// a ultima opcao na batalha
				if (health != null) health.use(oponente);
				if (mana != null) mana.use(oponente);

			}
		}
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
		if (this.MP > 5000)
			this.MP = 5000;
		if (this.MP < 0)
			this.MP = 0;
	}

	// Indica vitalidade do 'character'
	public void addHP(int HP){
		this.HP += HP;
		if (this.HP > 5000)
			this.HP = 5000;
		if (this.HP < 0)
			this.HP = 0;
	}
	
	/* Métodos Setters */

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
