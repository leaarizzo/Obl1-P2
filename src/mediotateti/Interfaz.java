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
            opcion = in.nextInt();
            in.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese Nombre");
                    String nombre = in.nextLine();
                    while ("".equals(nombre)) {
                        System.out.println("Vuelva a ingresar Nombre, no se permite el espacio vacio");
                        nombre = in.nextLine();
                    }
                    System.out.println("Ingrese Edad");
                    int edad = ingresarNum(0, 120);
                    sistema.registrarJugador(nombre, edad);
                    break;
                case 2:
                    mostarLista(sistema);
                    System.out.print("Elija al jugador 1: ");
                    int jugador1 = ingresarNum(1, sistema.getListaJugadores().size());

                    int jugador2 = ingresarNum(1, sistema.getListaJugadores().size());
                    while (jugador2 == jugador1) {
                        System.out.println("No puede ser el mismo.");
                        jugador2 = ingresarNum(1, sistema.getListaJugadores().size());
                    }

                    sistema.getListaJugadores().get(jugador1);
                    sistema.getListaJugadores().get(jugador1);

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("Opcion incorrecta, opciones posibles (1-5)");
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
            System.out.print("Ingrese un número entre " + min + " y " + max + ": ");
            try {
                numero = in.nextInt();
                if (numero >= min && numero <= max) {
                    valido = true;
                } else {
                    System.out.println("Número fuera de rango. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: debe ingresar un número entero.");
                in.nextLine(); 
            }
        }
        return numero;
    }

}
