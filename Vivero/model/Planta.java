package model;

public abstract class Planta{
	
	private String name;
	private int cost;
	
	public Planta(String name, int cost){
		this.name = name;
		this.cost = cost;
	}
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}
}

