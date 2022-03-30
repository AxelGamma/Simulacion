package Proyecto;

//estado: falta hacer el guardado del numero que ya se guardo
public class Poker {
    private double[] muestra;
    private String[] formateado, muestraPoker, resultPruebas;
    private int j, i, conteo = 1, a, ya, s;
    private int td = 0, par = 0, dosPares = 0, tercia = 0, terciaPar = 0, poker = 0, quintilla = 0;
    private double chiCalculada;
    private char agarrado;
    private char[] yaAgarrado;
    private boolean diferente = true, estadoPrueba = false;

    public Poker(double[] muestras) {
        this.muestra = muestras;
        formateado = new String[muestras.length];
        muestraPoker = new String[muestras.length];
        resultPruebas = new String[muestra.length];
    }

    // Metodo para imprimir nuestra muestra
    public void muestra() {
        i = 0;
        while (i < muestra.length) {
            formateado[i] = String.valueOf(muestra[i]);
            i++;
        }

        i = 0;

        // System.out.println("---Datos de guardado de tipo array---\n");
        while (i < formateado.length) {
            // System.out.println(formateado[i]); //Muestra o imprime los numeros
            j = 2;
            muestraPoker[i] = "";
            while (j < 7) {

                muestraPoker[i] += formateado[i].charAt(j);
                j++;
            }
            i++;
        }

        // Realizacion de las pruebas
        // System.out.println(
        // "---------------------------------------------------------------------------------------------------------");
        pruebas();
        // i = 0;
        // while (i < muestraPoker.length) {
        // System.out.println(String.format("%d", (i + 1)) + String.format("%10s",
        // muestraPoker[i])
        // + String.format("%5s", resultPruebas[i]));
        // i++;
        // }

        operaciones();

    }

    private void pruebas() {

        i = 0;
        j = 0;
        a = 0;
        ya = 0;
        while (i < muestraPoker.length) {// recorre los numeros del las muestra
            yaAgarrado = new char[5];// se borran los datos dentro de los ya agarrados
            a = 0;
            while (a < yaAgarrado.length) {
                yaAgarrado[a] = '0';
                a++;
            }
            resultPruebas[i] = "";
            a = 0;
            while (a < muestraPoker[i].length()) {// recorre los numeros dentro de la muestra
                j = a + 1;
                s = 0;
                while (s < yaAgarrado.length) {

                    if (muestraPoker[i].charAt(a) != yaAgarrado[s]) {// vaclor del vector en el lugar i <>
                        diferente = true;
                    } else {
                        break;
                    }
                    s++;

                }
                if (diferente == true) {

                    while (j < muestraPoker[i].length()) {// recorremos j
                        agarrado = ' ';
                        s = 0;

                        if (muestraPoker[i].charAt(a) == muestraPoker[i].charAt(j)) {

                            agarrado = muestraPoker[i].charAt(a);
                            conteo++;
                            yaAgarrado[ya] = agarrado;
                        }
                        j++;// recorre los numeros en la posicion i

                    }
                    if (conteo != 1) {
                        espar(conteo, i);

                    }
                    conteo = 1;
                }
                // recorre los numeros al siguiente numero
                a++;
                diferente = false;
            }
            i++;// recorre a los siguientes nuemeros del arreglo
        }

    }

    private void operaciones() {

        suma();
        i = 0;
        int suma = td + par + dosPares + tercia + terciaPar + poker + quintilla;
        double tdEsp = suma * 0.3024, parEsp = suma * 0.504, dosParesEsp = suma * 0.108, terciaEsp = suma * 0.072,
                terciaParEsp = suma * 0.009,
                pokerEsp = suma * 0.0045, quintillaEsp = suma * 0.0001;
        double tdEsta = Math.pow(td - tdEsp, 2) / tdEsp, parEsta = Math.pow(par - parEsp, 2) / parEsp,
                dosParesEsta = Math.pow(dosPares - dosParesEsp, 2) / dosParesEsp,
                terciaEsta = Math.pow(tercia - terciaEsp, 2) / terciaEsp,
                terciaParEsta = Math.pow(terciaPar - terciaParEsp, 2) / terciaParEsp,
                pokerEsta = Math.pow(poker - pokerEsp, 2) / pokerEsp,
                quintillaEsta = Math.pow(quintilla - quintillaEsp, 2) / quintillaEsp;
        this.chiCalculada = tdEsta + parEsta + dosParesEsta + terciaEsta + terciaParEsta + pokerEsta + quintillaEsta;
        System.out.println(String.format("%35s", "Todos diferentes")
                + String.format("%10s", "Un par") + String.format("%15s", "Dos pares") + String.format("%15s", "Tercia")
                +
                String.format("%15s", "Tercis + Par") + String.format("%15s", "Poquer")
                + String.format("%15s", "Quintilla") + String.format("%15s", "Suma"));

        System.out.println(String.format("%s", "Observado: ") + String.format("%17d", td)
                + String.format("%15d", par) + String.format("%13d", dosPares) + String.format("%17d", tercia)
                +
                String.format("%12d", terciaPar) + String.format("%17d", poker)
                + String.format("%13d", quintilla) + String.format("%15d", suma));

        System.out.println(String.format("%s", "Esperado: ") + String.format("%23f", tdEsp)
                + String.format("%15f", parEsp) + String.format("%13f", dosParesEsp) + String.format("%17f", terciaEsp)
                +
                String.format("%12f", terciaParEsp) + String.format("%17f", pokerEsp)
                + String.format("%13f", quintillaEsp));

        System.out.println(String.format("%s", "Estadistico: ") + String.format("%23f", tdEsta)
                + String.format("%15f", parEsta) + String.format("%13f", dosParesEsta)
                + String.format("%17f", terciaEsta)
                +
                String.format("%12f", terciaParEsta) + String.format("%17f", pokerEsta)
                + String.format("%13f", quintillaEsta) + String.format("%17f", chiCalculada));
        estadoPrueba();

    }

    private void espar(int numero, int lugar) {

        if (numero == 1) {
            resultPruebas[lugar] += " TD";
        } else if (numero == 2) {
            resultPruebas[lugar] += " P";
        } else if (numero == 3) {
            resultPruebas[lugar] += " T";
        } else if (numero == 4) {
            resultPruebas[lugar] += " Poker";

        } else if (numero == 5) {
            resultPruebas[lugar] += " Quintilla";
        }
    }

    private void suma() {
        i = 0;
        while (i < resultPruebas.length) {
            if (resultPruebas[i].equals("")) {
                td += 1;
            } else if (resultPruebas[i].equals(" P")) {
                par += 1;
            } else if (resultPruebas[i].equals(" P P")) {
                dosPares += 1;
            } else if (resultPruebas[i].equals(" T")) {
                tercia += 1;
            } else if (resultPruebas[i].equals(" T P") || resultPruebas[i].equals(" P T")) {
                terciaPar += 1;
            } else if (resultPruebas[i].equals(" Poker")) {
                poker += 1;
            } else if (resultPruebas[i].equals(" Quintilla")) {
                quintilla += 1;
            }
            i++;
        }
    }

    private void estadoPrueba() {

        if (chiCalculada < 12.592) {
            setEstadoPrueba(true);
        } else {
            setEstadoPrueba(false);
        }

    }

    private void setEstadoPrueba(boolean estadoPrueba) {
        this.estadoPrueba = estadoPrueba;
    }

    public boolean getEstadoPrueba() {
        return estadoPrueba;
    }
}
