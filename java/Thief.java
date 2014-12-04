import java.util.*;

public class Thief extends Character{

	protected int stealth;
	
	protected int getDefensePoints(){
		int item_def_pts = 0;

		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_def_pts += getInventory().getPair(i).first().getDefensePts();
	    	}
		return (int)((constitution*0.5+dexterity*0.3+speed*0.2+item_def_pts)*(XP/2));

	}

	protected int getAttackPoints(){
		int item_att_pts = 0;
		
		for (int i=0; getInventory().searchItem(i) != null; i++) {
			if (getInventory().getPair(i).second())
				item_att_pts += getInventory().getPair(i).first().getAttackPts();
	    	}	
		return (int)((strenght*0.5+dexterity*0.3+speed*0.2+item_att_pts)*(XP/3)) + stealth;

	}

	public Thief(String alias, int stealth){
		super(alias);		
		this.stealth = stealth;

	}

	public void addStealth(int stealth){
		this.stealth += stealth;
		if (this.stealth > 100)
			this.stealth = 100;
	}

}
