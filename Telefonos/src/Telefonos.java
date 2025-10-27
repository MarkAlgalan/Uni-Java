import java.util.Scanner;
abstract public class Telefonos {
    final int num = 50;
    //Atributos
    String nombreUsuario;
    int numContactos=0;
    int opcion;
    static Scanner teclado = new Scanner(System.in);
    String telefonoPropio;
    String []telefonosGuardados = new String[num];
    String []nombresGuardados = new String[num];
    //Constructor
    public Telefonos(String nombreUsuario, String telefonoPropio){
        this.nombreUsuario=nombreUsuario;
        this.telefonoPropio=telefonoPropio;
    }
    //Metodos
    public void llamar(String nom){
    }
    public void contestar(){
    }
    public void colgar(){
    }
    public void verDatos(){
    }
    public void verDatosDeContactos(int i){
    }
    public void almacenar(){
        String ans;
        teclado.nextLine();
        System.out.println("\tDeme el nombre del contacto");
        ans= teclado.nextLine();
        nombresGuardados[numContactos]=ans;
        System.out.println("\tDeme su celular");
        ans= teclado.nextLine();
        telefonosGuardados[numContactos]=ans;
        numContactos++;
    }
    //Metodos getter y setter
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getTelefonoPropio() {
        return telefonoPropio;
    }

}
