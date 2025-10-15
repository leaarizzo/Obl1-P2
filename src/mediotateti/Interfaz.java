/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediotateti;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Interfaz {
    public static   void menu(){
        Scanner in = new Scanner(System.in);
        int opcion=0;
        while(opcion!=5){
            System.out.println("MEDIO-TATETI MENU PRINCIPAL");
            System.out.println("------------------------\n");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Jugar partida normal");
            System.out.println("3. Continuaicon de partida");
            System.out.println("4. Mostrar ranking e invictos");
            System.out.println("5. Fin");
            opcion= in.nextInt();
        }
        System.out.println("Gracias por confiar en nosotros");
     }
}
