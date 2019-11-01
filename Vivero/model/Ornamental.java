package model;
public class Ornamental extends Planta{
	private double height;
	
	public Ornamental(String name, int cost,double height){
		super(name,cost);
		this.height = height;
	}
	
	public double getHeight(){
		return height;
	}
}