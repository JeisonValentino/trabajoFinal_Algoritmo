/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Modelos;

/**
 *
 * @author Jvalentino
 */
public class Modelo_producto_carrito {
        private static int contadorId = 1;
         private static int contadorCantidad = 1;
public int Id;
    public String Producto;
    public String codigo_producto;
    public int Cantidad;
    public double Precio;

    public Modelo_producto_carrito() {
    
    }

    public Modelo_producto_carrito( String Producto, double Precio,String codigo_producto) {
        this.Id = contadorId++;
        this.Producto = Producto;
        this.Cantidad = 1;
        this.Precio = Precio;
        this.codigo_producto=codigo_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }
    
    
    public double obtenerMontoTotal(){
        return Cantidad*Precio;
    }
    
    public void aumentarCantidad(){
        Cantidad++;
    }
    
     public void disminuirCantidad(){
        Cantidad--;
    }
    

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
    
}
