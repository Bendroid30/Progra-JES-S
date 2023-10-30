package ejercicios_modificados.tallerPracticas1;

import java.time.chrono.HijrahEra;
import java.util.ArrayList;

public class BancoHerramientas {
    private ArrayList<Herramienta> herramientasLista=new ArrayList<>();

    public BancoHerramientas(int numeroHerramientas){
        for (int num=0; num<=numeroHerramientas;num++){
            this.herramientasLista.add(new Herramienta());
        }
    }

    public ArrayList<Herramienta> getHerramientasLista() {
        return herramientasLista;
    }
}
