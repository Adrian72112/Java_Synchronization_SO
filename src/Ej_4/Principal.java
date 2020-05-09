package Ej_4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Adrián Tesore
 */
public class Principal {
    
    static final int MAX_THREADS = 4;
    static final int CPU_CORES = 8;
    static final int N = 100;
    
    public static void main(String... args) throws InterruptedException{
        // Inicializo var global para la suma
        int[] sumaTotal = {0};
        
        Semaphore semaforo = new Semaphore(CPU_CORES);
        int subRangos[] = new int[MAX_THREADS]; // Sacar valor de intervalos
        int variacion = N / MAX_THREADS;
        
        for (int i = 1; i <= MAX_THREADS;i++)
            subRangos[i-1] = variacion * i;
        
        for (int i = 0; i < MAX_THREADS;i++){
            int inicio = subRangos[i] - subRangos[0];
            // Comienzo el hilo
            SumaNatural sumita = new SumaNatural(semaforo,sumaTotal, inicio, subRangos[i]);
            sumita.start();
            sumita.join();
        }
        
        System.out.println("La suma final es: " + sumaTotal[0]);
    }
    
}
