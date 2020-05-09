package Ej_3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Adrián Tesore
 */
public class TienePalabra {
    
    Semaphore semaforo;
    public TienePalabra(Semaphore sem){this.semaforo = sem;}

    /**
     * Otra opción es hacer este método synchronized pero solo 1 
     * participante podría estar hablando a la vez
     * @param a
     */
    
    public void habla(String a) {
        try {
            semaforo.acquire();
            System.out.println(a + " esta hablando");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(a + " fue interrumpido");
            semaforo.release();
            return;
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(a + " termino de hablar");
        semaforo.release();

    }
    
    
}
