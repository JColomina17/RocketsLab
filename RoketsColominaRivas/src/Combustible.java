
public class Combustible {
	private double nivellCombustible;
	private double capacitatMaxima;
	
	public Combustible(int capacitatMaxima) {
		this.capacitatMaxima=capacitatMaxima;
		this.nivellCombustible=capacitatMaxima;
	}

	public double calcularDiposit (double velocitat) {
		nivellCombustible = nivellCombustible - (0.02*Math.pow(velocitat, 2));
		return nivellCombustible;
	}
	
	public boolean depositBuit() {
		if(this.nivellCombustible==0) return true;
		else return false;
	}
}

