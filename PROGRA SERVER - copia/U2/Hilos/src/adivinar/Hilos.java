package adivinar;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Hilos implements Runnable{
    int numeroElegido;
    public Hilos(int numeroElegido) {
        this.numeroElegido = numeroElegido;
    }

    static int adivinado=0;
    static int codigo=0;
    @Override
    public void run() {
        codigo++;
        int codigoSingular=codigo;
        int numeroAdivinado=0;
        while (adivinado!=-99) {
            numeroAdivinado=ThreadLocalRandom.current().nextInt(0,150001);
            if(adivinarNumero(numeroAdivinado)==0){
                adivinado=-99;
            }
        }
        if (adivinarNumero(numeroAdivinado)==0)
            System.out.println("He acertado: Hilo"+codigoSingular+" El numero es: "+numeroAdivinado);
        else System.out.println("No he acertado: Hilo"+codigoSingular);

    }

    public int adivinarNumero(int numeroAdivinado){

        if (numeroAdivinado==this.numeroElegido){
            return 0;
        } else return 1;
    }
}
