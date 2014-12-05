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
		return item;
	}
	public U second(){
		return bool;
	}

	public void setFirst(T first){
		this.first = first;
	}	

	public void setSecond(U second){
		this.second = second;
	}
}
