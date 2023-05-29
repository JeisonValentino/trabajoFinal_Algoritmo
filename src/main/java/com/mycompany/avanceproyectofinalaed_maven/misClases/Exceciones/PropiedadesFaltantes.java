/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases.Exceciones;

import java.lang.reflect.Field;

/**
 *
 * @author Jvalentino
 */
public class  PropiedadesFaltantes {
    
   
    public static  void verificarTodasPropiedadesFaltantes(Object objeto) throws IllegalArgumentException,IllegalAccessException {
    Field[] campos = objeto.getClass().getDeclaredFields();

    for (Field campo : campos) {
        campo.setAccessible(true);

        try {
            Object valor = campo.get(objeto);

            if (valor == null || (valor instanceof String && ((String) valor).isEmpty())) {
                throw new IllegalArgumentException("Elemento faltante -->: " + campo.getName());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
}
