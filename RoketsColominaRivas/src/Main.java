import java.io.IOException;

import Keyboard.Keyboard;

public class Main {
	public static void main (String [] args) throws Exception {
		int circuitLength=1700;
		String circuitName="SeaFly";
		double circuitTime=28;
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);
		addRocketProba(circuit);
			for(int time=1; time<circuit.getTime()&& !(circuit.circuitFinished(time))&& circuit.rocketList.size()>0; time++) {
				System.out.println("klk");
				circuit.nextMovement(time);
			}
		

}
	
	public static void addRocketProba(Circuit circuit) throws Exception {
		Rocket r= new Rocket("Cacatua Espacial",4200);
		Propeller p1=new Propeller(10);
		Propeller p2=new Propeller(20);
		Propeller p3=new Propeller(50);

		r.addPropeller(p2);
		r.addPropeller(p1);
		r.addPropeller(p3);
		circuit.addRockets(r);

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
