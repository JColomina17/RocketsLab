public class Propeller {
    
private double maxAcceleration;
private double  acceleration;

public Propeller(double maxAcceleration) throws Exception {
	if(maxAcceleration<0) throw new Exception("Error:The maximum acceleration cannot be lower than 0");

    acceleration=0;
    this.maxAcceleration=maxAcceleration;
}
public double increaseAcceleration(double increase) {
    if(acceleration+increase<=maxAcceleration) {
        acceleration+=increase;
        return 0;
        }
    else {
    	double auxiliar= this.maxAcceleration - this.acceleration;
    	this.acceleration=this.maxAcceleration;
    	return increase-auxiliar;
    }
    
}
public double decreaseAcceleration(double decrease) {
	if(acceleration-decrease>=0) {
        acceleration-=decrease;
        return 0;
        }
    else {
    	double auxiliar=decrease-this.acceleration;
    	this.acceleration=0;
    	return auxiliar;
    }    
}
public double getAcceleration() {
    return acceleration;
}
}