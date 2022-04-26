package VariablesAleatorias;

import Pruebas.Generador;

public class Main {
   
    public static void main(String[] args) {
        Generador numeros = new Generador();
        numeros.datos(5,5,10,50);
        numeros.generador();
//
//        VariablesAl variables = new VariablesAl(numeros.getMuestraA());
//        variables.show();
    }
    
    
}
