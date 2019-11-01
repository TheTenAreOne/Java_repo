package model;
public class Vivero{
	
	private String name;
	private String adress;
	private Planta plantas[][];
	public static final int ROWS = 12;
	public static final int COLUMNS = 6;
	
	public Vivero(String name, String adress){
		this.name = name;
		this.adress = adress;
		plantas = new Planta[ROWS][COLUMNS];
		
	}
	
	public String addPlanta(String name, int cost, String fruitName){
		String message = "Unable to add plant";
		boolean added = false;
		Planta frutal = new Frutal(name, cost, fruitName);
		for(int i = 0; i < ROWS && !added; i++){
			for(int k = 0; k < COLUMNS/2 && !added; k++){
				if(plantas[i][k]==null){
					plantas[i][k] = frutal;
					added = true;
					message = "Frutal plant added";
				}
			}
		}
		return message;
	}
	public String addPlanta(String name, int cost, double height){
		String message = "Unable to add plant";
		boolean added = false;
		Planta ornamental = new Ornamental(name, cost, height);
		for(int i = 6; i < ROWS && !added; i++){
			for(int k = 0; k < COLUMNS/2 && !added; k++){
				if(plantas[i][k]==null){
					plantas[i][k] = ornamental;
					added = true;
					message = "Ornamental plant added";
				}
			}
		}
		return message;
	}
	
	public String getPlantName(int row, int column){
		String message = "Invalid position";
		if(plantas[row][column]!=null)
			message = plantas[row][column].getName();
		return message;
	}
	
	public String getPlantCost(int row, int column){
		String message = "Invalid positon";
		if(plantas[row][column]!=null)
			message = ""+plantas[row][column].getCost();
		return message;
	}
	
	public String getPlantFruitName(int row, int column){
		String message = "Invalid position";
		if(plantas[row][column]!=null)
			message = (((Frutal)(plantas[row][column])).getFruitName());
		return message;
	}
	public String getPlantHeight(int row, int column){
		String message = "Invalid position";
		if(plantas[row][column]!=null)
			message = ""+(((Ornamental)(plantas[row][column])).getHeight());
		return message;
	}
	
	public String plantsOneMeterTall(){
		String message = "";
		for(int i = 0; i < ROWS; i++){
			for(int k = 0; k < COLUMNS; k++){
				if(plantas[i][k]!=null && plantas[i][k] instanceof Ornamental && ((Ornamental)plantas[i][k]).getHeight()>=1){
					message = ""+plantas[i][k].getName()+"\n";
				}
			}
		}
		return message;
	}
	
	public Planta searchPlant(String name){
		Planta planta = null;
		for(int i = 0; i < ROWS; i++){
			for(int k = 0; k < COLUMNS; k++){
				if(plantas[i][k]!=null && plantas[i][k].getName()==name){
					planta = plantas[i][k];
				}
			}
		}
		return planta;
	}
	
	public boolean verifyPlanta(int row, int column){
		boolean bool = false;
		if(plantas[row][column]!=null)
			bool = true;
		return bool;
	}
	
	public boolean typeOfPlant(int row, int column){
		boolean bool = false;
		if(plantas[row][column] instanceof Frutal)
			bool = true;
		return bool;
	}
	
	public String fruitsInVivero(){
		String frutas = "";
		for(int i = 0; i < ROWS; i++){
			for (int k = 0; k < COLUMNS; k++){
				if(plantas[i][k]!=null && plantas[i][k] instanceof Frutal){
					frutas += getPlantFruitName(i,k) + "\n";
				}
			}
		}
		if(frutas=="")
			frutas = "No hay frutas amiguito";
		return frutas;
	}
}