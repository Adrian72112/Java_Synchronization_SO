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
    int[] sumaTotal;
    int ini;
    int fin;
    
    public SumaNatural(Semaphore sem, int[] _sumaTotal, int inicio, int _final) {
        this.sumaTotal = _sumaTotal;
        this.sem = sem;
        this.ini = inicio;
        this.fin = _final;
    }
        
    @Override
    public void run(){
        try {
            this.sem.acquire();
            while (ini < fin){
                sumaTotal[0] = sumaTotal[0] + (ini + 1);
                ini++;
            }
            this.sem.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(SumaNatural.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
