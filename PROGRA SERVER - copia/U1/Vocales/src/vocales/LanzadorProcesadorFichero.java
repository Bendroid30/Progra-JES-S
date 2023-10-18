package vocales;

import java.io.*;
import java.util.ArrayList;

public class LanzadorProcesadorFichero {

    public static void main(String[] args) throws IOException, InterruptedException {
        String ficheroEntrada = args[0];
        LanzadorProcesadorFichero lanzador = new LanzadorProcesadorFichero();
        contarVocales(ficheroEntrada);
    }

    public static void contarVocales(String ficheroEntrada) throws IOException {
        String[] vocales = {"a", "e", "i", "o", "u"};
        ArrayList<Process>processList=new ArrayList<Process>();
        for (int cont = 0; cont < vocales.length; cont++) {
            String vocal = vocales[cont];
            String ficheroResultado = "letra" + vocal + ".txt";
            String clase = "vocales.Ej8_ProcesadorFichero";
            ProcessBuilder pb = new ProcessBuilder("java", clase, ficheroEntrada, vocal, ficheroResultado);
            pb.inheritIO();
            pb.directory(new File(System.getProperty("user.dir") + "/out/production/Vocales"));
            System.out.println(pb.directory());

            try {
                Process proceso = pb.start();
                processList.add(proceso);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Process process : processList) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int total = 0;
        for (int i = 0; i < vocales.length; i++) {
                BufferedReader br = new BufferedReader(new FileReader("out/production/Vocales/letra" + vocales[i] + ".txt"));
                total += Integer.parseInt(br.readLine());
        }
        System.out.println(total);


    }
}
