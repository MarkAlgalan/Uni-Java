import PermutationsCombinationsModule.PermutationsCombinationsPOA;

public class PermutationsCombinationsServer extends PermutationsCombinationsPOA {
    @Override
    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    @Override
    public int permutation(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    @Override
    public int combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        try {
            // Inicializar el ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Obtener referencia al POA y activar el POAManager
            org.omg.PortableServer.POA rootpoa = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Crear la implementación y registrar con el ORB
            PermutationsCombinationsServer server = new PermutationsCombinationsServer();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(server);
            PermutationsCombinationsModule.PermutationsCombinations href = PermutationsCombinationsModule.PermutationsCombinationsHelper.narrow(ref);

            // Obtener el contexto de nombrado
            org.omg.CosNaming.NamingContextExt ncRef = org.omg.CosNaming.NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));

            // Vincular el objeto en el contexto de nombrado
            org.omg.CosNaming.NameComponent path[] = ncRef.to_name("PermutationsCombinations");
            ncRef.rebind(path, href);

            System.out.println("Servidor listo y esperando...");

            // Esperar invocaciones desde los clientes
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}