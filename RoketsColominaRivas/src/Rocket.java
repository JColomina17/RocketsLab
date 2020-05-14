import java.util.*; 

public class Rocket {
	private Propeller propelerList[];
	private Fuel fuel;
	private String name;
	private double speed;
	
	public Rocket(String name,int maxiCapacity) {
		this.name=name;
		propelerList = new Propeller[3];
		this.fuel= new Fuel(maxiCapacity);
		this.speed=0;
	}
	
	public void increaseAcceleration(double hm) {
		for(int x=0;x<3 && hm>=0;x++) {
			hm=propelerList[x].increaseAcceleration(hm);
		}
	}
	
	public void decreaseAcceleration(double hm) {
		for(int x=0;x<3 && hm>=0;x++) {
			hm=propelerList[x].decreaseAcceleration(hm);
		}
		}
	
	public double getAcceleration() {
		double acceleration=0;
		
		for(int x=0;x<3;x++) {
			acceleration+=propelerList[x].getAcceleration();
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
	
	
	public double calculateSpeed() {
		return  this.fuel.calculateTank(this.speed);
	}
	
	public String getName() {return this.name;}
}