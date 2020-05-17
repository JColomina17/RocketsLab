	import java.util.ArrayList;
import java.util.Iterator;
	
	public class Circuit {
		
	private int circuitLength;
	private String circuitName;
	private double circuitTime;
	public ArrayList<Rocket> rocketList;
	
	public Circuit(int circuitLength,String circuitName, double circuitTime ) {
		this.circuitLength=circuitLength;
		this.circuitName=circuitName;
		this.circuitTime=circuitTime;
		this.rocketList = new ArrayList<Rocket> ();
	}
	
	
	public void nextMovement(int time) {
		Iterator<Rocket> it = rocketList.iterator(); 
        while(it.hasNext()) {
        	Rocket r=it.next();

        	System.out.println("What does the rocket "+r.getName()+" want");
        	try {
				r.nextMovement(time);
			} catch (Exception e) {
	        	System.out.println("The rocket "+r.getName() +" has no fuel left");
	        	it.remove();

			}
        	
        }
	}
	
	public void infoRocket(double time) {
		Iterator<Rocket> it = rocketList.iterator(); 
        while(it.hasNext()) {
        	Rocket r=it.next();

        	r.infoRocket(time);
        	
        }
	}
	
	public boolean circuitFinished(double time) {
		if(this.rocketList.size()==0) {
			System.out.print("There's no winner");
			return true;}
		Iterator<Rocket> it = rocketList.iterator(); 

        while(it.hasNext()) {
        	Rocket r=it.next();
    		double distance= r.getDistancecovered();
        	if(distance>=this.circuitLength){
        		System.out.println("And the winner is: "+ r.getName() +" with a time of "+time);
        		return true;
        	}
        }
		
		
		return false;
		
	}
	
	public void addRockets(Rocket r) {
		this.rocketList.add(r);
		
	}
	
	public double getTime() {
		return this.circuitTime;
	}
	
	



}
