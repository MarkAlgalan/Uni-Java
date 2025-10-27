import java.util.InputMismatchException;
import java.util.Scanner;
public class AdministraciónDeSeguros {
    static int numClien = 0;
    static Scanner Teclado = new Scanner(System.in);

    public static void agregarCliente(Personas e[]){
        if(numClien>=100){
            System.out.println("Se alcanzo el maximo del limite");
            return;
        }
        char op;
        do{
            System.out.println("¿Que tipo de persona ser su cliente?\nIngrese M para moral y F para fisica");
             op=Teclado.next().charAt(0);
        }while(op!='M'&&op!='F');
        if(op=='F'){
            e[numClien]=new Pfisica("John", 18, 2000);
            try {
                e[numClien].darDeAlta();
            } catch (InputMismatchException ex) {
                System.out.println("No se pudo dar de alta por que ingreso un dato incorrecto");
                return;
            }catch (Exception ex) {
                System.out.println("No se pudo dar de alta");
                return;
            }   
        }else{
            e[numClien]=new Pmoral("Papa Johns",8000);
            try {
                e[numClien].darDeAlta();
            } catch (InputMismatchException ex) {
                System.out.println("No se pudo dar de alta por que ingreso un dato incorrecto");
                return;
            }catch (Exception ex) {
                System.out.println("No se pudo dar de alta");
                return;
            }
            
        }
        numClien++;

    }
    public static void main(String[] args)  {
        int maso, num;
        Personas usuarios[]= new Personas[100];
        usuarios[0]=new Pfisica("Pedro",45,4000);
        try {
            
        } catch (Exception e) {
           
        }
        do{
            System.out.println("Bienvenido que desea \n(1) Agregar un cliente\n(2) Dar de baja a un cliente\n(3)Imprimir clientes de 40 a 60 años\n(4)Salir");
            try {
                
                maso=Teclado.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR");
                Teclado.nextLine();
                maso=0;
            }
            
            switch (maso) {
                case 1:
                    agregarCliente(usuarios);
                    break;
                case 2:
                
                try {
                    System.out.println("Dame el numero de cliente");
                    num=Teclado.nextInt();
                    usuarios[num].darDeBaja();
                } catch (Exception e) {
                    System.out.println("Eso no es posible"); 
                }
                    break;   
                case 3:
                    for(int i=0;i<numClien;i++){
                        if((usuarios[i].edad>=40)&&(usuarios[i].edad<=60)){
                            usuarios[i].imprimirDatos();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Intenta con otro número");
                    break;
            }   
        }while(maso !=4);
    }
}
