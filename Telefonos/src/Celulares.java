import java.util.Calendar;
import java.lang.Math;
import java.util.GregorianCalendar;
public class Celulares extends Telefonos{
    public Celulares(String nombreUsuario, String telefonoPropio, String correo){
        super( nombreUsuario, telefonoPropio);
        this.correo=correo;
    }   
    int inicio;
    Calendar calendario= new GregorianCalendar();
    String correo;
    String []correosGuardados = new String[num];
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCorreo() {
        return correo;
    }
    public void videoLlamada(String nom){
        System.out.println("\n\tIniciando Videollamada a "+nom);
    }
    public void verCorreo(){
        System.out.println("\tCorreo: "+getCorreo());
    }
    @Override
    public void llamar(String nom){
        int opcion;
        System.out.println("\n1.Llamada\n2. Videollamada");
        opcion= teclado.nextInt();
        switch(opcion){
            case 1:
            System.out.println("\n\tIniciando llamada a "+nom);
            break;
            case 2:
            videoLlamada(nom);
            break;
        }
        System.out.println("\n\tLLamada iniciada");
        inicio = calendario.get(Calendar.MINUTE);
        System.out.println(inicio);
        System.out.println("\n\n\tPresione 0 para colgar");
        opcion=Telefonos.teclado.nextInt();
        while(opcion!=0){
            opcion=Telefonos.teclado.nextInt();
        }
        colgar(); 
    }
    @Override
    public void contestar(){
        System.out.println("\n\tLa llamada ha sido contestada");
        System.out.println("\n\n\tPresione 0 para colgar");
        opcion=Telefonos.teclado.nextInt();
        while(opcion!=0){
            opcion=Telefonos.teclado.nextInt();
        }
        colgar();
    }
    @Override
    public void colgar(){
        System.out.println("\tLa llamada a finalizado");
        System.out.println("\tLa llamada duro "+(inicio+(int) (Math.random()*11.99999))+" minutos y costo "+((inicio+(int) (Math.random()*11.99999))*2)+" pesos");
    }
    @Override
    public void almacenar(){
        super.almacenar();
        System.out.println("\nDeme el correo");
        correosGuardados[numContactos-1]=Telefonos.teclado.nextLine();
    }
    @Override
    public void verDatos(){
        System.out.println("\tTelefono Celular");
        System.out.println("\tNombre del propietario: "+getNombreUsuario());
        System.out.println("\tTelefono: "+getTelefonoPropio());
        verCorreo();
    }
    @Override
    public void verDatosDeContactos(int x){
        System.out.println("\tNombre: "+nombresGuardados[x]);
        System.out.println("\tTelefono: "+telefonosGuardados[x]);
        System.out.println("\tCorreo: "+correosGuardados[x]);
    }
}
