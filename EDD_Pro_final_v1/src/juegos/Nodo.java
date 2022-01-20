/*
Necesitaremos:
    Catalogo:
        Titulo
        Descripcion
        Especificaciones // Tambien preguntar por esto
        

*/
package juegos;

public class Nodo {
    private int iDato; // Aqui guardaremos el dato
    private Nodo siguiente; // Aqui guardaremos los siguientes nodos
    private Nodo previo; // Aqui guardaremos los nodos previos
    
    // Variables correspondientes al USUARIO
    private String titJuego, descJuego, especJuego;
    
// - - - CONSTRUCTORES - - - 
    public Nodo(){ // Si no pasamos ningun parametro
        this.siguiente = null;
        this.previo = null;
    }
    
    public Nodo(int dato){ // si pasamos el dato
        this.iDato = dato;
        this.siguiente = null;
        this.previo = null;
    }

    public Nodo(String tituloDelJuego, String descripcionDelJuego, String especificacionesDelJuego) {
        this.titJuego = tituloDelJuego;
        this.descJuego = descripcionDelJuego;
        this.especJuego = especificacionesDelJuego;
        this.previo = null;
        this.siguiente = null;
    }

// - - - SETTERS Y GETTERS - - -
    
    // getter de dato
    public int getiDato() {
        return iDato;
    }

    // Getter del titulo
    public String getTitJuego() {
        return titJuego;
    }

    // Getter de la descripcion
    public String getDescJuego() {
        return descJuego;
    }

    // Getter de las especificaciones
    public String getEspecJuego() {
        return especJuego;
    }
    
    // Getter del nodo siguiente
    public Nodo getSiguiente() {
        return siguiente;
    }

    // Getter del nodo previo
    public Nodo getPrevio() {
        return previo;
    }

    // Setter del titulo
    public void setTitJuego(String titJuego) {
        this.titJuego = titJuego;
    }

    // Setter de la descripcion
    public void setDescJuego(String descJuego) {
        this.descJuego = descJuego;
    }

    // Setter de las especificaciones
    public void setEspecJuego(String especJuego) {
        this.especJuego = especJuego;
    }

    // Setter de dato
    public void setiDato(int iDato) {
        this.iDato = iDato;
    }

    // Setter del nodo siguiente
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // Setter del nodo previo
    public void setPrevio(Nodo previo) {
        this.previo = previo;
    }
    
    
}
