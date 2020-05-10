/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej_4;

/**
 *
 * @author Adrian Tesore
 */
public class Sumar {
    
    /**
     * El sumar debe ser sincronizado para evitar perdidas de datos
     * @param sumar
     * @param ini
     */
    public static synchronized void suma(long[] sumar,long ini){
        sumar[0] = sumar[0] + (ini + 1);
    }
    
}
