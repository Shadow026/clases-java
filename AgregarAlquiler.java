/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Diseño.DiseñoTabla;
import Models.Autos;
import Models.VerPrestamos;
import Models.VerUsuario;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hol33
 */
public class AgregarAlquiler extends javax.swing.JFrame {

 VerUsuario usu = new VerUsuario();
    /**
     * Creates new form AgregarAlquiler
     */
    public AgregarAlquiler() {
        initComponents();
       
        DiseñoTabla();
        mostrarDatosEnTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Placatxt = new javax.swing.JTextField();
        btnAlquilar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        VerAlquileres = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AutoTable = new javax.swing.JTable();
        DateInicio = new com.toedter.calendar.JDateChooser();
        DateEntrega = new com.toedter.calendar.JDateChooser();
        Username = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(192, 130, 97));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Ingrese la placa del auto que le gustaria rentar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        Placatxt.setBackground(new java.awt.Color(226, 199, 153));
        Placatxt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Placatxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Placa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 18))); // NOI18N
        jPanel1.add(Placatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 280, 60));

        btnAlquilar.setBackground(new java.awt.Color(210, 180, 140));
        btnAlquilar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAlquilar.setText("Alquilar");
        btnAlquilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlquilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 280, 40));

        btnRegresar.setBackground(new java.awt.Color(210, 180, 140));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setText("Alquilar un Automovil");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 430, 70));

        VerAlquileres.setBackground(new java.awt.Color(210, 180, 140));
        VerAlquileres.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VerAlquileres.setText("Ver Alquileres Realizados");
        VerAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerAlquileresActionPerformed(evt);
            }
        });
        jPanel1.add(VerAlquileres, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 290, 40));

        AutoTable.setBackground(new java.awt.Color(226, 199, 153));
        AutoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Modelo", "Marca", "Tipo", "Año Fabricacion", "Tarifa por Dia", "Disponibilidad"
            }
        ));
        jScrollPane1.setViewportView(AutoTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 770, 660));

        DateInicio.setBackground(new java.awt.Color(226, 199, 153));
        DateInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Inicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.add(DateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 280, 60));

        DateEntrega.setBackground(new java.awt.Color(226, 199, 153));
        DateEntrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.add(DateEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 280, 60));

        Username.setBackground(new java.awt.Color(226, 199, 153));
        Username.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Username.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Verifique su usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 18))); // NOI18N
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 280, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlquilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquilarActionPerformed

    String placa = Placatxt.getText();
    java.util.Date fechaInicio = DateInicio.getDate();
    java.util.Date fechaEntrega = DateEntrega.getDate();
    String username = Username.getText(); // Obtener el nombre de usuario

    // Validar que se haya seleccionado una fecha de inicio y una fecha de entrega
    if (fechaInicio == null || fechaEntrega == null) {
        
        System.out.println("Por favor, seleccione la fecha de inicio y la fecha de entrega.");
        return;
    }

    // Calcular la diferencia de días
    long diferenciaEnMillis = fechaEntrega.getTime() - fechaInicio.getTime();
    int diferenciaEnDias = (int) TimeUnit.DAYS.convert(diferenciaEnMillis, TimeUnit.MILLISECONDS);

    // Obtener la tarifa diaria
    double tarifaDiaria = obtenerTarifaDiaria(placa);

    // Calcular el costo total
    double costoTotal = diferenciaEnDias * tarifaDiaria;

    
    VerPrestamos prestamo = new VerPrestamos();

    
    prestamo.setUsername(username); // Establecer el nombre de usuario
    prestamo.setPlaca(placa);
    prestamo.setFechainicio(fechaInicio);
    prestamo.setFechaentrega(fechaEntrega);
    prestamo.setCostoTotal(costoTotal);

    // Realizar el alquiler
    boolean alquilerExitoso = prestamo.realizarAlquiler();

    
    if (alquilerExitoso) {
       
        JOptionPane.showMessageDialog(rootPane, "Alquiler realizado con éxito. Costo total: " + costoTotal);
    } else {
        
        JOptionPane.showMessageDialog(rootPane, "Error al realizar el alquiler. Por favor, inténtelo de nuevo.");
    }    
    }//GEN-LAST:event_btnAlquilarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Prestamos_realizados pa = new Prestamos_realizados();
        pa.show();
        this.dispose();

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void VerAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerAlquileresActionPerformed
        
        Prestamos_realizados pre = new Prestamos_realizados();
        pre.show();
        this.dispose();
    }//GEN-LAST:event_VerAlquileresActionPerformed

    public void DiseñoTabla(){
        AutoTable.setDefaultRenderer(Object.class, new DiseñoTabla());
        AutoTable.setRowHeight(30);
        AutoTable.setRowMargin(10);
        AutoTable.getTableHeader().setBackground(Color.decode("#9A3B3B"));
        AutoTable.getTableHeader().setForeground(Color.white);
        
        Font fuente = new Font("Roboto",Font.BOLD, 12);
        AutoTable.setFont(fuente);
        AutoTable.getTableHeader().setFont(fuente);
        AutoTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        AutoTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        AutoTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        AutoTable.getColumnModel().getColumn(3).setPreferredWidth(20);
        AutoTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        AutoTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        AutoTable.getColumnModel().getColumn(6).setPreferredWidth(20);

    }
    private double obtenerTarifaDiaria(String placa) {
    
     Autos auto = new Autos();
    return auto.obtenerTarifaDiaria(placa);
    }
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
            java.util.logging.Logger.getLogger(AgregarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarAlquiler().setVisible(true);
            }
        });
    }
private void mostrarDatosEnTabla() {
    Autos Ag = new Autos();
    ArrayList<Autos> listaautos = Ag.obtenerAutos();
    DefaultTableModel modelo = (DefaultTableModel) AutoTable.getModel();
    modelo.setRowCount(0);

    for (Autos ag : listaautos) {
        String disponibilidadTexto = ag.getDispon() ? "Disponible" : "No Disponible";
        Object[] fila = {ag.getPlaca(), ag.getModelo(), ag.getMarca(), ag.getTipo(), ag.getAnioFabricacion(), ag.getTarifaDiaria(), disponibilidadTexto};
        modelo.addRow(fila);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AutoTable;
    private com.toedter.calendar.JDateChooser DateEntrega;
    private com.toedter.calendar.JDateChooser DateInicio;
    private javax.swing.JTextField Placatxt;
    private javax.swing.JTextField Username;
    private javax.swing.JButton VerAlquileres;
    private javax.swing.JButton btnAlquilar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
