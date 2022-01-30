/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Splashscreen extends javax.swing.JFrame {

    /**
     * Creates new form SelamatDatang
     */
   
    public Splashscreen() {
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

        panelUtama = new javax.swing.JPanel();
        txtLoading = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        LoadingProgresBar = new javax.swing.JProgressBar();
        lblLoadingAnimasi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Rumah Sakit");

        panelUtama.setBackground(new java.awt.Color(255, 255, 255));

        txtLoading.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtLoading.setText("99 %");

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/image1.png"))); // NOI18N

        lblWelcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/selamat-datang-1.png"))); // NOI18N

        LoadingProgresBar.setForeground(new java.awt.Color(25, 131, 237));
        LoadingProgresBar.setBorderPainted(false);
        LoadingProgresBar.setOpaque(true);

        lblLoadingAnimasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loadingAnimasi.gif"))); // NOI18N

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(LoadingProgresBar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(txtLoading))
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(lblLoadingAnimasi)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtamaLayout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtamaLayout.createSequentialGroup()
                        .addComponent(lblImage)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtamaLayout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addGap(209, 209, 209))))
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLoadingAnimasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadingProgresBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLoading)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        Splashscreen Splash = new Splashscreen();
        Splash.setVisible(true);
        
        try{
            for (int i=0; i <=100; i++){
                Thread.sleep(40);
                Splash.txtLoading.setText(""+i+" %");
                Splash.LoadingProgresBar.setValue(i);
                if ( i == 100){
                    LoginForm login = new LoginForm();
                    Splash.setVisible(false);
                    login.setVisible(true);
                }
            }
        }catch(Exception e){
            
        }   
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private transient javax.swing.JProgressBar LoadingProgresBar;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLoadingAnimasi;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JLabel txtLoading;
    // End of variables declaration//GEN-END:variables
}
