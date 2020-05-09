/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej_2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que simula una Liebre corriendo
 * Implementada para usar semaforo y Thread
 * @author Adrián Tesore
 */
public class Liebre extends Thread{
    int contador;
    int parteA;
    
    boolean usarSemaforo;
    Semaphore sem;
    
    Liebre(int _cont, int _parteA){
        this.contador = _cont;
        this.parteA = _parteA;
    }
    
    Liebre(int cont, boolean _conSemaforo, Semaphore sem){
        this.contador = cont;
        this.usarSemaforo = _conSemaforo;
        this.sem = sem;
    }
    
    @Override
    public void run(){
        if (usarSemaforo){
            conSemaforo();
        }else{
            try {
                if (this.parteA == 0)
                    Thread.sleep(7000); // 4 vueltas de la tortuga
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Empieza a correr cada vuelta
            for(int i = 1;i <= contador ; i++){
                try {
                    System.out.println("Liebre vuelta: " + i);
                    Thread.sleep(500); // 1 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Ejecutre el código
            }
        }
    }
    
    /**
     * La liebre debe pedir el semaforo y luego liberarlo luego de correr
     * 4 vueltas
     * @param sem
     */
    public void conSemaforo(){
        try {
            boolean prenderSemaforo = true;
            for(int i = 1;i <= contador ; i++){
                if (prenderSemaforo){ // Debo solicitar el semaforo cuando comience
                    sem.acquire();
                    prenderSemaforo = false;
                }
                System.out.println("Liebre vuelta: " + i);
                if (i % 4 == 0){
                    sem.release();
                    prenderSemaforo = true;
                }
                Thread.sleep(10);
            }
            System.out.println("Liebre ha finalizado!  \n");
            sem.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
