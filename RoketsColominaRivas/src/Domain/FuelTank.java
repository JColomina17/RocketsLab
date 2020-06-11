package Domain;

public class FuelTank  {
    private double fuelLevel;
    private double maximumCapacity;
    
    public FuelTank(int maximumCapacity) throws Exception {
    	if(maximumCapacity<=0) throw new Exception("Error:The maximum capacity cannot be lower than 0 ");
        this.maximumCapacity=maximumCapacity;
        this.fuelLevel=maximumCapacity;
    }

	public double calculateTank (double velocity) throws Exception {
        fuelLevel = fuelLevel - (0.02*Math.pow(velocity, 2));
        if(fuelLevel<0) {
        	fuelLevel=0;
        	
        	throw new Exception("Empty tank");

        }
        else {
        return Math.round(fuelLevel);}
    }
	
	public double getMaximumCapacity() {return this.maximumCapacity;}
    
   

	
}