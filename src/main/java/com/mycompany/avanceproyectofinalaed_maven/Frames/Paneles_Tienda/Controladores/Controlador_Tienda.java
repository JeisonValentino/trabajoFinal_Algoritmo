 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Controladores;

import static com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_administrador.Almacen.redimensionarImagen;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Modelos.Modelo_listaproductos_carrito;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Modelos.Modelo_producto_carrito;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Vistas.Carrito_Compras;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Vistas.Modal_Ofertas;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.Tienda;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.vista_carrito;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.vista_inicio;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.vista_producto;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.vista_producto_item;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Listas.Lista_Productos;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Productos;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jvalentino
 */
public class Controlador_Tienda {

    private final Tienda tienda_vista;
    private final vista_producto vista__producto;
    private final Modal_Ofertas modal;
    Lista_Productos lista_productos= Lista_Productos.getInstancia();
    Modelo_listaproductos_carrito modelo_listaproductos_carrito =  Modelo_listaproductos_carrito.getSession();

    private void MostraPanel(JPanel p) {
        p.setSize(610, 500);
        p.setLocation(0, 0);
        tienda_vista.getPanel_hojas().removeAll();
        tienda_vista.getPanel_hojas().add(p, BorderLayout.CENTER);
        tienda_vista.getPanel_hojas().revalidate();
        tienda_vista.getPanel_hojas().repaint();
    }

