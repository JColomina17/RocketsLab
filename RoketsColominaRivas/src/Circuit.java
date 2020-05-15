	import java.util.ArrayList;
import java.util.Iterator;
	
	public class Circuit {
		
	private int circuitLength;
	private String circuitName;
	private double circuitTime;
	private ArrayList<Rocket> rocketList;
	
	public Circuit(int circuitLength,String circuitName, double circuitTime ) {
		this.circuitLength=circuitLength;
		this.circuitName=circuitName;
		this.circuitTime=circuitTime;
		this.rocketList = new ArrayList<Rocket> ();
	}
	
	
	public void nextMovement(int time) {
		Iterator<Rocket> it = rocketList.iterator(); 
        while(it.hasNext()) {
        	it.next();
        	System.out.println("Que vol fer el rocket "+((Rocket)it).getName());
        	try {
				((Rocket)it).nextMovement(time);
			} catch (Exception e) {
	        	System.out.println("El rocket "+((Rocket)it).getName() +" s'ha quedat sense combustible");
	        	it.remove();

			}
        	
        }
	}
	
	public void infoRocket(double time) {
		Iterator<Rocket> it = rocketList.iterator(); 
        while(it.hasNext()) {
        	((Rocket)it).infoRocket(time);
        	
        }
	}
	
	public boolean circuitFinished() {
		Iterator<Rocket> it = rocketList.iterator(); 
        while(it.hasNext()) {
        	if(((Rocket)it).getDistancecovered()>=this.circuitLength){
        		return true;
        	}
        }
		
		
		return false;
		
	}
	
	public void addRockets(Rocket r) {
		this.rocketList.add(r);
		
	}
	
	



}
