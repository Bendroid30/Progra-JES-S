package ejercicios_modificados.cuenta;

import ejercicios_modificados.cuenta.Cuenta;

public class GestorCuentas {

	public static boolean transferencia(Cuenta c1, Cuenta c2, int cantidad) {
		Cuenta cmayor,cmenor;
		if (c1.getIdentificador().get()< c2.getIdentificador().get()) {
			cmayor=c2;
			cmenor=c1;
		}
		else {
			cmayor=c1;
			cmenor=c2;
		}
		boolean resultado=false;
		synchronized (cmayor) {
			synchronized (cmenor) {
				if (c1.getSaldo()>=cantidad) {
					c1.sacar(cantidad);
					c2.ingresar(cantidad);
					resultado=true;
				}
			}			
		}
		return resultado;
	}

	public static boolean transferenciaBloqueo(Cuenta c1, Cuenta c2, int cantidad) {
		boolean resultado=false;
		synchronized (c1.getIdentificador()) {
			synchronized (c2.getIdentificador()) {
				if (c1.getSaldo()>=cantidad) {
					c1.sacar(cantidad);
					c2.ingresar(cantidad);
					resultado=true;
				}
			}			
		}
		return resultado;
	}

}
