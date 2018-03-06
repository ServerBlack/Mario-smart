package IA;

import java.util.*;

public class Busqueda {
    
    private int[][] matriz =  new int[10][10];
    private int nodosExpandidos;
    private int profundidadArbol;
    private int tiempoComputo;
    
    public Busqueda(int[][] matriz){
        
        this.matriz = matriz;
    }
   
    public Nodo amplitud(int x, int y){
        
        Queue <Nodo> cola = new LinkedList();
        
        Nodo raiz = new Nodo(x, y, x, y, "");
        cola.add(raiz);
                
        while(!cola.isEmpty()){                      
            
            if(matriz[cola.peek().getX()][cola.peek().getY()] == 5){
                
                return cola.peek();
            }
            
            else {
                
                ArrayList <Nodo> hijos = expandirSinDevolverse(cola.peek());
                
                cola.poll();                
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    cola.add(hijos.get(i));
                }                
            }            
        }
        
        Nodo hoja = new Nodo(0, 0, 0, 0, "F");
        
        return hoja;
    }
    
    public Nodo costoUniforme(int x, int y){
    
        
        ArrayList <Nodo> cola = new ArrayList();
        
        Nodo raiz = new Nodo(x, y, x, y, "");
        raiz.setCosto(0);
        cola.add(raiz);
                
        while(!cola.isEmpty()){                    
            
            if(matriz[cola.get(0).getX()][cola.get(0).getY()] == 5){
                
                return cola.get(0);
            }
            
            else {
                
                ArrayList <Nodo> hijos = expandirSinDevolverse(cola.get(0));
                
                cola.remove(0);              
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    cola.add(hijos.get(i));
                }
                
                // Ordenar cola.
                Collections.sort(cola, new Comparator<Nodo>() {
                    @Override
                    public int compare(Nodo z1, Nodo z2) {
                        if (z1.getCosto() > z2.getCosto()) {
                            return 1;
                        }
                        if (z1.getCosto() < z2.getCosto()) {
                            return -1;
                        }
                        return 0;
                    }
                });
            }            
        }
        
        Nodo hoja = new Nodo(0, 0, 0, 0, "F");
        
        return hoja;
    }
    
    public Nodo profundidad(int x, int y){
        
        Stack <Nodo> pila = new Stack();
        
        Nodo raiz = new Nodo(x, y, x, y, "");
        pila.push(raiz);
                
        while(!pila.empty()){                      
            
            if(matriz[pila.peek().getX()][pila.peek().getY()] == 5){
                
                return pila.peek();
            }
            
            else {
                
                ArrayList <Nodo> hijos = expandirSinCiclos(pila.peek());
                
                pila.pop();           
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    pila.push(hijos.get(i));
                }                
            }            
        }
        
        Nodo hoja = new Nodo(0, 0, 0, 0, "F");
        
        return hoja;
    }
    
    public ArrayList <Nodo> expandirSinDevolverse(Nodo raiz){
        
        ArrayList <Nodo> hijos = new ArrayList();
        int costo = 1;

        // Bajar.
        if(raiz.getX() + 1 >= 0 && raiz.getX() + 1 <= 9){
            
            if(matriz[raiz.getX() + 1][raiz.getY()] != 1){
            
                if(raiz.getX() + 1 != raiz.getxP()){
                    
                    Nodo hijo = new Nodo(raiz.getX() + 1, raiz.getY(), raiz.getX(), raiz.getY(), raiz.getCamino() + "D,");                    
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX() + 1][raiz.getY()] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);
                    hijos.add(hijo);
                }  
            }
        }
        
        // Derecha.
        if(raiz.getY() + 1 >= 0 && raiz.getY() + 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() + 1] != 1){
            
                if(raiz.getY() + 1 != raiz.getyP()){
                    
                    Nodo hijo = new Nodo(raiz.getX(), raiz.getY() + 1, raiz.getX(), raiz.getY(), raiz.getCamino() + "R,");
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX()][raiz.getY() + 1] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);                    
                    hijos.add(hijo);
                }
            }            
        }
                
        // Izquierda.
        if(raiz.getY() - 1 >= 0 && raiz.getY() - 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() - 1] != 1){
            
                if(raiz.getY() - 1 != raiz.getyP()){
                    
                    Nodo hijo = new Nodo(raiz.getX(), raiz.getY() - 1, raiz.getX(), raiz.getY(), raiz.getCamino() + "L,");
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX()][raiz.getY() - 1] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);                    
                    hijos.add(hijo);
                }
            }            
        }
        
        // Subir.
        if(raiz.getX() - 1 >= 0 && raiz.getX() - 1 <= 9){
            
            if(matriz[raiz.getX() - 1][raiz.getY()] != 1){
            
                if(raiz.getX() - 1 != raiz.getxP()){
                    
                    Nodo hijo = new Nodo(raiz.getX() - 1, raiz.getY(), raiz.getX(), raiz.getY(), raiz.getCamino() + "U,");
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX() - 1][raiz.getY()] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);                  
                    hijos.add(hijo);
                }
            }
        }
        
        return hijos;
    }
    
    public ArrayList <Nodo> expandirSinCiclos(Nodo raiz){
        
        ArrayList <Nodo> hijos = new ArrayList();
        int costo = 1;

        // Bajar.
        if(raiz.getX() + 1 >= 0 && raiz.getX() + 1 <= 9){
            
            if(matriz[raiz.getX() + 1][raiz.getY()] != 1){
            
                if(!hayCiclos(raiz.getX() + 1, raiz.getY(), raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX() + 1, raiz.getY(), raiz.getX(), raiz.getY(), raiz.getCamino() + "D,");                    
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX() + 1][raiz.getY()] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);
                    hijo.setPadre(raiz);
                    hijos.add(hijo);
                }  
            }
        }
        
        // Derecha.
        if(raiz.getY() + 1 >= 0 && raiz.getY() + 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() + 1] != 1){
            
                if(!hayCiclos(raiz.getX(), raiz.getY() + 1, raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX(), raiz.getY() + 1, raiz.getX(), raiz.getY(), raiz.getCamino() + "R,");
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX()][raiz.getY() + 1] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);
                    hijo.setPadre(raiz);
                    hijos.add(hijo);
                }
            }            
        }
                
        // Izquierda.
        if(raiz.getY() - 1 >= 0 && raiz.getY() - 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() - 1] != 1){
            
                if(!hayCiclos(raiz.getX(), raiz.getY() - 1, raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX(), raiz.getY() - 1, raiz.getX(), raiz.getY(), raiz.getCamino() + "L,");
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX()][raiz.getY() - 1] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);    
                    hijo.setPadre(raiz);
                    hijos.add(hijo);
                }
            }            
        }
        
        // Subir.
        if(raiz.getX() - 1 >= 0 && raiz.getX() - 1 <= 9){
            
            if(matriz[raiz.getX() - 1][raiz.getY()] != 1){
            
                if(!hayCiclos(raiz.getX() - 1, raiz.getY(), raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX() - 1, raiz.getY(), raiz.getX(), raiz.getY(), raiz.getCamino() + "U,");
                    
                    costo = 1;
                    
                    if(matriz[raiz.getX() - 1][raiz.getY()] == 4){
                        
                        costo = 8;
                    }
                    
                    hijo.setCosto(raiz.getCosto() + costo);  
                    hijo.setPadre(raiz);
                    hijos.add(hijo);
                }
            }
        }
        
        return hijos;
    }
    
    public boolean hayCiclos(int xH, int yH, Nodo padre){
                        
        /*ArrayList padres = padre.getPadres();
        
        for(int i = 0; i < padres.size(); i += 2){
            
            if(padres.get(i) == xH && padres.get(i + 1) == yH){
                
                return true;
            }
        }
        */
        return false;
    }
    
    public int getNodosExpandidos(){
        
        return nodosExpandidos;
    }

    public void setNodosExpandidos(int nodosExpandidos){
        
        this.nodosExpandidos = nodosExpandidos;
    }

    public int getProfundidadArbol(){
        
        return profundidadArbol;
    }

    public void setProfundidadArbol(int profundidadArbol){
        
        this.profundidadArbol = profundidadArbol;
    }

    public int getTiempoComputo(){
        
        return tiempoComputo;
    }

    public void setTiempoComputo(int tiempoComputo){
        
        this.tiempoComputo = tiempoComputo;
    }
}
