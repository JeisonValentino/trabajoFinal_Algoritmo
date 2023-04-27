/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Controladores;

import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.Tienda;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.vista_carrito;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.vista_inicio;
import com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Tienda.Vistas.vista_producto;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jvalentino
 */
public class Controlador_Tienda {
    private final Tienda tienda_vista;
  
        private void MostraPanel(JPanel p){
           p.setSize(610,500);
            p.setLocation(0,0);
            tienda_vista.getPanel_hojas().removeAll();
                   tienda_vista.getPanel_hojas().add(p,BorderLayout.CENTER);
                      tienda_vista.getPanel_hojas().revalidate();
                           tienda_vista.getPanel_hojas().repaint();
        }
    public Controlador_Tienda(Tienda tienda_vista) {
        this.tienda_vista = tienda_vista;
        
        
          
        
        
        
        tienda_vista.getInicio_PanelBtn().addMouseListener(new MouseAdapter() {
  @Override
    public void mouseClicked(MouseEvent e) {
        vista_inicio vistaInicio=new vista_inicio() ;
        MostraPanel(vistaInicio.getjPanel1());
        
        
    }
        
        
        });
        
        
           tienda_vista.getProductos_PanelBtn().addMouseListener(new MouseAdapter() {
  @Override
    public void mouseClicked(MouseEvent e) {
        
        
        
           vista_producto vista__producto=new vista_producto() ;
        MostraPanel(vista__producto.getjPanel1());
    }
        
        
        });
        
        
        
        
           tienda_vista.getCarrito_PanelBtn().addMouseListener(new MouseAdapter() {
  @Override
    public void mouseClicked(MouseEvent e) {
        
        
               vista_carrito vistaCarro=new vista_carrito() ;
        MostraPanel(vistaCarro.getjPanel1());
        
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
                  
                      tienda_vista.getSidebar_panel().setSize(i,500);
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
        
           for(int i = 140;i>=-30; i--){
                  Thread.sleep(1);
                  
                      tienda_vista.getEtiquetaBtn().setLocation(i, 150);
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
                      tienda_vista.getSidebar_panel().setSize(i,500);
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
        
           for(int i = 0;i<=170; i++){
                  Thread.sleep(2);
                  
                      tienda_vista.getEtiquetaBtn().setLocation(i, 150);
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
    

    
}
