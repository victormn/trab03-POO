import java.util.*;

public class Knight extends Character{

	protected int power;

	protected int getDefensePoints(){
		int item_def_pts = 0;

		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_def_pts += getInventory().getPair(i).first().getDefensePts();
	    	}
		return (int)((constitution*0.5+dexterity*0.3+speed*0.2+item_def_pts)*(XP/2)) + power;

	}

	protected int getAttackPoints(){
		int item_att_pts = 0;
		
		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_att_pts += getInventory().getPair(i).first().getAttackPts();
	    	}	
		return (int)((strenght*0.5+dexterity*0.3+speed*0.2+item_att_pts)*(XP/3));

	}

	public Knight(String alias, int power){
		super (alias);
		this.power = power;		
	}

	public void addPower(int power){
		this.power += power;
		if (this.power > 100)
			this.power = 100;
	}
}
