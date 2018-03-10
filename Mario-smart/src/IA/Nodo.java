package IA;

public class Nodo {

    /**
     * @return the profundidad
     */
    public int getProfundidad() {
        return profundidad;
    }

    /**
     * @param profundidad the profundidad to set
     */
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    private int x;
    private int y;
    private int xP;
    private int yP;
    private String camino;
    private int costo;
    private int heuristica;
    private int profundidad;
    
    public Nodo(int x, int y, int xP, int yP, String camino){
        
        this.x = x;
        this.y = y;
        this.xP = xP;
        this.yP = yP;
        this.camino = camino;
    }    
    
    public int getFn(){
        
        return heuristica + costo;
    }
    
    public int getHeuristica(){
        
        return heuristica;
    }

    public void setHeuristica(int heuristica){
        
        this.heuristica = heuristica;
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
