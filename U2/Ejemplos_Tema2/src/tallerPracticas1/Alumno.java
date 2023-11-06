package tallerPracticas1;


import java.util.concurrent.ThreadLocalRandom;

public class Alumno implements Runnable {

    private Herramienta[] bancoHerramientas;

    private static int contador = 0;
    private int id;

    public Alumno(Herramienta[] bancoHerramientas) {
        contador++;
        this.id = contador;
        this.bancoHerramientas = bancoHerramientas;
    }

    @Override
    public void run() {
        while (true) {
            //Cogemos las herramientas
            int herramienta1 = ThreadLocalRandom.current().nextInt(bancoHerramientas.length);
            int herramienta2 = ThreadLocalRandom.current().nextInt(bancoHerramientas.length);
            while (herramienta2 == herramienta1) {
                herramienta2 = ThreadLocalRandom.current().nextInt(bancoHerramientas.length);
            }

            //Ordenamos las herramientas
            int herramientaFuerte;
            int herramientaDebil;
            if (herramienta1 < herramienta2) {
                herramientaDebil = herramienta1;
                herramientaFuerte = herramienta2;
            } else {
                herramientaDebil = herramienta2;
                herramientaFuerte = herramienta1;
            }

            System.out.println("Alumno " + id + " necesita las herramientas " + herramientaFuerte + " y " + herramientaDebil + " para trabajar.");

            //Comienzan ha trabajar
            synchronized (bancoHerramientas[herramientaFuerte]) {
                synchronized (bancoHerramientas[herramientaDebil]) {
                    System.out.println("Alumno " + id + " está trabajando");
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextLong(2000, 3001));
                    } catch (InterruptedException e) {
                        System.err.println("No quiero descansar");
                    }
                }
            }



            System.out.println("Alumno " + id + " va a soltar las herramientas " + herramientaFuerte + " y " + herramientaDebil);
            //Libera herramientas
            synchronized (bancoHerramientas[herramientaFuerte]) {
                synchronized (bancoHerramientas[herramientaDebil]) {
                    //Comienza ha descansar
                    System.out.println("Alumno " + id + " está descansando");
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 2001));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        }
    }
}
