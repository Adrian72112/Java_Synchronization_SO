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
public class Principal {
    
    public static void main(String... args) {
        PartA();
        PartB();
        PartC();
    }
    
    /**
     * Parte A del ejercicio
    */
    static void PartA() {
        System.out.println("----- PARTE A ----- ");
        System.out.println("Adapte el programa para que funcione a n vueltas, trate de sincronizar con\n" +
"sleep() y usando cantidades de vueltas mayores \n");
        int vueltas = 7;
        Tortuga toru = new Tortuga(vueltas);
        Liebre liebre = new Liebre(vueltas,1);
        toru.start();   
        liebre.start();
        while (toru.isAlive() || liebre.isAlive()){}

        System.out.println("----- FIN A ----- \n");
    }
    
    /**
     * Parte B del ejercicio
    */
    static void PartB() {
        System.out.println("----- PARTE B ----- ");
        System.out.println("Adapte el programa para que la tortuga salga en una relación de 4 veces de\n" +
"vueltas antes, varíe la cantidad de vueltas \n");
        int vueltas = 10;
        Tortuga toru = new Tortuga(vueltas);
        Liebre liebre = new Liebre(vueltas,0);
        toru.start();   
        liebre.start();
        while (toru.isAlive() || liebre.isAlive()){}
            // Esperar a que finalicen los threads
        System.out.println("----- FIN B ----- \n");
    }
    
    
     /**
     * Implementación de la carrera usando Semaforos
     */
    static void PartC(){
        System.out.println("----- PARTE C ----- ");
        System.out.println("Implentar para que sea eficiente utilizando Semaforos \n");
        Semaphore semaforo = new Semaphore(1);
        int vueltas = 15;
        Tortuga toru = new Tortuga(vueltas,true,semaforo);
        Liebre liebre = new Liebre(vueltas,true,semaforo);
        toru.start();
        liebre.start();       
    }
    
}