    public Controlador_Tienda(Tienda tienda_vista, Modal_Ofertas modal, vista_producto vista__producto) {
        this.tienda_vista = tienda_vista;
        this.vista__producto = vista__producto;
        this.modal = modal;

        vista__producto.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                // El panel vista__producto se mostró
                // Aquí puedes agregar la lógica que deseas ejecutar cuando el panel se muestre
                actualizarPanelesProducto();
                // Agrega aquí tu lógica adicional dentro del panel vista__producto
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                System.out.println("El panel vista__producto se ocultó o fue removido");
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                System.out.println("El panel vista__producto fue movido");
            }
        });

        tienda_vista.getBtnDescuento().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modal.setVisible(true);

            }

        });

        modal.getjLabel1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modal.dispose();

                tienda_vista.getOverlayPanel().setVisible(false);
            }
        });

        tienda_vista.getBoton_compra().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tienda_vista.getjPopupMenu1().show(tienda_vista.getBoton_compra(), 0, 0);

            }

        });

        tienda_vista.getInicio_PanelBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista_inicio vistaInicio = new vista_inicio();
                MostraPanel(vistaInicio.getjPanel1());

            }

        });

        tienda_vista.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {

            }
        });

        tienda_vista.getProductos_PanelBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                MostraPanel(vista__producto);
            }

        });

        // AQUI SE VE EL MOVIMIENTO SLIDER DE LA BARRA LATERAL
        tienda_vista.getEtiquetaBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = tienda_vista.getSidebar_panel().getSize().width;

                if (x == 190) {
                    tienda_vista.getSidebar_panel().setSize(190, 500);
                    Thread th = new Thread() {
                        @Override
                        public void run() {
                            try {
                                for (int i = 190; i >= 0; i--) {
                                    Thread.sleep(1);

                                    tienda_vista.getSidebar_panel().setSize(i, 1000);
                                }

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(tienda_vista, ex);
                            }
                        }

                    };

                    Thread th2 = new Thread() {
                        @Override
                        public void run() {
                            try {

                                for (int i = 150; i >= -30; i--) {
                                    Thread.sleep(1);

                                    tienda_vista.getEtiquetaBtn().setLocation(i, 20);
                                }

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(tienda_vista, ex);
                            }
                        }
                    };

                    th.start();
                    th2.start();

                } else if (x == 0) {

                    Thread th = new Thread() {
                        @Override
                        public void run() {
                            try {
                                for (int i = 0; i <= 190; i++) {
                                    Thread.sleep(1);
                                    tienda_vista.getSidebar_panel().setSize(i, 1000);
                                }

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(tienda_vista, ex);
                            }
                        }

                    };

                    Thread th2 = new Thread() {
                        @Override
                        public void run() {
                            try {

                                for (int i = 0; i <= 150; i++) {
                                    Thread.sleep(2);

                                    tienda_vista.getEtiquetaBtn().setLocation(i, 20);
                                }

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(tienda_vista, ex);
                            }
                        }
                    };

                    th.start();
                    th2.start();

                }

            }
        });

    }

    public void actualizarPanelesProducto() {

        if (!lista_productos.retornarListaProductos().isEmpty()) {

            int numeroItem = lista_productos.retornarListaProductos().get().size(), columna = 0, fila = 0;
            columna = 3;
            if (numeroItem % 2 == 0) {
                fila = numeroItem / 3 + 1;
            } else {
                fila = (numeroItem / 2) + 1;
            }

            vista__producto.getjPanel2().setLayout(new GridLayout(fila, columna));
            for (Productos pro : lista_productos.retornarListaProductos().get()) {

                vista_producto_item panel = new vista_producto_item();
                panel.getNombre_producto().setText(pro.getNombre());
                panel.getPrecio_producto().setText(String.valueOf(pro.getPrecio()));
                
                BufferedImage imagen = null;
 BufferedImage imagen2 =null; 
   ImageIcon icon =null;
          try {

              imagen = ImageIO.read(new ByteArrayInputStream(pro.getImagenAlmacen().getImagen()));
              System.out.println(panel.getImagen_producto().getWidth());
                              imagen2 = redimensionarImagen(imagen,  120,120);
                            icon= new ImageIcon(imagen2);
          }catch(Exception ex){
              
          }
                
                panel.getImagen_producto().setIcon(icon);
                panel.getBtn_Agregar_carrito().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JOptionPane.showMessageDialog(null, "Seleccionaste una " + pro.getNombre() + "de la marca " + pro.getMarca());
                        try{
                        agregarProducto_carrito(pro);
                        }catch(IllegalArgumentException ex ){
                                    JOptionPane.showMessageDialog(null, "Se encontraron problemas: " + ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);

                        }
                        }
                });
                vista__producto.getjPanel2().add(panel);
            }

        } else {
                   vista__producto.getjPanel2().removeAll();
                 vista__producto.getjPanel2().revalidate();
            vista__producto.getjPanel2().repaint();
            vista__producto.getjPanel2().setLayout(new GridLayout(1, 1));
            vista_producto_item panel = new vista_producto_item();
            panel.getNombre_producto().setText("no hay datos");
            vista__producto.getjPanel2().add(panel);
        }
    }

    
    
    public void actualizarTablaCompras(){
                    DefaultTableModel modelo_tABLE = (DefaultTableModel) tienda_vista.getCarrito().getTable_compras().getModel();
              modelo_tABLE.setRowCount(0);
             for(Modelo_producto_carrito pro : modelo_listaproductos_carrito.obtenerListaCarrito()){
                 System.out.println(pro.getId()+"AQUI ESTA EL ID CARRITO"
                         + "");
              Object[] Fila = {pro.getId(), pro.getProducto(), 
                             pro.getCantidad(), pro.getPrecio(), 
                            };
              
            modelo_tABLE.addRow(Fila);
             }
    }
             
    
    
    
    public void agregarProducto_carrito(Productos id) {
    
 System.out.print(id.getId());

       
       
       try {
    if (modelo_listaproductos_carrito.obtenerListaCarrito_espefico(id.getId()) != null) {
        System.out.println("actualizar datos ");
        modelo_listaproductos_carrito.actualizarDatosCarrito(id);
    } else {
        System.out.println("agregar datos ");
        modelo_listaproductos_carrito.agregarDatosCarrito(id);
    }

    actualizarTablaCompras();
} catch (Exception ex) {
    // Manejo de excepciones
}

                

    


            
        
    }

         public static BufferedImage redimensionarImagen(Image imagenOriginal, int nuevoAncho, int nuevoAlto) {
        // Crear una imagen vacía con las dimensiones deseadas
        BufferedImage imagenRedimensionada = new BufferedImage(nuevoAncho, nuevoAlto, BufferedImage.TYPE_INT_ARGB);

        // Obtener el objeto Graphics2D para dibujar en la imagen redimensionada
        Graphics2D g2d = imagenRedimensionada.createGraphics();

        // Aplicar interpolación y suavizado para obtener una mejor calidad de imagen
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar la imagen original en la imagen redimensionada
        g2d.drawImage(imagenOriginal, 0, 0, nuevoAncho, nuevoAlto, null);

        // Liberar los recursos
        g2d.dispose();

        return imagenRedimensionada;
    }
    
    
    
}
