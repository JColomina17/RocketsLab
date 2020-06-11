package Domain;
import java.util.*;

import Keyboard.Keyboard;
import Observer.ObserverCircuit;
import Observer.ObserverRocket;

public class Rocket {
	List<Propeller> propelerList = new ArrayList<Propeller> ();
	private FuelTank fuelTank;
	private String name;
	private double speed;
	private double distance;
	private double MaxAcceleration;
	private  ObserverRocket observer;
	public Rocket(String name,int maxiCapacity) throws Exception {
		this.name=name;
		propelerList = new ArrayList<Propeller> ();
		this.distance=0;
		this.fuelTank= new FuelTank(maxiCapacity);
		this.speed=0;
	
	}
	public void addObserver(ObserverRocket ob) {
		this.observer=ob;
	}
	public ObserverRocket getObserver() {
		return this.observer;
	}
	public void addPropeller(Propeller p) {
		this.propelerList.add(p);
	}
	public double getMaxTank() {
		return this.fuelTank.getMaximumCapacity();
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
		observer.updatespeed(speed);
	}
	
	public double calculateDistancecovered(double V0, double time) {
			
		this.distance+= V0 + (this.speed*time) + 1/2*this.getAcceleration()*Math.pow(time, 2);
		observer.updatedistance(distance);
		return this.distance;
		}
	
	public double getDistancecovered() {
		return this.distance;
	}
	
	public double calculateTank() throws Exception {
		double fuelTank=this.fuelTank.calculateTank(this.speed);
		observer.updatefuelTank(fuelTank);
		return  fuelTank;
	}
	
	/////////MOVIMIENTO//////////
	public void nextMovement(double time) throws Exception {
		
		//PONER LOS PROPELLERS EN LA ACC
		calculateAll(time);
		
		}
	
	public void changeAcceleration(double hm, boolean increase) {
			
			//IMPLEMENTAR
			
		}
	
	///////////////////////////
	
	public void calculateAll(double time) throws Exception {
		 this.calculateSpeed(time);
		 this.calculateTank();
		 this.infoRocket(time);
	}
	public void infoRocket(double time) {////////MIRAR 
		try {
			observer.updateRace("The rocket "+this.name+" has a speed of "+this.getSpeed()+", with an acceleration of "+ this.getAcceleration()+ " a distance traveled of "+this.calculateDistancecovered(this.speed, time) +" and still has in its tank "+ this.calculateTank()+"/"+this.fuelTank.getMaximumCapacity());
		} catch (Exception e) {
			observer.updateRace("The rocket "+this.name+" has no fuel");
			
		}
	}
	
	public void Strategy(int circuitLength, double circuitTime) {
		MaxAcceleration=chooseStrategy(circuitLength, circuitTime, getMaxAcc());
	}
	
	private double chooseStrategy(int circuitLength, double circuitTime,double maxAcceleration) {
		double velocity,initialVelocity, metrmeterstraveled,fuelLevel;
		initialVelocity=0;
		metrmeterstraveled=0;
		fuelLevel=this.fuelTank.getMaximumCapacity();
		for(int time=0; time<circuitTime;time++) {
			velocity=initialVelocity+maxAcceleration*time;
			metrmeterstraveled=(metrmeterstraveled+velocity*time)+(1/2*maxAcceleration)*(Math.pow(time, 2));
			fuelLevel-=0.02*Math.pow(velocity, 2);
			
				if(metrmeterstraveled>circuitLength) {
					return maxAcceleration;
				}
				else { 
					if(fuelLevel<=0) {
						return chooseStrategy(circuitLength,circuitTime,maxAcceleration-1);
					}
		}
		}
		return 0;
	}
	public double getMaxAcc() {
		double maxAc=0;
		for(Propeller p: propelerList) {
			maxAc+=p.getMaxAcceleration();
		}
		return maxAc;
	}
	
	public String getName() {return this.name;}
}