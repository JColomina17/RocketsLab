package Application;

import Domain.Circuit;
import Domain.Propeller;
import Domain.Rocket;
import Keyboard.Keyboard;
import Observer.ObserverCircuit;
import Observer.ObserverRocket;

public class Main {
	public static void main (String [] args) throws Exception {

		int circuitLength=1700;
		String circuitName="SeaFly";
		double circuitTime=28;
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);//Rocket
			
		
		ObserverCircuit observerCircuit=new ObserverCircuit(circuit);
		circuit.addObserver(observerCircuit);
		
		createRockets(circuit);
		
		circuit.StartRace();
		
		System.out.println(observerCircuit.raceStatus.substring(4));
		if(observerCircuit.winner!="") {
	    	System.out.println("And the winner is: "+ observerCircuit.winner +" with a time of "+observerCircuit.time);

		}
		

}
	
	
	
	
	public static void create(Circuit circuit) throws Exception {
		Rocket r=new Rocket("Speedy 1",2000);

		r.addPropeller(new Propeller(10));
		r.addPropeller(new Propeller(30));
		r.addPropeller(new Propeller(50));
		r.addObserver(new ObserverRocket(r));
	
		Rocket r2=new Rocket("Speedy 2",4000);
		circuit.addRockets(r);

		r2.addPropeller(new Propeller(10));
		r2.addPropeller(new Propeller(50));
		r2.addPropeller(new Propeller(70));
		r2.addObserver(new ObserverRocket(r));
		circuit.addRockets(r2);

	}
	public static void createRockets(Circuit circuit) throws Exception {
		boolean repeat=true;
		while(repeat) {
		
		//Rockets
		System.out.println("Which will be the name of the rocket");
		String nameRocket=Keyboard.readString();	
		System.out.println("Which one will be the maximum capacity of the tank");
		int maxiCapacity=Keyboard.readInt();
		Rocket r= new Rocket(nameRocket,maxiCapacity);

		//Propellers
		System.out.println("How many propellers will the rocket have? ");
		int numProp=Keyboard.readInt();
		for(int x=0; x<numProp; x++) {
			System.out.println("Which will be the maximum acceleration of thr propeller number  "+(x+1)+"?");
			double maxAcceleration=Keyboard.readDouble();
			Propeller p=new Propeller(maxAcceleration);
			r.addPropeller(p);
		}
		
		r.addObserver(new ObserverRocket(r));
		circuit.addRockets(r);

		System.out.print("Do you want to add other Rocket? y o n");
		char option=Keyboard.readChar();
		if(option=='n') repeat=false;
		
	}
		}
	
	
	
	
}
