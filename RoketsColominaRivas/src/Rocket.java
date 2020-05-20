import java.util.*;

import Keyboard.Keyboard;

public class Rocket {
	List<Propeller> propelerList = new ArrayList<Propeller> ();
	private FuelTank fuelTank;
	private String name;
	private double speed;
	private double distance;
	
	public Rocket(String name,int maxiCapacity) throws Exception {
		this.name=name;
		propelerList = new ArrayList<Propeller> ();
		this.distance=0;
		this.fuelTank= new FuelTank(maxiCapacity);
		this.speed=0;
	}
	
	public void addPropeller(Propeller p) {
		this.propelerList.add(p);
	}
	
	public void changeAcceleration(double hm, boolean increase) {
		
		for (Propeller p : propelerList) {
			if(hm>0)
			if(increase) hm=p.increaseAcceleration(hm);
			else hm=p.decreaseAcceleration(hm);

		}

        if(hm>0) System.out.println("Maximum power already reached");
		
	}
	
	
	public double getAcceleration() {
		double acceleration=0;
		for (Propeller p : propelerList) {
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
		return  this.fuelTank.calculateTank(this.speed);
	}
	
	public void nextMovement(int time) throws Exception {
		int option;
		double aux;
		System.out.println("Press 1 to accelerate, 2 to stop and 3 to continue");
		option=Keyboard.readInt();
		switch(option) {
		  case 1:
			  System.out.println("How much do you want to accelerate");
			  aux=Keyboard.readDouble();
			  this.changeAcceleration(aux,true);
			  
			  break;
		  case 2:
			  System.out.println("How much do you want to decrease");
			  aux=Keyboard.readDouble();
			  this.changeAcceleration(aux,false);
			  break;
		  case 3: break;
			  
		}
		calculateAll(time);
		
		}
	
	public void calculateAll(double time) throws Exception {
		 this.calculateSpeed(time);
		 this.calculateTank();
		 this.infoRocket(time);
	}
	public void infoRocket(double time) {
		try {
			System.out.println("The rocket "+this.name+" has a speed of "+this.getSpeed()+", with an acceleration of "+ this.getAcceleration()+ " a distance traveled of "+this.calculateDistancecovered(this.speed, time) +" and still has in its tank "+ this.calculateTank()+"/"+this.fuelTank.getMaximumCapacity());
		} catch (Exception e) {
			System.out.println("The rocket "+this.name+" has no fuel");
			
		}
	}
	
	
	
	
	public String getName() {return this.name;}
}