import java.util.InputMismatchException;
import java.util.Scanner;
public class Seguros implements OpBan{
    boolean activo;
    double costo;
    String tipo;
    int monto;
    Propiedades propiedades;
    Seguros (){
    }
    @Override
    public void darDeAlta() throws InputMismatchException{
       Scanner Teclado = new Scanner(System.in); 
            int op;
            do{
                System.out.println("Elije el tipo de seguro:\n1)Propiedades\t2)Vida\t3)Carro");
                op=Teclado.nextInt();
                switch (op) {
                    case 1:
                        tipo="Propiedad";
                        costo=1000;
                        break;
                    case 2:   
                        tipo="Vida";
                        costo=500;
                        break;
                    case 3:
                        tipo="Auto";
                        costo=250;
                        break;
                    default:
                        System.out.println("Intenta con otro numero");
                        break;
                        
                }    
                if(tipo.equals("Propiedad")){
                    int tamaño = 0;
                    System.out.println("Elije el tipo de propiedad que vas a asegurar:\n1)Negocio\t2)Residencial\t3)Terreno");
                    op=Teclado.nextInt();
                    switch (op) {
                        case 1:
                            PropNegocio negocio = new PropNegocio();
                            negocio.darDeAlta();
                            System.out.println("Escriba el monto a pagar por asegurar el terreno: ");
                            int montoNegocio = Teclado.nextInt();
                            negocio.darDeAlta();
                            costo=costo + montoNegocio*0.01;
                            break;

                        case 2:
                            PropResiden residencia = new PropResiden();
                            residencia.darDeAlta();
                            System.out.println("Escriba el monto a pagar por asegurar el terreno: ");
                            int montoResidencia = Teclado.nextInt();
                            residencia.darDeAlta();
                            costo=costo + montoResidencia*0.01;
                            break;

                        case 3:
                            System.out.println("Ingrese el tamaño en metros cuadrados del terreno: ");
                            tamaño = Teclado.nextInt();
                            PropTerrenos terreno = new PropTerrenos(tamaño);
                            terreno.propTerrenos(tamaño);
                            System.out.println("Escriba el monto a pagar por asegurar el terreno: ");
                            int montoTerreno = Teclado.nextInt();
                            terreno.darDeAlta();
                            costo=costo+montoTerreno*0.01;
                            break;
                    
                        default:
                            break;
                    }
                    return;
                }           
                System.out.println("Deme el monto por el que quiere asegurar");
                monto=Teclado.nextInt();
                costo=costo+monto*0.01;
                System.out.println("El seguro ha sido dado de alta");
            }while((op!=1)&&(op!=2)&&(op!=3));
            
        activo=true;
        
    }
    @Override
    public void darDeBaja() {
        activo=false;
        costo=0;
        System.out.println("El seguro se ha dado de baja");
    }
    @Override
    public void imprimirDatos() {
        if(activo==true){
            System.out.println("Cuenta con el seguro de "+tipo+" con costo anual de "+costo+"$");
        }else{
            System.out.println("No cuenta con un seguro activo");
        }
            
    }
}