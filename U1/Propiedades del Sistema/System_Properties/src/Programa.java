public class Programa {
    public static void main(String[] args) {

        String sO = System.getProperty("os.name");
        String directorioHogar = System.getProperty("user.home");
        String codificacionPredeterminada = System.getProperty("file.encoding");

        long memoriaTotal = Runtime.getRuntime().totalMemory();
        long memoriaLibre = Runtime.getRuntime().freeMemory();
        long memoriaEnUso = memoriaTotal - memoriaLibre;
        long procesadoresLibres = Runtime.getRuntime().availableProcessors();

        System.out.println("Sistema Operativo: " + sO + "\n" +
                "Directorio Hogar: " + directorioHogar + "\n" +
                "Codificación Predeterminada: " + codificacionPredeterminada + "\n" +
                "Memoria Total: " + memoriaTotal + " bytes\n" +
                "Memoria Libre: " + memoriaLibre + " bytes\n" +
                "Memoria Usada: " + memoriaEnUso + " bytes\n" +
                "Procesadores Disponibles: " + procesadoresLibres);


    }
}
