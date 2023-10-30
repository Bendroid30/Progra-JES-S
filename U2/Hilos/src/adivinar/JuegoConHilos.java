package adivinar;

import java.util.concurrent.ThreadLocalRandom;

public class JuegoConHilos {
    public static void main(String[] args) {
        int numeroElegido= ThreadLocalRandom.current().nextInt(0,150001);
        Thread t1=new Thread(new Hilos(numeroElegido));
        Thread t2=new Thread(new Hilos(numeroElegido));
        Thread t3=new Thread(new Hilos(numeroElegido));
        Thread t4=new Thread(new Hilos(numeroElegido));
        Thread t5=new Thread(new Hilos(numeroElegido));
        Thread t6=new Thread(new Hilos(numeroElegido));

        System.out.println("Numero escogido: "+numeroElegido);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
