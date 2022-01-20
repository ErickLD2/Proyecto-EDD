
/*
    V4 del proyecto, hora 2:00
    
*/

package edd_pro_final_v1;

import java.util.LinkedList;
import usuarios.ListaDoble;
import juegos.ListaDobleJ;
import java.util.Scanner;

public class EDD_Pro_final_v1 {
    private static ListaDoble listaUsuarios = new ListaDoble();
    private static ListaDobleJ listaJuegos = new ListaDobleJ();
    private static LinkedList <String> linkedListJuegos = new LinkedList();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        llenarCatalogoJuegos();
        llenarListaUsuarios();
        
        while (true) {
            System.out.println("Escriba el numero de la opcion para elegirla\n"
                    + "1) Iniciar Sesion\n"
                    + "2) Registrarse\n"
                    + "3) Salir");
            String ingresar = scanner.next();
            if( (!ingresar.isEmpty()) && (!ingresar.equals("")) && (!ingresar.equals("3")) 
                    && (ingresar.equals("1") || ingresar.equals("2"))){
                seleccionMenu(ingresar);
            }
            else if(ingresar.equals("3")){
                System.out.println("Salido");
                break;
            }
            else{
                System.out.println("Valor no valido, intente de nuevo");
            }
        }
    }
    
    private static void seleccionMenu(String op){
        switch(op){
            case "1":
                System.out.println("Usted eligio: Inicia sesion\n");
                iniciarSesion();
                break;
            case "2":
                System.out.println("Usted eligio: Registrarse\n");
                registrarUsuario();
                break;
            default:
                System.out.println("Opcion no comprendida, intente de nuevon\n");
                break;
        }
    }
    
    private static void registrarUsuario(){
        // Nombre de usuario, correo y contraseña, y metodo de pago
        // nombre de usuario
        String nomUsu = "", corUsu = "";
        while (true) {
            System.out.println("Nombre de usuario:");
            nomUsu = scanner.next();
            if(!(nomUsu.isEmpty()) && !(nomUsu.equals(""))){
                if(listaUsuarios.nombreUsuEncontrado(nomUsu)){
                    System.out.println("Ese usuario ya esta registrado");
                }
                else{
                    System.out.println("Nombre registrado");
                    break;
                }
            }
        }

        // correo
        while(true){
            System.out.println("Correo");
            corUsu = scanner.next();
            
            if (!(corUsu.isEmpty() && !(corUsu.equals("")))) {
                if (listaUsuarios.correoUsuEncontrado(corUsu)) {
                    System.out.println("Ese correo ya esta en uso");
                }
                else{
                    System.out.println("Correo registrado");
                    break;
                }
            }
        }
        
        // Contraseña
        System.out.println("Contraseña:");
        String conUsu = scanner.next();
        
        // Metodo de pago
        System.out.println("Metodo de pago:");
        String metPagoUsu = scanner.next();
        
        listaUsuarios.agregar(corUsu, conUsu, metPagoUsu, nomUsu);
        
        System.out.println("\n");
    }
    
    private static void iniciarSesion(){
        int cont = 0;
        String nomUsu = "";
        
        while (true) {
            System.out.println("Nombre de usuario:");
            nomUsu = scanner.next();
            
            if(nomUsu.equals("admin")){
                break;
            }
            else if (nomUsu.equals("cancelar")){
                break;
            }
            else{
                if(listaUsuarios.nombreUsuEncontrado(nomUsu)){
                    System.out.println("Usuario correcto\n");
                    break;
                }
                else{
                    System.out.println("Usuario no encontrado ");
                }
            }
        }
        
        String conUsu = "";
        
        while (true) {
            if (nomUsu.equals("cancelar")){
                break;
            }
            System.out.println("Contraseña:");
            conUsu = scanner.next();

            if (nomUsu.equals("admin") && conUsu.equals("admin")) {
                System.out.println("Bienvenido, administrador");
                break;
            } 
            else if (conUsu.equals("cancelar")){
                break;
            }
            else if (!listaUsuarios.nombreUsuEncontrado(nomUsu)) {
                System.out.println("No hay usuarios registrados");
                break;
            }
            else {
                if(listaUsuarios.contraUsuEncontrada(nomUsu, conUsu)){
                    System.out.println("Contraseña correcta\nBienvenido " + nomUsu);
                    menuUsuario();
                    break;
                }
            }
        }
        
        if(nomUsu.equals("admin") && conUsu.equals("admin")){
            menuAdmin();
        }
        
        System.out.println("\n");
    }
    
    private static void menuAdmin(){
        String leer = "";
        boolean ruun = true;
        
        while (ruun) {
            System.out.println("Que desea hacer?\n"
                    + "1) Ver lista de usuarios\n"
                    + "2) Ver lista de juegos\n"
                    + "3) Agregar juegos\n"
                    + "4) Salir y cerrar sesion");
            leer = scanner.next();
            switch (leer) {
                case "1":
                    System.out.println("Ver lista de usuarios");
                    listaUsuarios.printList();
                    break;
                case "2":
                    System.out.println("Ver lista de juegos");
                    verListaJ();
                    break;
                case "3":
                    System.out.println("Agregar juegos");
                    agregarJuegos();
                    break;
                case "4":
                    System.out.println("Tenga bonita noche");
                    ruun = false;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }
    
    private static void verListaJ(){
        // listaJuegos.printList();
        ordenarCatalogo();
        // System.out.println(linkedListJuegos);
        System.out.println("\n");
    }
    
    private static void ordenarCatalogo(){
        for (int i = 0; i < linkedListJuegos.size(); i++) {
            int min = i;
            for (int j = i + 1; j < linkedListJuegos.size(); j++) {
                if(linkedListJuegos.get(j).compareTo(linkedListJuegos.get(min)) < 0){
                    min = j;
                }
            }
            String temp = linkedListJuegos.get(i);
            linkedListJuegos.set(i, linkedListJuegos.get(min));
            linkedListJuegos.set(min, temp);
        }
        
        for (int i = 0; i < linkedListJuegos.size(); i++) {
            int pos = listaJuegos.getPosByName(linkedListJuegos.get(i));
            System.out.println("Titulo: " + listaJuegos.getTitulo(pos));
            System.out.println("Descripcion: " + listaJuegos.getDesc(pos));
            System.out.println("Especificaciones: " + listaJuegos.getEspec(pos));
            System.out.println("");
        }
    }
    
    private static void agregarJuegos(){
        // Titulo
        System.out.println("Titulo de juego:");
        String titJue = scanner.next();

        // Descripcion
        System.out.println("Descripcion:");
        String desJue = scanner.next();
        
        // Espcecificaciones
        System.out.println("Especificaciones:");
        String espJue = scanner.next();
        
        listaJuegos.agregar(titJue, desJue, espJue);
        linkedListJuegos.add(titJue);
        
        System.out.println("\n");
    }
    
    private static void menuUsuario(){
        String leer = "";
        boolean ruun = true;

        while (ruun) {
            System.out.println("Escriba el numero de la opcion:\n"
                    + "1) Ver catalogo\n"
                    + "2) Salir");
            leer = scanner.next();
            
            if(leer.equals("1")){
                verListaJ();
                scanner.next();
            }else{
                break;
            }
        }
    }
    
    /*
    Este metodo fue creado con el unico propocito de crear ejemplos de juegos que lleguen a 
    aparecer en el proyecto funcionando
    */
    private static void llenarCatalogoJuegos(){
        String titulo,descri,espec;
        titulo = "DarkMoths";
        descri = "Una fascinante y desafiante historia,"
                + "donde eres una polilla buscando venganza";
        espec = "PC\n"
                + "Intel Pentium\n"
                + "Graficos integrados HD\n"
                + "1GB de RAM\n"
                + "2GB de almacenamiento";
        listaJuegos.agregar(titulo, descri, espec);
        linkedListJuegos.add(titulo);
        
        titulo = "Shengin Impact";
        descri = "Vive aventuras asombrosas en mundo maravilloso lleno de cosas"
                + " sorprendentes, y un pollo";
        espec = "PC\n"
                + "Intel Celeron\n"
                + "Graficos integrados HD\n"
                + "2GB de RAM\n"
                + "4GB de almacenamiento";
        
        listaJuegos.agregar(titulo, descri, espec);
        linkedListJuegos.add(titulo);
        
        titulo = "Mineville";
        descri = "Crees poder sobrevivir? Prueba este desafiante juego de aventura"
                + " donde tienes que aguantar oleada tras oleada de criaturas"
                + " espantosas";
        espec = "PC\n"
                + "Intel CORE i27\n"
                + "RTXPLUS 3000004\n"
                + "128GB de RAM\n"
                + "5TB de almacenamiento";
        
        listaJuegos.agregar(titulo, descri, espec);
        linkedListJuegos.add(titulo);
        
        titulo = "Doom";
        descri = "Las puertas del Infierno quedan abiertas, dejando libres a un "
                + "sinnúmero de demonios, espíritus inmundos, zombis, "
                + "que infestan la base en cuestión de horas. "
                + "Eres el único ser humano superviviente en la estación y "
                + "tu misión es ir logrando pasar con vida de nivel en nivel";
        espec = "PC(Opcional)";
        
        listaJuegos.agregar(titulo, descri, espec);
        linkedListJuegos.add(titulo);
        
        titulo = "Spyrol";
        descri = "Quieres ver cuantas vueltas puede dar? QUieres verlo otra vez?";
        espec = "Pc\n"
                + "Intel Crayola\n"
                + "Graficos patito\n"
                + "3GB de RAM";
        
        listaJuegos.agregar(titulo, descri, espec);
        linkedListJuegos.add(titulo);
        
    }
    
    private static void llenarListaUsuarios(){
        String nomUsu,corUsu, conUsu, pagUsu;
        nomUsu = "Emerald89";
        corUsu = "emerald999@hotmail.com"; 
        conUsu = "maripositas";
        pagUsu = "Banamex";
        
        listaUsuarios.agregar(corUsu, conUsu, pagUsu, nomUsu);
        
        nomUsu = "Pooh32";
        corUsu = "francisco.pm@gmail.com"; 
        conUsu = "gibraltar";
        pagUsu = "Scotia";
        
        listaUsuarios.agregar(corUsu, conUsu, pagUsu, nomUsu);
        
        nomUsu = "IronMan1111";
        corUsu = "xxromeoxx@hotmail.com"; 
        conUsu = "silvestre";
        pagUsu = "Market Pay";
        
        listaUsuarios.agregar(corUsu, conUsu, pagUsu, nomUsu);
        
        nomUsu = "Panditazzz";
        corUsu = "florencia.delatorre@outlook.es"; 
        conUsu = "12345";
        pagUsu = "merenge";
        
        listaUsuarios.agregar(corUsu, conUsu, pagUsu, nomUsu);
        
        nomUsu = "Alfonso";
        corUsu = "htking99@gmail.com"; 
        conUsu = "libertad";
        pagUsu = "bancomer";
        
        listaUsuarios.agregar(corUsu, conUsu, pagUsu, nomUsu);
    }
}
