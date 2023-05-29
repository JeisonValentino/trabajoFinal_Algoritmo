/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios;

import com.mycompany.avanceproyectofinalaed_maven.misClases.Item_Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jvalentino
 */
public interface Interface_item_productos {
         void  ActualizarDatos_itemProducto(Item_Producto item_producto );
     void eliminarFila_itemProducto (String id );
         void  AgregarDatos_itemProducto(Item_Producto  item_producto);
        Optional< Item_Producto> buscarPorId_itemProducto(String id )  ;
        Optional<List<Item_Producto>> retornarLista_itemProducto();
}
