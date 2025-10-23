package mediotateti;

import java.util.ArrayList;
import java.util.Comparator;

public class Sistema {

    private ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Interfaz.menu(sistema);;
    }

    public void registrarJugador(String nombre, int edad) {
        listaJugadores.add(new Jugador(nombre, edad));
        listaJugadores.sort(Comparator.comparing(Jugador::getNombre));
    }

    public ArrayList<Jugador> getListaJugadores() {
        return this.listaJugadores;
    }

    public ArrayList<Jugador> getInvictos() {
        ArrayList<Jugador> jugadoresInvictos = new ArrayList<>();
        for (Jugador jugador : this.listaJugadores) {
            if (jugador.getInvicto()) {
                jugadoresInvictos.add(jugador);
            }
        }
        return jugadoresInvictos;
    }

    public ArrayList<Jugador> getRanking() {
        ArrayList<Jugador> ranking = new ArrayList<>();
        for (Jugador jugador : this.listaJugadores) {
            ranking.add(jugador);
        }

        ranking.sort(Comparator.comparingInt(Jugador::getGanadas).reversed());  //orden descendente

        return ranking;
    }
}
