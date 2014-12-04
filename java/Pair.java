// classe craiada para simular um pair

import java.util.*;

public class Pair{

	private Item item;
	private boolean bool;

	public Pair(Item item, boolean bool){
		this.item = item;
		this.bool = bool;
	}

	public Item first(){
		return item;
	}
	public boolean second(){
		return bool;
	}
	public void setSecond(boolean bool){
		this.bool = bool;
	}
}
