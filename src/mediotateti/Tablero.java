package mediotateti;

public class Tablero {

    private String matriz;
    private boolean mostrarTitulos;

    public void mostrarTablero(boolean mostarTitulos, boolean turnoBlanco) {
        System.out.println("aca mostrar el tablero");
    }

    public void cambiarTurno() {
        mostrarTitulos = !mostrarTitulos;
    }

    public boolean getMostrarTitulos() {
        return mostrarTitulos;
    }
}
