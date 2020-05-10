package Ej_4;


import java.util.concurrent.*;
/**
 *
 * @author Adrián Tesore
 */
public class Principal {
    
    static final int MAX_THREADS = 500; // Probar con 2, con 100 y con cpu cores
    static final long N = 1000000;
    
    public static void main(String... args) throws InterruptedException{
        // Inicializo variable timerInicio
        long timerInicio = System.currentTimeMillis();
        ExecutorService es = Executors.newCachedThreadPool();
        // Inicializo Objeto del tipo int global para la suma
        long[] sumaTotal = {0};
        
        Semaphore semaforo = new Semaphore(MAX_THREADS);
        long subRangos[] = new long[MAX_THREADS]; // Sacar valor de intervalos
        long variacion = N / MAX_THREADS;
        
        // Inicializo los hilos para sumar
        for (int i = 0; i < MAX_THREADS;i++){
            subRangos[i] = variacion * (i+1);
            long inicio = subRangos[i] - subRangos[0];
            // Comienzo el hilo
            es.execute(new SumaNatural(semaforo,sumaTotal, inicio, subRangos[i]));            
            /*
            En las simulaciones noté que es más costoso el tema de crear un hilo, que la suma en sí.
            Es mas eficiente crear un solo hilo y realizar la suma. En mi caso con procesador i7 = 8770U.
            Simule en SumaNatural() que el realizar la suma costara 1 milisegundo y ahí si se vió diferencias 
            en los tiempos cuanto más hilos creados, mejoraba mucho el tiempo.
            */
        }
        es.shutdown();
        while(!es.awaitTermination(100, TimeUnit.MINUTES)){
            // Espero a que termine toda la ejecucion
        }
        long timerFin = System.currentTimeMillis();
        double tiempo = (double) ((timerFin - timerInicio));
        System.out.println("\n------------------------------- \n");
        System.out.println("\n LA SUMA FINAL ES! : " + sumaTotal[0] + 
                "\nY DEMORÓ: " + tiempo + " MILISEGUNDOS EN TERMINAR");
        System.out.println("\n------------------------------- \n");
    }
    
}
