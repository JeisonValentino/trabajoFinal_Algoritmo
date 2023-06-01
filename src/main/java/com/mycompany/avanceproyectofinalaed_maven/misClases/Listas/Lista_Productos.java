/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases.Listas;

import com.mycompany.avanceproyectofinalaed_maven.misClases.Exceciones.PropiedadesFaltantes;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Item_Producto;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Productos;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios.Interface_productos;
import java.lang.reflect.Array;
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
    
    
    
    public static Lista_Productos instancia;
    public  List<Productos> lista_productos;
    
    public Lista_Productos(){
        lista_productos= new ArrayList<>();
    }

    public Lista_Productos(  List<Productos> lista_productos ) {
        
        this.lista_productos=lista_productos;
        
    }
    
    public static Lista_Productos getInstancia() {
        if (instancia == null) {
            instancia = new Lista_Productos();
        }
        return instancia;
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
        Lista_Item_Producto list=Lista_Item_Producto.getInstancia();
        try{
         verificarTodasPropiedadesFaltantes(producto);
        lista_productos.add(producto);
        
        
        if(producto.getCantidad()>0){
            for(int i =0 ; i<producto.getCantidad();i++){
            Item_Producto item=new Item_Producto(producto.getId(), "01/07/2023", "activo");
            list.AgregarDatos_itemProducto(item);
            }
        }
        
        
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
    public  Optional<List<Productos>> retornarListaProductos() {


try{
    
    if(lista_productos.isEmpty())throw new IllegalArgumentException("no se encontraron datos en la lista de productos "); 
    for(Productos pro : lista_productos){
        System.out.println(pro.getId());
    }
  return Optional.of(lista_productos);
}catch(IllegalArgumentException ex ){
    System.out.println(ex.getMessage());
      return Optional.empty();
}

    }

    @Override
    public Optional<List<Productos>> retornarListaProductos_busqueda(String id) {
      try{
    List<Productos> list_busqueda=new ArrayList<Productos>();
    if(lista_productos.isEmpty())throw new IllegalArgumentException("no se encontraron datos en la lista de productos "); 
    for(Productos pro : lista_productos){
        if(pro.getId().startsWith(id)|| pro.getMarca().startsWith(id)||pro.getNombre().startsWith(id)||pro.getSeccion().startsWith(id)){
        list_busqueda.add(pro);
        }
    }
  return Optional.of(list_busqueda);
}catch(IllegalArgumentException ex ){
    System.out.println(ex.getMessage());
      return Optional.empty();
}
    }


    
    
     //Ordenamiento Burbuja
    public void ordenarPorId() {
        int n = lista_productos.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String id1 = lista_productos.get(j).getId();
                String id2 = lista_productos.get(j + 1).getId();

                if (id1.compareTo(id2) > 0) {
                    // Intercambiar los productos
                    Productos temp = lista_productos.get(j);
                    lista_productos.set(j, lista_productos.get(j + 1));
                    lista_productos.set(j + 1, temp);
                }
            }
        }
    }
    
    public void ordenarPorCantidad() {
        int n = lista_productos.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                int cantidad1 = lista_productos.get(j).getCantidad();
                int cantidad2 = lista_productos.get(minIndex).getCantidad();

                if (cantidad1 < cantidad2) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // Intercambiar los productos
                Productos temp = lista_productos.get(i);
                lista_productos.set(i, lista_productos.get(minIndex));
                lista_productos.set(minIndex, temp);
            }
        }
    }
    
      //Ordenamiento QuickSort
    public void ordenarPorIdQuickSort() {
        ordenarPorIdRecursivo(0, lista_productos.size() - 1);
    }

    private void ordenarPorIdRecursivo(int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(inicio, fin);
            ordenarPorIdRecursivo(inicio, indiceParticion - 1);
            ordenarPorIdRecursivo(indiceParticion + 1, fin);
        }
    }

    private int particion(int inicio, int fin) {
        String pivote = lista_productos.get(fin).getId();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista_productos.get(j).getId().compareTo(pivote) < 0) {
                i++;
                intercambiar(i, j);
            }
        }

        intercambiar(i + 1, fin);
        return i + 1;
    }

    private void intercambiar(int i, int j) {
        Productos temp = lista_productos.get(i);
        lista_productos.set(i, lista_productos.get(j));
        lista_productos.set(j, temp);
    }

    //Ordenamiento ShellShort
    public void ordenarPorNombreShellShort() {
        int n = lista_productos.size();
        int salto = n / 2;

        while (salto > 0) {
            for (int i = salto; i < n; i++) {
                Productos temp = lista_productos.get(i);
                int j = i;

                while (j >= salto && lista_productos.get(j - salto).getNombre().compareTo(temp.getNombre()) > 0) {
                    lista_productos.set(j, lista_productos.get(j - salto));
                    j -= salto;
                }

                lista_productos.set(j, temp);
            }

            salto /= 2;
        }
    }
       //Ordenamiento por insercion
    public void ordenarPorNombre() {
        int n = lista_productos.size();

        for (int i = 1; i < n; i++) {
            Productos producto = lista_productos.get(i);
            String nombre = producto.getNombre();
            int j = i - 1;

            while (j >= 0 && lista_productos.get(j).getNombre().compareTo(nombre) > 0) {
                lista_productos.set(j + 1, lista_productos.get(j));
                j--;
            }

            lista_productos.set(j + 1, producto);
        }
    }
}
