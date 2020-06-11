package Domain;
import java.util.*;

import Application.DTO.RocketDTO;
import Keyboard.Keyboard;
import Observer.ObserverCircuit;
import Observer.ObserverRocket;

public class Rocket {
	List<Propeller> propelerList = new ArrayList<Propeller> ();
	private FuelTank fuelTank;
	private String name;
	private double speed;
	private double time;
	private double distance;
	private double Acceleration;
	private  ObserverRocket observer;
	int Strategy; //1 FOR SMALL 2 FOR MEDIUM 3 FOR LARGE
	
	public Rocket() {
		
	}
	public Rocket(String name,int maxiCapacity) throws Exception {
		this.name=name;
		propelerList = new ArrayList<Propeller> ();
		this.distance=0;
		this.fuelTank= new FuelTank(maxiCapacity);
		this.speed=0;
		this.time=0;
	}
	
	public Rocket(RocketDTO rocketDTO) throws Exception {
		if(rocketDTO==null)
			throw new Exception();
		name=rocketDTO.getName();
		time=rocketDTO.getTime();
		
		
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
	public double getTime() {
	return time;	
	}
	public void setTime(double time) {
		this.time=time;
	}
	
	public double calculateSpeed(double time) {
		
		speed= this.speed +(this.getAcceleration()*time);
		observer.updatespeed(speed);
		return speed;
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
		switch(Strategy) {
		case 1: StrategySmallCircuit(); break;
		case 2:StrategyMediumCircuit(); break;
		case 3:StrategyLargeCircuit(); break;

		}
		infoRocket(time);
		
		}
	
	public void changeAcceleration(double howMuch) throws Exception {
		double aux=howMuch;
		for(Propeller p : propelerList) {
			p.setAcceleration(0);
		}
		
		for(Propeller p : propelerList) {
			if(aux!=0) aux=p.setAcceleration(aux);
			
		}
		}
	
	
	
	public void infoRocket(double time) {
		try {
			observer.updateRace("The rocket "+this.name+" has a speed of "+ this.calculateSpeed(time) +", with an acceleration of "+ this.getAcceleration()+ " a distance traveled of "+this.calculateDistancecovered(this.speed, time) +" and still has in its tank "+ this.calculateTank()+"/"+this.fuelTank.getMaximumCapacity());
		} catch (Exception e) {
			observer.updateRace("The rocket "+this.name+" has no fuel");
			observer.updateFuel();
		}
	}
	
	
	
	public void Strategy(int circuitLength, double circuitTime) {
		
		double proportion=circuitLength/circuitTime;
		
		if(proportion>0 && proportion<33) {
			this.Strategy=1;
		}
		else {
			if(proportion>33 && proportion<66) {
				this.Strategy=2;
			}
			else {
				this.Strategy=3;

			}
		}
		
	}
	

	
	private void StrategyLargeCircuit() throws Exception {
		if(this.getAcceleration()==0) changeAcceleration(this.getMaxAcc()*0.2);
		changeAcceleration(this.getAcceleration()+this.getMaxAcc()*0.1);
	}
	
	private void StrategyMediumCircuit() throws Exception {
		if(this.getAcceleration()==0) changeAcceleration(this.getMaxAcc()*0.5);	
		changeAcceleration(this.getAcceleration()+this.getMaxAcc()*0.1);
	}
	
	private void StrategySmallCircuit() throws Exception {
		if(this.getAcceleration()==0) changeAcceleration(this.getMaxAcc()*0.75);	
		changeAcceleration(this.getAcceleration()+this.getMaxAcc()*0.05);

	}
	
	public void updateRocket(RocketDTO dto) throws Exception{
		if(dto==null)
			throw new Exception();
		name=dto.getName();
		time=dto.getTime();
		
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