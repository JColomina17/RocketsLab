
public class Fuel  {
    private double fuelLevel;
    private double maximumCapacity;
    
    public Fuel(int maximumCapacity) throws Exception {
    	if(maximumCapacity<=0) throw new Exception("Error: La capacitat maxima no pot ser 0 o inferior.");
        this.maximumCapacity=maximumCapacity;
        this.fuelLevel=maximumCapacity;
    }

	public double calculateTank (double velocity) throws Exception {
        fuelLevel = fuelLevel - (0.02*Math.pow(velocity, 2));
        if(fuelLevel<0) {
        	fuelLevel=0;
        	throw new Exception("Tanc buid");

        }
        else {
        return fuelLevel;}
    }
    
   

	
}