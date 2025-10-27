import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class FibonacciServer implements Fibonacci{
    public FibonacciServer(){}
    public int fibonacci(int n){
        if(n==0){
            return 0;
        }   
        if(n==1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);

    }
    public int[] fibonacciSerie(int n){
        int[] serie = new int[n+1];
        int a = 0;
        int b = 1;
        int temp;
        for (int i = 0; i<n+1; i++){
            serie[i] =a ;
            temp = a;
            a = a+b;
            b = temp;;
        }
        return serie;
    }
    public static void main(String []args){
        try{
            FibonacciServer numeroF = new FibonacciServer();
            System.out.println("Se prendio el Server");
            Fibonacci stub = (Fibonacci) UnicastRemoteObject.exportObject(numeroF, 0);
            Registry registro = LocateRegistry.createRegistry(5000);
            registro.rebind("Fibonacci", stub);

        }catch (Exception e){

        }
    }
    
}
