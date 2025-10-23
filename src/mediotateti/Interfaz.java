package mediotateti;

import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {

    public static void menu(Sistema sistema) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("MEDIO-TATETI MENU PRINCIPAL");
            System.out.println("------------------------\n");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Jugar partida normal");
            System.out.println("3. Continuaicon de partida");
            System.out.println("4. Mostrar ranking e invictos");
            System.out.println("5. Fin");
            opcion = ingresarNum(1, 5);

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese Nombre");
                    String nombre = noVacio();
                    System.out.println("Ingrese Edad");
                    int edad = ingresarNum(0, 120);

                    sistema.registrarJugador(nombre, edad); //cuando se registren ya se debe ordenar alfabeticamente

                    break;
                case 2:
                    mostarLista(sistema);
                    System.out.print("Elija al jugador 1 (Blanco): ");
                    int blanco = ingresarNum(1, sistema.getListaJugadores().size());

                    System.out.print("Elija al jugador 2 (Negro): ");
                    int negro = ingresarNum(1, sistema.getListaJugadores().size());
                    while (negro == blanco) {
                        System.out.println("No puede ser el mismo, prueba de nuevo:");
                        negro = ingresarNum(1, sistema.getListaJugadores().size());
                    }

                    Partida partida = new Partida(
                            sistema.getListaJugadores().get(blanco),
                            sistema.getListaJugadores().get(negro));

                    jugarPartida(partida);

                    break;
                case 3:
                    //hacer
                    break;
                case 4:

                    mostrarRanking(sistema);
                    System.out.println("");
                    mostarInvictos(sistema);

                    break;
                case 5:
                        System.out.println("Fin del programa.");
                    break;
            }

        }
        System.out.println("Hasta luego!");
    }

    public static void mostarLista(Sistema sistema) {
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println((i + 1) + " - " + sistema.getListaJugadores().get(i).getNombre());
        }
    }

    public static void mostarInvictos(Sistema sistema) {
        for (int i = 0; i < sistema.getInvictos().size(); i++) {
            System.out.println((i + 1) + " - " + sistema.getInvictos().get(i).getNombre());
        }
    }

    public static void mostrarRanking(Sistema sistema) {
        for (int i = 0; i < sistema.getRanking().size(); i++) {
            System.out.println((i + 1) + " - " + sistema.getListaJugadores().get(i).getNombre() + " - " + sistema.getRanking().get(i).getGanadas());
        }
    }

    public static int ingresarNum(int min, int max) {
        Scanner in = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("Ingrese un numero entre " + min + " y " + max + ": ");
            try {
                numero = in.nextInt();
                if (numero >= min && numero <= max) {
                    valido = true;
                } else {
                    System.out.println("Numero fuera de rango. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un numero entero.");
                in.nextLine();
            }
        }
        return numero;
    }

    public static String noVacio() {
        Scanner in = new Scanner(System.in);
        String texto = in.nextLine();
        while ("".equals(texto)) {
            System.out.println("Vuelva a ingresarlo, no se permite el espacio vacio");
            texto = in.nextLine();
        }
        return texto;
    }

    private static void jugarPartida(Partida partida) {
        Scanner in = new Scanner(System.in);

        while (!partida.getIsTerminada()) {
            String turno = "";
            if (partida.getTurnoBlanco()) {
                turno = "blanco (" + partida.getBlanco() + " )";
            } else {
                turno = "negro (" + partida.getNegro() + " )";
            }

            System.out.println(partida.getTablero().toString());
            System.out.println("Turno del " + turno);

            System.out.print("Ingrese su jugada (ej...): ");
            String jugada = noVacio().trim();

            String resultado = partida.jugarTurno(jugada);

            switch (resultado) {
                case "INVALIDA":
                    System.out.println("Jugada invalida, intente nuevamente.");
                    break;
                case "GANADOR":
                    System.out.println("Hay un ganador!");
                    break;
                case "EMPATE":
                    System.out.println("Empate!");
                    break;
            }
        }

        System.out.println(partida.getTablero().toString());
        System.out.println("La partida termino!");

    }

}
