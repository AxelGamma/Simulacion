package Kolmogorov;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] pruebas;
        inputDatos datos = new inputDatos();
        datos.input();
        datos.outputArray();
        pruebas = datos.getPruebas();

        try {
            Generador generador = new Generador();
            
            while (generador.getEsCompleto() != true) {
                generador.datos(pruebas[3][0],pruebas[3][1],pruebas[3][2]);
                generador.generador();
            }
            chiCuadrada chi = new chiCuadrada(generador.muestraA,datos.getNumPruebas());
            chi.resultados();

        } catch (Exception e) {
            System.out.println("Introduce puros numeros");

        }

    }

}
