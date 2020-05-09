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
public class HolaMundoHilo extends Thread {
    
    int hilo;
    int[] ejecutar;
    
    public HolaMundoHilo(int[] _ejecutar, int _hilo){
        ejecutar = _ejecutar;
        hilo = _hilo;
    }
    
    @Override
    public void run(){
        String response = (ejecutar[0] == 1) ? "Hola Hilo " + hilo + "!!!"  : "Hola Mundo!!!";
        System.out.println(response);
    }
    
}
