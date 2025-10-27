package escuela.figura;

abstract class Figura {
    protected int x, y;
    public void mosstrarOrigen(){
        System.out.println("x= "+x+"y= "+y);
    }
    public abstract double area();
    public abstract void mostrarNombre();
}
