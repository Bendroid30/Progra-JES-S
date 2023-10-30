package vocales;

import java.text.Normalizer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String texto= input.nextLine();
        String textoNormalizao= Normalizer.normalize(texto, Normalizer.Form.NFD);
        System.out.println(textoNormalizao);
    }
}
