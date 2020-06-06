import java.io.IOException;

import Keyboard.Keyboard;

public class Main {
	public static void main (String [] args) throws Exception {
		int circuitLength=1700;
		String circuitName="SeaFly";
		double circuitTime=28;
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);
		
		
		System.out.println("Which will be the name of the rocket");
		String nameRocket=Keyboard.readString();	
		System.out.println("Which one will be the maximum capacity of the tank");
		int maxiCapacity=Keyboard.readInt();
		System.out.println("How many propellers will the rocket have? ");
		int numProp=Keyboard.readInt();
		circuit.addRockets(nameRocket,maxiCapacity);
		for(int x=0; x<numProp; x++) {
			System.out.println("Which will be the maximum acceleration of thr propeller number  "+(x+1)+"?");
			double maxAcceleration=Keyboard.readDouble();
			Propeller p=new Propeller(maxAcceleration);
			Circuit.addPropeller(p);
		}
		
		
		
		
		circuit.StartRace();
		

}
	
	
	
	
	
	
	
}
