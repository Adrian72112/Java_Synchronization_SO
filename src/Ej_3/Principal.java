package Ej_3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Adrian Tesore
 */
public class Principal {
    static final int CANTIDAD_DE_PERSONAS_HABLANDO = 3;
    
    public static void main(String... args) throws InterruptedException {
        Semaphore semafor = new Semaphore(CANTIDAD_DE_PERSONAS_HABLANDO);
        ThreadGroup grupo = new ThreadGroup("Grupo de Participantes");
        TienePalabra h1 = new TienePalabra(semafor);
        
        // Inicializo a los participantes
        Persona p1 = new Persona("Adrían",h1,grupo,"A");
        Persona p2 = new Persona("Nicolas",h1,grupo, "N");
        Persona p3 = new Persona("Mathias",h1, grupo, "M");
       
        //Inicializo al moderador
        Moderador mod = new Moderador(semafor);
        // Le doy permiso a todos que hablen
        p1.start();
        p2.start();
        p3.start();
        
        // Simulo que hablan por unos segundos
        Thread.sleep(1000);
        // Luego moderador decide parar a todos
        mod.pararATodos(grupo);
        mod.quienSigueHablando(new Persona("Adrían",h1, grupo, ""));
    }
    
}
