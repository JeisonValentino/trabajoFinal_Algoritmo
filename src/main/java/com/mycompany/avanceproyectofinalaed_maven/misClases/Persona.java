package com.mycompany.avanceproyectofinalaed_maven.misClases;

import java.util.Date;
/**
 *
 * @author rvill
 */
public abstract class Persona {
    String nombre;
    String Apellidos;
    int Edad;
    String Telefono;
    Date AñosNacimiento;
    String dni;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Date getAñosNacimiento() {
        return AñosNacimiento;
    }

    public void setAñosNacimiento(Date AñosNacimiento) {
        this.AñosNacimiento = AñosNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", Apellidos=" + Apellidos + ", Edad=" + Edad + ", Telefono=" + Telefono + ", A\u00f1osNacimiento=" + AñosNacimiento + ", dni=" + dni + '}';
    }
}
