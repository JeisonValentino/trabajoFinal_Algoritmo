package com.mycompany.avanceproyectofinalaed_maven.misClases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Productos {

    private String id;
    private String nombre;
    private String marca;
    private String seccion;
    private double precio;
    private ImagenAlmacen imagenAlmancen;
    private int cantidad;
    private final String fecha_creacion;
    private String fecha_actualizacion;



    public Productos(String nombre, String marca, String seccion, double precio, ImagenAlmacen imagenAlmancen, int cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.seccion = seccion;
        this.precio = precio;
        this.imagenAlmancen = imagenAlmancen;
        this.id = generarCodigoProducto();
        this.cantidad = cantidad;
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fecha_creacion = fechaActual.format(formateador);
        this.fecha_actualizacion = fechaActual.format(formateador);

    }

    private String generarCodigoProducto() {
        int numero = (int) (Math.random() * 9000) + 1000;
        char letra = (char) (Math.random() * 26 + 'A');
        return String.valueOf(numero) + letra;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public ImagenAlmacen getImagenAlmacen() {
        return imagenAlmancen;
    }

    public void setImagenAlmacen(byte[] ImagenAlmacen) {
        this.imagenAlmancen = imagenAlmancen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImagenAlmacen getImagenAlmancen() {
        return imagenAlmancen;
    }

    public void setImagenAlmancen(ImagenAlmacen imagenAlmancen) {
        this.imagenAlmancen = imagenAlmancen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
