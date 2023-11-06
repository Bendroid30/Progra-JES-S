package tallerPracticas1;

public class MainTaller {
    public static void main(String[] args) {
        Herramienta[] herramientas = new Herramienta[10];

        for (int i = 0; i < herramientas.length; i++) {
            herramientas[i] = new Herramienta();
        }

        Alumno alumno1=new Alumno(herramientas);
        Alumno alumno2=new Alumno(herramientas);
        Alumno alumno3=new Alumno(herramientas);
        Alumno alumno4=new Alumno(herramientas);
        Alumno alumno5=new Alumno(herramientas);

        Thread hilo1=new Thread(alumno1);
        Thread hilo2=new Thread(alumno2);
        Thread hilo3=new Thread(alumno3);
        Thread hilo4=new Thread(alumno4);
        Thread hilo5=new Thread(alumno5);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
