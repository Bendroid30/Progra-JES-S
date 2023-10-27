package ejemplos._3_CuentasBancarias;

import pspT2.ejemplos._3_CuentasBancarias.Cuenta;

public class GestorCuentas {

	public static boolean transferencia(pspT2.ejemplos._3_CuentasBancarias.Cuenta c1, pspT2.ejemplos._3_CuentasBancarias.Cuenta c2, int cantidad) {
		pspT2.ejemplos._3_CuentasBancarias.Cuenta cmayor,cmenor;
		if (c1.getNumCuenta().compareTo(c2.getNumCuenta())<0) {
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

	public static boolean transferenciaBloqueo(pspT2.ejemplos._3_CuentasBancarias.Cuenta c1, Cuenta c2, int cantidad) {
		boolean resultado=false;
		synchronized (c1) {
			synchronized (c2) {
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
