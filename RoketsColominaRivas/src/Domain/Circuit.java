package Domain;
	import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

import Keyboard.Keyboard;
import Observer.ObserverCircuit;
import Observer.ObserverRocket;
	
	public class Circuit {
		
	private int circuitLength;
	private String circuitName;
	private double circuitTime;
	private List<Rocket> Rockets = new ArrayList<Rocket>();
	private ObserverCircuit observer;

	public Circuit(int circuitLength,String circuitName, double circuitTime ) throws Exception {
		this.circuitLength=circuitLength;
		this.circuitName=circuitName;
		this.circuitTime=circuitTime;

	}
	
	public void addObserver(ObserverCircuit ob) {
		this.observer=ob;
	}
	
	 
	 public void StartRace() throws Exception {
		 for(Rocket r : Rockets) {
				r.Strategy(circuitLength,  circuitTime);
			}
		 
		 for(double time=0;!endCircuit(time);time++) {
			 for(Rocket r : Rockets) {
					r.nextMovement(time);
					observer.updateRaceStatus(r.getObserver().race);
					observer.updateRaceStatus(" /n");

				}
		 }
	
	}
	
	
	private boolean endCircuit(double time) {
		
		return time>this.getTime() && !(this.circuitFinished(time));
	}

	public void nextMovement(double time) throws Exception {
		
		for(Rocket r : Rockets) {
			r.nextMovement(time);

		}
		
        }
	
	
	public void infoRocket(double time) {
		for(Rocket r : Rockets) {
			r.infoRocket(time);

		}		
	}
	
	public boolean circuitFinished(double time) {
		for(Rocket r : Rockets) {
			double distance= r.getDistancecovered();
        	if(distance>=this.circuitLength){
        		observer.update(true, r.getName());
        		return true;
        	}
		}
		
		return false;
		
	}
	
	
		
		public double getTime() {
			return this.circuitTime;
		}
	

		public void addRockets(Rocket r) throws Exception {
			Rockets.add(r);			
		}


	
		


}
