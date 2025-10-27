import org.omg.CORBA.*;
import BancoModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import java.util.Scanner;

public class BancoCliente {
    static Banco bancoImpl;

    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String nombreServicio = "Banco";
            bancoImpl = BancoHelper.narrow(ncRef.resolve_str(nombreServicio));

            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            
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
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadDeposito = scanner.nextDouble();
                        bancoImpl.depositar(cantidadDeposito);
                        System.out.println("Cantidad depositada: $" + cantidadDeposito);
                        break;
                    case 2:
                        boolean retiroExitoso = false;
                        while (!retiroExitoso) {
                            System.out.print("Ingrese la cantidad a retirar: ");
                            double cantidadRetiro = scanner.nextDouble();
                            if (cantidadRetiro <= 0) {
                                System.out.println("No se pudo hacer el retiro. Intente de nuevo.");
                            } else {
                                double saldoAntes = bancoImpl.consultarSaldo();
                                bancoImpl.retirar(cantidadRetiro);
                                double saldoDespues = bancoImpl.consultarSaldo();
                                if (saldoAntes != saldoDespues) {
                                    retiroExitoso = true;
                                    System.out.println("Cantidad retirada: $" + cantidadRetiro);
                                } else {
                                    System.out.println("Fondos insuficientes. Intente de nuevo.");
                                }
                            }
                        }
                        break;
                    case 3:
                        double saldo = bancoImpl.consultarSaldo();
                        System.out.println("Saldo actual: $" + saldo);
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