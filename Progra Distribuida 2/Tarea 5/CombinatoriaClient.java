import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CombinatoriaClient {
    public static void main(String [] args){
        try {
            //Busca el registro en la dirección local con puerto 5000
            Registry registro = LocateRegistry.getRegistry("localhost",5000);

            // Buscar el objeto Cuenta_Bancaria en el registro
            Combinatoria fib = (Combinatoria) registro.lookup("Combinatoria");
            int opcion = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione una opcion");
            System.out.println("1. Combinacion");
            System.out.println("2. Permutacion");
            opcion = sc.nextInt();
            if(opcion == 1){
                System.out.println("Deme el valor de n");
                int n = sc.nextInt();
                System.out.println("Deme el valor de k");
                int k = sc.nextInt();
                System.out.println("La combinacion de "+n+" y "+k+" = "+fib.Combinacion(n,k));
            }else if(opcion == 2){
                System.out.println("Deme el valor de n");
                int n = sc.nextInt();
                System.out.println("Deme el valor de k");
                int k = sc.nextInt();
                System.out.println("La permutacion de "+n+" y "+k+" = "+fib.Permutacion(n,k));
            }

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
