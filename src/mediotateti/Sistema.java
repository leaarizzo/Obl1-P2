package mediotateti;

import java.util.ArrayList;

public class Sistema {
    public static void main(String[] args) {
        Sistema sistema=new Sistema();
        Interfaz.menu();
    }
    ArrayList<Jugador> listaJugadores=null;
    public static void registrarJugador(String nombre,int edad){
    Jugador nuevo= new Jugador(nombre,edad);
    listaJugadores.add(nuevo);
        System.out.println("Jugador registrado correctamente");
    }
    
}
