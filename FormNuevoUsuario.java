/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Models.VerPrestamos;
import Models.VerUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;

/**
 *
 * @author hol33
 */
public class FormNuevoUsuario extends javax.swing.JFrame {
VerUsuario usu = new VerUsuario();
AgregarAlquiler ag = new AgregarAlquiler();
public String newUsuario =" ";
    /**
     * Creates new form FormNuevoUsuario
     */
    public FormNuevoUsuario() {
        initComponents();
        showPasswordCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkbox = (JCheckBox) e.getSource();
                txtContraseña.setEchoChar(checkbox.isSelected() ? '\0' : '*');
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Txtusername = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        showPasswordCheckbox = new javax.swing.JCheckBox();
        btnInicio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnNewC = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 232, 198));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Por  Favor Inicie Sesion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 200, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Bienvenido a DriveSmart");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 310, 70));

        Txtusername.setBackground(new java.awt.Color(218, 212, 181));
        Txtusername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Txtusername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.add(Txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 250, 80));

        txtContraseña.setBackground(new java.awt.Color(218, 212, 181));
        txtContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 250, 80));

        showPasswordCheckbox.setBackground(new java.awt.Color(242, 232, 198));
        showPasswordCheckbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showPasswordCheckbox.setText("Mostrar Contraseña");
        showPasswordCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckboxActionPerformed(evt);
            }
        });
        jPanel1.add(showPasswordCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        btnInicio.setBackground(new java.awt.Color(210, 180, 140));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInicio.setText("Iniciar Sesion");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 250, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/user (2).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 70, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/password.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        btnNewC.setBackground(new java.awt.Color(210, 180, 140));
        btnNewC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNewC.setText("No tienes cuenta?");
        btnNewC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 250, 40));

        btnRegresar.setBackground(new java.awt.Color(210, 180, 140));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPasswordCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckboxActionPerformed
      
    }//GEN-LAST:event_showPasswordCheckboxActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
     String nombreUsuario = Txtusername.getText();
     newUsuario = Txtusername.getText();
    String contraseña = new String(txtContraseña.getPassword());
    AgregarAlquiler ag = new AgregarAlquiler();
    
    ArrayList<VerUsuario> listaUsuarios = usu.obtenerUsuarios();

    // Verifica si el nombre de usuario y la contraseña ingresados coinciden con algún usuario en la lista
    boolean credencialesValidas = false;
    for (VerUsuario usuario : listaUsuarios) {
        if (usuario.getUsername().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
            credencialesValidas = true;

            // Establecer el nombre de usuario actual
            usu.setUsuarioActual(nombreUsuario);
            
            
            VerPrestamos prestamo = new VerPrestamos();
            prestamo.setUsername(usuario.getUsername()); 
            prestamo.realizarAlquiler(); 
            ag.show();
            this.dispose();
            break;
        }
    }

    
    if (!credencialesValidas) {
        
        System.out.println("¡Nombre de usuario o contraseña inválidos!");
    }
    }//GEN-LAST:event_btnInicioActionPerformed
    
    private void btnNewCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCActionPerformed
        // TODO add your handling code here:
        CrearCuenta co = new CrearCuenta();
        this.dispose();
        co.show();
    }//GEN-LAST:event_btnNewCActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FormElegir fu = new FormElegir();
        fu.show();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(FormNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNuevoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Txtusername;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnNewC;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox showPasswordCheckbox;
    private javax.swing.JPasswordField txtContraseña;
    // End of variables declaration//GEN-END:variables
}
