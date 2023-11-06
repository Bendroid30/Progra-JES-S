package ejercicios_modificados.cuenta;

import java.util.concurrent.atomic.AtomicInteger;

public class Cuenta {

	int saldo;
	final String numCuenta;
	private static int codigo;
	private final AtomicInteger identificador=new AtomicInteger(codigo);


	
	public Cuenta(String numCuenta, int saldoInicial) {
		this.numCuenta=numCuenta;
		this.saldo=saldoInicial;
		this.codigo=identificador.incrementAndGet();
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
