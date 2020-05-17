import java.util.*;

import Keyboard.Keyboard;

public class Rocket {
	List<Propeller> propelerList = new ArrayList<Propeller> ();
	private Fuel fuel;
	private String name;
	private double speed;
	private double distance;
	
	public Rocket(String name,int maxiCapacity) throws Exception {
		this.name=name;
		propelerList = new ArrayList<Propeller> ();
		this.distance=0;
		this.fuel= new Fuel(maxiCapacity);
		this.speed=0;
	}
	
	public void addPropeller(Propeller p) {
		this.propelerList.add(p);
	}
	
	public void increaseAcceleration(double hm) {
        Iterator<Propeller> it = propelerList.iterator(); 
        while(it.hasNext() && hm>0) {
        	Propeller p=it.next();
    		hm=p.increaseAcceleration(hm);

        }
        if(hm<0) System.out.println("Maximum power already reached");
		
	}
	
	public void decreaseAcceleration(double hm) {
		Iterator<Propeller> it = propelerList.iterator(); 
        while(it.hasNext() && hm>0) {
        	Propeller p=it.next();

    		hm=p.decreaseAcceleration(hm);
        }
        
		}
	
	public double getAcceleration() {
		double acceleration=0;
		
		Iterator<Propeller> it = propelerList.iterator(); 
        while(it.hasNext()) {
        	Propeller p=it.next();
        	acceleration+=p.getAcceleration();
        }
		
		return acceleration;
	}
	public double getSpeed() {
		return this.speed;
		
	}
	public void calculateSpeed(double time) {
		
		speed= this.speed +(this.getAcceleration()*time);
		
	}
	
	public double calculateDistancecovered(double V0, double time) {
			
		this.distance+= V0 + (this.speed*time) + 1/2*this.getAcceleration()*Math.pow(time, 2);
		return this.distance;
		}
	
	public double getDistancecovered() {
		return this.distance;
	}
	
	public double calculateTank() throws Exception {
		return  this.fuel.calculateTank(this.speed);
	}
	
	public void nextMovement(int time) throws Exception {
		int option;
		double aux;
		System.out.println("Press 1 to accelerate and 2 to stop");
		option=Keyboard.readInt();
		switch(option) {
		  case 1:
			  System.out.println("How much do you want to accelerate");
			  aux=Keyboard.readDouble();
			  this.increaseAcceleration(aux);
			  
			  break;
		  case 2:
			  System.out.println("How much do you want to decrease");
			  aux=Keyboard.readDouble();
			  this.decreaseAcceleration(aux);
			  break;
		}
		
		 this.calculateSpeed(time);
		 this.calculateTank();
		 this.infoRocket(time);
		}
	public void infoRocket(double time) {
		try {
			System.out.println("The rocket "+this.name+" te una velocitat de "+this.getSpeed()+", with an acceleration of "+ this.getAcceleration()+ " a distance traveled of "+this.calculateDistancecovered(this.speed, time) +" and still has in its tank "+ this.calculateTank()+"/"+this.fuel.getMaximumCapacity());
		} catch (Exception e) {
			System.out.println("The rocket "+this.name+" has no fuel");
		}
	}
	
	
	
	
	public String getName() {return this.name;}
}