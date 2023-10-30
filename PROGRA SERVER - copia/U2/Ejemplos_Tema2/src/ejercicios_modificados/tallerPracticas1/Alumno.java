package ejercicios_modificados.tallerPracticas1;

import java.util.concurrent.ThreadLocalRandom;

public class Alumno implements  Runnable{

    Herramienta herramientas=new Herramienta(10);

    public Alumno(Herramienta herramientas) {
        this.herramientas = herramientas;
    }

    @Override
    public void run() {
        int herramienta1= herramientas.getHerramientasLista().get(ThreadLocalRandom.current().nextInt());
    }
}
