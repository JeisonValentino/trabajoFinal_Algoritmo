package com.mycompany.avanceproyectofinalaed_maven.misClases;



public class Productos {

    String nombre;
    String marca;
    String seccion;
    double precio;
    int cantidad;

    public Productos(String nombre, String marca, String seccion, double precio, int cantidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.seccion = seccion;
        this.precio = precio;
        this.cantidad = cantidad;
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
}
