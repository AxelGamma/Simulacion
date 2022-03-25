package Proyecto;

public class Main {
    
    public static void main(String[] args) throws Exception {
        try {
            int[][] pruebas;

            inputDatos datos = new inputDatos();
            datos.input();
            datos.outputArray();
            pruebas = datos.getPruebas();
            boolean[] estados = new boolean[datos.getNumPruebas()];
            int i = 0;
            while (i < pruebas.length) {

                Generador generador = new Generador();
                generador.datos(pruebas[i][0], pruebas[i][1], pruebas[i][2]);
                generador.generador();
                chiCuadrada chi = new chiCuadrada(generador.muestraA, datos.getNumPruebas());
                chi.resultados();
                estados[i] = chi.getEstadoPrueba();
                i++;
            }

            i = 0;
            while (i < estados.length) {
                System.out.print(String.format("%5b\n", estados[i]));
                i++;
            }

        } catch (Exception e) {
            System.out.println("Introduce puros numeros");

        }

    }
    

}
