package model;
public class Frutal extends Planta implements Flowering{
	
	private String fruitName;
	
	public Frutal(String name, int cost, String fruitName){
		super(name,cost);
		this.fruitName = fruitName;
	}
	public String getFruitName(){
		return fruitName;
	}
	
	@Override
	public String nextFlowering(int sowingMonth, int sowingYear, int todayMonth, int todayYear){
		String floweringTime;
		int floweringMonth = sowingMonth;
		int floweringYear = sowingMonth;
		int monthStack = 8;
		
		while(monthStack!=0){
			if(floweringMonth<=12){
				floweringMonth++;
				monthStack--;
			}else if(floweringMonth==12){
				floweringYear++;
			}else{
				floweringMonth++;
			}
		}
		floweringTime = "Month: "+floweringMonth+"/Year: "+floweringYear;
		
		return floweringTime;
		// 1 2 3 4 5 6 7 8 9 /10 11 12   1 2 /3 4 5 6 7 8 9 10 11 12
	}
}