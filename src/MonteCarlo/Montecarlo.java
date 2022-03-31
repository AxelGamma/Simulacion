package MonteCarlo;

public class Montecarlo {
    private double[] muestra1, muestra2;
    private int contar = 0;
    private int nototal = 0;

    // integral 2x^2+3 intervalo de 1 3
    // introducimos los dos arreglos con las muestras
    public Montecarlo(double[] muestra1, double[] muestra2, int noTotal) {
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.nototal = noTotal;
    }

    public void showArray() {
        int i = 0;
        double primeraOperacion, segundaOperacion;
        System.out.println(
                String.format("%5s", "No Aleatorios 1") + String.format("%15s", "1-x^2")
                        + String.format("%17s", "Array 2")
                        + String.format("%30s", "Up=0 y Down= bajo curva"));
        while (i < muestra1.length) {
            primeraOperacion = (1 - (Math.pow(muestra1[i], 2)));
            System.out.print(String.format("\n%f5", muestra1[i]) + String.format("%24f", primeraOperacion)
                    + String.format("%15f", muestra2[i]));
            if (muestra2[i] < primeraOperacion) {
                System.out.printf("%15f", muestra2[i]);
                contarPase();
            } else {
                System.out.printf("%15d", 0);
            }
            i++;
        }

        resultados();


    }

    private void resultados() {
        System.out.println(
                "\n-----------------------------------------------------------------RESULTADOS------------------------------------------------------");
        System.out.println("\nNumeros bajo la curva= " + getContar());
        System.out.println("Numero total de puntos= " + getNototal());
        System.out.println("Area total estimada= " + areaTotalEst());
        System.out.println("Area bajo la curva por integracion= 0.66");
    }

    private float areaTotalEst() {

        return (float) getContar() / getNototal();
    }

    private void contarPase() {
        contar += 1;
    }

    private int getContar() {
        return contar;
    }

    public int getNototal() {
        return nototal;
    }
}
