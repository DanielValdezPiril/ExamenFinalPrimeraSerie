
public class Racional {

	// sumar fracciones
		public Fraccion sumar(Fraccion f1, Fraccion f2) {
			Fraccion aux = new Fraccion();
			aux.setNum(f1.getNum() * f2.getDen() + f1.getDen() * f2.getNum());
			aux.setDen( f1.getDen() * f2.getDen());
			aux.simplificar(); // se simplifica antes de devolverla
			return aux;
		}

		// restar fracciones
		public Fraccion restar(Fraccion f1, Fraccion f2) {
			Fraccion aux = new Fraccion();
			aux.setNum(f1.getNum() * f2.getDen() - f1.getDen() * f2.getNum());
			aux.setDen( f1.getDen() * f2.getDen());
			aux.simplificar(); // se simplifica antes de devolverla
			return aux;
			
		}

		// multiplicar fracciones	
		public Fraccion multiplicar(Fraccion f1, Fraccion f2) {
			Fraccion aux = new Fraccion();
			aux.setNum (f1.getNum() * f2.getNum());
			aux.setDen (f1.getDen() * f2.getDen());
			aux.simplificar(); // se simplifica antes de devolverla
			return aux;
		}

		// dividir fracciones
		public Fraccion dividir(Fraccion f1, Fraccion f2) {
			Fraccion aux = new Fraccion();
			aux.setNum (f1.getNum() * f2.getDen());
			aux.setDen (f1.getDen() * f2.getNum());
			aux.simplificar(); // se simplifica antes de devolverla
			return aux;
		}


		
}