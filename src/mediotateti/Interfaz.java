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
                    while (nombre == "") {
                        System.out.println("Vuelva a ingresar Nombre, no se permite el espacio vacio");
                        nombre = in.nextLine();
                    }
                    System.out.println("Ingrese Edad");
                    int edad = in.nextInt();
                    while (edad == 0) {
                        System.out.println("Vuelva a ingresar Edad, no se permite el espacio vacio");
                        edad = in.nextInt();
                    }
                    sistema.registrarJugador(nombre, edad);
                    break;
                case 2:

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
}
