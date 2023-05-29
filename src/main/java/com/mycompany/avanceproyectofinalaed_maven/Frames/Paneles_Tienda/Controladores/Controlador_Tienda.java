/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Controladores;

import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Modelos.Modelo_listaproductos_carrito;
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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Jvalentino
 */
public class Controlador_Tienda {
    private final Tienda tienda_vista;
        private final  vista_producto vista__producto;
            private final Modal_Ofertas modal;
    Lista_Productos lista_productos =new Lista_Productos();
    Modelo_listaproductos_carrito modelo_listaproductos_carrito =new Modelo_listaproductos_carrito();
        private void MostraPanel(JPanel p){
           p.setSize(610,500);
            p.setLocation(0,0);
            tienda_vista.getPanel_hojas().removeAll();
                   tienda_vista.getPanel_hojas().add(p,BorderLayout.CENTER);
                      tienda_vista.getPanel_hojas().revalidate();
                           tienda_vista.getPanel_hojas().repaint();
        }
    public Controlador_Tienda(Tienda tienda_vista,Modal_Ofertas modal ,vista_producto vista__producto) {
        this.tienda_vista = tienda_vista;
        this.vista__producto=vista__producto;
        this.modal=modal;
          
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

        
        
       tienda_vista.getBtnDescuento().addActionListener(new ActionListener(){
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
       
       
       
              tienda_vista.getBoton_compra().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
      tienda_vista.getjPopupMenu1().show(tienda_vista.getBoton_compra(), 0, 0);

            }
           
       });
              
              
              
              
          
       
        
        tienda_vista.getInicio_PanelBtn().addMouseListener(new MouseAdapter() {
  @Override
    public void mouseClicked(MouseEvent e) {
        vista_inicio vistaInicio=new vista_inicio() ;
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
  
        int x = tienda_vista.getSidebar_panel().getSize().width ;
            
        if(x==190){
    tienda_vista.getSidebar_panel().setSize(190,500);
    Thread th=new Thread(){ 
      @Override
      public void run (){
          try{
              for(int i = 190;i>=0; i--){
                  Thread.sleep(1);
                  
                      tienda_vista.getSidebar_panel().setSize(i,1000);
              }
              
              
             
              
          }catch(Exception ex ){
              JOptionPane.showMessageDialog(tienda_vista, ex);
          }
      }
        
    };
    
    Thread th2 = new Thread() {
            @Override
      public void run (){
        try{
        
           for(int i = 150;i>=-30; i--){
                  Thread.sleep(1);
                  
                      tienda_vista.getEtiquetaBtn().setLocation(i, 20);
              }
                      
          }catch(Exception ex ){
              JOptionPane.showMessageDialog(tienda_vista, ex);
          }
      }
    };
    
    
    
    th.start();
    th2.start();
 
        }else
        if(x==0){
                      

               
               Thread th=new Thread(){
      @Override
      public void run (){
          try{ 
              for(int i = 0;i<=190; i++){
                  Thread.sleep(1);
                      tienda_vista.getSidebar_panel().setSize(i,1000);
              }
              
              
          }catch(Exception ex ){
              JOptionPane.showMessageDialog(tienda_vista, ex);
          }
      }
        
    };
               
                  Thread th2 = new Thread() {
            @Override
      public void run (){
        try{
        
           for(int i = 0;i<=150; i++){
                  Thread.sleep(2);
                  
                      tienda_vista.getEtiquetaBtn().setLocation(i, 20);
              }
                      
          }catch(Exception ex ){
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
    public void actualizarPanelesProducto(){
        
        
        
        if(!lista_productos.retornarListaProductos().isEmpty()){
               int numeroItem= lista_productos.retornarListaProductos().get().size() , columna=0,fila=0; 
        columna=3;
        if (numeroItem%2==0){
             fila= numeroItem/3+1;
        }else{
             fila= (numeroItem/2)+1;
        }
       

        vista__producto.getjPanel2().setLayout(new GridLayout(fila,columna));
        for (Productos pro:  lista_productos.retornarListaProductos().get()) {

            vista_producto_item panel = new vista_producto_item();
           panel.getNombre_producto().setText(pro.getNombre());
           panel.getPrecio_producto().setText(String.valueOf(pro.getPrecio()));
           panel.getBtn_Agregar_carrito().addMouseListener(new MouseAdapter() {
  @Override
    public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(null, "Seleccionaste una " +pro.getNombre()+"de la marca "+pro.getMarca());
                    agregarProducto_carrito(pro);
    }
           });
                vista__producto.getjPanel2().add(panel); 
        }
        
        }else{
         vista__producto.getjPanel2().setLayout(new GridLayout(1,1));
            vista_producto_item panel = new vista_producto_item();
              panel.getNombre_producto().setText("no hay datos");
             vista__producto.getjPanel2().add(panel); 
        }
        }
    
public void agregarProducto_carrito(Productos id ){
        for (Productos pro:  lista_productos.retornarListaProductos().get()) {
            if(pro.getId().equals(id.getId())){
                try{
                modelo_listaproductos_carrito.actualizarDatosCarrito(id);
                }catch(Exception ex ){
                    
                }
            }
        }
}
    
}
