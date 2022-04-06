package VariablesAleatorias;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class VariablesAl {
    private double[] muestra;
    private int i, a, b;
    private String datoA, datoB;
    Scanner sc = new Scanner(System.in);

    public VariablesAl(double[] muestra) {
        this.muestra = muestra;
    }

    public void show() {
        // Algoritmo terminado
        // x=a+Ri(b-a)
        datosAd();
        // Distribucion uniforme
        uniforme();
        empirica();

    }

    private void datosAd() {
        datoA = JOptionPane.showInputDialog("Introduce el valor de a");
        a = Integer.parseInt(datoA);
        datoB = JOptionPane.showInputDialog("Introduce el valor de b");
        b = Integer.parseInt(datoB);
    }

    private void uniforme() {
        // Variable aleatoria continua U~(a,b)

        // Funcion de densidad
        // F(x)=1/(b-a) -> Integramos de a-b se tiene la distribucion acumulada F(x)

        // Distribucion Acumulada
        // F(x)=(x-a)/(b-a) -> x=F(x)(b-a)+a

        // Algoritmo terminado
        // x=a+Ri(b-a)
        System.out
                .println("--------------------------------------Uniforme---------------------------------------------");
        System.out.println(String.format("%15s", "Ri") + String.format("%20s", "x=a(b-a)Ri"));
        i = 0;
        while (i < muestra.length) {
            System.out.println(String.format("%15f", muestra[i]) + String.format("%15f", a + (b - a) * muestra[i]));
            i++;
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    private void empirica() {
        // empirica
        // f(x)=4x dx
        // f(x)=2x^2
        // x=raiz(f(x)/2)
        System.out
                .println("--------------------------------------Empirica---------------------------------------------");
        System.out.println(String.format("%15s", "Ri") + String.format("%20s", "x=raiz(f(x)/2)"));
        i = 0;
        while (i < muestra.length) {
            System.out.println(String.format("%15f", muestra[i]) + String.format("%15f", Math.sqrt(muestra[i] / 2)));
            i++;
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    private void discreta() {
        //Bernoulli
        // El siguiente algoritmo es bastante intuitivo y es equivalente al método de la
        // transformación inversa (si se invierten los papeles de U y 1 - U):
        // 1. Generar U~U(0, 1).
        // 2. Si U <= p, devuelve X + 1. En caso contrario, devuelve X = 0.
    }
}
