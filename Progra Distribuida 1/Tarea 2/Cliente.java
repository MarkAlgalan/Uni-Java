import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        try {
            Socket socket = new Socket("localhost", 8080);

            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            
            do{
                int bytesRead = is.read(buffer);
                System.out.println(new String(buffer, 0, bytesRead));
                String texto = scanner.nextLine();
                
                byte [] mensajeBytes = texto.getBytes();
                os.write(mensajeBytes);
                os.flush();
                opcion = Integer.parseInt(texto);
                bytesRead = is.read(buffer);
                System.out.println(new String(buffer, 0, bytesRead));
                if (0<opcion && opcion<5){
                    texto = scanner.nextLine();
                    mensajeBytes = texto.getBytes();
                    os.write(mensajeBytes);
                    os.flush();

                    texto = scanner.nextLine();
                    mensajeBytes = texto.getBytes();
                    os.write(mensajeBytes);
                    os.flush();

                    bytesRead = is.read(buffer);
                    System.out.println(new String(buffer, 0, bytesRead));

                }
            } while (opcion != 5);
            
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        scanner.close();
    }
}
