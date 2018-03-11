package IA;

public class Nodo {

    // Coordenadas de Mario o Goku.
    private int x;
    private int y;
    // Coordenadas del nodo padre (Posicion anterior).
    private int xP;
    private int yP; 
    // Datos: costo = g(n) y heuristica = h(n).
    private int costo;
    private int heuristica;
    // Profundidad del nodo en el arbol.
    private int profundidad;
    // Lista de pasos realizados.
    private String camino;
    // Si tiene poder o no.
    boolean estado;
    
    public Nodo(int x, int y){
        
        this.x = x;
        this.y = y;
        camino = "";
        estado = false;
    }    

    public int getX(){ 
        
        return x;
    }
    
    public void setX(int x){ 
        
        this.x = x;
    }

    public int getY(){
        
        return y;
    }

    public void setY(int y){
        
        this.y = y;
    }
    
    public int getxP(){
        
        return xP;
    }

    public void setxP(int xP){
        
        this.xP = xP;
    }

    public int getyP(){
        
        return yP;
    }

    public void setyP(int yP){
        
        this.yP = yP;
    }   
    
    public int getCosto(){
        
        return costo;
    }
    
    public void setCosto(int costo){
        
        this.costo = costo;
    }
    
    public int getHeuristica(){
        
        return heuristica;
    }

    public void setHeuristica(int heuristica){
        
        this.heuristica = heuristica;
    }
    
    public int getProfundidad(){
        
        return profundidad;
    }

    public void setProfundidad(int profundidad){
        
        this.profundidad = profundidad;
    }               
    
    public String getCamino(){
        
        return camino;
    }

    public void setCamino(String camino){
        
        this.camino = camino;
    }
    
    public int getFn(){
        
        return (heuristica + costo);
    }
    
    public boolean getEstado(){ 
        
        return estado;
    }
    
    public void setEstado(boolean estado){ 
        
        this.estado = estado;
    }
}