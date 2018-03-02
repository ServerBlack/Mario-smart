package IA;

import java.util.*;

public class BusquedaNoInformada {
    
    private int[][] matriz =  new int[10][10];
    private int[][] matrizExploracion = new int[10][10];
    
    public BusquedaNoInformada(int[][] matriz){
        
        this.matriz = matriz;
        iniciarMatrizExploracion();
    }
   
    public String amplitud(int x, int y){
        
        Queue <Nodo> cola = new LinkedList();
        
        // Nodo raiz, posicion inicial del italiano.
        cola.add(new Nodo(x, y, ""));
        matrizExploracion[x][y] = 1;
                
        while(!cola.isEmpty()){                        
            
            if(matriz[cola.peek().getX()][cola.peek().getY()] == 5){
                
                return cola.peek().getCamino();
            }
            
            else {
                
                matrizExploracion[cola.peek().getX()][cola.peek().getY()] = 1;
                ArrayList <Nodo> hijos = expandir(cola.peek());
                cola.poll();                
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    cola.add(hijos.get(i));
                }                
            }            
        }
        
        return "Fallo";
    }
    
    private ArrayList <Nodo> expandir(Nodo raiz){
        
        ArrayList <Nodo> hijos = new ArrayList();
        // System.out.println("Nodo: (" + raiz.getX() + ", " + raiz.getY() + ")");
        
        // Baja
        if(raiz.getX() + 1 >= 0 && raiz.getX() + 1 <= 9){
            
            if(matriz[raiz.getX() + 1][raiz.getY()] != 1 && matrizExploracion[raiz.getX() + 1][raiz.getY()] != 1){
            
                //System.out.println("- Baja: (" + (raiz.getX() + 1) + ", " + raiz.getY() + ")");
                hijos.add(new Nodo(raiz.getX() + 1, raiz.getY(), raiz.getCamino() + "D,"));
            }
        }
        // Derecha
        if(raiz.getY() + 1 >= 0 && raiz.getY() + 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() + 1] != 1 && matrizExploracion[raiz.getX()][raiz.getY() + 1] != 1){
            
                //System.out.println("- Derecha: (" + raiz.getX() + ", " + (raiz.getY() + 1) + ")");
                hijos.add(new Nodo(raiz.getX(), raiz.getY() + 1, raiz.getCamino() + "R,"));
            }            
        }
        // Izquierda
        if(raiz.getY() - 1 >= 0 && raiz.getY() - 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() - 1] != 1 && matrizExploracion[raiz.getX()][raiz.getY() - 1] != 1){
            
                //System.out.println("- Izquierda: (" + raiz.getX() + ", " + (raiz.getY() - 1) + ")");
                hijos.add(new Nodo(raiz.getX(), raiz.getY() - 1, raiz.getCamino() + "L,"));
            }            
        }
        // Sube
        if(raiz.getX() - 1 >= 0 && raiz.getX() - 1 <= 9){
            
            if(matriz[raiz.getX() - 1][raiz.getY()] != 1 && matrizExploracion[raiz.getX() - 1][raiz.getY()] != 1){
            
                //System.out.println("- Sube: (" + (raiz.getX() - 1) + ", " + raiz.getY() + ")");
                hijos.add(new Nodo(raiz.getX() - 1, raiz.getY(), raiz.getCamino() + "U,"));
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

    private void iniciarMatrizExploracion(){
        
        for(int i = 0; i < 10; i++){
           
           for(int j = 0; j < 10; j++){
               
               matrizExploracion[i][j] = 0;
           }
       }
    }
    
    private void imprimirMatrizExplorada(){
               
       for(int i = 0; i < 10; i++){
           
           for(int j = 0; j < 10; j++){
               
               System.out.print(matrizExploracion[i][j] + " ");
           }
           
           System.out.print("\n");
       }
    }
}
