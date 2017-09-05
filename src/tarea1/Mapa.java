/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author UNAM09
 */
public class Mapa extends JPanel{
    
    
    Cazador cazador;
    Objetivo presa;
    int contador;
    int tiempo;
    Mapa(){
        super();
        this.setSize(650,650);
        
        
        cazador = new Cazador(0, 0);
        presa = new Objetivo(100, 600);
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintarMalla(g);
        g.fillOval(Tools.redondear(cazador.x/100)*6, Tools.redondear(cazador.y/100)*6, 20, 20);
        g.setColor(Color.GREEN);
        g.fillRect(Tools.redondear(presa.x/100)*6, Tools.redondear(presa.y/100)*6, 20, 20);
        g.setColor(Color.RED);
        g.drawString("PUNTOS "+contador, 600, 630);
        g.drawString("TIEMPO "+tiempo, 500, 630);
    }
    
    private void pintarMalla(Graphics g){
        this.setBackground(Color.BLACK);
        for (int i = 0; i < 600; i+=60) {
            g.setColor(Color.RED);
            g.drawLine(i, 0, i, 600);
            g.drawLine(0, i, 600, i);
            g.setColor(Color.BLUE);
            for (int j = i+6; j < i+60; j+=6) {
                g.drawLine(j, 0, j, 600);
                g.drawLine(0, j, 600, j);
            }
            
        }
        g.setColor(Color.RED);
        g.drawLine(600, 0, 600, 600);
        g.drawLine(0, 600, 600, 600);
        
    }



}
