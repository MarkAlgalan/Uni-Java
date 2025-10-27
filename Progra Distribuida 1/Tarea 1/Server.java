import java.io.*;
import java.net.*;

public class Server {
    static public void main(String[] args) {
        System.out.println("Hola soy un servidor");
        try {
            ServerSocket servSock = new ServerSocket(8080);
            Socket clientSock = servSock.accept();
            InputStream is = clientSock.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = is.read(buffer);
            System.out.println("Caracteres : "+bytesRead);
            System.out.println("Recivido " + new String(buffer, 0, bytesRead));
            clientSock.close();
            servSock.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
