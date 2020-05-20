	import java.util.ArrayList;
import java.util.Iterator;

import Keyboard.Keyboard;
	
	public class Circuit {
		
	private int circuitLength;
	private String circuitName;
	private double circuitTime;
	public static ArrayList<Rocket> rocketList;
	
	public Circuit(int circuitLength,String circuitName, double circuitTime ) {
		this.circuitLength=circuitLength;
		this.circuitName=circuitName;
		this.circuitTime=circuitTime;
		this.rocketList = new ArrayList<Rocket> ();
	}
	
	
	public void nextMovement(int time) {
		for (Rocket r : rocketList) {
			System.out.println("What does the rocket "+r.getName()+" want");
        	try {
				r.nextMovement(time);
			} catch (Exception e) {
	        	System.out.println("The rocket "+r.getName() +" has no fuel left");
	        	rocketList.remove(r);
			}
		}
        	
        }
	
	
	public void infoRocket(double time) {
		for (Rocket r : rocketList) r.infoRocket(time);
		
	}
	
	public boolean circuitFinished(double time) {
		if(this.rocketList.size()==0) {
			System.out.print("There's no winner");
			return true;}
		
		for (Rocket r : rocketList) {
			double distance= r.getDistancecovered();
        	if(distance>=this.circuitLength){
        		System.out.println("And the winner is: "+ r.getName() +" with a time of "+time);
        		return true;
        	}
		}
		

		
		return false;
		
	}
	
	
	
	public double getTime() {
		return this.circuitTime;
	}
	public static void addRockets() throws Exception {
			
			System.out.println("Which will be the name of the rocket");
			String nameRocket=Keyboard.readString();	
			System.out.println("Which one will be the maximum capacity of the tank");
			int maxiCapacity=Keyboard.readInt();
			
			Rocket r= new Rocket(nameRocket,maxiCapacity);
			
			addPropellers(r);
			rocketList.add(r);
		
			System.out.println("Do you want to add another rocket to the race? Y/N");
			char option=Keyboard.readChar();
			if(option=='Y') addRockets();
	
			
		}
		
		public static void addPropellers(Rocket r) throws Exception {
			System.out.println("How many propellers will the rocket have? ");
			int numProp=Keyboard.readInt();
			for(int x=0; x<numProp; x++) {
				System.out.println("Which will be the maximum acceleration of thr propeller number  "+(x+1)+"?");
				double maxAcceleration=Keyboard.readDouble();
				Propeller p=new Propeller(maxAcceleration);
				r.addPropeller(p);
			}
		}
		
	



}
