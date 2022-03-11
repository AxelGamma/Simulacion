package Kolmogorov;

import java.util.Scanner;

public class chiCudrada {
    double[] muestras;
    int contador1 = 0, contador2 = 0, contador3 = 0, contador4 = 0, contador5 = 0, esperado = 10;
    int sumaObserv=0;

    //determinamos los rangos------ Observados-----   Esperados
    //0.000>= ri < 0.200                                  10
    //0.200>= ri < 0.400                                  10
    //0.400>= ri <0.600                                   10
    //0.600>= ri <0.800                                   10
    //0.800>+ ri <1
    public void chiCuadrada(double[] muestraA) {
        this.muestras = muestraA;
    }

    public int contador() {
        int i = 0;
        while (i < muestras.length) {
            if (muestras[i] >= 0.000 && muestras[i] < 0.200) {
                contador1++;
                sumaObserv++;
            } else if (muestras[i] >= 0.200 && muestras[i] < 0.400) {
                contador2++;
                sumaObserv++;
            } else if (muestras[i] >= 0.400 && muestras[i] < 0.600) {
                contador3++;
                sumaObserv++;
            } else if (muestras[i] >= 0.600 && muestras[i] < 0.800) {
                contador4++;
                sumaObserv++;
            } else if (muestras[i] >= 0.800 && muestras[i] < 1) {
                contador5++;
                sumaObserv ++;
            }
            i++;
        }
        return 0;
    }

    public void resultados() {
        contador();
        System.out.printf("\n%62s", "-Prueba chiCuadrada-\n");
        System.out.println(String.format("%s", "i") + "" + String.format("%23s", "Rangos") + "" + String.format("%22s", "Observado") + "" + String.format("%22s", "Esperado") + "" + String.format("%22s", "((O-E)^2)/E"));
        System.out.println(String.format("%s", 1) + String.format("%29s", "0.000>= ri < 0.200") + String.format("%12s", getContador1()) + String.format("%22s", esperado) + String.format("%25f", Math.pow(getContador1() - 10, 2) / getContador1()));
        System.out.println(String.format("%s", 2) + String.format("%29s", "0.200>= ri < 0.400") + String.format("%12s", getContador2()) + String.format("%22s", esperado) + String.format("%25f", Math.pow(getContador2() - 10, 2) / getContador2()));
        System.out.println(String.format("%s", 3) + String.format("%29s", "0.400>= ri < 0.600") + String.format("%12s", getContador3()) + String.format("%22s", esperado) + String.format("%25f", Math.pow(getContador3() - 10, 2) / getContador3()));
        System.out.println(String.format("%s", 4) + String.format("%29s", "0.600>= ri < 0.800") + String.format("%12s", getContador4()) + String.format("%22s", esperado) + String.format("%25f", Math.pow(getContador4() - 10, 2) / getContador4()));
        System.out.println(String.format("%s", 5) + String.format("%25s", "0.800>= ri < 1") + String.format("%16s", getContador5()) + String.format("%22s", esperado) + String.format("%25f", Math.pow(getContador5() - 10, 2) / getContador5()));
        System.out.println(String.format("%42d",sumaObserv)+String.format("%22d",esperado*5));
    }

    public int getContador1() {
        return contador1;
    }

    public int getContador2() {
        return contador2;
    }

    public int getContador3() {
        return contador3;
    }

    public int getContador4() {
        return contador4;
    }

    public int getContador5() {
        return contador5;
    }
}
