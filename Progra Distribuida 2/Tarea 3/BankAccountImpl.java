import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class BankAccountImpl implements BankAccount {
    private double balance = 0.0;
    public BankAccountImpl(double initialBalance)  {   
        balance = initialBalance;
    }
    
    public void deposit(double amount)  {
        balance += amount;
        System.out.println("Monto Depositado: " + amount);
    }
    
    public void withdraw(double amount) throws RemoteException, OverdrawnException {
        if (amount > balance){
            System.out.println("Intendo fallido de retirar: " + amount);
            throw new OverdrawnException("Fondos insuficientes");
        }
        balance -= amount;
        System.out.println("Monto Retirado: " + amount);
    }
    
    public double getBalance() throws RemoteException {
        return balance;
    }
    public static void main(String[] args) {
        try {
            BankAccountImpl cuenta = new BankAccountImpl(1000);
            System.out.println("Prendiendo servidor ...");
            BankAccount stub = (BankAccount) UnicastRemoteObject.exportObject(cuenta,1);
            System.out.println("Cuenta creada");
            Registry registro = LocateRegistry.createRegistry(5000);
            registro.rebind("Cuenta_Bancaria", stub);

        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }

    }
    
}
