package Kolmogorov;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Generador {
    //Declaramos las variables x0= semilla
    int xo, a, m, numeroG, semilla, b;
    int j = 0, i = 0;
    double[] muestraA = new double[50];// muestra la cual tiene un tamaño de 40
    double uniformidad;
    boolean EsCompleto=false;
    quickSort ordenamiento = new quickSort();
    Scanner sc = new Scanner(System.in);
    //metodo que es llamado por el main para introducir los datos: xo,a,b
    public void datos() {
        System.out.println("Introduce la semilla -Xo- ");
        xo = sc.nextInt();
        semilla = xo;

        System.out.println("Introduce -a-");
        a = sc.nextInt();

        System.out.println("Introduce el valor de -b-");
        b = sc.nextInt();
        //se calcula m
        m = (int) Math.pow(2, b);// 2^10
    }
    //Creamos un metodo para poder generar los numeros
    public void generador() {
        i = 0;
        //Imprimimos los numeros generados
        System.out.println(String.format("%10s","i")+String.format("%10s","Numeros generados")+String.format("%10s","Uniformidad"));
        //Nuestro bucle empieza en 0 hasta m, en la linea 40 donde se rompe si los se llega a encontrar la semilla
        while (i < m) {
            numeroG = (a * xo) % m;
            uniformidad = (float) xo / m;

            System.out.println(i + 1 + "    " + xo + "     , " + numeroG + "    " + uniformidad);
            //Condicional que hace que el ciclo se detenga al encontar la semilla
            if (numeroG == semilla) {
                break;
            }
            xo = numeroG;
            if (i > 30 && j < muestraA.length) {
                muestraA[j] = uniformidad;
                j++;
            }

            i++;
        }//Si i es igual a los numeros generados entonces se dice que es un periodo completo, en caso contrario no
        if (m/4==i) {
            System.out.println("No es periodo completo");
            setEsCompleto(false);
        } else {
            System.out.println("Es periodo completo");
            setEsCompleto(true);
        }
    }

    public boolean getEsCompleto(){return EsCompleto;}

    public void setEsCompleto(boolean esCompleto) {
        EsCompleto = esCompleto;
    }
}
