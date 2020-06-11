package Observer;

import Domain.Circuit;

public class ObserverCircuit extends Observer {
	protected Circuit circuit;
	public boolean finished;
	public String winner;
	public double time;
	public String raceStatus;
	public ObserverCircuit(Circuit circuit) {
		 this.circuit = circuit;
	}
	public void update(boolean update, String winner) {
		this.finished=update;
		this.winner=winner;
	}
	
	public void updateTime(double time) {
		this.time= time;
	}
	
	public void updateRaceStatus(String update) {
		raceStatus+=update;
	}
	
	

	
}
