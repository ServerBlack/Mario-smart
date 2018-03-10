package IA;

import java.util.*;

public class Busqueda {
    
    private int[][] matriz =  new int[10][10];
    private int nodosExpandidos;
    private int profundidadArbol;
    
    public Busqueda(int[][] matriz){
        
        this.matriz = matriz;
        nodosExpandidos = 0;
        profundidadArbol = 0;
    }
   
    public Nodo amplitud(int x, int y){
        
        Queue <Nodo> cola = new LinkedList();
        
        Nodo raiz = new Nodo(x, y, x, y, "");
        raiz.setProfundidad(0);
        cola.add(raiz);
                
        while(!cola.isEmpty()){                      
            
            if(matriz[cola.peek().getX()][cola.peek().getY()] == 5){
                
                nodosExpandidos++;
                return cola.peek();
            }
            
            else {
                
                
                ArrayList <Nodo> hijos = expandirSinDevolverse(cola.peek());
                nodosExpandidos++;
                cola.poll();   
                if(!hijos.isEmpty()){
                if(hijos.get(0).getProfundidad() > profundidadArbol){
                        
                        profundidadArbol = hijos.get(0).getProfundidad();
                }
                
                for(int i = 0; i < hijos.size(); i++){                                        
                    
                    cola.add(hijos.get(i));
                } 
                }
            }            
        }
        
        Nodo hoja = new Nodo(0, 0, 0, 0, "F");
        
        return hoja;
    }
    
