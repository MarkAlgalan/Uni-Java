import PermutationsCombinationsModule.PermutationsCombinations;
import PermutationsCombinationsModule.PermutationsCombinationsHelper;
import java.util.Scanner;
public class PermutationsCombinationsClient {
    public static void main(String[] args) {
        try {
            // Inicializar el ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Obtener el contexto de nombrado
            org.omg.CosNaming.NamingContextExt ncRef = org.omg.CosNaming.NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));

            // Resolver el objeto de referencia en el contexto de nombrado
            String name = "PermutationsCombinations";
            PermutationsCombinations permutationsCombinations = PermutationsCombinationsHelper.narrow(ncRef.resolve_str(name));

            // Invocar métodos en el servidor
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el valor de n: ");
            int n = sc.nextInt();
            System.out.print("Ingrese el valor de k: ");
            int r = sc.nextInt();
            System.out.println("Factorial de " + n + " es: " + permutationsCombinations.factorial(n));
            System.out.println("Permutacion de " + n + " y " + r + " es: " + permutationsCombinations.permutation(n, r));
            System.out.println("Combinacion de " + n + " y " + r + " es: " + permutationsCombinations.combination(n, r));
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}