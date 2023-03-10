
package juego;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Juego extends JFrame{
    
    int cantidadDedos;
    JPanel Contenido = new JPanel();
    Mano ManoDerecha1 = new Mano(cantidadDedos, 1);
    Mano ManoDerecha2 = new Mano(cantidadDedos, 2);
    Mano ManoIzquierda1 = new Mano(cantidadDedos, 1);
    Mano ManoIzquierda2 = new Mano(cantidadDedos, 2);
    private boolean manoSeleccionada = false;
    int puntaje=0;
    private Mano[] pbtn = new Mano[2];
    //turno
    private boolean PrimeraMano = true;
    //return b ? 1 : 0;
    boolean turno = Aleatorio();
    static int contadorTurnos;
    static int turnosJugables;
    static HashMap<String,Integer> hm;
    
    public Juego(int dedo, int turnoContador, int turnosJug, HashMap<String,Integer> hash){
        hm = hash;
        setSize(420, 560);
        setResizable(false);
        setTitle("D2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
        //ReversoCartas();
        cantidadDedos = dedo;
        contadorTurnos = turnoContador;
        turnosJugables = turnosJug;
        JOptionPane.showMessageDialog(null,
                "Inicia el Jugador " + Turno(turno),
                "TURNO",
                JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    private void createContents(){
        
        JLabel LblTitulo = new JLabel("D2", SwingConstants.CENTER);
        add (LblTitulo, BorderLayout.NORTH);
        JLabel LblTurnos = new JLabel("Partida Número "+ (contadorTurnos+1), SwingConstants.CENTER);
        add (LblTurnos, BorderLayout.NORTH);
        add(Contenido, BorderLayout.CENTER);
        
        
        GroupLayout Orden = new GroupLayout(Contenido);
        Contenido.setLayout(Orden);
        
        Orden.setHorizontalGroup(
            Orden.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Orden.createSequentialGroup()
                .addContainerGap()
                .addGroup(Orden.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(Orden.createSequentialGroup()
                        .addComponent(ManoDerecha1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ManoDerecha2))
                    .addGroup(Orden.createSequentialGroup()
                        .addComponent(ManoIzquierda1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ManoIzquierda2)))
            .addContainerGap())
        );
            Orden.setVerticalGroup(
            Orden.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(Orden.createSequentialGroup()
                .addContainerGap()
                .addGroup(Orden.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ManoDerecha1)
                    .addComponent(ManoDerecha2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Orden.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ManoIzquierda1)
                    .addComponent(ManoIzquierda2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap())
        );
        
        ManoDerecha1.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                btnActionPerformed(evt, ManoDerecha1);
            } catch (IOException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ManoDerecha1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                try {
                    btnMouseExited(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ManoDerecha2.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                btnActionPerformed(evt, ManoDerecha2);
            } catch (IOException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ManoDerecha2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                try {
                    btnMouseExited(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ManoIzquierda1.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                btnActionPerformed(evt, ManoIzquierda1);
            } catch (IOException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ManoIzquierda1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                try {
                    btnMouseExited(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ManoIzquierda2.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                btnActionPerformed(evt, ManoIzquierda2);
            } catch (IOException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ManoIzquierda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                try {
                    btnMouseExited(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    private void btnActionPerformed(ActionEvent evt, Mano btn) throws IOException {                                      
        btnEnabled(btn);
    }
    
    private void btnEnabled(Mano btn) throws IOException {
        //Si aún no se seleccionó una mano antes
        if(!manoSeleccionada) {
            //Desactivamos la mano ya que no puede atacarse a si misma
            btn.setEnabled(false);
            pbtn[0] = btn;
            //Extraemos el puntaje de la mano
            puntaje = btn.getDedos();
            manoSeleccionada = true;
            PrimeraMano = false;
        }
        //Analizar la métrica para determinar la suma de dedos y si 
        //Ya hay un ganador
        else {
            btn.setEnabled(false);
            //Ya se acumularon los dedos
            puntaje += btn.getDedos();
            pbtn[1] = btn;
            PrimeraMano = true;
            //AGREGAR PARA VER QUE AMBAS MANOS ESTEN ACTIVAS
            pregwin();
        }
        adicionar();
    }
    
    private void pregwin() throws IOException {
        if(ManoDerecha1.getDedos() == 0 && ManoIzquierda1.getDedos() == 0) {
            JOptionPane.showMessageDialog(this, "GANO JUGADOR NÚMERO 2", "GANADOR!!",
                    JOptionPane.INFORMATION_MESSAGE);
            //contador++;
            dispose();
            hm.put("PARTIDA " + (contadorTurnos + 1) , 2);
            contadorTurnos++;
            if (verificacion()){
                Juego ventana = new Juego(cantidadDedos, contadorTurnos, turnosJugables, hm);
            }
            
        }
        else if (ManoDerecha2.getDedos() == 0 && ManoIzquierda2.getDedos() == 0){
            JOptionPane.showMessageDialog(this, "GANO JUGADOR NÚMERO 1", "GANADOR!!",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
            hm.put("PARTIDA " + (contadorTurnos + 1) , 1);
            contadorTurnos++;
            if (verificacion()){
                Juego ventana = new Juego(cantidadDedos, contadorTurnos, turnosJugables, hm);
            }
        }
    }
    
    private boolean verificacion() throws IOException {
        String resultados="";
        int[] punto = {0,0};
        String ganador;
        if (!(contadorTurnos<turnosJugables)){
            for (String key: hm.keySet()){  
                resultados = "\n" + key+ " -> " + hm.get(key) + resultados;
                if (hm.get(key)==1){
                    punto[0]++;
                }
                else {
                    punto[1]++;
                }
            }
            if (punto[0]>punto[1]){
                ganador = "JUGADOR 1";
            } else if (punto[0]<punto[1]){
                ganador = "JUGADOR 2";
            } else {
                ganador = "EMPATE";
            }
            JOptionPane.showMessageDialog(null,
                "FINALMENTE LOS RESULTADOS SON \n" + resultados + "\n RESULTADO GANADOR: " + ganador,
                "GANADOR",
                JOptionPane.INFORMATION_MESSAGE);
            writeArray(hm);
            return false;
        }
        return true;
    }
    
    private void adicionar() throws IOException {
        //Desactivar las que no son de sus manos
        //entonces turno=false(0) es equipo 1 y si primeraMano es true entonces tienen
        //que estar actvivadas los de la manoderecha1 y manoizquierda1
        //o también puede ser que sea el turno=true(1) y que primeraMano sea false
        if ((!turno && PrimeraMano)||(turno && !PrimeraMano)){
            if (ManoDerecha1.getDedos()!=0) ManoDerecha1.setEnabled(true);
            if (ManoIzquierda1.getDedos()!=0) ManoIzquierda1.setEnabled(true);
            ManoDerecha2.setEnabled(false);
            ManoIzquierda2.setEnabled(false);
        }
        else {
            ManoDerecha1.setEnabled(false);
            ManoIzquierda1.setEnabled(false);
            if (ManoDerecha2.getDedos()!=0) ManoDerecha2.setEnabled(true);
            if (ManoIzquierda2.getDedos()!=0) ManoIzquierda2.setEnabled(true);
        }
        
        if(manoSeleccionada && PrimeraMano) {
            if(puntaje<cantidadDedos) {
                pbtn[1].ActualizarDedos(puntaje);
                //Se le resta 10
            }
            else if (puntaje==cantidadDedos){
                pbtn[1].ActualizarDedos(0);
                //Mató esa mano
                pbtn[1].setEnabled(false);
            }
            else {
                puntaje=puntaje%cantidadDedos;
                pbtn[1].ActualizarDedos(puntaje);
            }
            puntaje=0;
            manoSeleccionada = false;
            turno=!turno;
            //Deshabilitar a los que no les corresponde ese turno y volverloa a activar
            //En el metodo btnEnabled
        }
        pregwin();
    }
    
    private void btnMouseExited(MouseEvent evt) throws IOException {                                   
        // TODO add your handling code here:
        adicionar();
    }
    
    private int Turno(boolean turno) {                                   
        // TODO add your handling code here:
        if (turno) return 2;
        return 1;
    }
    
    public static boolean Aleatorio(){
        Random aleatorio = new Random();
        int num = aleatorio.nextInt(1-0+1)+0;
        return num == 1;
    }
    
    private static void writeArray(HashMap<String,Integer> mapa) throws IOException {
        FileWriter fr;
        int[] punto = {0,0};
        String ganador;
        String resultados="";
        try{
            fr=new FileWriter("resultados.txt");
            for (String key: hm.keySet()) {
                resultados = "\n" + key+ " -> " + hm.get(key) + resultados;
                fr.write("\n");
                //fout.write("<br />");
            }
            if (punto[0]>punto[1]){
                ganador = "JUGADOR 1";
            } else if (punto[0]<punto[1]){
                ganador = "JUGADOR 2";
            } else {
                ganador = "EMPATE";
            }
            fr.write("FINALMENTE LOS RESULTADOS SON \n" + resultados + "\n RESULTADO GANADOR: " + ganador);
            fr.close();
        }catch(IOException ex){}
    }
}
