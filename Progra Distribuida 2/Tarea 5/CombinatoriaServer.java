import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class CombinatoriaServer implements Combinatoria{
    public CombinatoriaServer(){}
    public int Factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*Factorial(n-1);
    }
    public int Combinacion(int n, int k){
        return Factorial(n)/(Factorial(k)*Factorial(n-k));

    }
    public int Permutacion(int n, int k){
        return Factorial(n)/Factorial(n-k);
    }
    public static void main(String []args){
        try{
            CombinatoriaServer comb = new CombinatoriaServer();
            System.out.println("Se prendio el Server");
            Combinatoria stub = (Combinatoria) UnicastRemoteObject.exportObject(comb, 0);
            Registry registro = LocateRegistry.createRegistry(5000);
            registro.rebind("Combinatoria", stub);
            System.out.println("Server listo");
        }catch (Exception e){

        }
    }
    
}
