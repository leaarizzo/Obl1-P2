package mediotateti;

public class Tablero {

    private String[][] mat;
    private boolean mostrarTitulos;

    public Tablero() {
        this.mat = new String[3][3];
        this.mostrarTitulos = true;
    }

    public boolean ingresarJugada(String jugada) {
        return true; //aca vemos si la jugada q nos dieron tiene sentido, si lo tiene la ingresamos y devolvemos true
        // sino, devolvemos false y no la ingresamos
    }

    public void titulosOnOff() {
        mostrarTitulos = !mostrarTitulos;
    }

    public boolean hayGanador() {
        return false;
    }

    public boolean estaLleno() {
        return false;
    }

    @Override
    public String toString() {
        String texto = "";
        String titulos = "";
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                
            }
        }
        
        String texto2 = texto;
        if (mostrarTitulos) {
            texto2 += titulos;
        }
        
        //aca vamos a hacer el mostrartablero, se tiene q verificar si hay q mostrar los titulos
        // tambien verificar si hubo ganador, y resaltar jugada
        // y capaz las posibles jugadas
        return texto;
    }
}
