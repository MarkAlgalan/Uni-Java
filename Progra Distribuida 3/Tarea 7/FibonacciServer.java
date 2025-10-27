import FibonacciModule.FibonacciPOA;

public class FibonacciServer extends FibonacciPOA {
    @Override
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Servidor Fibonacci iniciado...");
        try {
 
            System.out.println("Inicializando el ORB...");
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

    
            System.out.println("Obteniendo referencia al POA...");
            org.omg.PortableServer.POA rootpoa = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();


            System.out.println("Creando la implementación de Fibonacci...");
            FibonacciServer fibonacciImpl = new FibonacciServer();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(fibonacciImpl);
            FibonacciModule.Fibonacci href = FibonacciModule.FibonacciHelper.narrow(ref);


            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            org.omg.CosNaming.NamingContextExt ncRef = org.omg.CosNaming.NamingContextExtHelper.narrow(objRef);
            System.out.println("Vinculando el objeto en el servicio de nombres...");
            org.omg.CosNaming.NameComponent path[] = ncRef.to_name("Fibonacci");
            ncRef.rebind(path, href);

            System.out.println("Servidor Fibonacci listo y esperando...");

            // Esperar invocaciones desde los clientes
            orb.run();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}