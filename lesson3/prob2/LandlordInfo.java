package lesson3.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
	
	private List<Building> buildings ;
	
	public LandlordInfo() {
		buildings = new ArrayList<Building>();
	}

	public void addBuilding(Building b) {
		buildings.add(b);
	}
	
	public double calcProfits() {
		
		double profit = 0;
		for(Building b : this.buildings)
			profit += b.calcuProfit();
		
		return profit;
	}
}
