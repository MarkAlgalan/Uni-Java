import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Fibonacci extends Remote{
    public int fibonacci(int n) throws RemoteException;
    public int[] fibonacciSerie(int n) throws RemoteException;
}