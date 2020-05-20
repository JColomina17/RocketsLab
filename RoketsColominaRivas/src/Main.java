import java.io.IOException;

import Keyboard.Keyboard;

public class Main {
	public static void main (String [] args) throws Exception {
		int circuitLength=1700;
		String circuitName="SeaFly";
		double circuitTime=28;
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);
		circuit.addRockets();
			for(int time=1; endCircuit(time,circuit); time++) {
				circuit.nextMovement(time);
			}
		

}
	
	public static boolean endCircuit(double time, Circuit circuit) {
		return time<circuit.getTime()&& !(circuit.circuitFinished(time))&& Circuit.rocketList.size()>0;
	}
	
	
	
	
	
}
