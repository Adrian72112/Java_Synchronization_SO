package Ej_4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Adrián Tesore
 */
public class Principal {
    
    static final int MAX_THREADS = 2;
    static final int CPU_CORES = 8;
    static final long N = 10000;
    
    public static void main(String... args) throws InterruptedException{
        // Inicializo variable timerInicio
        long timerInicio = System.currentTimeMillis();
        ThreadGroup group = new ThreadGroup("Hilos");
        // Inicializo Objeto del tipo int global para la suma
        long[] sumaTotal = {0};
        
        Semaphore semaforo = new Semaphore(CPU_CORES);
        long subRangos[] = new long[MAX_THREADS]; // Sacar valor de intervalos
        long variacion = N / MAX_THREADS;
        
        // Inicializo los hilos para sumar
        for (int i = 0; i < MAX_THREADS;i++){
            subRangos[i] = variacion * (i+1);
            long inicio = subRangos[i] - subRangos[0];
            // Comienzo el hilo
            SumaNatural sumita = new SumaNatural(semaforo,sumaTotal, inicio, subRangos[i], group , "");
            sumita.start();
            /*
            En las simulaciones noté que es más costoso el tema de crear un hilo, que la suma en sí.
            Es mas eficiente crear un solo hilo y realizar la suma. En mi caso con procesador i7 = 8770U.
            Simule en SumaNatural() que el realizar la suma costara 1 milisegundo y ahí si se vió diferencias 
            en los tiempos cuanto más hilos creados, mejoraba mucho el tiempo.
            */
        }
        while (group.activeCount() > 0) {
            // do nothing
        }
        long timerFin = System.currentTimeMillis();
        double tiempo = (double) ((timerFin - timerInicio));
        System.out.println("\n LA SUMA FINAL ES! : " + sumaTotal[0] + 
                "\ny demoró: " + tiempo + " milisegundos en terminar");
    }
    
}
