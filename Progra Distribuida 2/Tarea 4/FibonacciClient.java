import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class FibonacciClient {
    public static void main(String [] args){
        try {
            //Busca el registro en la dirección local con puerto 5000
            Registry registro = LocateRegistry.getRegistry("localhost",5000);

            // Buscar el objeto Cuenta_Bancaria en el registro
            Fibonacci fib = (Fibonacci) registro.lookup("Fibonacci");
            int opcion = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Deme el numero de Fibonacci que quiere");
            opcion = sc.nextInt();
            System.out.println("El Fibonnacci de "+opcion+" = "+fib.fibonacci(opcion));
            
            int [] serie = fib.fibonacciSerie(opcion);
            System.out.println("La sucesion de Fibonacci es ");
            for (int i = 0; i<serie.length; i++){
                System.out.print(serie[i]+" ");
            }
            
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
