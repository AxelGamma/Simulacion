package Proyecto;

public class Montecarlo {
    double[] muestra1, muestra2;

    // integral 2x^2+3 intervalo de 1 3
    // introducimos los dos arreglos con las muestras
    public Montecarlo(double[] muestra1, double[] muestra2) {
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
    }

    public void showArray() {
        int i = 0;
        double primeraOperacion, segundaOperacion;
        System.out.println(
                String.format("%5s", "Array 1") + String.format("%18s", "1+2(Array 1)") + String.format("%15s", "2*x+3")
                        + String.format("%15s", "Array 2"));
        while (i < muestra1.length) {
            primeraOperacion = (2 * (Math.pow(muestra1[i], 2) + 3));
            System.out.println(String.format("%10f", muestra2[i]));
            i++;
        }
    }

}
