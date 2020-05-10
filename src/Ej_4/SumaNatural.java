/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej_4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tesit
 */
public class SumaNatural extends Thread {

    Semaphore sem;
    long[] sumaTotal;
    long ini;
    long fin;
    
    public SumaNatural(Semaphore sem, long[] sumaTotal, long ini, long fin){
        this.sem = sem;
        this.sumaTotal = sumaTotal;
        this.ini = ini;
        this.fin = fin;
    }
        
    @Override
    public void run(){
        try {
            this.sem.acquire(1);
            while (ini < fin){
                Sumar.suma(sumaTotal,ini);
                ini++;
                // Voy a simular que esto tiene un costo en tiempo
                sleep(1);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SumaNatural.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.sem.release(1);
    }
}
