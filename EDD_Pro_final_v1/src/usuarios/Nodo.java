/*
Modificar la clase para que se adecue a las necesidades del proyecto
Necesitaremos:
    Usuario
        Nombre
        Correo
        Contraseña
        Metodo de pago
        Tiempo suscrito

*/
package usuarios;

public class Nodo {
    private int iDato; // Aqui guardaremos el dato
    private Nodo siguiente; // Aqui guardaremos los siguientes nodos
    private Nodo previo; // Aqui guardaremos los nodos previos
    
    // Variables correspondientes al USUARIO
    private String nombreUsuario, correoUsuario, contraUsuario, metPagoUsuario;
    
    private String tituloJuego, descriJuego;
    
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

    public Nodo(String correoUsuarioString,
            String contraUsuario,
            String metPagoUsuario, 
            String nombreUsuario) {
        this.correoUsuario = correoUsuarioString;
        this.contraUsuario = contraUsuario;
        this.metPagoUsuario = metPagoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.previo = null;
        this.siguiente = null;
    }

// - - - SETTERS Y GETTERS - - -
    
    // getter de dato
    public int getiDato() {
        return iDato;
    }

    // Getter de nombreUsuario (nombre de usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Getter correoUsuario (Correo de usuario)
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    // Getter de contraUsuario (contraseña de usuario)
    public String getContraUsuario() {
        return contraUsuario;
    }

    // Getter de metPagoUsuario (metodo de pago de usuario)
    public String getMetPagoUsuario() {
        return metPagoUsuario;
    }
    
    // Getter del nodo siguiente
    public Nodo getSiguiente() {
        return siguiente;
    }

    // Getter del nodo previo
    public Nodo getPrevio() {
        return previo;
    }

    
    // Setter del nombreUsuario (nombre de usuario
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Setter correoUsuario (Correo de usuario)
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    // Setter de contraUsuario (contraseña de usuario)
    public void setContraUsuario(String contraUsuario) {
        this.contraUsuario = contraUsuario;
    }

    // Setter de metPagoUsuario (metodo de pago de usuario)
    public void setMetPagoUsuario(String metPagoUsuario) {
        this.metPagoUsuario = metPagoUsuario;
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
