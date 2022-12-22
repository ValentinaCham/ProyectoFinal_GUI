package juego;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JuegoGeneral {
    
    static int contadorTurnos=1;
    static int turnosJugables;
    public static void main(String[] args) {
        ArrayList<String> Ganador = new ArrayList<>();
        int dedo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de dedos para jugar (Min:0 y Max:5): ", "DETERMINAR DEDOS"));
        int cantidadTurnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de partidas que desea jugar: ", "CANTIDAD DE PARTIDAS"));
        turnosJugables = cantidadTurnos;
        Juego ventana = new Juego(dedo, contadorTurnos);
        contadorTurnos++;
        
    }
}
