import java.io.*;
import java.net.*;

public class Server {
    static String menu = "Bienvenido\n"+
            "1. Sumar\n"+
            "2. Restar\n"+
            "3. Multiplicar\n"+
            "4. Dividir\n"+
            "5. Salir\n";
    static String prop = "\nIngrese los dos numeros a operar separados por un espacio\n";
    static public void main(String[] args) {
        System.out.println("Servidor encendido");
        int opcion = 0;
        try {
            ServerSocket servSock = new ServerSocket(8080);
            Socket clientSock = servSock.accept();
            System.out.println("Cliente conectado");
            
            InputStream is = clientSock.getInputStream();
            OutputStream os = clientSock.getOutputStream();
            byte[] buffer = new byte[1024];

            do{
                os.write(menu.getBytes());
                
                int bytesRead = is.read(buffer);
                String respuesta = new String(buffer, 0, bytesRead);
                System.out.println("La opción seleccionada es: "+respuesta);
                
                opcion = Integer.parseInt(respuesta);
                int num1, num2;
                
                switch(opcion){
                    case 1:
                        os.write(("Sumar"+prop).getBytes());
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num1 = Integer.parseInt(respuesta.split(" ")[0]);
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num2 = Integer.parseInt(respuesta.split(" ")[0]);
                        System.out.println("Numeros recibidos:\num1: "+num1+" num2: "+num2);
                        os.write(("El resultado es: "+(num1+num2)).getBytes());
                        break;
                    case 2:
                        os.write(("Restar"+prop).getBytes());
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num1 = Integer.parseInt(respuesta.split(" ")[0]);
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num2 = Integer.parseInt(respuesta.split(" ")[0]);
                        System.out.println("Numeros recibidos:\nnum1: "+num1+" num2: "+num2);
                        os.write(("El resultado es: "+(num1-num2)).getBytes());
                        break;
                    case 3:
                        os.write(("Multiplicar"+prop).getBytes());
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num1 = Integer.parseInt(respuesta.split(" ")[0]);
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num2 = Integer.parseInt(respuesta.split(" ")[0]);
                        System.out.println("Numeros recibidos:\nnum1: "+num1+" num2: "+num2);
                        os.write(("El resultado es: "+(num1*num2)).getBytes());
                        break;
                    case 4:
                        os.write(("Dividir"+prop).getBytes());
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num1 = Integer.parseInt(respuesta.split(" ")[0]);
                        bytesRead = is.read(buffer);
                        respuesta = new String(buffer, 0, bytesRead);
                        num2 = Integer.parseInt(respuesta.split(" ")[0]);
                        

                        System.out.println("Numeros recibidos:\nnum1: "+num1+" num2: "+num2);
                        if (num2 == 0){
                            os.write("No se puede dividir entre 0".getBytes());
                            break;
                        }
                        os.write(("El resultado es: "+((float)num1/(float)num2)).getBytes());
                        break;
                    case 5:
                        os.write(("Saliendo").getBytes());
                        break;
                    default:
                        os.write("Opcion no valida".getBytes());
                        break;
                }
            }while(opcion != 5);
            System.out.println("Cerrando servidor");
            os.close();
            is.close();
            clientSock.close();
            servSock.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}


