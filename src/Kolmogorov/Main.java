package Kolmogorov;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Kolmogorov prueba1 = new Kolmogorov();
        chiCudrada chi = new chiCudrada();

        prueba1.datos();
        prueba1.generados();

        chi.chiCuadrada(prueba1.getMuestraA());
        chi.resultados();


    }


}


