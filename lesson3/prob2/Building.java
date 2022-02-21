package lesson3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {

	private double maintenanceCost;
	private List<Apartment> apartments =  new ArrayList<Apartment>();
	
	public Building( double cost, double rent) {
		
		apartments.add(new Apartment(rent));
		this.maintenanceCost = cost;
		
	}


	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}
	
	public void addApartment(Apartment a) {
		apartments.add(a);
	}
	
	public double calcuProfit() {
		
		double rent = 0;
		for(Apartment p : this.apartments)
			rent += p.getRent();
		
		return rent - maintenanceCost;
		
	}
	
}
