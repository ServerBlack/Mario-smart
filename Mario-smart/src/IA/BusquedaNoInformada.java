package IA;

import java.util.*;

public class BusquedaNoInformada {
    
    private int[][] matriz =  new int[10][10];
    
    public BusquedaNoInformada(int[][] matriz){
        
        this.matriz = matriz;
    }
   
    public String amplitud(){
        
        Queue <Nodo> cola = new LinkedList();
        
        cola.add(new Nodo(0, 5));
        
        while(!cola.isEmpty()){
            
            if(cola.peek() == new Nodo(4, 9)){
                
                return "La salvaste Scorpion";
            }
            
            else {
                
                cola.remove();
                
            }
        }
        
        return "Fallo";
    }
    
    private ArrayList <Nodo>  expandir(Nodo raiz){
        
        ArrayList <Nodo> hijos = new ArrayList();
        // Sube
        if(raiz.getY() - 1 >= 0 && raiz.getY() - 1<= 9){
            
            if(matriz[raiz.getX()][raiz.getY() - 1] != 1){
            
                hijos.add(new Nodo(raiz.getX(), raiz.getY() - 1));
            }
        }
        // Baja
        if(raiz.getY() + 1 >= 0 && raiz.getY() + 1<= 9){
        }
        // Derecha
        if(raiz.getX() + 1 >= 0 && raiz.getX() + 1<= 9){
        }
        // Izquierda
        if(raiz.getX() - 1 >= 0 && raiz.getX() - 1<= 9){
        }
    }
}
