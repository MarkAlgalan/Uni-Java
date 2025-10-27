abstract class Transporte implements ITransporte{ //clase abstractara que nos permitira 
    //al heredar Itransportes se nos deja implementar el metodo desplazar a esta clase
    public static int contador=0; // creamos la variable que va a servir como contador de objetos
    private String nombre;
    public Transporte(String nombre){ // metodo constructor para transporte
        this.nombre = nombre;
        System.out.println("Constructor Transporte, "+"nombre del Transporte: "+this.nombre);
        contador++;
    }
    public String getNombre() { // metodo getter para el nombre
        return nombre;
    }
    public abstract void tipoTransporte(); // metodo abstracto para el tipo de transporte
}
