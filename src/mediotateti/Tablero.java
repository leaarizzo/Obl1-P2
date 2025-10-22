package mediotateti;

public class Tablero {

    private String[][] mat;
    private boolean mostrarTitulos;

    public Tablero() {
        this.mat = new String[3][3];
        this.mostrarTitulos = true;
    }
    
    public boolean ingresarJugada(String jugada){
        return true; //aca vemos si la jugada q nos dieron tiene sentido, si lo tiene la ingresamos y devolvemos true
                        // sino, devolvemos false y no la ingresamos
    }

    public void titulosOnOff() {
        mostrarTitulos = !mostrarTitulos;
    }

    public boolean hayGanador() {
        return true;
    }

    public boolean estaLleno() {
        return true;
    }

    @Override
    public String toString() {
        String texto = ""; //aca vamos a hacer el mostrartablero, se tiene q verificar si hay q mostrar los titulos
                            // tambien verificar si hubo ganador, y resaltar jugada
                                // y capaz las posibles jugadas
        return texto;
    }
}
