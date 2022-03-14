package Kolmogorov;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Kolmogorov {
    Scanner sc = new Scanner(System.in);
    int xo, a, m, numeroG, semilla;
    int b, conteo = 15, j = 0,i;
    boolean periodoCom = true;

    double[] muestraA = new double[50];// muestra
    double[] muestraB = new double[15];
    double[] muestraC = new double[15];
    double[] AcumuEspe = new double[muestraC.length];
    double[] Diferencia = new double[muestraC.length];
    double uniformidad, Dmax;
    DecimalFormat format = new DecimalFormat("#,###.##");
    quickSort ordenamiento = new quickSort();

    public void Kolmogorov() {
        

    }

    
    //Numeros generados
    public void generados() {
        //Prueba de kolmogorov
        i = 0;
        System.out.println("i   " + "---Muestras arreglo A---");
        while (i < muestraA.length) {
            System.out.println(i + 1 + "   " + muestraA[i]);
            i++;
        }

        // Arreglo A Muestra con 50
        // Arreglo B de 15
        // Arreglo C
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

        System.out.print("--------Dmax= " + Diferencia[Diferencia.length - 1] + "---------");


    }


    public double[] getMuestraA() {
        return muestraA;
    }


}
