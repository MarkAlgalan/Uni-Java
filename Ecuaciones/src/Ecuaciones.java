import java.util.Scanner;
public class Ecuaciones {
    int matriz[][]= new int[3][4];
    double x, y, z;
    public void leer(int y) throws Exception {
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        for(int i=0;i<4;i++){
            switch (i) {
                case 0:System.out.println("Deme el valor de a: ");      
                    break;
                case 1:System.out.println("Deme el valor de b: ");
                    break;
                case 2:System.out.println("Deme el valor de c: ");
                    break;
                case 3:System.out.println("Deme el resultado de la ecuación: "); 
                    break;                    
            }  
            respuesta=teclado.nextLine();
            matriz[y][i]=Integer.parseInt(respuesta);
            if (matriz[y][i]>75000||matriz[y][i]<-75000){
                BigNumerCoefsException eo= new BigNumerCoefsException();
                throw eo;
            }
        }
    }
    public void ver() {
        for (int y = 0; y < 3; y++) {
        System.out.println("("+matriz[y][0]+")x + ("+matriz[y][1]+")y + ("+matriz[y][2]+")z = "+matriz[y][3]);
        }
    }
    public double determinante()throws ArithmeticException{
        double det = 0, a = 0, b = 0, c = 0;
        a = (matriz[0][1] * matriz[2][2]);
        a = a - (matriz[0][2] * matriz[2][1]);
        a = a * (-matriz[1][0]); 

        b = (matriz[0][0] * matriz[2][2]); 
        b = b - (matriz[2][0] * matriz[0][2]);
        b = b * (matriz[1][1]);
        
        c = (matriz[0][0] * matriz[2][1]);
        c = c - (matriz[2][0] * matriz[0][1]);
        c = c * (-matriz[1][2]);

        det = a + b + c;
        if(det==0.0){
            ArithmeticException e = new ArithmeticException();
            throw e;
        }
        return det; 
    }
    public double determinanteX(){
        double det = 0, a = 0, b = 0, c = 0;
        a = (matriz[0][1] * matriz[2][2]);
        a = a - (matriz[2][1] * matriz[0][2]);
        a = a * (-matriz[1][3]);

        b = (matriz[0][3] * matriz[2][2]);
        b = b - (matriz[2][3] * matriz[0][2]);
        b = b * (matriz[1][1]);
        
        c = (matriz[0][3] * matriz[2][1]);
        c = c - (matriz[2][3] * matriz[0][1]);
        c = c * (-matriz[1][2]);

        det = a + b + c;
        
        return det; 
    }
    public double determinanteY(){
        double det = 0, a = 0, b = 0, c = 0;

        a = (matriz[0][3] * matriz[2][2]);
        a = a - (matriz[2][3] * matriz[0][2]);
        a = a * (-matriz[1][0]);

        b = (matriz[0][0] * matriz[2][2]);
        b = b - (matriz[2][0] * matriz[0][2]);
        b = b * (matriz[1][3]);
        
        c = (matriz[0][0] * matriz[2][3]);
        c = c - (matriz[2][0] * matriz[0][3]);
        c = c * (-matriz[1][2]);

        det = a + b + c;
        
        return det; 
    }
    public double determinanteZ(){
        double det = 0, a = 0, b = 0, c = 0;

        a = (matriz[0][1] * matriz[2][3]);
        a = a - (matriz[2][1] * matriz[0][3]);
        a = a * (-matriz[1][0]);

        b = (matriz[0][0] * matriz[2][3]);
        b = b - (matriz[2][0] * matriz[0][3]);
        b = b * (matriz[1][1]);
        
        c = (matriz[0][0] * matriz[2][1]);
        c = c - (matriz[2][0] * matriz[0][1]);
        c = c * (-matriz[1][3]);

        det = a + b + c;
        
        return det; 
    }
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Ecuaciones ecu = new Ecuaciones();
        int o;
        System.out.print("Este programa resuelve ecuaciones de 3 incognitas de la forma\n ax + by + cz = d\nInstrucciones\nEl programa solo acepta valores enteros para a, b, c y d\nAdemás solo se aceptan numeros desde -75,000 a 75,000 ");
        do{
            System.out.println("\n¿Quieres  resolver ecuaciones(1) o salir (2)?");
            o=teclado.nextInt();
           
            switch (o) {
                case 1:
                    try {
                        for(int i=0;i<3;i++){
                            System.out.println("Para la ecuación "+(i+1));
                            ecu.leer(i);
                        }
                        ecu.ver();
                        
                        ecu.x=ecu.determinanteX()/ecu.determinante();
                        ecu.y=ecu.determinanteY()/ecu.determinante();
                        ecu.z=ecu.determinanteZ()/ecu.determinante();
                        System.out.printf("Las soluaciones para las ecuaciones son:\nx = %.3f",ecu.x);
                        System.out.printf("  y = %.3f",ecu.y);
                        System.out.printf("  z = %.3f",ecu.z);
                    } catch (BigNumerCoefsException e){
                        System.out.println("Valores extremales para un coeficiente del Sistema");                       
                    } catch (NumberFormatException e) {
                        System.out.println("El programa no acepta caracteres ni numeros decimales");
                    } catch (ArithmeticException e) {
                        System.out.println("El Determinante del sistema es 0 por lo que las ecuaciones no tienen soluciones\nya que no se puede dividir por 0");
                    } catch (Exception e) {
                        System.out.println("ERROR");
                    }
                    
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Intenta de nuevo");
                    break;
            }
        }while(o!=2);
    }
}
