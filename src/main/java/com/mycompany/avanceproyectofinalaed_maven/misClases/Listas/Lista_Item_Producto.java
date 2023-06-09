/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases.Listas;

import com.mycompany.avanceproyectofinalaed_maven.misClases.Constantes.codificacion;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Exceciones.PropiedadesFaltantes;
import static com.mycompany.avanceproyectofinalaed_maven.misClases.Exceciones.PropiedadesFaltantes.verificarTodasPropiedadesFaltantes;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Item_Producto;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios.Interface_item_productos;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author Jvalentino
 */
public class Lista_Item_Producto extends PropiedadesFaltantes implements Interface_item_productos  {
    
    public static  Lista_Item_Producto instancia ; 
    public List<Item_Producto> lista_item_producto ;

    public Lista_Item_Producto() {
        lista_item_producto =new ArrayList<>();
    }

    public Lista_Item_Producto(List<Item_Producto> lista_item_producto) {
        this.lista_item_producto=lista_item_producto;
    }

    
    
        
    public static Lista_Item_Producto getInstancia() {
        if (instancia == null) {
            instancia = new Lista_Item_Producto();
        }
        return instancia;
    }
    
    @Override
    public void ActualizarDatos_itemProducto(Item_Producto producto) {

        try{
             verificarTodasPropiedadesFaltantes(producto);
        lista_item_producto.add(producto);

            JOptionPane.showMessageDialog(null, "Se actualizo correctamente los datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        }catch(IllegalArgumentException ex ){

            JOptionPane.showMessageDialog(null, "Se requiere completen los siguientes componentes del item producto : " + ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);

        }
        catch(IllegalAccessException ex2){
         
            
   JOptionPane.showMessageDialog(null, "Error en la clase"+ex2.getClass().getSimpleName() + "hubo algunos datos que no cumplieron con el parametro : "+ex2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void eliminarFila_itemProducto(String id) {
      try {
        if(buscarPorId_itemProducto(id).isPresent())throw  new NoSuchElementException ("El id no existe ");
        
        lista_item_producto.remove(buscarPorId_itemProducto(id).get());
        }catch(NoSuchElementException ex ){
 JOptionPane.showMessageDialog(null, "Se encontraron problemas  : " + ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);

        }
    }

    @Override
    public void AgregarDatos_itemProducto(Item_Producto producto) {

        try{
         verificarTodasPropiedadesFaltantes(producto);
        lista_item_producto.add(producto);
        
           }catch(IllegalArgumentException ex ){

            JOptionPane.showMessageDialog(null, "Se requiere completen los siguientes componentes del item  Producto : " + ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);

        }
        catch(IllegalAccessException ex2){
         
            
   JOptionPane.showMessageDialog(null, "Error en la clase"+ex2.getClass().getSimpleName() + "hubo algunos datos que no cumplieron con el parametro : "+ex2, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public Optional<Item_Producto> buscarPorId_itemProducto(String id) {

        for( Item_Producto pe : lista_item_producto ){
            if(pe.getId().equals(id)){
                return Optional.of(pe);
            }
        }
 
            return Optional.empty();
        
    }

    @Override
    public Optional<List<Item_Producto>> retornarLista_itemProducto() {
try{
    
    if(lista_item_producto.isEmpty())throw new IllegalArgumentException("no se encontraron datos en la lista de items productos "); 
  return Optional.of(lista_item_producto);
}catch(IllegalArgumentException ex ){
      return Optional.empty();
}

    }

    @Override
    public Optional<List<Item_Producto>> retornarLista_itemProducto_especifico(String codigo) {
        
      
        if(!retornarLista_itemProducto().isEmpty()){ //VERIFICA SI EL RETORNO DE TODA LA LISTA DE LOS ITEMS PRODUCTO RETORNA VACIO O NO 
List<Item_Producto> list_items=  new ArrayList<>();

for( Item_Producto item_pro :retornarLista_itemProducto().get()){
   
    if(item_pro.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA).equals(codigo.substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA))){
        list_items.add(item_pro);
    }
}

return Optional.of(list_items);
        }else{
            return Optional.empty(); //RETORNA UN ESTADO VACIO 
        }
    }

    @Override
    public Optional<List<Item_Producto>> retornarLista_itemProducto_especifico_estado(String codigo, String estado) {
              if(!retornarLista_itemProducto().isEmpty()){ //VERIFICA SI EL RETORNO DE TODA LA LISTA DE LOS ITEMS PRODUCTO RETORNA VACIO O NO 
List<Item_Producto> list_items=  new ArrayList<>();

for( Item_Producto item_pro :retornarLista_itemProducto().get()){
    if(item_pro.getId().substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA).equals(codigo.substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA)) && item_pro.getEstado().equals(estado) ){
        list_items.add(item_pro);
    }
}

return Optional.of(list_items);
        }else{
            return Optional.empty(); //RETORNA UN ESTADO VACIO 
        }
    }
    
 
    
    
    
    
}
