package Domain;
public class Propeller {
    
private double maxAcceleration;
private double  acceleration;
public Propeller(double maxAcceleration) throws Exception {
	if(maxAcceleration<0) throw new Exception("Error:The maximum acceleration cannot be lower than 0");
    acceleration=0;
    this.maxAcceleration=maxAcceleration;
    
}
public double setAcceleration(double acceleration) throws Exception {
	if(acceleration<0)
		throw new Exception();
	if(acceleration>maxAcceleration) {
		this.acceleration=maxAcceleration;
		acceleration-=maxAcceleration;
	}
	else {
		this.acceleration=acceleration;
		acceleration=0;
	}

	return acceleration;
}
public double getAcceleration() {
    return acceleration;
}
public double getMaxAcceleration() {
	return this.maxAcceleration;
}
}