import java.io.IOException;

import Keyboard.Keyboard;

public class Main {
	public static void main (String [] args) throws Exception {
		int circuitLength=100000000;
		String circuitName="SeaFly";
		double circuitTime=10000000;
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);
		addRockets(circuit);
			for(int time=1; time<circuit.getTime()&& !(circuit.circuitFinished(time))&& circuit.rocketList.size()>0; time++) {
				circuit.nextMovement(time);
			}
		

}
	
	
	
	public static void addRockets(Circuit circuit) throws Exception {
		boolean Continue=true;
		while(Continue) {
		System.out.println("Which will be the name of the rocket");
		String nameRocket=Keyboard.readString();	
		System.out.println("Which one will be the maximum capacity of the tank");
		int maxiCapacity=Keyboard.readInt();
		
		Rocket r= new Rocket(nameRocket,maxiCapacity);
		
		System.out.println("How many propellers will the rocket have? ");
		int numProp=Keyboard.readInt();
		for(int x=0; x<numProp; x++) {
			System.out.println("Which will be the maximum acceleration of thr propeller number  "+(x+1)+"?");
			double maxAcceleration=Keyboard.readDouble();
			Propeller p=new Propeller(maxAcceleration);
			r.addPropeller(p);
		}
			
		System.out.println("Do you want to add another rocket to the race? Y/N");
		char option=Keyboard.readChar();
		if(option=='N') Continue=false;
		
		circuit.addRockets(r);

		}
		
		
	}
	
	
}
