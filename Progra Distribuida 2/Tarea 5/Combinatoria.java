import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Combinatoria extends Remote{
    public int Combinacion(int n, int k) throws RemoteException;
    public int Permutacion(int n, int k) throws RemoteException;
    public int Factorial(int n) throws RemoteException;
}