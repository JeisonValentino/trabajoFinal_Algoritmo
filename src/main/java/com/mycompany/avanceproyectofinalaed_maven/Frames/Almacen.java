package com.mycompany.avanceproyectofinalaed_maven.Frames;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Almacen extends javax.swing.JFrame {

    /**
     * Creates new form Almacen
     */
    public Almacen() {
        initComponents();
        data();
    }

    public void data() {
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        
        //codigo, nombre, marca, cantidad, seccion, precio
        
        Object[] fila1 = {3423, "Glacitas", "Field", 35, "Field", 1.50};
        Object[] fila2 = {2134, "Cerveza Pilsen personal", "Field", 25, "Field", 6.00};
        Object[] fila3 = {2315, "Inca Kola personal", "Field", 25, "Field", 2.50};
        Object[] fila4 = {9234, "Papas Lays", "Field", 55, "Field", 2.00};
        Object[] fila5 = {2156, "Pan con pollo", "Field", 8, "Field", 4.50};
        Object[] fila6 = {7542, "Agua San Luis", "Field", 25, "Field", 1.50};
        
        model.addRow(fila1);
        model.addRow(fila2);
        model.addRow(fila3);
        model.addRow(fila4);
        model.addRow(fila5);
        model.addRow(fila6);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        textFieldPrecio = new javax.swing.JTextField();
        textFieldCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        ButtonBuscar = new javax.swing.JButton();
        ButtonQuitar = new javax.swing.JButton();
        ComboBoxSeccion = new javax.swing.JComboBox<>();
        ComboBoxMarca = new javax.swing.JComboBox<>();
        ButtonAgregar = new javax.swing.JButton();
        ButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jvalentino\\Desktop\\ACTIVIDADES\\Proyectos Programacion\\Proyectos Escritorio\\NetBeanst\\AvanceProyectoFinalAED_Maven\\src\\main\\java\\Imagenes\\LogoSinFondoResized.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 280, 80));

        textFieldNombre.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel1.add(textFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 160, 30));

        textFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 60, -1));
        jPanel1.add(textFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 40, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Marca");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 60, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Seccion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Precio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 102));
        jLabel7.setText("Cantidad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 102));
        jLabel8.setText("Nombre");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Cantidad", "Seccion", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.setShowGrid(true);
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 780, 350));

        ButtonBuscar.setText("Buscar Producto");
        jPanel1.add(ButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        ButtonQuitar.setText("Eliminar producto");
        ButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        ComboBoxSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confitería", "Bebidas", "Lacteos", "Comidas" }));
        jPanel1.add(ComboBoxSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        ComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nestle", "Kraft", "Field", "D'onofrio" }));
        jPanel1.add(ComboBoxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        ButtonAgregar.setText("Agregar Producto");
        ButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        ButtonRegresar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jvalentino\\Desktop\\ACTIVIDADES\\Proyectos Programacion\\Proyectos Escritorio\\NetBeanst\\AvanceProyectoFinalAED_Maven\\src\\main\\java\\Imagenes\\back.png")); // NOI18N
        ButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPrecioActionPerformed

    private void ButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgregarActionPerformed
        // TODO add your handling code here:
        Random random = new Random();
        short codigo = (short) ((short) random.nextInt(9000) + 1000);
        String nombre = textFieldNombre.getText();
        String marca = ComboBoxMarca.getSelectedItem().toString();
        String seccion = ComboBoxSeccion.getSelectedItem().toString();
        double precio = Double.parseDouble(textFieldPrecio.getText());
        int cantidad = Integer.parseInt(textFieldCantidad.getText());

        Object[] fila = {codigo, nombre, marca, cantidad, seccion, precio};
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        model.addRow(fila);

        textFieldNombre.setText("");
        textFieldCantidad.setText("");
        textFieldPrecio.setText("");
    }//GEN-LAST:event_ButtonAgregarActionPerformed

    private void ButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitarActionPerformed
        // TODO add your handling code here:
        String codigoIngresado = JOptionPane.showInputDialog(null, "Ingrese el código del producto a eliminar:");
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        int nFilas = model.getRowCount();
        int codigoIndex = -1;
        for (int i = 0; i < nFilas; i++) {
            int codigoActual = (int) model.getValueAt(i, 0);
            if (codigoActual == Integer.parseInt(codigoIngresado)) {
                codigoIndex = i;
                break;
            }
        }
        if (codigoIndex >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el producto con código " + codigoIngresado + "?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                model.removeRow(codigoIndex);
                JOptionPane.showMessageDialog(null, "El producto ha sido eliminado de la tabla.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El código ingresado no se encuentra en la tabla.");
        }
    }//GEN-LAST:event_ButtonQuitarActionPerformed

    private void ButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegresarActionPerformed
        // TODO add your handling code here:
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Almacen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAgregar;
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonQuitar;
    private javax.swing.JButton ButtonRegresar;
    private javax.swing.JComboBox<String> ComboBoxMarca;
    private javax.swing.JComboBox<String> ComboBoxSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField textFieldCantidad;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
