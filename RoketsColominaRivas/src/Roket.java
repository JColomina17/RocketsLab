import java.util.*; 

public class Roket {
	private Propulsor llistaProp[];
	private Combustible combustible;
	private String name;
	private double velocitatActual;
	public Roket(String name,int capacitatMaxima) {
		this.name=name;
		llistaProp = new Propulsor[3];
		this.combustible= new Combustible(capacitatMaxima);
		this.velocitatActual=0;
	}
	
	public void augmentarAcc(double cuant) {
		for(int x=0;x<3 && cuant>=0;x++) {
			cuant=llistaProp[x].increaseAcceleration(cuant);
		}
	}
	
	public void disminuirAcc(double cuant) {
		for(int x=0;x<3 && cuant>=0;x++) {
			cuant=llistaProp[x].decreaseAcceleration(cuant);
		}
		}
	
	public double getAcceleracio() {
		double acceleracioTotal=0;
		
		for(int x=0;x<3;x++) {
			acceleracioTotal+=llistaProp[x].getAcceleration();
		}
		
		return acceleracioTotal;
	}
	public double getVelocitat() {
		return this.velocitatActual;
		
	}
	public void calculatVelocitat(double temps) {
		
		velocitatActual= this.velocitatActual +(this.getAcceleracio()*temps);
		
	}
	
	public double metresRecorreguts(double posicioInicial, double temps) {
			
		return posicioInicial + (this.velocitatActual*temps) + 1/2*this.getAcceleracio()*Math.pow(temps, 2);

		}
	
	
	public double calcularCombustible() {
		return this.combustible.calcularDiposit(this.velocitatActual);
	}
	
	public String getName() {return this.name;}
}
