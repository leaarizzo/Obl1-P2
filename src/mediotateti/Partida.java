package mediotateti;

public class Partida {

    private Jugador blanco;
    private Jugador negro;
    private Tablero tablero;
    private boolean turnoBlanco;

    public Partida(Jugador blanco, Jugador negro) {
        this.blanco = blanco;
        this.negro = negro;
        this.tablero = new Tablero();
    }

    public Tablero getTablero() {
        return tablero;
    }
            
    public boolean getTurnoBlanco() {
        return turnoBlanco;
    }
    
    public void cambiarTurno() {
        turnoBlanco = !turnoBlanco;
    }
}
