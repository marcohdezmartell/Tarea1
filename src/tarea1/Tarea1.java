/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author UNAM09
 */
public class Tarea1 extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    Mapa cuadricula;
    int tiempo;
    Cazador cazador;
    Objetivo presa;
    private String historial[];
    public Tarea1() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            
            
        });
        cuadricula = new Mapa();
        
        this.setMinimumSize(new Dimension(700,700));
        this.add(cuadricula).setVisible(true);
        cazador = new Cazador(0, 0);
        presa = new Objetivo(0, 0);
        this.repaint();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Tarea1 tarea = new Tarea1();
        tarea.pack();
        tarea.setVisible(true);
        Motor motor = new Motor();
        tarea.historial = motor.jugar();
        for (tarea.tiempo = 0; tarea.tiempo < tarea.historial.length; tarea.tiempo++) {
            tarea.leer();
            System.out.println(tarea.historial[tarea.tiempo]);
            tarea.cuadricula.cazador = tarea.cazador;
            tarea.cuadricula.presa = tarea.presa;
            tarea.cuadricula.tiempo = tarea.tiempo;
            tarea.cuadricula.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        private void leer(){
        String cadena=historial[tiempo];
        String datos[]=cadena.split(", ");
        cazador.x=Integer.parseInt(datos[0]);
        cazador.y=Integer.parseInt(datos[1]);
        presa.x=Integer.parseInt(datos[2]);
        presa.y=Integer.parseInt(datos[3]);
        if(cazador.x==presa.x){
            if(cazador.y==presa.y){
                this.cuadricula.contador++;
            }
        }
    }
    
}
