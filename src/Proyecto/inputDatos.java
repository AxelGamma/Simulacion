package Proyecto;

import java.util.Scanner;

public class inputDatos {
    private int numPruebas, i, j, y = 3;
    private int[][] pruebas;
    Scanner sc = new Scanner(System.in);

    public void input() {
        System.out.println("Introduce el numero de pruebas a hacer");
        numPruebas = sc.nextInt(); // Numero de pruebas hacer
        pruebas = new int[numPruebas][y];
        System.out.println("------Introduce los datos por ejemplo, valor1=Xo valor2= a valor 3= b ------\n");
        i = 0;
        while (i < pruebas.length) {
            System.out.println("Introduce los datos de la prueba " + (i + 1) + ": ");
            j = 0;
            while (j < y) {
                if (j == 0) {
                    pruebas[i][j] = sc.nextInt();
                } else if (j == 1) {
                    pruebas[i][j] = sc.nextInt();
                } else if (j == 2) {
                    pruebas[i][j] = sc.nextInt();
                }
                j++;
            }
            i++;
        }

    }

    public void outputArray() {
        i = 0;
        System.out.println("--Pruebas--");
        while (i < pruebas.length) {
            j = 0;
            while (j < y) {

                System.out.print(String.format("%5d", pruebas[i][j]));
                j++;
            }
            System.out.println(" ");
            i++;
        }
    }

    public int[][] getPruebas() {
        return pruebas;
    }

    public int getNumPruebas() {
        return numPruebas;
    }
}
