package vocales;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;


public class Ej8_ProcesadorFichero {
    // Dado un fichero de entrada y una letra
    // contamos cuantas veces aparece dicha letra
    // y dejamos el recuento en un fichero de salida
    public static void hacerRecuento(String fichEntrada, String letra, String fichSalida) throws FileNotFoundException, IOException {

        BufferedReader br;
//        br = Ej7_UtilidadesFicheros.getBufferedReader(fichEntrada);
        br=new BufferedReader(new InputStreamReader(new FileInputStream(fichEntrada), StandardCharsets.UTF_8));
        PrintWriter pw;
        pw = Ej7_UtilidadesFicheros.getPrintWriter(fichSalida);
        String lineaLeida;
        lineaLeida = br.readLine();
        int totalVocal = 0;
        int total = 0;
        //Mientras no queden líneas....
        while (lineaLeida != null) {
            //...recorremos la linea...
            for (int i = 0; i < lineaLeida.length(); i++) {
                char letraLeida = Character.toLowerCase(comprobarAcento(lineaLeida.charAt(i)));
                char letraPasada = Character.toLowerCase(letra.charAt(0));
                // incrementamos el contador
                if (comprobarAcento(letraLeida) == letraPasada) totalVocal++;
            }
            // Pasamos a la siguiente linea
            lineaLeida = br.readLine();
        }
        //Escribimos el total de vocales
        //en el fichero de salida
        pw.println(totalVocal);
        pw.flush();
        //Y cerramos los ficheros
        pw.close();
        br.close();
        System.out.println("Aparece la vocal "+letra.toUpperCase()+": "+totalVocal);
    }

    /**
     * Dado un fichero pasado como argumento, contará cuantas
     * apariciones hay de una cierta vocal (pasada como argumento)
     * y dejará la cantidad en otro fichero (también pasado como
     * argumento)
     *
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String nombreFicheroEntrada = args[0];
        String letra = args[1];
        String nombreFicheroResultado = args[2];
        hacerRecuento(nombreFicheroEntrada, letra, nombreFicheroResultado);
    }

    public static char comprobarAcento(char letra){
        switch (letra) {
            case 'á':
                return 'a';
            case 'é':
                return 'e';
            case 'í':
                return 'i';
            case 'ó':
                return 'o';
            case 'ú':
                return 'u';
            default:
                return letra;
        }
    }
}
