package IA;

import java.util.*;

public class BusquedaNoInformada {
    
    private int[][] matriz =  new int[10][10];
    
    public BusquedaNoInformada(int[][] matriz){
        
        this.matriz = matriz;
        System.out.println("");
        //imprimirMatriz();
    }
   
    public String amplitud(){
        
        Queue <Nodo> cola = new LinkedList();
        
        cola.add(new Nodo(0, 5));
        
        int j = 5;
        while(j > 0){                        
            
            if(cola.peek() == new Nodo(4, 9)){
                
                return "La salvaste Scorpion";
            }
            
            else {
                
                ArrayList <Nodo> hijos = expandir(cola.peek());
                cola.remove();
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    cola.add(hijos.get(i));
                }                
            }
            
            j--;
        }
        
        return "Fallo";
    }
    
    private ArrayList <Nodo> expandir(Nodo raiz){
        
        ArrayList <Nodo> hijos = new ArrayList();
        System.out.println("(" + raiz.getX() + ", " + raiz.getY() + ")");
        
        // Baja
        if(raiz.getY() + 1 >= 0 && raiz.getY() + 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() + 1] != 1){
            
                System.out.println("Baja: " + matriz[raiz.getX()][raiz.getY() + 1]);
                hijos.add(new Nodo(raiz.getX(), raiz.getY() + 1));
            }
        }
        // Derecha
        if(raiz.getX() + 1 >= 0 && raiz.getX() + 1 <= 9){
            
            if(matriz[raiz.getX() + 1][raiz.getY()] != 1){
            
                System.out.println("Derecha: " + matriz[raiz.getX() + 1][raiz.getY()]);
                hijos.add(new Nodo(raiz.getX() + 1, raiz.getY()));
            }            
        }
        // Izquierda
        if(raiz.getX() - 1 >= 0 && raiz.getX() - 1 <= 9){
            
            if(matriz[raiz.getX() - 1][raiz.getY()] != 1){
            
                System.out.println("Izquierda: " + matriz[raiz.getX() - 1][raiz.getY()]);
                hijos.add(new Nodo(raiz.getX() - 1, raiz.getY()));
            }            
        }
        // Sube
        if(raiz.getY() - 1 >= 0 && raiz.getY() - 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() - 1] != 1){
            
                System.out.println("Sube: " + matriz[raiz.getX()][raiz.getY() - 1]);
                hijos.add(new Nodo(raiz.getX(), raiz.getY() - 1));
            }
        }
        
        return hijos;
    }
    
    private void imprimirMatriz(){
               
       for(int i = 0; i < 10; i++){
           
           for(int j = 0; j < 10; j++){
               
               System.out.print(matriz[i][j] + " ");
           }
           
           System.out.print("\n");
       }
    }
}
