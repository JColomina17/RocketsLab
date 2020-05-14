
public class Fuel  {
    private double fuelLevel;
    private double maximumCapacity;
    
    public Fuel(int maximumCapacity) {
        this.maximumCapacity=maximumCapacity;
        this.fuelLevel=maximumCapacity;
    }

	public double calculateTank (double velocity) {
        fuelLevel = fuelLevel - (0.02*Math.pow(velocity, 2));
        return fuelLevel;
    }
    
    public boolean emptyTank() {
        if(this.fuelLevel==0) return true;
         return false;
    }

	
}