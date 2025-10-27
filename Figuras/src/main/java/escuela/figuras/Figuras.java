/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package escuela.figuras;

/**
 *
 * @author joseA
 */

    abstract class Figuras {
    protected int x, y;
    public void mosstrarOrigen(){
        System.out.println("x= "+x+"y= "+y);
    }
    public abstract double area();
    public abstract void mostrarNombre();
}

    

