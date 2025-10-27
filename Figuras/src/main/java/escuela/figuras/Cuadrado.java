/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela.figuras;

/**
 *
 * @author joseA
 */
public class Cuadrado extends Figuras{
    protected int lado;
    public Cuadrado(int lado){this.lado=lado;}
    @Override
    public double area(){
        return lado*lado;
    }
    @Override
    public void mostrarNombre(){
        System.out.println("cuadrado");
    }
}
