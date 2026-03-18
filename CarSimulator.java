// Fuel Gauge class
class FuelGauge {
	// Private fields
	private double currentGallons; // Current fuel in the gas tank
	private final double MAX_CAPACITY = 15.0; // The tank cannot hold more than 15 gallons
	
	public FuelGauge() {
		this.currentGallons = 0.0;
	}
	
	public FuelGauge(double currentGallons) {
		this.currentGallons = currentGallons;
	}
	
	// Getter methods
	public double getFuel() {
		return currentGallons;
	}
	
	// Setter methods
	// Adds fuel but never exceeds MAX_CAPACITY
	public void addFuel(double amount) {
		if (this.currentGallons < MAX_CAPACITY) {
			this.currentGallons += amount;
		}
	}
	
	// Decrements currentGallons by 0.1 gallons
	public void useFuel() {
		if (currentGallons > 0) {
			currentGallons -= 0.1;
		}
	}
}

// Odometer class
class Odometer {
	// Private fields
	private int mileage; // Current total miles traveled
	private int milesSinceLastFuelDrop; // Counter to track when to drop fuel level

	FuelGauge myTank; // Reference to a FuelGauge object.
	
	public Odometer() {
		this.mileage = 0;
		this.milesSinceLastFuelDrop = 0;
	}
	
	public Odometer(FuelGauge gauge) {
		this.myTank = gauge;
	}
	
	// Getter methods
	// Return current mileage
	public int getMileage() {
		return mileage;
	}
	
	// Setter methods
	public void drive() {
		if (myTank.getFuel() > 0) {
			mileage++;
			milesSinceLastFuelDrop++;
			if (milesSinceLastFuelDrop == 24) {
				myTank.useFuel();
				milesSinceLastFuelDrop = 0;
			}
		} else {
			System.out.println("Out of gas! Total mileage: " + mileage);
		}
	}

}

public class CarSimulator {

	public static void main(String[] args) {
		
		// Fuel Gauge Object
		FuelGauge tank = new FuelGauge(0.5);
		
		// Odometer Object
		Odometer dashboard = new Odometer(tank);
		
		while (tank.getFuel() > 0) {
			dashboard.drive();
			System.out.printf("Mile: %d | Fuel: %.1fg%n", dashboard.getMileage(), tank.getFuel());
		}
	}

}
