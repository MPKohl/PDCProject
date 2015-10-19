/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.project.View;

/**
 *
 * @author shanon
 */
public class GUIHelpInformation extends javax.swing.JFrame {

    /**
     * Creates new form GUIHelpInformation
     */
    public GUIHelpInformation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtHelp = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtHelp.setColumns(20);
        txtHelp.setRows(5);
        txtHelp.setText("MOVE:\nUse the directional arrow buttons to move the player: LEFT, RIGHT, UP, DOWN.\n\nTILE TYPES:\nThere are four types of tiles on the map: EMPTY, ENEMY, BLOCKED, CHALLENGE.\n\nEMPTY TILES:\nThese tiles appear as plain grass and can be accessed by the player, no event will happen on these tiles.\n\nENEMY TILES:\nThese tiles appear as plain grass, the enemy is hidden and will not be revealed till the tile is navigated to. \n\nBLOCKED TILES:\nThese tiles appear as lava and cannot be accessed by the player.\n\nCHALLENGE TILES:\nThese tiles appear as a fairy and will prompt a riddle that must be answered by the player. Correct answers will provide experience and rejuvanated health.\n\nPLAYER:\nThe player will appear as an archer, warrior, or wizard sprite on the map.\n\nHEALTH BAR:\nDisplays the player health in red at bottom of the screen.\n\nExPERIENCE BAR:\nDisplays the player experience at bottom of the screen.\n\nAIM OF GAME:\nTo complete challenges, fight enemies and find the boss on the map.\n\n\n");
        jScrollPane1.setViewportView(txtHelp);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to Help");

        jToggleButton1.setText("Close");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jToggleButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//    txtHelp.setText("Welcome To The Amazing Adventurer Game");
//    txtHelp.setText(txtHelp.getText() + "MOVING\nUse the directional button keys to move LEFT, RIGHT, UP, DOWN.\nCannot move while fighting an enemy or doing a challenge.");
//    txtHelp.setText(txtHelp.getText() + "\nCHALLENGES\nChallenges will present you with a riddle to be solved, solving the riddle will rejuvanate player health and grant experience");
//    txtHelp.setText(txtHelp.getText() + "\nTILE TYPES\nThere are four types of tiles: EMPTY, BLOCKED, CHALLENGE, ENEMY");
//    txtHelp.setText(txtHelp.getText() + "\nBLOCKED TILE\nAppears on the map as lava, this tile cannot be accessed.");
////    txtHelp.setText(txtHelp.getText() + "\nENEMY\n"
    
    
    }//GEN-LAST:event_formWindowOpened

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIHelpInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIHelpInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIHelpInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIHelpInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIHelpInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea txtHelp;
    // End of variables declaration//GEN-END:variables
}
