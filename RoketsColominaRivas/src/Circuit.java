	import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Keyboard.Keyboard;
	
	public class Circuit {
		
	private int circuitLength;
	private String circuitName;
	private double circuitTime;
	private static  Rocket Rocket;
	
	public Circuit(int circuitLength,String circuitName, double circuitTime ) throws Exception {
		this.circuitLength=circuitLength;
		this.circuitName=circuitName;
		this.circuitTime=circuitTime;

	}
	
	 
	 public void StartRace() throws Exception {
		for(double time=1; endCircuit(time); time++) {
			this.nextMovement(time);
		}
	
	}
	
	
	private boolean endCircuit(double time) {
		
		return time>this.getTime() && !(this.circuitFinished(time));
	}

	public void nextMovement(double time) throws Exception {
		
		Rocket.nextMovement(time);
        }
	
	
	public void infoRocket(double time) {
		Rocket.infoRocket(time);
		
	}
	
	public boolean circuitFinished(double time) {
		
			double distance= Rocket.getDistancecovered();
        	if(distance>=this.circuitLength){
        		System.out.println("And the winner is: "+ Rocket.getName() +" with a time of "+time);
        		return true;
        	}
		
		

		
		return false;
		
	}
	
	
	
	public double getTime() {
		return this.circuitTime;
	}
	
		
		public static void addPropeller(Propeller p) throws Exception {
			
				Rocket.addPropeller(p);
			
		}

		public void addRockets(String nameRocket, int maxiCapacity) throws Exception {
			this.Rocket = new Rocket(nameRocket,maxiCapacity);
			
		}
		
	



}
