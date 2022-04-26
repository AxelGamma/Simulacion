package Exposicion;

import Pruebas.Generador;

public class AppExp {
    public static void main(String[] args) {
        int i;
        Generador g2 = new Generador();
        Generador g1 = new Generador();
        double[] r1, r2, x1, fx1, fx1entUC, resultados, x1aux, fx1aux;
        r1 = new double[150];
        r2 = new double[150];
        x1 = new double[150];
        fx1 = new double[150];
        fx1entUC = new double[150];
        resultados = new double[150];
        x1aux = new double[150];
        fx1aux = new double[150];

        // 41 1203 16
        // 295 419 16
        // Generamos R1 y R2
        // 5 5 10
        // 43 1003 10
        g1.datos(5, 5, 10, 150);
        g1.generador();
        g2.datos(43, 1003, 10, 150);
        g2.generador();
        r1 = g1.getMuestraA();
        r2 = g2.getMuestraA();

        i = 0;
        while (i < r1.length) {
            System.out.println(r2[i]);
            i++;
        }
        // Determinamos x1
        i = 0;
        while (i < r1.length) {
            x1[i] = -1 + r1[i] * (1 - (-1));
            // System.out.println(x1[i]);
            i++;
        }
        // determinamos los f(x1)
        i = 0;
        while (i < r1.length) {

            fx1[i] = 1.5 * Math.pow(x1[i], 2);
            // System.out.println(fx1[i]);
            i++;
        }
        // determinamos f(x1)/1.5 <-=M
        i = 0;
        while (i < fx1.length) {
            fx1entUC[i] = (double) (fx1[i] / 1.5);

            i++;
        }
        // vemos si R2<=f(x1)/M
        i = 0;
        while (i < fx1.length) {
            if (r2[i] <= fx1entUC[i]) {
                resultados[i] = x1[i];
            }
            // System.out.println(resultados[i]);
            i++;
        }

        i = 0;
        int a = 0;
        while (i < resultados.length) {
            if (resultados[i] != 0.0) {
                x1aux[a] = x1[i];
                fx1aux[a] = fx1[i];
                a++;
            }

            i++;
        }

        i = 0;
        while (i < resultados.length) {
            // System.out.println(x1aux[i]);
            // System.out.println(fx1aux[i]);
            i++;
        }

    }
}
