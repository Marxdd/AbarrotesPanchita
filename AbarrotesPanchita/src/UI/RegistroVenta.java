/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAOs.ProductoDAO;
import DAOs.RelacionProductosVentasDAO;
import DAOs.VentaDAO;
import Entidades.Producto;
import Entidades.RelacionProductosVentas;
import Entidades.Venta;
import java.awt.Color;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carls
 */
public class RegistroVenta extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    ProductoDAO pD = new ProductoDAO();
    VentaDAO vD = new VentaDAO();
    RelacionProductosVentasDAO rpvD = new RelacionProductosVentasDAO();

    public RegistroVenta() {
        initComponents();
        configurarPantalla();
        hacerTabla();
    }

    public void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tblBusqueda.getModel();
        tb.setRowCount(0);
//        tfID1.setText(null);
//        tfNombre.setText(null);
//        tfPrecioActual.setText(null);
//        tfStock.setText(null);
    }

    private void hacerTabla() {
        eliminarDatos();
        String[] dato = new String[5];
        DefaultTableModel tb = (DefaultTableModel) tblBusqueda.getModel();
        List<Producto> productos = pD.mostrarTodas();
        
        if(productos == null){
            return;
        }
        
        try {
            for (Producto producto : productos) {
                if (producto.getExistencia()) {
                    dato[0] = Integer.toString(producto.getId());
                    dato[1] = producto.getCodigo();
                    dato[2] = producto.getNombre();
                    dato[3] = Float.toString(producto.getPrecio());
                    dato[4] = producto.getCategoria();
                    tb.addRow(dato);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void calcularPrecios() {
        float subTotal = 0;
        //float descuento;
        //float total;

        float valores[] = new float[tblCarrito.getRowCount()];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = Float.parseFloat(tblCarrito.getModel().getValueAt(i, 4).toString());
            subTotal += valores[i];
        }
        subTotal = (float) (Math.round(subTotal * 100.0) / 100.0);
        tfSubTotal.setText(subTotal + "");

    }

    public void setMontosCero() {
        tfSubTotal.setText("0.00");
        tfMonto.setText("0.00");
        tfCambio.setText("0.00");
    }

    public boolean modificarStock(Integer cantidad) {
        int stock = Integer.parseInt(tblBusqueda.getValueAt(tblBusqueda.getSelectedRow(), 3).toString());

        if (stock == 0 || stock - cantidad.intValue() < 0) {
            JOptionPane.showMessageDialog(this, "No hay stock suficieJOptionnte");
            return false;
        } else {
            stock = stock - cantidad.intValue();
            tblBusqueda.setValueAt(stock, tblBusqueda.getSelectedRow(), 3);
            return true;
        }

    }

    public boolean validarExistenciaTablaRelacion(Integer id) {

        for (int i = 0; i < tblCarrito.getRowCount(); i++) {
            int idProductoRel = Integer.parseInt(tblCarrito.getValueAt(i, 0).toString());
            if (idProductoRel == id.intValue()) {
                JOptionPane.showMessageDialog(this, "Ya esta agregado el producto que desea agregar");
                return true;
            }
        }
        return false;

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
        lblTitulo = new javax.swing.JLabel();
        lblBuscarProducto = new javax.swing.JLabel();
        tfBuscarProducto = new javax.swing.JTextField();
        cbOrdenBusqueda = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBusqueda = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblNota = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        tfSubTotal = new javax.swing.JTextField();
        tfCambio = new javax.swing.JTextField();
        tfMonto = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Registro de Venta");

        lblBuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBuscarProducto.setText("Buscador de producto");

        tfBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarProductoActionPerformed(evt);
            }
        });
        tfBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarProductoKeyReleased(evt);
            }
        });

        cbOrdenBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Codigo", "Categoria"}));

        tblBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Codigo", "Nombre", "Precio", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBusquedaMouseClicked(evt);
            }
        });
        tblBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblBusquedaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblBusqueda);
        if (tblBusqueda.getColumnModel().getColumnCount() > 0) {
            tblBusqueda.getColumnModel().getColumn(0).setResizable(false);
            tblBusqueda.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblBusqueda.getColumnModel().getColumn(1).setResizable(false);
            tblBusqueda.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblBusqueda.getColumnModel().getColumn(2).setResizable(false);
            tblBusqueda.getColumnModel().getColumn(3).setResizable(false);
            tblBusqueda.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblBusqueda.getColumnModel().getColumn(4).setResizable(false);
        }

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Precio / Peso Granel", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarritoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCarrito);
        if (tblCarrito.getColumnModel().getColumnCount() > 0) {
            tblCarrito.getColumnModel().getColumn(0).setResizable(false);
            tblCarrito.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblCarrito.getColumnModel().getColumn(1).setResizable(false);
            tblCarrito.getColumnModel().getColumn(2).setResizable(false);
            tblCarrito.getColumnModel().getColumn(3).setResizable(false);
            tblCarrito.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblCarrito.getColumnModel().getColumn(4).setResizable(false);
            tblCarrito.getColumnModel().getColumn(4).setPreferredWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Carrito");

        jLabel6.setText(" ");

        jLabel7.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblTitulo)
                    .addComponent(lblBuscarProducto)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbOrdenBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNota)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitulo)
                .addGap(19, 19, 19)
                .addComponent(lblBuscarProducto)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbOrdenBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNota)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Detalle de venta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("SubTotal");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Monto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Cambio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, -1, -1));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 340, -1, -1));

        tfSubTotal.setEditable(false);
        tfSubTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfSubTotal.setToolTipText("");
        getContentPane().add(tfSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 215, -1));

        tfCambio.setEditable(false);
        tfCambio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(tfCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 215, -1));

        tfMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMontoActionPerformed(evt);
            }
        });
        tfMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMontoKeyReleased(evt);
            }
        });
        getContentPane().add(tfMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 215, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 440, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tfMontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMontoKeyReleased
        try {
            if (!tfSubTotal.getText().isEmpty()) {
                float subtlt = Float.parseFloat(tfSubTotal.getText());
                float mont = Float.parseFloat(tfMonto.getText());
                float cambio = mont - subtlt;
                if (cambio >= 0) {
                    cambio = (float) (Math.round(cambio * 100.0) / 100.0);
                    tfCambio.setText(cambio + "");
                } else {
                    tfCambio.setText("");
                }
            } else {
                tfMonto.setText("");
            }
        } catch (NumberFormatException e) {
            tfMonto.setText("");
        }

    }//GEN-LAST:event_tfMontoKeyReleased

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (tblCarrito.getRowCount() > 0) {
            if (!tfMonto.getText().isEmpty() && (new Float(tfMonto.getText()) >= new Float(tfSubTotal.getText()))) {

                Calendar fecha = Calendar.getInstance();
                Venta venta = new Venta(fecha, Float.parseFloat(tfSubTotal.getText()));

                Producto producto;
                RelacionProductosVentas rpv;// = new RelacionProductosVentas();
                RelacionProductosVentas rpv1;
                int fila = 0;
                for (int i = 0; i < tblCarrito.getRowCount(); i++) {
                    producto = pD.buscarPorId(new Integer(tblCarrito.getValueAt(i, 0).toString()));

                    //Poner un if si es a granel(?)
                    rpv = new RelacionProductosVentas(new Integer(tblCarrito.getValueAt(i, 3).toString()),
                            new Float(tblCarrito.getValueAt(i, 4).toString()), new Float(tblCarrito.getValueAt(i, 2).toString()), producto, venta);
                    venta.agregarProductos(rpv);
                }
                vD.agregar(venta);

                hacerTabla();
                setMontosCero();
                DefaultTableModel tb = (DefaultTableModel) tblCarrito.getModel();
                tb.setRowCount(0);
                JOptionPane.showMessageDialog(null, "Venta Registrada.", "Aviso", INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Dinero insuficiente.", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos agregados", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarritoMouseClicked
        if (evt.getClickCount() == 1) {
            //recuperarStock();
            //  calcularPrecios();
            DefaultTableModel tb = (DefaultTableModel) tblCarrito.getModel();
            tb.removeRow(tblCarrito.getSelectedRow());
            calcularPrecios();
        }
    }//GEN-LAST:event_tblCarritoMouseClicked

    private void tblBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBusquedaMouseClicked

        if (evt.getClickCount() == 1) {
            Integer cantidad = null;

            try {

                String numero = JOptionPane.showInputDialog(this, "Indique cantidad/peso del producto", "", QUESTION_MESSAGE);

                if (numero == null) {
                    return;
                } else {
                    cantidad = new Integer(numero);
                    if (cantidad <= 0) {
                        JOptionPane.showMessageDialog(null, "Introduzca una cantidad v??lida.", "Aviso", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Introduzca una cantidad v??lida.", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cantidad != null) {//&& modificarStock(cantidad)) {

                DefaultTableModel tb = (DefaultTableModel) tblCarrito.getModel();
                Object dato[] = new Object[5];

                dato[0] = tblBusqueda.getValueAt(tblBusqueda.getSelectedRow(), 0);
                dato[1] = tblBusqueda.getValueAt(tblBusqueda.getSelectedRow(), 1);
                Float precio = Float.parseFloat(tblBusqueda.getValueAt(tblBusqueda.getSelectedRow(), 3).toString());
                precio = precio * cantidad;
                precio = (float) (Math.round(precio * 100.0) / 100.0);
                dato[4] = precio;
                dato[2] = tblBusqueda.getValueAt(tblBusqueda.getSelectedRow(), 3);
                dato[3] = cantidad;

                if (!validarExistenciaTablaRelacion(new Integer(dato[0].toString()))) {
                    tb.addRow(dato);
                    calcularPrecios();
                }

            } else {
            }

        }

    }//GEN-LAST:event_tblBusquedaMouseClicked

    private void tfBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarProductoKeyReleased
        if (!tfBuscarProducto.getText().isEmpty() || tfBuscarProducto.equals("")) {
            eliminarDatos();
            String[] dato = new String[5];
            DefaultTableModel tb = (DefaultTableModel) tblBusqueda.getModel();
            List<Producto> productos = null;
            if (cbOrdenBusqueda.getSelectedItem().equals("Nombre")) {
                productos = pD.buscarPorNombre(tfBuscarProducto.getText());
            } else if (cbOrdenBusqueda.getSelectedItem().equals("Codigo")) {
                productos = pD.buscarPorCodigo(tfBuscarProducto.getText());
            } else {
                productos = pD.buscarPorCategoria(tfBuscarProducto.getText());
            }

            try {
                if (productos.isEmpty()) {
                    lblNota.setForeground(Color.red);
                    lblNota.setText("No hay coincidencias de articulos.");
                    return;
                } else {
                    lblNota.setText("");
                }
                for (Producto producto : productos) {
                    if (producto.getExistencia()) {
                        dato[0] = Integer.toString(producto.getId());
                        dato[2] = producto.getNombre();
                        dato[3] = Float.toString(producto.getPrecio());
                        dato[1] = producto.getCodigo();
                        dato[4] = producto.getCategoria();
                        tb.addRow(dato);
                    }

                }
            } catch (Exception i) {
            }
        } else {
            hacerTabla();
        }
    }//GEN-LAST:event_tfBuscarProductoKeyReleased


    private void tfBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarProductoActionPerformed

    private void tfMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMontoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        RegistroVenta rv = new RegistroVenta();
        rv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBusquedaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBusquedaKeyPressed

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
            java.util.logging.Logger.getLogger(RegistroVenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistroVenta rv = new RegistroVenta();
                rv.setVisible(true);
            }
        });
    }

    private void configurarPantalla() {

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Registrar Ventas");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbOrdenBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscarProducto;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblBusqueda;
    private javax.swing.JTable tblCarrito;
    private javax.swing.JTextField tfBuscarProducto;
    private javax.swing.JTextField tfCambio;
    private javax.swing.JTextField tfMonto;
    private javax.swing.JTextField tfSubTotal;
    // End of variables declaration//GEN-END:variables

}
