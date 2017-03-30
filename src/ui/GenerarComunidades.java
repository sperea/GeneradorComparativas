/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import java.awt.Dialog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pdf.TablaComparativa;

/**
 *
 * @author sergio
 */
public class GenerarComunidades extends javax.swing.JInternalFrame implements Serializable {

    /**
     * Creates new form GenerarComunidades
     */
    public GenerarComunidades() {
        initComponents();
        
        // Escuchar cambios en txtNombreRiesgo para etiquetar ventana
        txtNombreRiesgo.getDocument().addDocumentListener(new DocumentListener() {
          @Override
          public void changedUpdate(DocumentEvent e) {
            CambiarTituloVentana(txtNombreRiesgo.getText());
          }
          @Override
          public void removeUpdate(DocumentEvent e) {
            CambiarTituloVentana(txtNombreRiesgo.getText());
          }
          @Override
          public void insertUpdate(DocumentEvent e) {
            CambiarTituloVentana(txtNombreRiesgo.getText());
          }
        });
    }
    
    private void CambiarTituloVentana(String titulo) {
        this.setTitle(titulo);
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
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreRiesgo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre del riesgo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 17, -1, -1));

        txtNombreRiesgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRiesgoActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombreRiesgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 407, -1));

        jLabel2.setText("Capital a asegurar");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 49, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 150, -1));

        jLabel3.setText("Responsabilidad Civil");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 81, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "150.000€", "300.000€", "450.000€", "600.000€" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 149, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("/home/sergio/NetBeansProjects/GestorProyectos/src/icons/data_sheet-48.png")); // NOI18N
        jButton1.setText("Añadir oferta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/start-48.png"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setLabel("Generar Proyecto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 230, 100));

        jSplitPane1.setTopComponent(jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 676, 154));

        jSplitPane1.setRightComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        @SuppressWarnings("UnusedAssignment")
        InsertarCompania dialog = null;
        dialog = new InsertarCompania((mainForm) SwingUtilities.getAncestorOfClass(mainForm.class,this), "", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        String compania = dialog.getCompania();
        String prima = dialog.getPrima();
        boolean danosEsteticosComunes = dialog.getDanosEsteticosComunes();
        boolean danosEsteticosPrivados = dialog.getDanosEsteticosPrivativos();
        boolean danosAguaComunes = dialog.getDanosAguaComunes();
        boolean danosAguaPrivados = dialog.getDanosAguaPrivativos();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtNombreRiesgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRiesgoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRiesgoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        TablaComparativa t = new TablaComparativa ();
        try {
            t.crearPDF();
            t.MarcaDeAgua("fichero.pdf", "fichero2.pdf", Image.getInstance("img/logo.jpg"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerarComunidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(GenerarComunidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtNombreRiesgo;
    // End of variables declaration//GEN-END:variables
}
