/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Color;

/**
 *
 * @author UNAM09
 */
public class Figura {
    public int x, y;
    Color color;

    public Figura(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public void mover(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return ""+this.x+", "+this.y;
    }
    
    
}
