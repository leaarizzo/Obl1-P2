package mediotateti;

import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {

    public static void menu(Sistema sistema) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("MEDIO-TATETI MENU PRINCIPAL");
            System.out.println("------------------------");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Jugar partida normal");
            System.out.println("3. Continuaicon de partida");
            System.out.println("4. Mostrar ranking e invictos");
            System.out.println("5. Fin \n");
            opcion = ingresarNum("Ingrese una opcion (1-5): ", 1, 5);

            switch (opcion) {
                case 1:
                    String nombre = noVacio("Ingrese Nombre: ");
                    int edad = ingresarNum("Ingrese Edad: ", 0, 100);

                    sistema.registrarJugador(nombre, edad);

                    break;
                case 2:
                    jugarPartida(sistema);
                    break;
                case 3:
                    //hacer
                    break;
                case 4:

                    mostrarRanking(sistema);
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
        System.out.println("Lista de Jugadores: ");
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println((i + 1) + " - " + sistema.getListaJugadores().get(i).getNombre());
        }
    }

    public static void mostarInvictos(Sistema sistema) {
        System.out.println("Jugadores invictos: ");
        for (int i = 0; i < sistema.getInvictos().size(); i++) {
            System.out.println((i + 1) + " - " + sistema.getInvictos().get(i).getNombre());
        }
    }

    public static void mostrarRanking(Sistema sistema) {
        System.out.println("Ranking: ");
        for (int i = 0; i < sistema.getRanking().size(); i++) {
            System.out.println((i + 1) + " - " + sistema.getListaJugadores().get(i).getNombre() + " - " + sistema.getRanking().get(i).getGanadas());
        }
    }

    public static int ingresarNum(String mensaje, int min, int max) {
        Scanner in = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
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

    public static String noVacio(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje);
        String texto = in.nextLine();
        while ("".equals(texto)) {
            System.out.print(mensaje);
            texto = in.nextLine();
        }
        return texto;
    }

    private static void jugarPartida(Sistema sistema) {
        Scanner in = new Scanner(System.in);
        if (sistema.getListaJugadores().size() > 1) {
            mostarLista(sistema);
            int blanco = ingresarNum("Elija al jugador 1 (blanco, circulos): ", 1, sistema.getListaJugadores().size()) - 1;

            int negro = ingresarNum("Elija al jugador 2 (Negro, cruces): ", 1, sistema.getListaJugadores().size()) - 1;
            while (negro == blanco) {
                negro = ingresarNum("No puede ser el mismo, prueba de nuevo:", 1, sistema.getListaJugadores().size());
            }

            Partida partida = new Partida(
                    sistema.getListaJugadores().get(blanco),
                    sistema.getListaJugadores().get(negro));

            while (!partida.getIsTerminada()) {
                String turno = "";
                if (partida.getTurnoBlanco()) {
                    turno = "blanco (" + partida.getBlanco().getNombre() + ", circulos)";
                } else {
                    turno = "negro (" + partida.getNegro().getNombre() + ", cruces)";
                }

                System.out.println(partida.getTablero().toString());
                System.out.println("Turno del " + turno);

                String jugada = noVacio("Ingrese su jugada (ej...): ").trim();

                String resultado = partida.jugarTurno(jugada);

                switch (resultado) {
                    case "INVALIDA":
                        System.out.println("Jugada invalida, intente nuevamente.");
                        break;
                    case "GANADORB":
                        System.out.println("Hay ganador, felicitaciones jugador blanco!");
                        break;
                    case "GANADORN":
                        System.out.println("Hay ganador, felicitaciones jugador negro!");
                        break;
                    case "EMPATE":
                        System.out.println("Empate!");
                        break;
                }
            }

            System.out.println(partida.getTablero().toString());
            System.out.println("La partida termino!");
        } else {
            System.out.println("Debe crear al menos 2 jugadores.");

        }
    }

}
