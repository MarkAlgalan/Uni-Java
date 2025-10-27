import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class BankClient {
    public static void main(String [] args){
        try {
            //Busca el registro en la dirección local con puerto 5000
            Registry registro = LocateRegistry.getRegistry("localhost",5000);

            // Buscar el objeto Cuenta_Bancaria en el registro
            BankAccount cuenta = (BankAccount) registro.lookup("Cuenta_Bancaria");
            int opcion = 0;
            Scanner sc = new Scanner(System.in);
            do{
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Consultar Saldo");
                System.out.println("4. Salir");
                System.out.println("Seleccione una opción: ");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("Ingrese el monto a depositar: ");
                        double monto = sc.nextDouble();
                        cuenta.deposit(monto);
                        break;
                    case 2:
                        System.out.println("Ingrese el monto a retirar: ");
                        monto = sc.nextDouble();
                        cuenta.withdraw(monto);
                        break;
                    case 3:
                        System.out.println("Saldo: " + cuenta.getBalance());
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }   
                Thread.sleep(2000);
            }while(opcion != 4);
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
