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
    
    long hilo;
    int[] responder;
    
    public HolaMundoHilo(int[] _ejecutar, long _hilo){
        responder = _ejecutar;
        hilo = _hilo;
    }
    
    public HolaMundoHilo(int[] _ejecutar){
        responder = _ejecutar;
    }
    
    @Override
    public void run(){
        String response = (responder[0] == 1) ? "Hola Hilo " + hilo + "!!!"  : "Hola Mundo!!!";
        responder[0]++;
        System.out.println(response);
    }
    
}
