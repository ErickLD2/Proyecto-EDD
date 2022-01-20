/*
Modificar la clase para que se adecue a las necesidades del proyecto
Necesitaremos:
    Usuario
        Nombre
        Correo
        Contraseña
        Metodo de pago
        Tiempo suscrito

Debemos de crear una forma de pasar los datos pertinentes
*/
package juegos;

public class ListaDobleJ {
    private Nodo inicio, finnal; // Donde iremos guardando los nodos creados
    private int tamano; // Contador de nodos
    
    public ListaDobleJ() {
        inicio = null; // LISTA VACIA
        finnal = null; // Posicion final de la lista
        tamano = 0; // Tamano comenzara en cero
    }
    
    public void agregar(String tituloDelJuego, String descripcionDelJuego, String especificacionesDelJuego) {
        Nodo nuevo = new Nodo(tituloDelJuego, descripcionDelJuego, especificacionesDelJuego);
        
        if(inicio == null){
            this.inicio = nuevo;
            this.finnal = nuevo;
        }else{
            finnal.setSiguiente(nuevo);
            nuevo.setPrevio(nuevo);
            finnal = nuevo;
        }
        tamano++;
    }
    
    // Imprimir la lista entera
    public void printList(){
        Nodo temp = inicio; // Guardamos la lista en temp
        
        // Pasamos por cada nodo  1 en 1
        while(temp != null){ // Mientras temp no sea nulo
            System.out.println("Datos del Juego:\n- Titulo: \n" + temp.getTitJuego()); // imprimimos
            System.out.println("- Descripcion: \n" + temp.getDescJuego());
            System.out.println("- Especificaciones:\n" + temp.getEspecJuego());
            temp = temp.getSiguiente(); // guardamos los nodos siguientes de temp en temp
        }
        System.out.println(""); // Pa que se vea bomnito
    }
    
    // Limpiamos la lista completa
    public void limpiar(){
        inicio = null; // Igualamos el inicio a nulo, eliminando la lista casi completa
        finnal = null; // Igualamos el ultimo nodo a nulo, terminando de limpiar la lista
        tamano = 0; // Reducimos el contador a 0
    }
    
    // Getter del tamaño de la lista XDXDXD
    public int tamanoLista(){
        return tamano; // Devolvemos el tamaño
    }
    
    // Saber si es una lista vacia
    public boolean isEmpty(){
        return inicio == null; // si esta vacia
        // devolvemos verdadero
        // devolvemos falso si no
    }
    
    public int getPosicion(int iPos) throws Exception{ // Lanzara una excepcion
        if(isEmpty()){ // en caso de ser una lista vacia
            throw new Exception("No hay valores almacenados en la lista!!");
        }
        else{ // Si no
           if( (iPos < 0) || (iPos >= tamanoLista() ) ){ // Revisara si la posicion dada
                                                        // esta dentro de la lista
                throw new Exception("Posicion fuera de rango");
            }
        }
        Nodo temp = inicio; // Guardamos la lista en temp
        
        // Vamos desde 0 hasta la posicion dada
        for (int i = 0; i < (iPos); i++) {
            temp = temp.getSiguiente();  // Vamos pasando cada siguiente de temp en temp
        }
        return temp.getiDato(); // Devolvemos el valor
    }
    
    public String getTitulo(int pos) {
        boolean encontrado = false;
        if (isEmpty()) { // en caso de ser una lista vacia
            // System.out.println("No hay usuarios");
            return "0";
        }
        else { // Si no
            while (true) {                
                if ((pos < 0) || (pos >= tamanoLista())) { // Revisara si la posicion dada
                    // esta dentro de la lista
                    return "1";
                }
                else{
                    encontrado = true;
                    break;
                }
            }
            Nodo temp = inicio;
            
            if (encontrado) {
                for (int i = 0; i < pos; i++) {
                    temp = temp.getSiguiente();
                }
            }
            return temp.getTitJuego();
        }
    }
    
    public String getDesc(int pos){
        boolean encontrado = false;
        if (isEmpty()) { // en caso de ser una lista vacia
            // System.out.println("No hay usuarios");
            return "0";
        }
        else { // Si no
            while (true) {                
                if ((pos < 0) || (pos >= tamanoLista())) { // Revisara si la posicion dada
                    // esta dentro de la lista
                    return "1";
                }
                else{
                    encontrado = true;
                    break;
                }
            }
            Nodo temp = inicio;
            
            if (encontrado) {
                for (int i = 0; i < pos; i++) {
                    temp = temp.getSiguiente();
                }
            }
            return temp.getDescJuego();
        }
    }
    
