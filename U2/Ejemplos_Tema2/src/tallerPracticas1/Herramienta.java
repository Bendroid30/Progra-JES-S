package tallerPracticas1;

import java.util.concurrent.atomic.AtomicInteger;

public class Herramienta {
    private static AtomicInteger identificador=new AtomicInteger(0);
    private final int codigo;

    public Herramienta(){
        this.codigo=identificador.incrementAndGet();
    }

    public AtomicInteger getIdentificador() {
        return identificador;
    }

}
