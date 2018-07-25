package interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Conexion.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.PlanEstudio;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class cargaPlanEstudio extends javax.swing.JFrame {

    ConexionBase cx=new ConexionBase();
    
    public cargaPlanEstudio() {
        initComponents();
        cargarCarreras();
        consultaPlan();
        cargarMaterias();
    }
    public void consultaPlan(){
        Connection base=cx.getConection();
        DefaultTableModel modelo=(DefaultTableModel) this.jtTablaPlanes.getModel();
        modelo.setRowCount(0);
        try{
            PreparedStatement valores=base.prepareStatement("SELECT * FROM planestudio ");
            ResultSet resultado=valores.executeQuery();
            String [] fila=new String[5]; 
            while(resultado.next()){
                fila[0]=resultado.getString(1);
                fila[1]=resultado.getString(2);
                fila[2]=resultado.getString(3);
                fila[3]=resultado.getString(4);
                fila[4]=resultado.getString(5);
                modelo.addRow(fila);
            }
            this.jtTablaPlanes.setModel(modelo);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void cargarCarreras(){
        Connection base=cx.getConection();
        try {
            PreparedStatement valores=base.prepareStatement("SELECT * FROM cursos");
            ResultSet resultado=valores.executeQuery();
            this.cbxCarreras.removeAllItems();
            this.cbxCarreras.addItem("Seleccionar");
            while(resultado.next()){
                this.cbxCarreras.addItem(resultado.getString(2));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void cargarMaterias(){
        Connection base=cx.getConection();
        DefaultTableModel modelo=(DefaultTableModel) this.jTablaMaterias.getModel();
        try{
            PreparedStatement valores=base.prepareStatement("SELECT * FROM materia");
            ResultSet resultado=valores.executeQuery();
            Object [] fila=new Object[3]; 
            while(resultado.next()){
                fila[0]=resultado.getString(1);
                fila[1]=resultado.getString(2);
                fila[2]=false;
                modelo.addRow(fila);
            }
            this.jTablaMaterias.setModel(modelo);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void adjuntarMaterias(int idP){
        
       Connection base=cx.getConection();
       int cant=this.jTablaMaterias.getRowCount();
       Object [] columna=new Object[3];
       for(int i=0;i<cant;i++){
            if(!columna[2].equals(false)){
                try {
                    int idM=Integer.valueOf(this.jTablaMaterias.getValueAt(i, 0).toString());
                    PreparedStatement valores=base.prepareStatement("CALL cargarDetallePlan("+idM+","+idP+")");
                } catch (SQLException ex) {
                    Logger.getLogger(cargaPlanEstudio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtpPanel = new javax.swing.JTabbedPane();
        jpListaPlanes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaPlanes = new javax.swing.JTable();
        jpNuevoPlan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        cbxCarreras = new javax.swing.JComboBox<>();
        btnSiguiente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jsAnio = new javax.swing.JSpinner();
        txtNotaMin = new javax.swing.JSpinner();
        txtCantMaterias = new javax.swing.JSpinner();
        txtEstado = new javax.swing.JComboBox<>();
        jpAdjuntarMaterias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaMaterias = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTablaPlanes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPlan", "idCarrera", "Año", "Estado", "Nota mínima", "Cantidad de Materias"
            }
        ));
        jScrollPane1.setViewportView(jtTablaPlanes);

        javax.swing.GroupLayout jpListaPlanesLayout = new javax.swing.GroupLayout(jpListaPlanes);
        jpListaPlanes.setLayout(jpListaPlanesLayout);
        jpListaPlanesLayout.setHorizontalGroup(
            jpListaPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaPlanesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpListaPlanesLayout.setVerticalGroup(
            jpListaPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaPlanesLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jtpPanel.addTab("Lista de planes", jpListaPlanes);

        jLabel1.setText("Carrera");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cbxCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCarrerasActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Año");

        jLabel3.setText("Estado");

        jLabel4.setText("Nota mínima");

        jLabel5.setText("Cantidad de materias");

        jsAnio.setModel(new javax.swing.SpinnerNumberModel(2000, 2000, 2100, 1));

        txtNotaMin.setModel(new javax.swing.SpinnerNumberModel(7, 1, 10, 1));

        txtCantMaterias.setModel(new javax.swing.SpinnerNumberModel(10, 1, 50, 1));

        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Finalizado", "Próximo año", "Anulado\t" }));

        javax.swing.GroupLayout jpNuevoPlanLayout = new javax.swing.GroupLayout(jpNuevoPlan);
        jpNuevoPlan.setLayout(jpNuevoPlanLayout);
        jpNuevoPlanLayout.setHorizontalGroup(
            jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoPlanLayout.createSequentialGroup()
                .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevoPlanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevoPlanLayout.createSequentialGroup()
                                .addComponent(cbxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregar))
                            .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNotaMin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jsAnio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCantMaterias, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevoPlanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)))
                .addContainerGap())
        );
        jpNuevoPlanLayout.setVerticalGroup(
            jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoPlanLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jsAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNotaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpNuevoPlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addContainerGap())
        );

        jtpPanel.addTab("Nuevo Plan", jpNuevoPlan);

        jTablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablaMaterias);

        jLabel6.setText("Seleccionar materias:");

        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Volver");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAdjuntarMateriasLayout = new javax.swing.GroupLayout(jpAdjuntarMaterias);
        jpAdjuntarMaterias.setLayout(jpAdjuntarMateriasLayout);
        jpAdjuntarMateriasLayout.setHorizontalGroup(
            jpAdjuntarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdjuntarMateriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAdjuntarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAdjuntarMateriasLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAdjuntarMateriasLayout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAdjuntarMateriasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpAdjuntarMateriasLayout.setVerticalGroup(
            jpAdjuntarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdjuntarMateriasLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jpAdjuntarMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jToggleButton1))
                .addContainerGap())
        );

        jtpPanel.addTab("Adjuntar materias", jpAdjuntarMaterias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCarrerasActionPerformed
        // TODO add your handling code here:
        cargarMaterias();
    }//GEN-LAST:event_cbxCarrerasActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        this.jtpPanel.setSelectedIndex(2);
        this.jpAdjuntarMaterias.show();
        cargarMaterias();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int idP=this.jtTablaPlanes.getRowCount();
        Connection base=cx.getConection();
        try {
            PreparedStatement valores=base.prepareStatement("CALL agregarPlan("+this.cbxCarreras.getSelectedIndex()+","+this.jsAnio.getValue().toString()+",'" +this.txtEstado.getSelectedItem().toString()+"',"+this.txtNotaMin.getValue().toString()+ ","+this.txtCantMaterias.getValue().toString()+")");
            valores.executeUpdate();
            JOptionPane.showMessageDialog(null, "Carga exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        adjuntarMaterias(idP);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
       // agregarCarrera ac=new agregarCarrera();
        //ac.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        this.jpNuevoPlan.setVisible(true);
        this.jtpPanel.setSelectedIndex(1);
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
            java.util.logging.Logger.getLogger(cargaPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cargaPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cargaPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cargaPlanEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cargaPlanEstudio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbxCarreras;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaMaterias;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel jpAdjuntarMaterias;
    private javax.swing.JPanel jpListaPlanes;
    private javax.swing.JPanel jpNuevoPlan;
    private javax.swing.JSpinner jsAnio;
    private javax.swing.JTable jtTablaPlanes;
    private javax.swing.JTabbedPane jtpPanel;
    private javax.swing.JSpinner txtCantMaterias;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JSpinner txtNotaMin;
    // End of variables declaration//GEN-END:variables
}
