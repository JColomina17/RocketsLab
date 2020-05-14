public class Propulsor {
    
private double maxacceleration;
private double  acceleration;

public Propulsor(double maxacceleration) {
    acceleration=0;
    this.maxacceleration=maxacceleration;
}
public double increaseAcceleration(double increase) {
    if(acceleration+increase<=maxacceleration) {
        acceleration+=increase;
        return 0;
        }
    else {
    	double auxiliar= this.maxacceleration - this.acceleration;
    	this.acceleration=this.maxacceleration;
    	return auxiliar;
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