package Kolmogorov;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Generador generador = new Generador();
            Kolmogorov prueba1 = new Kolmogorov();
            chiCudrada chi = new chiCudrada();
            while(generador.getEsCompleto()!=true) {
                generador.datos();
                generador.generador();
            }

            // chi.chiCuadrada(prueba1.getMuestraA());
            // chi.resultados();

        } catch (Exception e) {
            System.out.println("Introduce puros numeros");

        }

    }

}
