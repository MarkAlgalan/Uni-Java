public abstract class Personas implements OpBan { 
    String nombre;
    Seguros seguro= new Seguros();
    Boolean deuda=false; 
    double saldo;
    int edad;
    public Personas (String nombre, double saldo) {
        this.nombre=nombre;
        this.saldo=saldo;
    }
    
}
