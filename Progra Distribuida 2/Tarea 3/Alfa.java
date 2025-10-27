import java.rmi.RemoteException;

public interface Alfa {
    public final String okey = "Constante es Okey Tambien";
    public Object foo(Object object) throws RemoteException;
    public void bar() throws RemoteException;
    public int baz() throws RemoteException;
}

