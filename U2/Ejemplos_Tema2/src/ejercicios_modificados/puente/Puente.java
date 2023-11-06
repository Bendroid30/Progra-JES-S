package ejercicios_modificados.puente;

/**
 * Clase para el control de los requisitos
 *
 * @author jmartinezs
 */
public class Puente {

    private static final int PESO_MAXIMO = 400;
    private static final int MAX_PERSONAS = 4;
    private static final int MAX_DIRECCION_DERECHA = 3;
    private static final int MAX_DIRECCION_IZQUIERDA = 3;

    private int peso = 0;
    private int numPersonasTotal = 0;
    private int numPersonasIzquierda = 0;
    private int numPersonasDerecha = 0;


    synchronized public int getPeso() {
        return peso;
    }

    synchronized public int getNumPersonasTotal() {
        return numPersonasTotal;
    }
	synchronized public int getNumPersonasIzquierda(){
		return numPersonasIzquierda;
	}
	synchronized public int getNumPersonasDerecha(){
		return numPersonasDerecha;
	}

    synchronized public boolean autorizacionPaso(Persona persona) {
        boolean resultado;
		if (persona.getDireccion()==0) {
			if (this.peso + persona.getPeso() <= Puente.PESO_MAXIMO && this.numPersonasTotal < Puente.MAX_PERSONAS && this.numPersonasDerecha < Puente.MAX_DIRECCION_DERECHA) {
				this.numPersonasTotal++;
				this.numPersonasDerecha++;
				this.peso += persona.getPeso();
				resultado = true;
			} else
				resultado = false;
		}else {
			if (this.peso + persona.getPeso() <= Puente.PESO_MAXIMO && this.numPersonasTotal < Puente.MAX_PERSONAS && this.numPersonasIzquierda < Puente.MAX_DIRECCION_IZQUIERDA) {
				this.numPersonasTotal++;
				this.numPersonasIzquierda++;
				this.peso += persona.getPeso();
				resultado = true;
			} else
				resultado = false;
		}
        return resultado;
    }

    synchronized public void terminaPaso(Persona persona) {
        this.peso -= persona.getPeso();
        this.numPersonasTotal--;
		if (persona.getDireccion()==0)
			this.numPersonasDerecha--;
		else
			this.numPersonasIzquierda--;
    }
}
