package juego;

import java.util.*;

public class DistribucionInicial {
    public int[] ObtenerTablero() {
        int[] TableroCartas = new int[16];
        int cont = 0;
        while(cont < 16) {
            Random r = new Random();
            // na es un numero aleatorio de 1 al 8
            int ale = r.nextInt(8) + 1;
            int numRepeticiones = 0;
            for (int i = 0; i < TableroCartas.length; i++) {
                //Revisara todos los casilleros donde el numero na (random del
                //1 al 8) se repite
                if(TableroCartas[i] == ale) {
                    //La cantidad de veces sera asimilada por el contador
                    numRepeticiones++;
                }
            }
            //Si el numero de veces es menor a 2, entonces quiere decir que esa
            //carta aun no ha salido, o aun no tiene par
            //Solo en ese caso se admite el valor y aumenta el contador porque
            //se ubicara una carta
            if(numRepeticiones < 2) {
                TableroCartas[cont] = ale;
                //El contador solo aumenta cuando nvr es menor que 2
                cont++;
            }//fin
        }
        //Se retorna el arreglo de los pares aleatorios
        return TableroCartas;
    }
}
