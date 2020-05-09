/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej_1;

/**
 *
 * @author Adrián Tesore
 */

public class Principal {
    
    public static void main(String... args) throws InterruptedException{
        System.out.println("--- Ejercicio 1 --- \n");
        int[] com = {0};
        HolaMundoHilo hilo1 = new HolaMundoHilo(com);
        HolaMundoHilo hilo2 = new HolaMundoHilo(com,hilo1.getId());
        hilo1.start();
        Thread.sleep(100);
        hilo2.start();
    }
    
}
