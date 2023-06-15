/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Modelos;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Constantes.codificacion;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Item_Producto;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Listas.Lista_Item_Producto;
import static com.mycompany.avanceproyectofinalaed_maven.misClases.Listas.Lista_Item_Producto.instancia;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Productos;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios.Interface_item_productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jvalentino
 */
public class Modelo_listaproductos_carrito {
    
    public static Modelo_listaproductos_carrito session;
    public   List<Modelo_producto_carrito> lista_productos;

    public Modelo_listaproductos_carrito() {
        lista_productos=new ArrayList<>();
    }

    public static  Modelo_listaproductos_carrito getSession(){
             if (session == null) {
            session = new Modelo_listaproductos_carrito();
        }
        return session;
    }
    public Modelo_listaproductos_carrito(List<Modelo_producto_carrito> lista_productos) {
        this.lista_productos=lista_productos;
    }
    
    public List<Modelo_producto_carrito> obtenerListaCarrito(){
        if(lista_productos.isEmpty()) throw new IllegalArgumentException("no hay datos");
        
        return lista_productos;
    }
    
       public Modelo_producto_carrito obtenerListaCarrito_espefico(String codigo) {
    for (Modelo_producto_carrito mo : lista_productos) {
        if (mo.codigo_producto.equals(codigo)) {
            return mo;
        }
    }
    return null;
}
    
    
    public void actualizarDatosCarrito (Productos m  ) {
                                 Lista_Item_Producto  interfaz = Lista_Item_Producto.getInstancia();
        if(!obtenerListaCarrito().isEmpty()){
                    boolean estadoActivoEncontrado = false;
   
          
               if(obtenerListaCarrito_espefico(m.getId()).Cantidad ==interfaz.retornarLista_itemProducto_especifico_estado(m.getId(),"activo").get().size()){
                  
               throw new IllegalStateException("Ya no hay mas productos ");
               
       
        }else{
                    for(Modelo_producto_carrito item_pro:  lista_productos){
    
            if(m.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA).equals(item_pro.getCodigo_producto().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA))){
              
             
         
              
               System.out.println(interfaz.retornarLista_itemProducto_especifico_estado(m.getId(),"activo").get().size());
         if(obtenerListaCarrito_espefico(m.getId()).getCantidad() <interfaz.retornarLista_itemProducto_especifico_estado(m.getId(),"activo").get().size()){
                 
                      estadoActivoEncontrado = true;
           
             item_pro.aumentarCantidad();
        
                return;
                }
               
                
            }
        }
               }
       
          if (!estadoActivoEncontrado) {
            throw new IllegalStateException("No se encontraron productos activos");
        }
          
           
        
        }
   
    }
    
    
    
    
    public void disminuirDatosCarrito (Productos m  ) {
                                           Interface_item_productos  interfaz =new Lista_Item_Producto();
        if(!obtenerListaCarrito().isEmpty()){
                    boolean estadoActivoEncontrado = false;     
                    
        for(Modelo_producto_carrito item_pro:  lista_productos){
            if(m.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA).equals(item_pro.getCodigo_producto().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA))){
                
                if(obtenerListaCarrito_espefico(m.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA)).Cantidad <=1){
                    return ; 
                }
                
         
                  if(obtenerListaCarrito_espefico(m.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA)).Cantidad >1){
                    estadoActivoEncontrado = true;
             item_pro.disminuirCantidad();
                return;
                }
               
                
            }
        }
       
          if (!estadoActivoEncontrado) {
            throw new IllegalStateException("No se encontraron productos activos");
        }
        
        }
   
   
    }
    
    

    
    public void agregarDatosCarrito (Productos m ){
                Lista_Item_Producto  interfaz = Lista_Item_Producto.getInstancia();
        if(!interfaz.retornarLista_itemProducto().get().isEmpty()){
                    boolean estadoActivoEncontrado = false;

        for(Item_Producto item_pro:  interfaz.retornarLista_itemProducto_especifico(m.getId()).get()){
            if(m.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA).equals(item_pro.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA))){
                
                if(item_pro.getEstado().equals("activo")){
                    estadoActivoEncontrado = true;
                    Modelo_producto_carrito m1 =new Modelo_producto_carrito(m.getNombre(), m.getPrecio(),m.getId());
                lista_productos.add(m1);
                return;
                }
      
                
            }
        }
       
          if (!estadoActivoEncontrado) {
            throw new IllegalStateException("No se encontraron productos activos");
        }
        
        }
    }
    
    
     public void EliminarDatosCarrito(int id ){
         
         
         lista_productos.remove(id);
     }
    
    
    
}
