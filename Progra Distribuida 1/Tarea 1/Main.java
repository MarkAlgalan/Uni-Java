import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    static public void main(String[] args) {
        System.out.println("Ingrese un texto a enviar!");
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();

        
        try {
            Socket socket = new Socket("localhost", 8080);
            //Socket socket = new Socket("192.168.68.111", 8080);
            OutputStream os = socket.getOutputStream();
            byte [] mensajeBytes = texto.getBytes();
            os.write(mensajeBytes);
            os.flush();
            os.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        scanner.close();
    }
}
