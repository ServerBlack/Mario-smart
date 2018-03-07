package IA;

public class Nodo {

    private int x;
    private int y;
    private int xP;
    private int yP;
    private String camino;
    private int costo;
    
    public Nodo(int x, int y, int xP, int yP, String camino){
        
        this.x = x;
        this.y = y;
        this.xP = xP;
        this.yP = yP;
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

    String[] split(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
