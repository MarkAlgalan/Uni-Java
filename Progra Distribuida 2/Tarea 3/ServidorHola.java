import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;



public class ServidorHola  implements Hola {
    
    public ServidorHola()  {
     
    }
    
    @Override
    public String di_hola() {
        return "¡Hola desde el servidor!";
    }
    
    public static void main(String[] args) {
        try {
            ServidorHola servidor = new ServidorHola();
            Hola stub = (Hola) UnicastRemoteObject.exportObject(servidor, 0);
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("Servidor_Hola", stub);
            System.out.println("Servidor RMI listo");
            /*
            ServidorHola servidor = new ServidorHola();
            System.out.println("Servidor RMI listo");
            Hola stub = (Hola) UnicastRemoteObject.exportObject(servidor, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Servidor_Hola", stub);
            System.err.println("Servidor listo");
             */
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            System.out.println("Vuelva a intentar la conexión");
        }
    }
}