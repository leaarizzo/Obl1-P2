package mediotateti;

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

                    sistema.registrarJugador(nombre, edad);
                    break;
                case 2:
                    mostarLista(sistema);
                    System.out.print("Elija al jugador 1: ");
                    int blanco = ingresarNum(1, sistema.getListaJugadores().size());

                    int negro = ingresarNum(1, sistema.getListaJugadores().size());
                    while (negro == blanco) {
                        System.out.println("No puede ser el mismo.");
                        negro = ingresarNum(1, sistema.getListaJugadores().size());
                    }

                    Partida partida = new Partida(
                            sistema.getListaJugadores().get(blanco),
                            sistema.getListaJugadores().get(negro));

                    //seguir
                    while (!partida.verificarTerminada()) {
                        partida.getTablero().mostrarTablero(partida.getTablero().getMostrarTitulos(), partida.getTurnoBlanco());
                        String jugada = noVacio();
                        partida.jugarTurno(jugada);
                    }

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }

        }
        System.out.println("Gracias por confiar en nosotros");
    }

    public static void mostarLista(Sistema sistema) {
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            System.out.println((i + 1) + " - " + sistema.getListaJugadores().get(i).getNombre());
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
}
