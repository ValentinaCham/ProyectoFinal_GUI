package juego;
import java.awt.*;
import javax.swing.*;
public class Mano extends JButton{
    
    int dedos;
    int jugador;
    
    public Mano(int CantidadDedos, int jug){
        dedos = 1;
        jugador = jug;
        setSize(50, 50);
        //D1_mano0
        setIcon(new ImageIcon(getClass().getResource("/ilus/D"+jugador+"_mano"+dedos+".png")));
        setVisible(true);
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusable(false);
    }
    
    public int getDedos(){
        return dedos;
    }
    
    public void ActualizarDedos(int nuevoDedos){
        dedos=nuevoDedos;
        setIcon(new ImageIcon(getClass().getResource("/ilus/D"+jugador+"_mano"+dedos+".png")));
    }

}



