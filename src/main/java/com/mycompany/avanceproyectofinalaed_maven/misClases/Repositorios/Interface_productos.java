/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios;

import com.mycompany.avanceproyectofinalaed_maven.misClases.Productos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jvalentino
 */
public interface  Interface_productos {
     void  ActualizarDatos(Productos producto );
     void eliminarFila (String id );
       void eliminarFila_comienzo ( );
         void  AgregarDatos(Productos  producto);
        Optional< Productos> buscarPorId(String id )  ;
        Optional<List<Productos>> retornarListaProductos();
        Optional<List<Productos>> retornarListaProductos_busqueda(String id);
}
