package mediotateti;

public class Tablero {

    private String[][] mat;
    private boolean mostrarTitulos;

    public Tablero() {
        this.mat = new String[][]{
            {"CB", "CN", "DB", "DN", "GX", "GC"},
            {"CN", "CB", "DN", "DB", "GC", "GX"},
            {"DB", "DN", "CB", "CN", "GX", "GC"}
        };

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
    public boolean hayCirculo(int i,int j){
    return ((mat[i][j]!=null && mat[i][j+1]!=null) && (mat[i][j].charAt(0)=='C' && mat[i][j+1].charAt(0)=='D'));
    }
    public boolean hayEquis(int i,int j){ 
    return ((mat[i][j]!=null && mat[i][j+1]!=null) && (mat[i][j].charAt(0)=='D' && mat[i][j+1].charAt(0)=='C'));
    }

    public boolean hayGanadorHorizontal() {
        boolean hayGanadorHorizontal=false;
        for (int i = 0; i < mat.length; i++) {
            int circulos=0;
            int equis=0;
            for (int j = 0; j <mat[0].length-1; j++) {
                if (hayCirculo(i,j)) {
                    circulos++;
                }
                if (hayEquis(i,j)) {
                    equis++;
                }
                if (circulos==3) {
                    hayGanadorHorizontal=true;
                }
                if (equis==3) {
                    hayGanadorHorizontal=true;
                }
        }
    }
        return hayGanadorHorizontal;
    }
    public boolean hayGanadorVertical(){
        boolean hayGanadorVertical=false;
        for (int j = 0; j <mat[0].length; j++) {
            int circulos=0;
            int equis=0;
            for (int i = 0; i <mat.length-1; i++) {
            if (hayCirculo(i,j)) {
                    circulos++;
            }
                if (hayEquis(i,j)) {
                    equis++;
                } 
             if (circulos==3) {
                    hayGanadorVertical=true;
                }
                if (equis==3) {
                    hayGanadorVertical=true;
                }
            }
        }
        return hayGanadorVertical;
    }
    public boolean hayGanadorDiagonal(){
    boolean hayGanadorDiagonal=false;
                for (int j = 0; j <mat[0].length; j++) {
                if(j<3){
                if (hayCirculo(0,j)) {
                    if (hayCirculo(1,j+1)) {
                       if (hayCirculo(2,j+2)) {
                       hayGanadorDiagonal=true;
                    }   
                    }
                }
                if (hayEquis(0,j)) {
                    if (hayEquis(1,j+1)) {
                       if (hayEquis(2,j+2)) {
                       hayGanadorDiagonal=true;
                    }   
                    }
                }   
            } 
            if(j>2){
            if (mat[0][j].charAt(0)=='D' && mat[0][j-1].charAt(0)=='C') {
                    if (mat[1][j-1].charAt(0)=='D' && mat[1][j-2].charAt(0)=='C') {
                       if (mat[2][j-2].charAt(0)=='D' && mat[2][j-3].charAt(0)=='C') {
                       hayGanadorDiagonal=true;
                    }   
                    }
                }
                if (mat[0][j].charAt(0)=='C' && mat[0][j-1].charAt(0)=='D') {
                    if (mat[1][j-1].charAt(0)=='C' && mat[1][j-2].charAt(0)=='D') {
                       if (mat[2][j-2].charAt(0)=='C' && mat[2][j-3].charAt(0)=='D') {
                       hayGanadorDiagonal=true;
                    }   
                    }
                }
            }
                }
    return hayGanadorDiagonal;
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
