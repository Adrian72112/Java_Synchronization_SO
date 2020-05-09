package Ej_3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrián Tesore
 */
public class Moderador {
    Semaphore semaforo;
    
    public Moderador(Semaphore semaforo){
        this.semaforo = semaforo;
    }
    
    /**
     * Método que para a todos los Threads que esten en un ThreadGroup
     * @param grupo
     */
    public void pararATodos(ThreadGroup grupo){
        // Interrumpe a todos
        grupo.interrupt();
        try {
            semaforo.acquire();
            System.out.println("Parar a TODOS");
            Thread.sleep(4000);
            System.out.println("Terminó de hablar Moderador");
        } catch (InterruptedException ex) {
            Logger.getLogger(Moderador.class.getName()).log(Level.SEVERE, null, ex);
        }
            semaforo.release();
    }
    
    /**
     * Método que pasado por parametro una Persona, continua hablando
     * @param p
     */
    public void quienSigueHablando(Persona p){
        p.start();
    }
    
}
