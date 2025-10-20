package mediotateti;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Interfaz.menu(sistema);;
    }

    public void registrarJugador(String nombre, int edad) {
        listaJugadores.add(new Jugador(nombre, edad));
        System.out.println("Jugador registrado correctamente");
    }

}
