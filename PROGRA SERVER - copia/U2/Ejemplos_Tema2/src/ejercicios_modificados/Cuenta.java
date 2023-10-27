package ejercicios_modificados;

import java.util.concurrent.atomic.AtomicInteger;

public class Cuenta {

	int saldo;
	final String numCuenta;
	private static int codigo=0;
	private final AtomicInteger identificador=new AtomicInteger(codigo);


	
	public Cuenta(String numCuenta, int saldoInicial) {
		this.numCuenta=numCuenta;
		this.saldo=saldoInicial;
		this.codigo=identificador.addAndGet(1);
	}
	
	public synchronized int getSaldo() {
		return saldo;		
	}
	
	public synchronized void ingresar(int cantidad) {
		saldo+=cantidad;
	}
	
	public synchronized void sacar(int cantidad) {
		saldo-=cantidad;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}

	public AtomicInteger getIdentificador() {
		return identificador;
	}
}
