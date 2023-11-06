package ejercicios_modificados.puente;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que respresenta las personas que cruzan el puente
 * 
 * @author jmartinezs
 *
 */
public class Persona implements Runnable{

	private final String idPersona;
	private final int peso;
	private final int tMinPaso,tMaxPaso;
	private final Puente puente;
	private final int direccion;
	
	Persona(Puente puente, int peso, int tMinPaso, int tMaxPaso,int direccionPaso, String idP){
		this.peso=peso;
		this.tMinPaso=tMinPaso;
		this.tMaxPaso=tMaxPaso;
		this.idPersona=idP;
		this.puente=puente;
		this.direccion=direccionPaso;
	}
	
	public int getPeso() {
		return this.peso;
	}

	public int getDireccion() {
		return direccion;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (this.direccion==0)
		System.out.print("-- "+idPersona+" de "+peso+" kg quiere cruzar al lado derecho.");
		else
			System.out.print("-- "+idPersona+" de "+peso+" kg quiere cruzar al lado izquierdo.");

		System.out.println(" En puente hay un peso de "+puente.getPeso()+" y "+puente.getNumPersonasTotal()+" persona"+((puente.getNumPersonasTotal()==1)?"s\n":"\n")+
				"de los cuales "+puente.getNumPersonasDerecha()+" van a la derecha y "+puente.getNumPersonasIzquierda()+" van a la izquierda");
		
		//Espera autorización para pasar
		boolean autorizado=false;
		while (!autorizado) {
			synchronized (this.puente) {
				autorizado=this.puente.autorizacionPaso(this);
				if (!autorizado) {					
					try {
						System.out.println("~ "+idPersona+" tiene que esperar");
						this.puente.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Interrupción mientras espera "+idPersona);
					}
				}				
			}
		}
		
		// Autorizado
		System.out.print("> "+idPersona+" con peso "+peso+" puede cruzar.");
		System.out.println(" En puente hay un peso de "+puente.getPeso()+" y "+puente.getNumPersonasTotal()+" persona"+((puente.getNumPersonasTotal()==1)?"s\n":"\n")+
				"de los cuales "+puente.getNumPersonasDerecha()+" van a la derecha y "+puente.getNumPersonasIzquierda()+" van a la izquierda");
		int tiempoPaso=ThreadLocalRandom.current().nextInt(tMinPaso, tMaxPaso);
		try {
			System.out.println("// "+idPersona+" tardará "+tiempoPaso+" en cruzar");
			Thread.sleep(1000*tiempoPaso);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupción mientras pasa "+idPersona);
		}
		
		// Sale del puente
		synchronized (this.puente) {
			this.puente.terminaPaso(this);
			System.out.print("< "+idPersona+" con peso "+peso+" sale del puente.");
			System.out.println("En puente hay un peso de "+puente.getPeso()+" y "+puente.getNumPersonasTotal()+" persona"+((puente.getNumPersonasTotal()==1)?"s":""));
			puente.notifyAll();
		}
	}

}
