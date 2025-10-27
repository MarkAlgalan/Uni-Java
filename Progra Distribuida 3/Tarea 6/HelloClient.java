import HelloApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class HelloClient {
    static Hello helloImpl;

    public static void main(String args[]) {
        try {
            // Crear e inicializar el ORB
            ORB orb = ORB.init(args, null);

            // Obtener la referencia al servicio de nombres
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolver la referencia del objeto en el servicio de nombres
            String name = "Hello";
            helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtenida la referencia al objeto del servidor: " + helloImpl);
            System.out.println(helloImpl.sayHello());
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}