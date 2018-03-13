package IA;

import java.util.*;

public class Busqueda {

    // Matriz de numeros que representa el ambiente.
    private int[][] matriz = new int[10][10];
    // Datos del reporte.
    private int nodosExpandidos;
    private int profundidadArbol;

    public Busqueda(int[][] matriz){

        this.matriz = matriz;
        nodosExpandidos = 0;
        profundidadArbol = 0;
    }

    // Busquedas no informadas.
    public Nodo amplitud(int xi, int yi){

        Queue<Nodo> cola = new LinkedList();

        Nodo raiz = new Nodo(xi, yi);
        raiz.setxP(xi);
        raiz.setyP(yi);
        raiz.setProfundidad(0);

        cola.add(raiz);

        while(!cola.isEmpty()){            

            if(matriz[cola.peek().getX()][cola.peek().getY()] == 5){              

                nodosExpandidos++;
                return cola.peek();
            } 
            else {

                ArrayList<Nodo> hijos = expandirSinCiclos(cola.peek());
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

        // Fallo.
        Nodo hoja = new Nodo(0, 0);
        hoja.setCamino("F");

        return hoja;
    }

    public Nodo costoUniforme(int xi, int yi){

        ArrayList<Nodo> cola = new ArrayList();

        Nodo raiz = new Nodo(xi, yi);
        raiz.setxP(xi);
        raiz.setyP(yi);       
        raiz.setCosto(0);
        raiz.setProfundidad(0);
        
        cola.add(raiz);

        while(!cola.isEmpty()){

            if(matriz[cola.get(0).getX()][cola.get(0).getY()] == 5){               

                nodosExpandidos++;
                return cola.get(0);                
            } 
            else {

                ArrayList<Nodo> hijos = expandirSinCiclos(cola.get(0));
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

                Collections.sort(cola, (Nodo z1, Nodo z2) -> {
                    
                    if(z1.getCosto() > z2.getCosto()){
                        
                        return 1;
                    }
                    if(z1.getCosto() < z2.getCosto()){
                        
                        return -1;
                    }  
                    
                    return 0;
                });
            }
        }

        // Fallo.
        Nodo hoja = new Nodo(0, 0);
        hoja.setCamino("F");

        return hoja;
    }

    public Nodo profundidad(int xi, int yi){

        Stack<Nodo> pila = new Stack();

        Nodo raiz = new Nodo(xi, yi);
        raiz.setxP(xi);
        raiz.setyP(yi);
        raiz.setProfundidad(0);
        
        pila.push(raiz);

        while(!pila.empty()){

            if(matriz[pila.peek().getX()][pila.peek().getY()] == 5){
                
                nodosExpandidos++;
                return pila.peek();
            } 
            else {

                ArrayList<Nodo> hijos = expandirSinCiclos(pila.peek());
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

        // Fallo.
        Nodo hoja = new Nodo(0, 0);
        hoja.setCamino("F");

        return hoja;
    }

    // Busquedas informadas.
    public Nodo avara(int xi, int yi, int xf, int yf){

        ArrayList<Nodo> cola = new ArrayList();

        Nodo raiz = new Nodo(xi, yi);
        raiz.setxP(xi);
        raiz.setyP(yi);
        raiz.setHeuristica(manhattan(xi, yi, xf, yf));
        raiz.setProfundidad(0);        
        
        cola.add(raiz);

        while(!cola.isEmpty()){

            if(matriz[cola.get(0).getX()][cola.get(0).getY()] == 5){
                
                nodosExpandidos++;
                return cola.get(0);
            }
            else {

                ArrayList<Nodo> hijos = expandirSinCiclos(cola.get(0));
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
                
                Collections.sort(cola, (Nodo z1, Nodo z2) -> {
                    
                    if(z1.getHeuristica() > z2.getHeuristica()){
                        
                        return 1;
                    }
                    if(z1.getHeuristica() < z2.getHeuristica()){
                        
                        return -1;
                    }
                    
                    return 0;
                });
            }
        }

        // Fallo.
        Nodo hoja = new Nodo(0, 0);
        hoja.setCamino("F");

        return hoja;
    }

    public Nodo aEstrella(int xi, int yi, int xf, int yf){

        ArrayList<Nodo> cola = new ArrayList();

        Nodo raiz = new Nodo(xi, yi);
        raiz.setxP(xi);
        raiz.setyP(yi);
        raiz.setCosto(0);
        raiz.setHeuristica(manhattan(xi, yi, xf, yf));
        raiz.setProfundidad(0);
        
        cola.add(raiz);

        while(!cola.isEmpty()){

            if(matriz[cola.get(0).getX()][cola.get(0).getY()] == 5){
                
                nodosExpandidos++;
                return cola.get(0);
            } 
            else {

                ArrayList<Nodo> hijos = expandirSinCiclos(cola.get(0));
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
                
                Collections.sort(cola, (Nodo z1, Nodo z2) -> {
                    
                    if(z1.getFn() > z2.getFn()){
                        
                        return 1;
                    }
                    if(z1.getFn() < z2.getFn()){
                        
                        return -1;
                    }
                    
                    return 0;
                });
            }
        }

        // Fallo.
        Nodo hoja = new Nodo(0, 0);
        hoja.setCamino("F");        

        return hoja;
    }

    // Metodo para expandir nodos.   
    public ArrayList<Nodo> expandirSinCiclos(Nodo padre){

        ArrayList<Nodo> hijos = new ArrayList();

        int costo;
        boolean estado = false, devolver = false;
        
        // Si el estado cambia, es permintido devolverse.
        if(matriz[padre.getX()][padre.getY()] == 3 || padre.getEstado()){
            
            if(!padre.getEstado()){
                
                devolver = true;
            }
            
            padre.setEstado(true);
            estado = true;                        
        }
        
        // Izquierda.
        if(padre.getY() - 1 >= 0 && padre.getY() - 1 <= 9 && matriz[padre.getX()][padre.getY() - 1] != 1 && (!hayCiclos(padre.getX(), padre.getY() - 1, padre) || devolver)){

            Nodo hijo = new Nodo(padre.getX(), padre.getY() - 1); 
            hijo.setxP(padre.getX());
            hijo.setyP(padre.getY());
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijo.setCamino(padre.getCamino() + "L,");                      
            hijo.setEstado(estado);
            
            costo = 1;

            if(matriz[padre.getX()][padre.getY() - 1] == 4 && !padre.getEstado()){

                costo = 8;
            }

            hijo.setCosto(padre.getCosto() + costo);
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijos.add(hijo);
        }

        // Subir.
        if(padre.getX() - 1 >= 0 && padre.getX() - 1 <= 9 && matriz[padre.getX() - 1][padre.getY()] != 1 && (!hayCiclos(padre.getX() - 1, padre.getY(), padre) || devolver)){

            Nodo hijo = new Nodo(padre.getX() - 1, padre.getY());
            hijo.setxP(padre.getX());
            hijo.setyP(padre.getY());
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijo.setCamino(padre.getCamino() + "U,");
            hijo.setEstado(estado);
            
            costo = 1;

            if(matriz[padre.getX() - 1][padre.getY()] == 4 && !padre.getEstado()){

                costo = 8;
            }

            hijo.setCosto(padre.getCosto() + costo);
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijos.add(hijo);
        }

        // Derecha.
        if (padre.getY() + 1 >= 0 && padre.getY() + 1 <= 9 && matriz[padre.getX()][padre.getY() + 1] != 1 && (!hayCiclos(padre.getX(), padre.getY() + 1, padre) || devolver)) {

            Nodo hijo = new Nodo(padre.getX(), padre.getY() + 1); 
            hijo.setxP(padre.getX());
            hijo.setyP(padre.getY());
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijo.setCamino(padre.getCamino() + "R,");
            hijo.setEstado(estado);
            
            costo = 1;

            if(matriz[padre.getX()][padre.getY() + 1] == 4 && !padre.getEstado()){

                costo = 8;
            }

            hijo.setCosto(padre.getCosto() + costo);
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijos.add(hijo);
        }

        // Bajar.
        if(padre.getX() + 1 >= 0 && padre.getX() + 1 <= 9 && matriz[padre.getX() + 1][padre.getY()] != 1 && (!hayCiclos(padre.getX() + 1, padre.getY(), padre) || devolver)){

            Nodo hijo = new Nodo(padre.getX() + 1, padre.getY());
            hijo.setxP(padre.getX());
            hijo.setyP(padre.getY());
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijo.setCamino(padre.getCamino() + "D,");
            hijo.setEstado(estado);

            costo = 1;

            // Por si es una tortuga o un Toppo.
            if(matriz[padre.getX() + 1][padre.getY()] == 4 && !padre.getEstado()){

                costo = 8;
            }

            hijo.setCosto(padre.getCosto() + costo);
            hijo.setProfundidad(padre.getProfundidad() + 1);
            hijos.add(hijo);
        }

        return hijos;
    }

    // Metodos auxiliares.
    public boolean hayCiclos(int xH, int yH, Nodo padre){

        int x = padre.getX();
        int y = padre.getY();

        if(x == xH && y == yH){

            return true;
        }

        String[] values = padre.getCamino().split(",");

        for(int i = (values.length - 1); i >= 0; i--){

            if(values[i].equals("U")){
                
                x++;
            } 
            else if(values[i].equals("D")){
                
                x--;
            } 
            else if(values[i].equals("R")){
                
                y--;
            } 
            else if(values[i].equals("L")){
                
                y++;
            }

            if(x == xH && y == yH){

                return true;
            }
        }

        return false;
    }

    public int manhattan(int xi, int yi, int xf, int yf){

        int resultado = (xi - xf);

        if((xi - xf) < 0){

            resultado = ((xi - xf) * -1);
        }
        if(yi - yf < 0){

            resultado += ((yi - yf) * -1);
        }

        resultado += (yi - yf);

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