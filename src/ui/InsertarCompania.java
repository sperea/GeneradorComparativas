/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import companias.ListadoCompanias;
import comparativos.ComparativoComunidades;
import java.awt.Dialog;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author sergio
 */
public class InsertarCompania extends javax.swing.JDialog {
    
    public String getCompania()
    {
        return this.cbCompanias.getSelectedItem().toString();
    }
    
    public String getPrima()
    {
        return this.txtPrima.getText();
    }
    
    public boolean getDanosEsteticosComunes()
    {
        return this.checkDanosEsteticosCompartidos.isSelected();
    }
    
    public boolean getDanosEsteticosPrivativos()
    {
        return this.checkDanosEsteticosPrivados.isSelected();
    }

    public boolean getDanosAguaComunes()
    {
        return this.checkDanosAguaCompartidos.isSelected();
    }

    public boolean getDanosAguaPrivativos()
    {
        return this.checkDanosAguaPrivativos.isSelected();
    }
    
    public String getImporteFranquicia()
    {
        return this.txtFranquicia.getText();
    }
    
    public boolean getTieneFranquicia()
    {
        return this.checkFranquicia.isSelected();
    }
    
    public String getObservaciones()
    {
        return this.txtObservaciones.getText();
    }
    
    private ListadoCompanias listaCompanias;
    
    // Mascara para nuestra contraseña
     private MaskFormatter mascaraMoneda() {
         // Inicializamos el objeto
         MaskFormatter mascara = new MaskFormatter();
         // Entramos en un try/catch por alguna eventualidad
         try {
             // Creamos el formato de nuestra contraseña
             // # -> un número U -> letra mayúscula L -> letra minúscula
             // * -> cualquier caracter ' -> caracteres de escape
             // A -> cualquier letra o número ? -> cualquier caracter
             // H -> cualquier caracter hexagonal (0-9, a-f or A-F).
             mascara = new MaskFormatter("#,##0.00 €");
         } catch (ParseException e) {
             // Algún error que pueda ocurrir
             e.printStackTrace();
         }
         return mascara;
     }    
 
