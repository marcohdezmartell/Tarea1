/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.util.Random;

/**
 *
 * @author UNAM09
 */
public class Tools {
    
    public static int aleatorio(){
          Random rand = new Random();
    return rand.nextInt(10000);
    }
    
    public static int redondear(double n){
        int entero= (int)Math.round(n);
        return entero;
    }
}
