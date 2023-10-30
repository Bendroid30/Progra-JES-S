package ejercicios_modificados.tallerPracticas1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Herramienta {

    private ArrayList<Integer> herramientasLista=new ArrayList<>();
    private static AtomicInteger identificador=new AtomicInteger(0);
    private final int codigo;

    public Herramienta(){
        this.codigo=identificador.incrementAndGet();
    }

    public ArrayList<Integer> getHerramientasLista() {
        return herramientasLista;
    }

    public static AtomicInteger getIdentificador() {
        return identificador;
    }
}