    /**
     * Creates new form InsertarCompania
     * @param parent
     * @param modal
     */
    public InsertarCompania(mainForm parent, String title, Dialog.ModalityType modalityType) {
        
        comparativoComunidades = new ComparativoComunidades();
                
        this.setModalityType(modalityType);
        initComponents();
        
        try {
            listaCompanias = new ListadoCompanias();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(InsertarCompania.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.checkDanosAguaCompartidos.setSelected(true);
        
        // Define the number factory.
        NumberFormat nf = NumberFormat.getIntegerInstance(); // Specify specific format here.
        NumberFormatter nff = new NumberFormatter(nf);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(nff);

        // Define the decimal factory.
        DecimalFormat df = new DecimalFormat(); // And here..
        NumberFormatter dnff = new NumberFormatter(df);
        DefaultFormatterFactory factory2 = new DefaultFormatterFactory(dnff); 

        this.txtPrima.setFormatterFactory(factory2);
        
        ArrayList<String> lista=listaCompanias.getListadoOrdenadorCompanias();
        for(int i=0;i<lista.size();i++){
            cbCompanias.addItem(lista.get(i));
        }
        
        
        
    }
    
    private ComparativoComunidades comparativoComunidades;

    /*
    InsertarCompania() throws ParserConfigurationException, SAXException, IOException {
        initComponents();
        listaCompanias = new ListadoCompanias();
        
        this.checkDanosAguaCompartidos.setSelected(true);
        
        // Define the number factory.
        NumberFormat nf = NumberFormat.getIntegerInstance(); // Specify specific format here.
        NumberFormatter nff = new NumberFormatter(nf);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(nff);

        // Define the decimal factory.
        DecimalFormat df = new DecimalFormat(); // And here..
        NumberFormatter dnff = new NumberFormatter(df);
        DefaultFormatterFactory factory2 = new DefaultFormatterFactory(dnff); 

        this.txtPrima.setFormatterFactory(factory2);
        
        ArrayList<String> lista=listaCompanias.getListadoOrdenadorCompanias();
        for(int i=0;i<lista.size();i++){
            cbCompanias.addItem(lista.get(i));
        }
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbCompanias = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        txtPrima = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        checkDanosEsteticosPrivados = new javax.swing.JCheckBox();
        checkDanosEsteticosCompartidos = new javax.swing.JCheckBox();
        checkDanosAguaCompartidos = new javax.swing.JCheckBox();
        checkDanosAguaPrivativos = new javax.swing.JCheckBox();
        checkFranquicia = new javax.swing.JCheckBox();
        txtFranquicia = new javax.swing.JTextField();
        lblFranquicia = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        lblObservaciones = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        javax.swing.JButton btnCargarPdf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Prima:");

        jLabel2.setText("Compañía:");

        btnInsertar.setIcon(new javax.swing.ImageIcon("/home/sergio/NetBeansProjects/GestorProyectos/src/icons/add.png")); // NOI18N
        btnInsertar.setText("Insertar nueva compañía");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jLabel3.setText("€");

        checkDanosEsteticosPrivados.setText("Daños estéticos privados");

        checkDanosEsteticosCompartidos.setText("Daños estéticos compartidos");

        checkDanosAguaCompartidos.setText("Daños por agua comunes");
        checkDanosAguaCompartidos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkDanosAguaCompartidosStateChanged(evt);
            }
        });

        checkDanosAguaPrivativos.setText("Daños por agua privativos");

        checkFranquicia.setText("Franquicia");

        lblFranquicia.setText("Importe:");

        lblObservaciones.setText("Observaciones:");

        btnCancel.setIcon(new javax.swing.ImageIcon("/home/sergio/NetBeansProjects/GestorProyectos/src/icons/cancel-48.png")); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCargarPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file-48.png"))); // NOI18N
        btnCargarPdf.setText("Incluir proyecto PDF");

        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblObservaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservaciones))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargarPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCompanias, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel3))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkFranquicia)
                                .addGap(47, 47, 47)
                                .addComponent(lblFranquicia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkDanosEsteticosPrivados)
                                    .addComponent(checkDanosEsteticosCompartidos))
                                .addGap(114, 114, 114)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(checkDanosAguaCompartidos)
                                    .addComponent(checkDanosAguaPrivativos, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCompanias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDanosEsteticosCompartidos)
                    .addComponent(checkDanosAguaCompartidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDanosEsteticosPrivados)
                    .addComponent(checkDanosAguaPrivativos))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkFranquicia)
                    .addComponent(lblFranquicia)
                    .addComponent(txtFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObservaciones))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCargarPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnInsertar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkDanosAguaCompartidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkDanosAguaCompartidosStateChanged
        // TODO add your handling code here:
        if(!checkDanosAguaCompartidos.isSelected()) {//checkbox has been de-selected
            checkDanosAguaPrivativos.setVisible(false);
            checkFranquicia.setVisible(false);
            txtFranquicia.setVisible(false);
            lblFranquicia.setVisible(false);
        } else {//checkbox has been deselected.isSelected()
            checkDanosAguaPrivativos.setVisible(true);
            checkFranquicia.setVisible(true);
            txtFranquicia.setVisible(true);
            lblFranquicia.setVisible(true);
        };
    }//GEN-LAST:event_checkDanosAguaCompartidosStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); 
        try {
            comparativoComunidades.InsertarOferta("allianz.json");
        } catch (IOException ex) {
            Logger.getLogger(InsertarCompania.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

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
            java.util.logging.Logger.getLogger(InsertarCompania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarCompania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarCompania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarCompania.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InsertarCompania dialog = null;
                dialog = new InsertarCompania(new mainForm(), "", Dialog.ModalityType.APPLICATION_MODAL);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JComboBox<String> cbCompanias;
    private javax.swing.JCheckBox checkDanosAguaCompartidos;
    private javax.swing.JCheckBox checkDanosAguaPrivativos;
    private javax.swing.JCheckBox checkDanosEsteticosCompartidos;
    private javax.swing.JCheckBox checkDanosEsteticosPrivados;
    private javax.swing.JCheckBox checkFranquicia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel lblFranquicia;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JTextField txtFranquicia;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JFormattedTextField txtPrima;
    // End of variables declaration//GEN-END:variables
}
