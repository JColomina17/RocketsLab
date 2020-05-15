import java.util.*; 

public class Rocket {
	List<Propeller> propelerList = new ArrayList<Propeller> ();
	private Fuel fuel;
	private String name;
	private double speed;
	
	public Rocket(String name,int maxiCapacity) throws Exception {
		this.name=name;
		propelerList = new ArrayList<Propeller> ();

		this.fuel= new Fuel(maxiCapacity);
		this.speed=0;
	}
	
	public void increaseAcceleration(double hm) {
        Iterator<Propeller> it = propelerList.iterator(); 
        while(it.hasNext() && hm>0) {
        	it.next();
    		hm=((Propeller) it).increaseAcceleration(hm);

        }
		
	}
	
	public void decreaseAcceleration(double hm) {
		Iterator<Propeller> it = propelerList.iterator(); 
        while(it.hasNext() && hm>0) {
        	it.next();
    		hm=((Propeller) it).decreaseAcceleration(hm);
        }
        
		}
	
	public double getAcceleration() {
		double acceleration=0;
		
		Iterator<Propeller> it = propelerList.iterator(); 
        while(it.hasNext()) {
        	it.next();
        	acceleration+=((Propeller)it).getAcceleration();
        }
		
		return acceleration;
	}
	public double getSpeed() {
		return this.speed;
		
	}
	public void calculateSpeed(double time) {
		
		speed= this.speed +(this.getAcceleration()*time);
		
	}
	
	public double distancecovered(double V0, double time) {
			
		return V0 + (this.speed*time) + 1/2*this.getAcceleration()*Math.pow(time, 2);

		}
	
	
	public double calculateTank() throws Exception {
		return  this.fuel.calculateTank(this.speed);
	}
	
	public String getName() {return this.name;}
}