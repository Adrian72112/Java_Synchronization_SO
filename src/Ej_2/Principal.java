/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej_2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author tesit
 */
public class Principal {
    
    public static void main(String... args) {
        //PartA();
        //PartB();
        PartC();
    }
    
    static void PartA() {
        System.out.println("----- PARTE A ----- \n");
        int vueltas = 5;
        Tortuga toru = new Tortuga(vueltas);
        Liebre liebre = new Liebre(vueltas,1);
        toru.start();   
        liebre.start();
        while (toru.isAlive() || liebre.isAlive())

        System.out.println("----- FIN A ----- \n");
    }
    
    static void PartB() {
        System.out.println("----- PARTE B ----- \n");
        int vueltas = 5;
        Tortuga toru = new Tortuga(vueltas);
        Liebre liebre = new Liebre(vueltas,0);
        toru.start();   
        liebre.start();
        while (toru.isAlive() || liebre.isAlive())
            // Esperar a que finalicen los threads
        System.out.println("----- FIN B ----- \n");
    }
    
    static void PartC(){
        System.out.println("----- PARTE C ----- \n");
        Semaphore semaforo = new Semaphore(1);
        int vueltas = 15;
        Tortuga toru = new Tortuga(vueltas,true,semaforo);
        Liebre liebre = new Liebre(vueltas,true,semaforo);
        toru.start();
        liebre.start();
    }
    
}
