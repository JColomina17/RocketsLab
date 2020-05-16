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
        if(hm<0) System.out.println("Potencia Maxima del coet");
		
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
		System.out.println("1 per accelerar 2 per frenar");
		option=Keyboard.readInt();
		switch(option) {
		  case 1:
			  System.out.println("Quant vols accelerar?");
			  aux=Keyboard.readDouble();
			  this.increaseAcceleration(aux);
			  
			  break;
		  case 2:
			  System.out.println("Quant vols disminuir?");
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
			System.out.println("El rocket "+this.name+" te una velocitat de "+this.getSpeed()+", amb una acceleracio de "+ this.getAcceleration()+ " amb una distancia correguda de "+this.calculateDistancecovered(this.speed, time) +" i li queda al diposit: "+ this.calculateTank()+"/"+this.fuel.getMaximumCapacity());
		} catch (Exception e) {
			System.out.println("El rocket "+this.name+" s'ha quedad sense gasolina");
		}
	}
	
	
	
	
	public String getName() {return this.name;}
}