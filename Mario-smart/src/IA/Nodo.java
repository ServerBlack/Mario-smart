package IA;

public class Nodo {
    
    private int x;
    private int y;
    private String camino;
    
    public Nodo(int x, int y, String camino){
        
        this.x = x;
        this.y = y;
        this.camino = camino;
    }
    
    public String getCamino(){
        
        return camino;
    }

    public void setCamino(String camino){
        
        this.camino = camino;
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
}
