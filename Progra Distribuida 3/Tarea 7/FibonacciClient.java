import java.util.Scanner;

public class FibonacciClient {
    public static void main(String[] args) {
        try {
            // Inicializar el ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Obtener el contexto de naming
            org.omg.CosNaming.NamingContextExt ncRef = org.omg.CosNaming.NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));

            // Resolver el objeto en el servicio de nombres
            
            FibonacciModule.Fibonacci fibonacci = FibonacciModule.FibonacciHelper.narrow(ncRef.resolve_str("Fibonacci"));

            // Llamar a la función de Fibonacci
            int opcion;
            Scanner sc = new Scanner(System.in);
            System.out.println("Deme el numero de Fibonacci que quiere");
            opcion = sc.nextInt();
            System.out.println("El Fibonnacci de "+opcion+" = "+fibonacci.fibonacci(opcion));
            
        
            System.out.println("La sucesion de Fibonacci es ");
            for (int i = 0; i<opcion+1; i++){
                System.out.print(fibonacci.fibonacci(i)+" ");
            }
            System.out.println("\nTODO ACABO CORRECTAMENTE ");
            sc.nextLine();
            sc.nextLine();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}