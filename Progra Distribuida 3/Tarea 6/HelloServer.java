import HelloApp.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class HelloImpl extends HelloPOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public String sayHello() {
        return "Hello, world!";
    }
}

public class HelloServer {
    public static void main(String args[]) {
        try {
            // Crear e inicializar el ORB
            ORB orb = ORB.init(args, null);

            // Obtener referencia al POA y activar el POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Crear la implementación del servidor y registrar el ORB
            HelloImpl helloImpl = new HelloImpl();
            helloImpl.setORB(orb);

            // Obtener la referencia del objeto del servidor
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Hello href = HelloHelper.narrow(ref);

            // Obtener la referencia al servicio de nombres
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Vincular la referencia del objeto en el servicio de nombres
            String name = "Hello";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("HelloServer listo y esperando...");

            // Esperar invocaciones desde los clientes
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("HelloServer saliendo...");
    }
}