/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases.Listas;

import com.mycompany.avanceproyectofinalaed_maven.misClases.Exceciones.PropiedadesFaltantes;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Productos;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios.Interface_productos;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author Jvalentino
 */
public class Lista_Productos extends PropiedadesFaltantes implements Interface_productos   {
    
    public List<Productos> lista_productos= new ArrayList<>();
    
    public Lista_Productos(){
        
    }

    public Lista_Productos(  List<Productos> lista_productos ) {
        
        this.lista_productos=lista_productos;
        
    }
    
    
    
    public void  ActualizarDatos(Productos producto ){
        
        try{
             verificarTodasPropiedadesFaltantes(producto);
        lista_productos.add(producto);

            JOptionPane.showMessageDialog(null, "Se actualizo correctamente los datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        }catch(IllegalArgumentException ex ){

            JOptionPane.showMessageDialog(null, "Se requiere completen los siguientes componentes del Producto : " + ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);

        }
        catch(IllegalAccessException ex2){
         
            
   JOptionPane.showMessageDialog(null, "Error en la clase"+ex2.getClass().getSimpleName() + "hubo algunos datos que no cumplieron con el parametro : "+ex2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void eliminarFila (String id ){
        
        try {
        if(buscarPorId(id).isPresent())throw  new NoSuchElementException ("El id no existe ");
        
        lista_productos.remove(buscarPorId(id).get());
        }catch(NoSuchElementException ex ){
 JOptionPane.showMessageDialog(null, "Se encontraron problemas  : " + ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);

        }
        
    }
    
    public void  AgregarDatos(Productos  producto)  {
        
        try{
         verificarTodasPropiedadesFaltantes(producto);
        lista_productos.add(producto);
        
           }catch(IllegalArgumentException ex ){

            JOptionPane.showMessageDialog(null, "Se requiere completen los siguientes componentes del Producto : " + ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);

        }
        catch(IllegalAccessException ex2){
         
            
   JOptionPane.showMessageDialog(null, "Error en la clase"+ex2.getClass().getSimpleName() + "hubo algunos datos que no cumplieron con el parametro : "+ex2, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

  
    public Optional<Productos> buscarPorId(String id)  {

        for( Productos pe : lista_productos ){
            if(pe.getId().equals(id)){
                return Optional.of(pe);
            }
        }
 
            return Optional.empty();
        
    }

    @Override
    public Optional<List<Productos>> retornarListaProductos() {


try{
    
    if(lista_productos.isEmpty())throw new IllegalArgumentException("no se encontraron datos en la lista de productos "); 
  return Optional.of(lista_productos);
}catch(IllegalArgumentException ex ){
      return Optional.empty();
}

    }


    
    
    
    
    
    
    
    
}
