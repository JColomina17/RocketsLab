import java.util.ArrayList;
import java.util.Iterator;

public class Probes {
	public static void main (String [] args) throws Exception {
		int circuitLength=1700;
		String circuitName="SeaFly";
		double circuitTime=28;
		Circuit circuit=new Circuit(circuitLength,circuitName,circuitTime);
			for(int time=0; time<circuit.getTime(); time++) {
				circuit.nextMovement(time);
			}
		}
	}
	

