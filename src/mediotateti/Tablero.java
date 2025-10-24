package mediotateti;

public class Tablero {

    private String[][] mat;
    private boolean mostrarTitulos;

    public Tablero() {
        this.mat = new String[3][6];
        this.mostrarTitulos = true;
    }

    public boolean ingresarJugada(String jugada) {
        return false; //aca vemos si la jugada q nos dieron tiene sentido, si lo tiene la ingresamos y devolvemos true
        // sino, devolvemos false y no la ingresamos
    }

    public void titulosOnOff() {
        mostrarTitulos = !mostrarTitulos;
    }

    public boolean hayGanador() {
        return false;
    }

    private String[] celda(String pieza) {
        String[] celda = {"  ", "  ", "  "};
        String p = "";

        if (pieza != null) {
            switch (pieza.charAt(1)) {
                case 'B':
                    p = "○";
                    break;
                case 'N':
                    p = "●";
                    break;
                case 'C': //GC
                    p = "O";
                    break;
                case 'X': //GX
                    p = "X";
                    break;
            }

            switch (pieza.charAt(0)) {
                case 'C':
                    celda[0] = " " + p;
                    celda[1] = p + " ";
                    celda[2] = " " + p;
                    break;
                case 'D':
                    celda[0] = p + " ";
                    celda[1] = " " + p;
                    celda[2] = p + " ";
                    break;
                case 'G': //RESLTAR GANADOR
                    celda[0] = p + p;
                    celda[1] = p + p;
                    celda[2] = p + p;
                    break;
            }
        }

        return celda;
    }

    @Override
    public String toString() {
        String texto = "+--+--+--+--+--+--+\n";
        String[] letras = {"A", "B", "C"};

        if (mostrarTitulos) {
            texto = "   1  2  3  4  5  6\n" + " " + texto;
        }

        for (int i = 0; i < this.mat.length; i++) {
            String linea1 = "";
            String linea2 = "";
            String linea3 = "";
            for (int j = 0; j < this.mat[i].length; j++) {
                String[] c = celda(mat[i][j]);
                linea1 += "|" + c[0];
                linea2 += "|" + c[1];
                linea3 += "|" + c[2];

            }

            if (mostrarTitulos) {
                linea1 = " " + linea1;
                linea2 = letras[i] + linea2;
                linea3 = " " + linea3;
            }

            texto += linea1 + "|\n" + linea2 + "|\n" + linea3 + "|\n";
            texto += "+--+--+--+--+--+--+\n";
        }

        // tambien verificar si hubo ganador, y resaltar jugada
        // y capaz las posibles jugadas
        return texto;
    }
}
