// classe craiada para simular um pair

import java.util.*;

public class Pair<T, U>{

	private T first;
	private U second;

	public Pair(T first, U second){
		this.first = first;
		this.second = second;
	}

	public T first(){
		return first;
	}
	public U second(){
		return second;
	}

	public void setFirst(T first){
		this.first = first;
	}	

	public void setSecond(U second){
		this.second = second;
	}
}




// classe craiada para simular um pair
/*
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
}*/