package MonteCarlo;

import Pruebas.Generador;

public class AppIntegral {
    public static void main(String[] args) {
        Generador prueba1= new Generador();
        Generador prueba2 = new Generador();
        prueba1.datos(41, 1203, 16, 12000);
        prueba2.datos(295, 419, 16, 12000);
        prueba1.generador();
        prueba2.generador();


    }
}
