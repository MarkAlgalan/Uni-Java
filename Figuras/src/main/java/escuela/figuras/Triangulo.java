/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuela.figuras;

/**
 *
 * @author joseA
 */
public class Triangulo extends Figuras{
    protected int base, altura;
    public Triangulo(int ba, int al){base=ba; altura=al;}
    @Override
    public double area(){return base*altura/2;}
    @Override
    public void mostrarNombre(){System.out.println("triangulo");}
}
