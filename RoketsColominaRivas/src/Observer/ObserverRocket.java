package Observer;

import Domain.Rocket;

public class ObserverRocket {
	protected Rocket rocket;
	public double speed;
	public double distance;
	public double fuelTank;
	public final String name;
	public final  double maxTank;
	public String race;
	public boolean noFuel=false;

	public ObserverRocket(Rocket rocket) {
		 this.rocket = rocket;
		 this.maxTank=rocket.getMaxTank();
		 this.name=rocket.getName();
		 this.race="";

	}
	public void updatespeed(double speed) {
		this.speed=speed;
	}
	public void updatedistance(double distance) {
		this.distance=distance;
	}
	public void updatefuelTank(double fuelTank) {
		this.fuelTank=fuelTank;
	}
	public void updateRace(String race) {
		this.race=race;
	}
	public void updateFuel() {
		this.noFuel=true;;
	}

}
