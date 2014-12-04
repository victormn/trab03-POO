import java.util.*;

public enum Color {

	blue ("blue"),
	red ("red"),
	green ("green"),
	yellow ("yellow"),
	white ("white"),
	black ("black");

	private String color;
	
	private Color(String color){
		this.color = color;
	}
	
	public String getColor(){
		return color;
	}
}
