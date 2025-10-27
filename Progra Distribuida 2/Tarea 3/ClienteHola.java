import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteHola {
    public static void main(String[] args) {
        try {
            // Buscar el registro RMI en el localhost y puerto 1099
            Registry registry = LocateRegistry.getRegistry("localhost",5000);

            // Buscar el objeto Hola en el registro
            Hola elServidor = (Hola) registry.lookup("Servidor_Hola");

            // Utilizar el objeto Hola
            String mensaje = elServidor.di_hola();
            System.out.println(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}