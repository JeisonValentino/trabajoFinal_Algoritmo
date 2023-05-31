/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases;

import com.mycompany.avanceproyectofinalaed_maven.misClases.Constantes.codificacion;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Listas.Lista_Item_Producto;
import com.mycompany.avanceproyectofinalaed_maven.misClases.Repositorios.Interface_item_productos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Jvalentino
 */
public class Item_Producto {
 
    private String id ;
private String caducidad;
private final String fecha_creacion;
private String fecha_actualizacion;
private String estado;
    public Item_Producto(String codigo, String caducidad,String estado) {
        this.id = GenerarCodigo(codigo);
        this.caducidad=caducidad;
         LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fecha_creacion = fechaActual.format(formateador);
        this.fecha_actualizacion=fechaActual.format(formateador);
   this.estado=estado;
    }





    private String GenerarCodigo(String codigoProducto ){
         String codigoItem = codigoProducto.substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA); 
         Interface_item_productos interfaz= new Lista_Item_Producto();
         
     if(interfaz.retornarLista_itemProducto().isEmpty()){

 return codigoItem + String.format("%03d",1);
         }else{
             
            List<Item_Producto> items = interfaz.retornarLista_itemProducto().get(); 
             
            for(Item_Producto it : items ){
                if(codigoItem.equals(it.id.substring(codificacion.PRIMERA_ESCALA, codificacion.SEGUNDA_ESCALA))){
                     return codigoItem + String.format("%03d", items.size()+1);
                }
            }
 return codigoItem + String.format("%03d",1);
         }
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }


    
    
    
    
}
