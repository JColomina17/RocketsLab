package Domain;
public class Propeller {
    
private double maxAcceleration;
private double  acceleration;

public Propeller(double maxAcceleration) throws Exception {
	if(maxAcceleration<0) throw new Exception("Error:The maximum acceleration cannot be lower than 0");

    acceleration=0;
    this.maxAcceleration=maxAcceleration;
}
public void setAcceleration(double acceleration) throws Exception {
	if(acceleration<1)
		throw new Exception();
	this.acceleration=acceleration;
}
public double getAcceleration() {
    return acceleration;
}
public double getMaxAcceleration() {
	return this.maxAcceleration;
}
}