/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAOs.CategoriaDAO;
import Entidades.Categoria;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class RegistroCategoria extends javax.swing.JFrame {

    CategoriaDAO cd = new CategoriaDAO();

    /**
     * Creates new form RegistroCategoria
     */
    public RegistroCategoria() {
        initComponents();
        configurarPantalla();
        hacerTabla();
    }

    public void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tblCategoria.getModel();
        tb.setRowCount(0);
    }

    private void hacerTabla() {
        eliminarDatos();
        String[] dato = new String[4];
        DefaultTableModel tb = (DefaultTableModel) tblCategoria.getModel();
        List<Categoria> categorias = cd.mostrarTodas();
        try {
            for (Categoria producto : categorias) {
                dato[0] = String.valueOf(producto.getId());
                dato[1] = producto.getNombre();
                dato[2] = producto.getDescripcion();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    public void limpiarCampos() {
        tfID.setText("");
        tfNombre.setText("");
        tfDescripcion.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        botonAgregarCategoria = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        botonEliminarCategoria = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfBuscar = new javax.swing.JTextField();
        tblFakeCategoria = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        lblNota = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Registro de Categoria");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("ID:");

        tfID.setEditable(false);
        tfID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfID.setToolTipText("");
        tfID.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Nombre:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Descripcion:");

        tfDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfDescripcion.setToolTipText("");

        tfNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNombre.setToolTipText("");

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar))
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLimpiar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAgregarCategoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonAgregarCategoria.setText("Agregar");
        botonAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCategoriaActionPerformed(evt);
            }
        });

        botonRegresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        botonEliminarCategoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonEliminarCategoria.setText("Eliminar");
        botonEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarCategoriaActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Buscador categoria");

        tfBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfBuscar.setToolTipText("");
        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        tblFakeCategoria.setViewportView(tblCategoria);
        if (tblCategoria.getColumnModel().getColumnCount() > 0) {
            tblCategoria.getColumnModel().getColumn(0).setResizable(false);
            tblCategoria.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblCategoria.getColumnModel().getColumn(1).setResizable(false);
            tblCategoria.getColumnModel().getColumn(1).setPreferredWidth(160);
            tblCategoria.getColumnModel().getColumn(2).setResizable(false);
            tblCategoria.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        lblNota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNota.setText(" ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNota, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tblFakeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(tblFakeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Actualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(botonAgregarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Actualizar)
                .addGap(167, 167, 167)
                .addComponent(botonRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCategoriaActionPerformed
        if (!tfNombre.getText().isEmpty() && !tfNombre.getText().equals("") && !tfDescripcion.getText().isEmpty() && !tfDescripcion.getText().equals("")) {
            Categoria venta = new Categoria(tfNombre.getText(), tfDescripcion.getText());
            cd.agregar(venta);
            hacerTabla();
            limpiarCampos();
        }
    }//GEN-LAST:event_botonAgregarCategoriaActionPerformed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased
        if (!tfBuscar.getText().isEmpty() || tfBuscar.equals("")) {
            eliminarDatos();
            String[] dato = new String[4];
            DefaultTableModel tb = (DefaultTableModel) tblCategoria.getModel();
            List<Categoria> categorias = null;

            categorias = cd.buscarPorNombre(tfBuscar.getText());

            try {
                if (categorias.isEmpty()) {
                    lblNota.setForeground(Color.red);
                    lblNota.setText("No hay coincidencias de articulos.");
                    return;
                } else {
                    lblNota.setText("");
                }
                for (Categoria categoria : categorias) {
                    dato[0] = categoria.getNombre();
                    dato[1] = categoria.getDescripcion();
                    tb.addRow(dato);
                }
            } catch (Exception i) {
            }
        } else {
            hacerTabla();
        }
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        if (evt.getClickCount() == 1) {
            tfID.setText(String.valueOf(tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 0)));
            tfNombre.setText(String.valueOf(tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 1)));
            tfDescripcion.setText(String.valueOf(tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 2)));
        }
    }//GEN-LAST:event_tblCategoriaMouseClicked

    private void botonEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCategoriaActionPerformed
        if (!tfID.getText().isEmpty() && !tfID.getText().equals("")) {
            Categoria categoria = new Categoria(Integer.parseInt(tfID.getText()));
            cd.eliminar(categoria);
            hacerTabla();
            limpiarCampos();
        }
    }//GEN-LAST:event_botonEliminarCategoriaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        if (!tfID.getText().isEmpty() && !tfID.getText().equals("") && !tfNombre.getText().isEmpty() && !tfNombre.getText().equals("")
                && !tfDescripcion.getText().isEmpty() && !tfDescripcion.getText().equals("")) {
            Categoria categoria = new Categoria(Integer.parseInt(tfID.getText()), tfNombre.getText(), tfDescripcion.getText());
            cd.actualizar(categoria);
            hacerTabla();
            limpiarCampos();
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void configurarPantalla() {

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Registrar Ventas");
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
            java.util.logging.Logger.getLogger(RegistroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton botonAgregarCategoria;
    private javax.swing.JButton botonEliminarCategoria;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JScrollPane tblFakeCategoria;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
