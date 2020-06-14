import java.math.BigDecimal;
import java.math.RoundingMode;

public class Fraccion {

	

	private int num;
	private int den;

	public Fraccion() {
		this.num = 0;
		this.den = 1;
	}

	public Fraccion(int num, int den) {
		this.num = num;
		if (den == 0) {
			den = 1;
		}
		this.den = den;
		simplificar();
	}

	public Fraccion(int num) {
		this.num = num;
		this.den = 1;
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int n = mcd(); // se calcula el mcd de la fracción
		num = num / n;
		den = den / n;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int mcd() {
		int u = Math.abs(num); // valor absoluto del numerador
		int v = Math.abs(den); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}
	
	public String toString() {
		simplificar();
		return num + "/" + den;
	}
	
	public String obtenerFlotante(int decimales) {
		double numero = Double.parseDouble(num+"") / Double.parseDouble(den +"");
		BigDecimal num = new BigDecimal(numero).setScale(decimales, RoundingMode.HALF_UP);
		return num.toString(); 
	}

}
