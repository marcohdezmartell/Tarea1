/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

/**
 *
 * @author sonic
 */
public class Motor {
    private Cazador cazador;
    private Objetivo objetivo;
    private Objetivo reflexion[];
    private String historial[];
    private int tiempo;
    private static final int tLimite = 5000;
    public Motor() {
        reflexion = new Objetivo[9];
        cazador = new Cazador(Tools.aleatorio(), Tools.aleatorio());
        objetivo = new Objetivo(Tools.aleatorio(), Tools.aleatorio());
        historial = new String[5000];
        tiempo = 0;
    }
    
    public String[] jugar(){
        Objetivo mejorReflex;
        
        for (tiempo = 0; tiempo < 5000; tiempo++) {
            
        calcularPlanos(objetivo);
        guardarHist();
        if(fueCapturado()){
            objetivo.mover(Tools.aleatorio(), Tools.aleatorio());
        }else{
            mejorReflex = cazador.analizar(reflexion);
            Figura nuevasCoo = cazador.calcular(mejorReflex);
            mover(nuevasCoo);
        }
        }
        
        return historial;
    }
    private boolean fueCapturado(){
        if(cazador.x == objetivo.x){
            if(cazador.y == objetivo.y){
                return true;
            }
        }
    return false;
    }
    private void guardarHist(){
        historial[tiempo] = "" + cazador + ", "+objetivo;
    }
    
    private void calcularPlanos(Objetivo objetivo){
        //1 centra
        reflexion[0]=objetivo;
        //2 arriba izq
        reflexion[1]= new Objetivo(objetivo.x-10000, objetivo.y+10000);
        //3 arriba
        reflexion[2]= new Objetivo(objetivo.x, objetivo.y+10000);
        //4 arriba der
        reflexion[3]= new Objetivo(objetivo.x+10000, objetivo.y+10000);
        //5 izquierda
        reflexion[4]=new Objetivo(objetivo.x-10000, objetivo.y);
        //6 derecha
        reflexion[5]=new Objetivo(objetivo.x+10000, objetivo.y);
        //7 izq abajo
        reflexion[6]=new Objetivo(objetivo.x-10000, objetivo.y-10000);
        //8 abajo
        reflexion[7]=new Objetivo(objetivo.x, objetivo.y-10000);
        //9 der abajo
        reflexion[8]=new Objetivo(objetivo.x+10000, objetivo.y-10000);
    }
    private void mover(Figura coordenadas){
        if(coordenadas.x<0){
            coordenadas.x = 10000+coordenadas.x;
        }else{
            if(coordenadas.x>10000){
            coordenadas.x = coordenadas.x-10000;
            }
        }
        if(coordenadas.y<0){
            coordenadas.y = 10000+coordenadas.y;
        }else{
            if(coordenadas.y>10000){
            coordenadas.y = coordenadas.y-10000;
            }
        }
        cazador.x = coordenadas.x;
        cazador.y = coordenadas.y;
    }
}
