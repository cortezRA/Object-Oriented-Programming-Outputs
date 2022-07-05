package bikeproject;

import java.util.ArrayList;
import java.util.Random;

public class BikeList {
	
	static void fillArray(ArrayList<Bike> allBikes) {
		Random rand = new Random(); //instance of random class
		
		for(int i = 0; i < 10; i++) {
			int bikeType = rand.nextInt(2);
			
			if(bikeType < 1) {
				allBikes.add(new MountainBike());
			} else {
				allBikes.add(new RoadBike());
			}
		}//end for loop
	}//end method fillArray
	
	static void displayStock(ArrayList<Bike> allBikes) {
		for(Bike newBike: allBikes) {
			newBike.printDescription();
		}//end for loop
		System.out.println();
	}//end method displayStock
	
	static int calculateStock(ArrayList<Bike> allBikes) {
		int bikesSold = 0;
		for(Bike newBike: allBikes) {
			if(newBike instanceof MountainBike) {
				bikesSold++;
			}
		}//end for loop
		
		return bikesSold;
	}//end method calculateStock
	
	static void displayBikeNumbers(ArrayList<Bike> allBikes) {
		int mb = calculateStock(allBikes);
		int rb = allBikes.size() - mb;
		
		System.out.println("Stock Levels");
		System.out.println("We have " + mb + " Mountain Bikes in stock");
		System.out.println("We have " + rb + " Road Bikes in stock");
	}//end method displayBikeNumbers
	
	public static void main(String[] args) {
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		
		int mountainBikeSales = 0;
		int roadBikeSales = 0;
		
		fillArray(bikes);
		displayStock(bikes);
		displayBikeNumbers(bikes);
		
	}//end method main
	
}//end class BikeList