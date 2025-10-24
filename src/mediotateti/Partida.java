package mediotateti;

public class Partida {

    private Jugador blanco;
    private Jugador negro;
    private Tablero tablero;
    private boolean turnoBlanco;
    private boolean isTerminada;

    public Partida(Jugador blanco, Jugador negro) {
        this.blanco = blanco;
        this.negro = negro;
        this.tablero = new Tablero();
        this.turnoBlanco = true;
        this.isTerminada = false;
    }

    public Jugador getBlanco() {
        return this.blanco;
    }

    public Jugador getNegro() {
        return this.negro;
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

    public boolean getIsTerminada() {
        return this.isTerminada;
    }

    public String jugarTurno(String jugada) {
        boolean verificada = procesarJugada(jugada);
        String respuesta = "OK";

        if (verificada) {
            if (tablero.hayGanador()) {
                respuesta = "GANADOR";
                this.isTerminada = true;
            } else if (true) { //poner algo aca en vez de true
                respuesta = "EMPATE";
            } else {
                cambiarTurno();
            }

        } else {
            respuesta = "INVALIDA";
        }

        return respuesta;
    }

    public Boolean procesarJugada(String jugada) {
        boolean jugadaVerificada = true;

        switch (jugada.toUpperCase()) {
            case "X":
                //Termina El Juego, Gana el rival
                break;
            case "T":
                //Solicitacion de Empate
                break;
            case "B":
                //Se colocan titulos de las columnas y filas
                break;
            case "N":
                //Se ocultan los titulos de las columnas y filas
                break;
            case "H":
                //Jugada ganadora
                break;
            default:
                if (this.tablero.ingresarJugada(jugada)) {

                } else {
                    jugadaVerificada = false;
                }

                break;
        }

        return jugadaVerificada;
    }
}
