import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import BancoModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextExtPackage.*;

public class BancoServidor {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            System.out.println("Prendiendo servidor ...");
            BancoImpl bancoImpl = new BancoImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(bancoImpl);
            Banco href = BancoHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("Banco");
            ncRef.rebind(path, href);

            System.out.println("Servidor listo");

            orb.run();
        } catch (Exception e) {
            System.err.println("Error en el servidor: "+e.toString());
            e.printStackTrace();
        }
    }
}