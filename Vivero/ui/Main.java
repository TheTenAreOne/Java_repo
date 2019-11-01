package ui;
import model.*;
import java.util.*;
public class Main{
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		Scanner scNum = new Scanner(System.in);
		
		System.out.println("Nombre del vivero:");
		String vivName = sc.nextLine();
		System.out.println("Direccion: ");
		String direc = sc.nextLine();
		
		Vivero vivero = new Vivero(vivName, direc);
		
		System.out.println("1: Agregar planta");
		System.out.println("2: Ver plantas");
		System.out.println("3: Ver frutas");
		System.out.println("4: Ver plantas que miden mas de 1 metro de altura");
		System.out.println("5: Salir");
		
		
		int type, heigth, price, menuOption;
		String name, fruitName;
		boolean onMenu = true;
		
		while(onMenu){
			menuOption = scNum.nextInt();
			switch(menuOption){
				case 1: 
				System.out.println("Tipo de planta: 1 Frutal / 2 Ornamental");
				type = scNum.nextInt();
				System.out.println("Nombre de planta: ");
				name = sc.nextLine();
				System.out.println("Precio: ");
				price = scNum.nextInt();
				if(type==1){
					System.out.println("Nombre de fruta: ");
					fruitName = sc.nextLine();
					System.out.println(vivero.addPlanta(name, price, fruitName));
				}else{
					System.out.println("Altura: ");
					heigth = scNum.nextInt();
					System.out.println(vivero.addPlanta(name, price, heigth));
				}
				break;
				case 2:
					System.out.println("Plantas: ");
					int pos = 1;
					for(int i = 0; i < Vivero.ROWS; i++){
						for(int k = 0; k < vivero.COLUMNS; k++){
							if(vivero.verifyPlanta(i,k)){
								System.out.println(pos+" "+vivero.getPlantName(i,k));
								System.out.println(vivero.getPlantCost(i,k));
								if(vivero.typeOfPlant(i,k))
									System.out.println(vivero.getPlantFruitName(i,k));
								else
									System.out.println(vivero.getPlantHeight(i,k));
							}
						}
					}
				break;
				case 3:
					System.out.println(vivero.fruitsInVivero());
				break;
				case 4:
					System.out.println(vivero.plantsOneMeterTall());
				break;
				case 5:
				System.exit(0);
				break;
			}
		}
	}
}