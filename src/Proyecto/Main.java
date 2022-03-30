package Proyecto;

public class Main {

    public static void main(String[] args) throws Exception {
        // try {
        int[][] pruebas;

        inputDatos datos = new inputDatos();
        datos.input();
        // datos.outputArray();
        pruebas = datos.getPruebas();
        boolean[] estados = new boolean[datos.getNumPruebas()];

        int i = 0;
        while (i < pruebas.length) {
            // Creamos objeto de la clase generador
            Generador generador = new Generador();
            generador.datos(pruebas[i][0], pruebas[i][1], pruebas[i][2]); // hacemos la generacion de las pruebas a
                                                                          // hacer
            generador.generador();

            // Creamos objeto de la chiCuadrada donde introducimos la muestraA(muestra de 50
            // numeros) y la cantidad de numeros de las pruebas hacer
            // chiCuadrada chi = new chiCuadrada(generador.muestraA, datos.getNumPruebas());
            // generador.muestraA(); ---->Muestra que toma del generador = 50,
            Poker poker = new Poker(generador.getMuestraA());
            poker.muestra();
            estados[i] = poker.getEstadoPrueba();
            // Huecos huecos = new Huecos(generador.getMuestraA());
            // huecos.pruebaH();
            // chi.resultados();
            // estados[i] = huecos.getEstadoPrueba();

            i++;

        }

        // Nos imprime si paso la prueba o no
        i = 0;
        while (i < estados.length) {
        System.out.print(String.format("%d", i + 1) + String.format("%10b\n",
        estados[i]));
        i++;
        }

        // } catch (Exception e) {
        // System.out.println(e);

        // }

    }

}