    public String getEspec(int pos){
        boolean encontrado = false;
        if (isEmpty()) { // en caso de ser una lista vacia
            return "0";
        }else { // Si no
            while (true) {
                if ((pos < 0) || (pos >= tamanoLista())) { // Revisara si la posicion dada
                    // esta dentro de la lista
                    return "1";
                } else {
                    encontrado = true;
                    break;
                }
            }
            Nodo temp = inicio;

            if (encontrado) {
                for (int i = 0; i < pos; i++) {
                    temp = temp.getSiguiente();
                }
            }
            return temp.getEspecJuego();
        }
    }
   
    public int getPosByName(String titulo){
        boolean encontrado = false;
        int cont = 0;
        if (isEmpty()) { // en caso de ser una lista vacia
            // System.out.println("No hay usuarios");
            return 0;
        }
        else {
            while (true) {
                if (getTitulo(cont).equals(titulo)) {
                    return cont;
                }

                cont++;
            }
        }
    }
    
    // Insertar un nodo
    // Esta clase estara sujeta a cambios radicales
    /*
    Que cambiara? Desconocido:
    posiblemente solo la parte de la declaracion del nuevo nodo (1)
    debido a que solo recibe un unico valor, y no el resto de cosas nuevas
    */
    public void insertarEn(int iPos, int valor){
        Nodo nuevo = new Nodo(valor); // (1)
        
        if(iPos == 0){ // Si es en la primera posicion
            nuevo.setSiguiente(inicio); // establecemos inicio como siguiente del nodoNuevo
            inicio.setPrevio(nuevo); // establecemos nuevoNodo como previo de inicio
            inicio = nuevo; // igualamos inicio al nuevo nodo
        }
        else{ // Cualquier otra posicion
            Nodo temp = inicio; // guardamos la lista en temp
            
            // Pasamos por cada nodo hasta llegar al deseado
            for (int i = 0; i < iPos; i++) {
                temp = temp.getSiguiente(); // Lo guardamos en temp 
            }
            nuevo.setSiguiente(temp); // Establecemos temp como siguiente de nuevo
            nuevo.setPrevio(temp.getPrevio()); // establecemos el anterior a temp como el anterior a nuevo
            temp.getPrevio().setSiguiente(nuevo); // establecemos el nuevo como el siguiente del anterior a temp
            temp.setPrevio(nuevo); // establecemos el nuevo como previo de temp
        }
        tamano++; // Incrementamos contador
    }
    
    // Borrar un nodo
    // No parece que necesite ser modificada
    public void borrarEn(int iPos){
        if(tamanoLista() == 1){ // si solo hay un nodo, entonces solo limpiamos
            limpiar();
        }
        else{ // mas de un nodo
           if(iPos == 0){ // Si es el primer nodo
                inicio = inicio.getSiguiente(); // Pasamos el segundo nodo a ser el primero
                inicio.setPrevio(null); // El nodo previo lo mandamos a null
           }
            else{ // Si no es el primer nodo
                Nodo temp = inicio; // Guardamos la lista en temp
                
                // Pasamos por cada nodo hasta llegar a la posicion dada
                for (int i = 0; i < iPos; i++) {
                    temp = temp.getSiguiente();  // Vamos guardando el nodo en temp
                }
                
                temp.getPrevio().setSiguiente(temp.getSiguiente()); // Establecemos el siguiente del
                    // Nodo temp como el siguiente del nodo anterior a temp
                
                // En caso de que sig de temp no sea nullo
                if(temp.getSiguiente() != null){
                    temp.getSiguiente().setPrevio(temp.getPrevio());// igualamos el nodo previo 
                        // del siguiente de temp como el nodo anterior a temp
                }
                
                // Si la posicion era la ultima
                if(iPos == tamanoLista() - 1){ 
                    finnal = temp.getPrevio(); // Indicamos que finnal ahora es el anterior a temp
                }
            }
        }
        // Decrementamos el conteo
        tamano--;
    }
    
    // Imprimir la lista en reversa
    // No se si se vaya a usar, pero tambien hay que modificarla
    // Posiblemente se lleve el mismo cambio que el printList normal
    public void printReversList(){
        Nodo temp = finnal; // Guardamos el nodo final en temp
        
        while(temp != null){ // Mientras temp no sea null
            System.out.println("Datos del Juego:\n\tTitulo: " + temp.getTitJuego()); // imprimimos
            System.out.println("Descripcion: \n" + temp.getDescJuego());
            System.out.println("Especificaciones:\n" + temp.getEspecJuego());
            temp = temp.getPrevio(); // Guardamos en temp cada nodo previo
        }
        System.out.println(""); // Evitar que se vea feo XD
    }
}
