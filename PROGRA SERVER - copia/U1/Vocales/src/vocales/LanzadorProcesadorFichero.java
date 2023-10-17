package vocales;

import java.io.File;
import java.io.IOException;

public class LanzadorProcesadorFichero {

    public static void main(String[] args) throws IOException, InterruptedException {
        String ficheroEntrada= args[0];
        LanzadorProcesadorFichero lanzador = new LanzadorProcesadorFichero();
        contarVocales(ficheroEntrada);
    }

    public static void contarVocales(String ficheroEntrada){
        String[] vocales = {"a", "e", "i", "o", "u"};

        for (int cont=0; cont< vocales.length;cont++ ){
            String vocal= vocales[cont];
            String ficheroResultado="letra"+vocal.toUpperCase()+".txt";
            String clase = "vocales.Ej8_ProcesadorFichero";
            ProcessBuilder pb = new ProcessBuilder("java",clase, ficheroEntrada,vocal, ficheroResultado);
            pb.inheritIO();
            pb.directory(new File("D:\\DAM2\\PROGRA SERVER\\U1\\Progra-JES-S\\out\\production\\Vocales"));
            System.out.println(pb.directory());

            try {
                pb.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
