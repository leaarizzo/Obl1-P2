/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediotateti;

/**
 *
 * @author leaco
 */
public class Jugador {
    private String nombre;
    private int edad;
    private int ganadas;
    private boolean invicto;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int Edad) {
        this.edad = Edad;
    }
    public Jugador(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
        this.ganadas=0;
        this.invicto=true;
}   
}
