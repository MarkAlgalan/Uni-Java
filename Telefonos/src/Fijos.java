public class Fijos extends Telefonos {
    public Fijos(String nombreUsuario, String telefonoPropio){
        super( nombreUsuario, telefonoPropio);
    }    
    @Override
    public void llamar(String nom){
        System.out.println("\n\tLlamando a "+nom);
        System.out.println("\n\tLlamada iniciada");
        System.out.println("\n\n\tPresione 0 para colgar");
  
        opcion=teclado.nextInt();
        while(opcion!=0){
            opcion=Telefonos.teclado.nextInt();
        }
        colgar();
    }
    @Override
    public void contestar(){
        System.out.println("\tLa llamada ha sido contestada");
        System.out.println("\n\n\tPresione 0 para colgar");
        opcion=Telefonos.teclado.nextInt();
        while(opcion!=0){
            opcion=Telefonos.teclado.nextInt();
        }
        colgar();
    }
    @Override
    public void colgar(){
        System.out.println("\tLlamada finalizada");
    }
    @Override
    public void verDatos(){
        System.out.println("\tTelefono Fijo");
        System.out.println("\tNombre del propietario: "+getNombreUsuario());
        System.out.println("\tTelefono: "+getTelefonoPropio());
    }
    @Override
    public void verDatosDeContactos(int x){
        System.out.println("\tNombre: "+nombresGuardados[x]);
        System.out.println("\tTelefono: "+telefonosGuardados[x]);
    }
}