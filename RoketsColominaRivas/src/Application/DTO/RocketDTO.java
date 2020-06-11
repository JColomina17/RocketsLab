package Application.DTO;

import Domain.Rocket;

public class RocketDTO {
	private String name;
	private double time;
	
	public RocketDTO(String name,double time) {
		this.name=name;
		this.time=time;
		
	}
	public RocketDTO(Rocket rocket) throws Exception {
		if(rocket==null)
			throw new Exception();
		name=rocket.getName();
		time=rocket.getTime();
	}
	
	public String getName() throws Exception {
		if(name==null)
			throw new Exception();
		return name;
		
	}
	public double getTime() throws Exception {
		if(time<0)
			throw new Exception();
		return time;
		
	}
	
	

}
