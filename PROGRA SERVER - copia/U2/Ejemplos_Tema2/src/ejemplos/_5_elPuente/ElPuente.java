package ejemplos._5_elPuente;

import pspT2.ejemplos._5_elPuente.Persona;
import pspT2.ejemplos._5_elPuente.Puente;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Siulación del paso de personas por un puente. Pero este paso tiene restricciones, no se puede superar un peso máximo
 * no se pueden superar un número máximo de personas simultaneas
 * 
 * @author jmartinezs
 *
 */
public class ElPuente {

	public static void main(String[] args) {
		pspT2.ejemplos._5_elPuente.Puente elPuente=new Puente();
		
		int tMinNuevaPersona=1;
		int tMaxNuevaPersona=5;
		int tMinPasoPuente=5;
		int tMaxPasoPuente=10;
		
		int pesoMinpersona=40;
		int pesoMaxPersona=120;
		
		System.out.println("###################### Se abre el puente");
		int idPersona=1;
		
		while(true) {
			int tiempoNuevoPersona=ThreadLocalRandom.current().nextInt(tMinNuevaPersona, tMaxNuevaPersona);
			int pesoNuevaPersona=ThreadLocalRandom.current().nextInt(pesoMinpersona, pesoMaxPersona);
			
			System.out.println("Siguiente persona en "+tiempoNuevoPersona+" segundos");
			try {
				Thread.sleep(1000*tiempoNuevoPersona);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Interrumpido proceso princial");
			}
			Thread hiloPersona=new Thread(new Persona(elPuente,pesoNuevaPersona,tMinPasoPuente,tMaxPasoPuente,"Person"+idPersona));
			hiloPersona.start();
			idPersona++;
		}
	}

}
