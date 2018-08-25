/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Julian
 */
public class Arbol {
    
    private Nodo raiz;
    
    public void Arbol(){
        raiz = null;
    }
    
    public boolean esVacia(){
        return raiz == null;
    }
    
    public void insertar(int valor){
        Nodo aux = new Nodo();
        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);
        if(esVacia()){
            raiz = nuevo;
        }else if(nuevo.getValor() < raiz.getValor()){
            if(raiz.getIzquierda() == null){
                nuevo.setPadre(raiz);
                raiz.setIzquierda(nuevo);                
            }else{
                aux = raiz.getIzquierda();
                do{
                    if((nuevo.getValor() < aux.getValor()) && aux.getIzquierda() == null){
                        nuevo.setPadre(aux);
                        aux.setIzquierda(nuevo);
                        aux = null;
                    }else if((nuevo.getValor() > aux.getValor()) && aux.getDerecha() == null){
                        nuevo.setPadre(aux);
                        aux.setDerecha(nuevo);
                        aux = null;
                    }else if(nuevo.getValor() < aux.getValor()){
                        aux = aux.getIzquierda();
                    }else if(nuevo.getValor() > aux.getValor()){
                        aux = aux.getDerecha();
                    }
                }while(aux != null);
            }
        }else if(nuevo.getValor() > raiz.getValor()){
            if(raiz.getDerecha() == null){
                nuevo.setPadre(raiz);
                raiz.setDerecha(nuevo);                
            }else{
                aux = raiz.getDerecha();
                do{
                    if((nuevo.getValor() < aux.getValor()) && aux.getIzquierda() == null){
                        nuevo.setPadre(aux);
                        aux.setIzquierda(nuevo);
                        aux = null;
                    }else if((nuevo.getValor() > aux.getValor()) && aux.getDerecha() == null){
                        nuevo.setPadre(aux);
                        aux.setDerecha(nuevo);
                        aux = null;
                    }else if(nuevo.getValor() < aux.getValor()){
                        aux = aux.getIzquierda();
                    }else if(nuevo.getValor() > aux.getValor()){
                        aux = aux.getDerecha();
                    }
                }while(aux != null);
            }
        }
    }
    
    public String inOrden(int tamaño){
        String inOrden = "";
        Nodo aux = new Nodo();
        Nodo aux2 = new Nodo();
        Nodo aux3 = new Nodo();
        aux = raiz;
        while(aux.getIzquierda() != null){
            aux = aux.getIzquierda();
        }
        aux2 = aux;
        for(int i = 0; i < tamaño; i++){
            if(aux.getIzquierda() != null && aux.getIzquierda() != aux2){                
                aux = aux.getIzquierda();
                inOrden = inOrden + " " + Integer.toString(aux.getValor());
                System.out.println(inOrden);
                aux2 = aux;
            }else{
                inOrden = inOrden + " " + Integer.toString(aux.getValor());
                System.out.println(inOrden);
            }
            if(aux.getDerecha() != null){
                aux = aux.getDerecha();
            }else{
                if(aux.getPadre() != null){
                    aux = aux.getPadre();
                    if(aux3 == aux){
                        aux = aux.getPadre();
                        aux2 = aux3;
                    }else{
                        aux2 = aux.getIzquierda();
                    }                      
                    aux3 = aux;
                }else{
                    aux = aux.getDerecha();
                }
            }
        }
        return inOrden;
    }
    
}
