
package escuela.figura;

public class Cuadrado extends Figura{
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
