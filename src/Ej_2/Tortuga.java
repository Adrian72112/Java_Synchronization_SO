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
 *
 * @author tesit
 */
public class Tortuga extends Thread {
    
    int contador;
    boolean usarSemaforo;
    Semaphore sem;
    
    Tortuga(int cont){
        this.contador = cont;
        this.usarSemaforo = false;
    }
    
    Tortuga(int cont, boolean _conSemaforo, Semaphore sem){
        this.contador = cont;
        this.usarSemaforo = _conSemaforo;
        this.sem = sem;
    }
    
    @Override
    public void run(){
        if (usarSemaforo){
            conSemaforo();
        }else{
            // Empieza a correr cada vuelta
            for(int i = 1;i <= contador ; i++){
                try {
                    System.out.println("Tortuga vuelta: " + i);
                    Thread.sleep(2000); // 4 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Tortuga ha finalizado!  \n");
        }
    }
    
    /**
     * La tortuga debe pedir el semaforo y luego liberarlo luego de correr
     * 1 vuelta
     * @param sem
     */
    public void conSemaforo(){
        try {
            for(int i = 1;i <= contador ; i++){
                sem.acquire();
                System.out.println("Tortuga vuelta: " + i);
                sem.release();
                // Noté que la tortuga debe tener un mayor sleep porque sino
                // Va a solicitar el .aquire() antes que la liebre
                Thread.sleep(15); 
            }
            System.out.println("Tortuga ha finalizado!  \n");
        } catch (InterruptedException ex) {
            Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
