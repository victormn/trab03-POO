import java.util.*;

public class Wizard extends Character{

	protected int wisdom;
	
	protected int getDefensePoints(){
		int item_def_pts = 0;

		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_def_pts += getInventory().getPair(i).first().getDefensePts();
	    	}
		return (int)((constitution*0.5+dexterity*0.3+speed*0.2+item_def_pts)*(XP/2)) + wisdom/2;

	}

	protected int getAttackPoints(){
		int item_att_pts = 0;
		
		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_att_pts += getInventory().getPair(i).first().getAttackPts();
	    	}	
		return (int)((strenght*0.5+dexterity*0.3+speed*0.2+item_att_pts)*(XP/3));

	}

	public Wizard(String alias, int wisdom){
		super(alias);		
		this.wisdom = wisdom;

	}

	public void addWisdom(int wisdom){
		this.wisdom += wisdom;
		if (this.wisdom > 100)
			this.wisdom = 100;
	}

}
