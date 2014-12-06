import java.util.*;

public class Knight extends Character{

	/* Atributos */
	
	protected int power;		// poder extra de resistência do 'knight'

	/* Construtor */

	public Knight(String alias, int power){
		super (alias);
		this.power = power;		
	}

	/* Metodos */

	// Retorna valor de defesa de 'character'
	protected int getDefensePoints(){
		int item_def_pts = 0;

		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_def_pts += getInventory().getPair(i).first().getDefensePts();
	    	}
		return (int)((constitution*0.5+dexterity*0.3+speed*0.2+item_def_pts)*(XP/2)) + power;

	}

	// Retorna valor de ataque de 'character'
	protected int getAttackPoints(){
		int item_att_pts = 0;
		
		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_att_pts += getInventory().getPair(i).first().getAttackPts();
	    	}	
		return (int)((strenght*0.5+dexterity*0.3+speed*0.2+item_att_pts)*(XP/3));

	}

	// Indica poder extra de resistência do 'knight'
	public void addPower(int power){
		this.power += power;
		if (this.power > 100)
			this.power = 100;
	}
}
