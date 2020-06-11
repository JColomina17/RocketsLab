package Domain;
	import java.util.ArrayList;
import java.util.List;

import Observer.ObserverCircuit;

	
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
				r.Strategy(circuitLength, circuitTime);
			}
		 
		 for(double time=0;!endCircuit(time);time++) {
			 for(Rocket r : Rockets) {
				 if(!r.getObserver().noFuel) {
					r.nextMovement(time);
					observer.updateRaceStatus(r.getObserver().race);}
				}
		 }
	
	}
	
	
	private boolean endCircuit(double time) {
		
		return time>this.getTime() && (this.circuitFinished(time));
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
		int rocketsRacing=0;
		for(Rocket r : Rockets) {
			if(!r.getObserver().noFuel) {
				rocketsRacing++;
			double distance= r.getDistancecovered();
        	if(distance>=this.circuitLength){
        		observer.update(true, r.getName());
        		return true;
        	}
			}
		}
		if(rocketsRacing==0) { 
			observer.updateRaceStatus("There is no winner");
			
			return true;}
		return false;
		
	}
	
	
		
		public double getTime() {
			return this.circuitTime;
		}
	

		public void addRockets(Rocket r) throws Exception {
			Rockets.add(r);			
		}


	
		


}
