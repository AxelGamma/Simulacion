package Kolmogorov;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Generador {
    int xo, a, m, numeroG, semilla, b;
    int j = 0, i = 0;
    double[] muestraA = new double[50];// muestra
    double uniformidad;
    boolean EsCompleto=false;
    quickSort ordenamiento = new quickSort();
    Scanner sc = new Scanner(System.in);

    public void datos() {
        System.out.println("Introduce la semilla -Xo- ");
        xo = sc.nextInt();
        semilla = xo;

        System.out.println("Introduce -a-");
        a = sc.nextInt();

        System.out.println("Introduce el valor de -b-");
        b = sc.nextInt();

        m = (int) Math.pow(2, b);// 2^10
    }

    public void generador() {
        i = 0;

        System.out.println(String.format("%10s","i")+String.format("%10s","Numeros generados")+String.format("%10s","Uniformidad"));
        while (i < m) {
            numeroG = (a * xo) % m;
            uniformidad = (float) xo / m;

            System.out.println(i + 1 + "    " + xo + "     , " + numeroG + "    " + uniformidad);
            if (numeroG == semilla) {
                break;
            }
            xo = numeroG;
            if (i > 30 && j < muestraA.length) {
                muestraA[j] = uniformidad;
                j++;
            }

            i++;
        }
        if (getI() < getM()) {
            System.out.println("No es periodo completo");
            setEsCompleto(false);
        } else {
            System.out.println("Es periodo completos");
            setEsCompleto(true);
        }
    }

    public int getI() {
        return i;
    }

    public int getM() {
        return m;
    }

    public boolean getEsCompleto(){return EsCompleto;}

    public void setEsCompleto(boolean esCompleto) {
        EsCompleto = esCompleto;
    }
}
