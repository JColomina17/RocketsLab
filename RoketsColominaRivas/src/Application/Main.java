package Application;
import java.io.IOException;

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
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);
		boolean repeat=true;
		while(repeat) {
			//Rocket
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
		
		ObserverCircuit observerCircuit=new ObserverCircuit(circuit);
		
		
		circuit.addObserver(observerCircuit);
		circuit.StartRace();
		
		System.out.println(observerCircuit.raceStatus);
    	System.out.println("And the winner is: "+ observerCircuit.winner +" with a time of "+observerCircuit.time);
		

}
	
	
	
	
	
	
	
}
