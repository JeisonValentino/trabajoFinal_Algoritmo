/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases;

/**
 *
 * @author Jvalentino
 */
public class ImagenAlmacen {
    private static int  contador=1;
    String imagen_id;
    String titulo;
    byte[] imagen;

    public ImagenAlmacen() {
    }

    public ImagenAlmacen( String titulo, byte[] imagen) {
        this.imagen_id = "img-"+contador++;
        this.titulo = titulo;
        this.imagen = imagen;
    }

    
    
    
    public String getImagen_id() {
        return imagen_id;
    }

    public void setImagen_id(String imagen_id) {
        this.imagen_id = imagen_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    
    
    
}
