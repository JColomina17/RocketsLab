import java.io.IOException;

import Keyboard.Keyboard;

public class Main {
	public static void main (String [] args) throws Exception {
		int circuitLength=1700;
		String circuitName="SeaFly";
		double circuitTime=28;
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);
		addRockets(circuit);
		while(circuit.circuitFinished()) {
			for(int time=0; time<circuit.getTime(); time++) {
				
			}
		}

}
	
	public static void addRockets(Circuit circuit) throws Exception {
		boolean Continue=true;
		while(Continue) {
		System.out.println("Com es dira el rocket?");
		String nameRocket=Keyboard.readString();	
		System.out.println("Quina sera la capacitat maxima del combustible?");
		int maxiCapacity=Keyboard.readInt();
		
		Rocket r= new Rocket(nameRocket,maxiCapacity);
		
		System.out.println("Cuants propulsors tindra el rocket?");
		int numProp=Keyboard.readInt();
		for(int x=0; x<numProp; x++) {
			System.out.println("Quina sera l'acceleració maxima del propulsor numero "+(x+1)+"?");
			double maxAcceleration=Keyboard.readDouble();
			Propeller p=new Propeller(maxAcceleration);
			r.addPropeller(p);
		}
			
		System.out.println("Vols afeguir un altre rocket s o n?");
		char option=Keyboard.readChar();
		if(option=='n') Continue=false;
		
		circuit.addRockets(r);

		}
		
		
	}
	
	
}
