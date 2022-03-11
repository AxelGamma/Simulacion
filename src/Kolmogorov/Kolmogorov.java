package Kolmogorov;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Kolmogorov {
    Scanner sc = new Scanner(System.in);
    int xo, a, m, numeroG;
    int b, conteo = 15, j = 0;

    double[] muestraA = new double[50];//muestra
    double[] muestraB = new double[15];
    double[] muestraC = new double[15];
    double[] AcumuEspe = new double[muestraC.length];
    double[] Diferencia = new double[muestraC.length];
    double uniformidad, Dmax;
    DecimalFormat format = new DecimalFormat("#,###.##");
    quickSort ordenamiento = new quickSort();
    chiCudrada chicuadrada = new chiCudrada();

    public void Kolmogorov() {

    }

    public void datos() {
        System.out.println("Introduce la semilla -Xo- ");
        xo = sc.nextInt();

        System.out.println("Introduce -a-");
        a = sc.nextInt();

        System.out.println("Introduce el valor de -b-");
        b = sc.nextInt();

        m = (int) Math.pow(2, b);//2^10
    }

    public void generados() {
        int i = 0;
        System.out.println("i   " + "numeros generados    " + "     Uniformidad");
        while (i < m) {
            numeroG = (a * xo) % m;
            uniformidad = (float) xo / m;
            System.out.println(i + 1 + "    " + xo + "     , " + numeroG + "    " + uniformidad);
            xo = numeroG;
            if (i > 30 && j < muestraA.length) {
                muestraA[j] = uniformidad;
                j++;
            }
            i++;
        }

        i = 0;
        System.out.println("i   " + "---Muestras arreglo A---");
        while (i < muestraA.length) {
            System.out.println(i + 1 + "   " + muestraA[i]);
            i++;
        }

        //Arreglo A Muestra con 50
        //Arreglo B de 15
        //Arreglo C
        i = 0;
        while (i < muestraB.length) {
            muestraB[i] = muestraA[i];
            i++;
        }
        i = 0;

        System.out.println("i   " + "---Muestras arreglo B---");
        while (i < muestraB.length) {
            System.out.println(i + 1 + "   " + muestraB[i]);
            i++;
        }
        muestraC = muestraB.clone();
        ordenamiento.quickSort(muestraC, 0, muestraC.length - 1);

        i = 0;
        System.out.println("---Muestras arreglo C Ordenada---");
        System.out.print("i     Acum.Obs      Acum.Esp         Diferencia \n");
        while (i < muestraC.length) {
            AcumuEspe[i] = Double.parseDouble(format.format((double) (i + 1) / muestraC.length));
            Diferencia[i] = Math.abs(muestraC[i] - (double) (i + 1) / muestraC.length);
            i++;
        }
        i = 0;
        while (i < muestraC.length) {
            System.out.println(i + 1 + "   " + muestraC[i] + "  " + AcumuEspe[i] + "       " + Diferencia[i]);
            i++;
        }

        ordenamiento.quickSort(Diferencia, 0, Diferencia.length - 1);

        System.out.print("  Dmax= " + Diferencia[Diferencia.length - 1]);

    }

    public double[] getMuestraA() {
        return muestraA;
    }
}
