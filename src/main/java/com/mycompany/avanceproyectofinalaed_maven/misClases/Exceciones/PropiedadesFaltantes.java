/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.misClases.Exceciones;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Jvalentino
 */
public class  PropiedadesFaltantes {
    
   
    public static  void verificarTodasPropiedadesFaltantes(Object objeto) throws IllegalArgumentException,IllegalAccessException {
    Field[] campos = objeto.getClass().getDeclaredFields();
boolean Excepciones =false;
    ArrayList<String> array = new ArrayList<>();
    for (Field campo : campos) {
        campo.setAccessible(true);

       
            Object valor = campo.get(objeto);

            if (valor == null || (valor instanceof String && ((String) valor).isEmpty())  || (valor instanceof Number && ((Number) valor).doubleValue() == 0)) {
                 Excepciones=true;
              array.add(campo.getName());
               
            }
            
            
            
            
            
            
    
    }
    
    
if(Excepciones)     {    
       throw new IllegalArgumentException("Elementos faltantes -->: " + array.toString());

}
       
    
}
}
