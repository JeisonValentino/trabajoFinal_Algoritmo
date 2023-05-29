/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Modelos;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Constantes.codificacion;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Item_Producto;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Listas.Lista_Item_Producto;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Productos;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios.Interface_item_productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jvalentino
 */
public class Modelo_listaproductos_carrito {
    
    
    private  List<Modelo_producto_carrito> lista_productos=new ArrayList<>();

    public Modelo_listaproductos_carrito() {
    }

    public Modelo_listaproductos_carrito(List<Modelo_producto_carrito> lista_productos) {
        this.lista_productos=lista_productos;
    }
    
    public List<Modelo_producto_carrito> obtenerListaCarrito(){
        if(lista_productos.isEmpty()) throw new IllegalArgumentException("no hay datos");
        
        return lista_productos;
    }
    
    public void actualizarDatosCarrito (Productos m  ) {
        
        Interface_item_productos  interfaz =new Lista_Item_Producto();
        if(!interfaz.retornarLista_itemProducto().get().isEmpty()){
        for(Item_Producto item_pro:  interfaz.retornarLista_itemProducto().get()){
            if(m.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA).equals(item_pro.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA))){
                
                if(item_pro.getEstado().equals("activo")){
                    Modelo_producto_carrito m1 =new Modelo_producto_carrito();
                lista_productos.add(m1);
                }
            }
        }
       
        }
    }
    
    public void agregarDatosCarrito (Modelo_producto_carrito m ){
                lista_productos.add(m);
    }
    
    
     public void EliminarDatosCarrito(int id ){
         
         
         lista_productos.remove(id);
     }
    
    
    
}
