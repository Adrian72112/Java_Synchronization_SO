package Ej_3;

/**
 *
 * @author Adrián Tesore
 */
public class Persona extends Thread {
    
    String nombre;
    TienePalabra h1;

    public Persona(String nombre, TienePalabra h1, ThreadGroup group, String name) {
        super(group, name);
        this.nombre = nombre;
        this.h1 = h1;
    }
    
    @Override
    public void run(){
        this.h1.habla(this.nombre);
    }
    
    
}
