package Pruebas;

public class AppMain {

    public static void main(String[] args) throws Exception {

        int[][] pruebas;

        inputDatos datos = new inputDatos();
        datos.input();

        pruebas = datos.getPruebas();
        boolean[] estados = new boolean[datos.getNumPruebas()];

        int i = 0;
        while (i < pruebas.length) {
            // Creamos objeto de la clase generador
            Generador generador = new Generador();
            generador.datos(pruebas[i][0], pruebas[i][1], pruebas[i][2], datos.getSizeMuestra()); // hacemos la
                                                                                                  // generacion de las
                                                                                                  // pruebas a
            generador.generador();
            estados[i] = generador.getEsCompleto();
            // Fin de la generador

            
             //Prueba de la chiCuadrada
            // ChiCuadrada chi = new ChiCuadrada(generador.getMuestraA(),datos.getNumPruebas());
            // chi.resultados();
            // estados[i] = chi.getEstadoPrueba();
            

            // Huecos huecos = new Huecos(generador.getMuestraA());
            // huecos.pruebaH();
            // estados[i] = huecos.getEstadoPrueba();
            


             //Prueba de poker
//             Poker poker = new Poker(generador.getMuestraA());
//             poker.muestra();
//             estados[i] = poker.getEstadoPrueba();

            i++;

        }

        // Nos imprime si paso la prueba o no
        i = 0;
        while (i < estados.length) {
            System.out.print(String.format("%d", i + 1) + String.format("%10b\n",
                    estados[i]));
            i++;
        }

    }

}
