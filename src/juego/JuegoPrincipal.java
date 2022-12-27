package juego;

import java.io.FileReader;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class JuegoPrincipal extends javax.swing.JFrame {

    static int contadorTurnos;
    static int turnosJugables;
    static HashMap<String,Integer> hm;
    
    public JuegoPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnJugar = new javax.swing.JButton();
        BtnContinuar = new javax.swing.JButton();
        BtnUltimas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JUEGO DEDOS");

        BtnJugar.setText("INICIO");
        BtnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJugarActionPerformed(evt);
            }
        });

        BtnContinuar.setText("CONTINUAR");
        BtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnContinuarActionPerformed(evt);
            }
        });

        BtnUltimas.setText("VER RESULTADOS ÚLTIMA PARTIDA");
        BtnUltimas.setToolTipText("");
        BtnUltimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUltimasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnUltimas, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnJugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnContinuar)
                .addGap(18, 18, 18)
                .addComponent(BtnUltimas)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJugarActionPerformed
        hm=new HashMap<String,Integer>();
        
        //ArrayList<String> Ganador = new ArrayList<>();
        int dedo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de dedos para jugar (Min:0 y Max:5): ", "DETERMINAR DEDOS"));
        int turnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de partidas que desea jugar: ", "CANTIDAD DE PARTIDAS"));
        turnosJugables= turnos;
        contadorTurnos = 0;
        Juego ventana = new Juego(dedo, contadorTurnos, turnosJugables, hm);
        //contadorTurnos++;
    }//GEN-LAST:event_BtnJugarActionPerformed

    private void BtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnContinuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnContinuarActionPerformed

    private void BtnUltimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUltimasActionPerformed
        // Creates an array of character
        String jugada="";
        char[] array = new char[100];

        try {
          // Creates a reader using the FileReader
          FileReader input = new FileReader("resultados.txt");

          // Reads characters
          input.read(array);
          for (int i=0; i<array.length;i++){
              jugada = jugada + array[i];
          }
          JOptionPane.showMessageDialog(null,
                jugada,
                "PARTIDA ANTERIOR",
                JOptionPane.INFORMATION_MESSAGE);
          // Closes the reader
          input.close();
        }

        catch(Exception e) {
          e.getStackTrace();
        }
    }//GEN-LAST:event_BtnUltimasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnContinuar;
    private javax.swing.JButton BtnJugar;
    private javax.swing.JButton BtnUltimas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

