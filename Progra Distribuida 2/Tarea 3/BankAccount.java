import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {
    public void deposit(double amount) throws RemoteException;
    public void withdraw(double amount) throws RemoteException, OverdrawnException;
    public double getBalance() throws RemoteException;
    
}