    public Nodo costoUniforme(int x, int y){
            
        ArrayList <Nodo> cola = new ArrayList();
        
        Nodo raiz = new Nodo(x, y, x, y, "");
        
        raiz.setProfundidad(0);
        raiz.setCosto(0);
        cola.add(raiz);
                
        while(!cola.isEmpty()){                    
            
            if(matriz[cola.get(0).getX()][cola.get(0).getY()] == 5){
                
                nodosExpandidos++;
                return cola.get(0);
            }
            
            else {
                
                ArrayList <Nodo> hijos = expandirSinDevolverse(cola.get(0));
                nodosExpandidos++;
                cola.remove(0);              
                if(!hijos.isEmpty()){
                if(hijos.get(0).getProfundidad() > profundidadArbol){
                        
                        profundidadArbol = hijos.get(0).getProfundidad();
                }
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    cola.add(hijos.get(i));
                }
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
        raiz.setProfundidad(0);
        pila.push(raiz);
        
        while(!pila.empty()){                      
            
            System.out.println("Nodo pop: (" + pila.peek().getX() + ", " + pila.peek().getY() + ")");
            
            if(matriz[pila.peek().getX()][pila.peek().getY()] == 5){
                nodosExpandidos++;
                return pila.peek();
            }
            
            else {                                
                
                ArrayList <Nodo> hijos = expandirSinCiclos(pila.peek());                                        
                nodosExpandidos++;
                pila.pop();
                
                if(!hijos.isEmpty()){
                    
                    if(hijos.get(0).getProfundidad() > profundidadArbol){
                        
                        profundidadArbol = hijos.get(0).getProfundidad();
                    }
                    for(int i = 0; i < hijos.size(); i++){
                    
                    pila.push(hijos.get(i));
                    } 
                }                
                               
            }       
        }
        
        Nodo hoja = new Nodo(0, 0, 0, 0, "F");
        
        return hoja;
    }
    
    public Nodo avara(int x, int y, int xf, int yf) {
        
        ArrayList <Nodo> cola = new ArrayList();
        
        Nodo raiz = new Nodo(x, y, x, y, "");
        raiz.setProfundidad(0);
        raiz.setHeuristica(manhattan(x, y, xf, yf));
        cola.add(raiz);
                
        while(!cola.isEmpty()){                    
            
            if(matriz[cola.get(0).getX()][cola.get(0).getY()] == 5){
                nodosExpandidos++;
                return cola.get(0);
            }
            
            else {
                
                ArrayList <Nodo> hijos = expandirSinCiclos(cola.get(0));
                nodosExpandidos++;
                cola.remove(0);              
                if(!hijos.isEmpty()){
                if(hijos.get(0).getProfundidad() > profundidadArbol){
                        
                        profundidadArbol = hijos.get(0).getProfundidad();
                }
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    hijos.get(i).setHeuristica(manhattan(hijos.get(i).getX(), hijos.get(i).getY(), xf, yf));
                    cola.add(hijos.get(i));
                }
                }
                
                // Ordenar cola.
                Collections.sort(cola, new Comparator<Nodo>() {
                    @Override
                    public int compare(Nodo z1, Nodo z2) {
                        if (z1.getHeuristica() > z2.getHeuristica()) {
                            return 1;
                        }
                        if (z1.getHeuristica() < z2.getHeuristica()) {
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

    public Nodo aEstrella(int x, int y, int xf, int yf) {
    
        ArrayList <Nodo> cola = new ArrayList();
        
        Nodo raiz = new Nodo(x, y, x, y, "");
        raiz.setHeuristica(manhattan(x, y, xf, yf));
        raiz.setProfundidad(0);
        raiz.setCosto(0);
        cola.add(raiz);
                
        while(!cola.isEmpty()){                    
            
            if(matriz[cola.get(0).getX()][cola.get(0).getY()] == 5){
                nodosExpandidos++;
                return cola.get(0);
            }
            
            else {
                
                ArrayList <Nodo> hijos = expandirSinDevolverse(cola.get(0));
                
                cola.remove(0);              
                if(!hijos.isEmpty()){
                if(hijos.get(0).getProfundidad() > profundidadArbol){
                        
                        profundidadArbol = hijos.get(0).getProfundidad();
                }
                
                for(int i = 0; i < hijos.size(); i++){
                    
                    hijos.get(i).setHeuristica(manhattan(hijos.get(i).getX(), hijos.get(i).getY(), xf, yf));
                    nodosExpandidos++;
                    cola.add(hijos.get(i));
                }
                }
                // Ordenar cola.
                Collections.sort(cola, new Comparator<Nodo>() {
                    @Override
                    public int compare(Nodo z1, Nodo z2) {
                        if (z1.getFn() > z2.getFn()){
                            return 1;
                        }
                        if (z1.getFn() < z2.getFn()){
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
    
    public ArrayList <Nodo> expandirSinDevolverse(Nodo raiz){
        
        ArrayList <Nodo> hijos = new ArrayList();
        int costo;

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
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
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
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
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
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
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
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
                    hijos.add(hijo);
                }
            }
        }
        
        return hijos;
    }
    
    public ArrayList <Nodo> expandirSinCiclos(Nodo raiz){
        
        ArrayList <Nodo> hijos = new ArrayList();

        // Izquierda.
        if(raiz.getY() - 1 >= 0 && raiz.getY() - 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() - 1] != 1){
            
                if(!hayCiclos(raiz.getX(), raiz.getY() - 1, raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX(), raiz.getY() - 1, raiz.getX(), raiz.getY(), raiz.getCamino() + "L,");
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
                    hijos.add(hijo);
                }
            }            
        }
        
        // Subir.
        if(raiz.getX() - 1 >= 0 && raiz.getX() - 1 <= 9){
            
            if(matriz[raiz.getX() - 1][raiz.getY()] != 1){
            
                if(!hayCiclos(raiz.getX() - 1, raiz.getY(), raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX() - 1, raiz.getY(), raiz.getX(), raiz.getY(), raiz.getCamino() + "U,");
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
                    hijos.add(hijo);
                }
            }
        }               
        
        // Derecha.
        if(raiz.getY() + 1 >= 0 && raiz.getY() + 1 <= 9){
            
            if(matriz[raiz.getX()][raiz.getY() + 1] != 1){
            
                if(!hayCiclos(raiz.getX(), raiz.getY() + 1, raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX(), raiz.getY() + 1, raiz.getX(), raiz.getY(), raiz.getCamino() + "R,");
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
                    hijos.add(hijo);
                }
            }            
        }               
        
        // Bajar.
        if(raiz.getX() + 1 >= 0 && raiz.getX() + 1 <= 9){
            
            if(matriz[raiz.getX() + 1][raiz.getY()] != 1){
            
                if(!hayCiclos(raiz.getX() + 1, raiz.getY(), raiz)){
                    
                    Nodo hijo = new Nodo(raiz.getX() + 1, raiz.getY(), raiz.getX(), raiz.getY(), raiz.getCamino() + "D,");                    
                    hijo.setProfundidad(raiz.getProfundidad() + 1);
                    hijos.add(hijo);
                }  
            } 
        }
               
        return hijos;
    }
    
    public boolean hayCiclos(int xH, int yH, Nodo padre) {

        int x = padre.getX(), y = padre.getY();

        if (x == xH && y == yH) {

            return true;
        }

        System.out.println("Hijo: (" + xH + ", " + yH + ")");
        System.out.print("Padres: (" + x + "," + y + ")");
        
        String[] values = padre.getCamino().split(",");

        for (int i = values.length - 1; i >= 0; i--) {

            if (values[i].equals("U")) {
                x++;
                System.out.print(" (" + x + "," + y + ")");
            } else if (values[i].equals("D")) {
                x--;
                System.out.print(" (" + x + "," + y + ")");
            } else if (values[i].equals("R")) {
                y--; 
                System.out.print(" (" + x + "," + y + ")");
            } else if (values[i].equals("L")){
                y++;
                System.out.print(" (" + x + "," + y + ")");
            }                        

            if (x == xH && y == yH){

                return true;
            }    
        }             
        
        System.out.println(" ");
        
        return false;
    }   
    
    public int manhattan(int x, int y, int xf, int yf){
        
        int resultado = x - xf;
        
        if(x - xf < 0){
            
           resultado = ((x - xf)*-1);
        }
        
        if(y - yf < 0){
            
            resultado += ((y - yf)*-1);
        }
        
        resultado += y - yf;
        
        return resultado;
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
}
