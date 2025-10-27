import java.util.Scanner;
public class Pmoral extends Personas {
	int op;
	public Pmoral(String nom, double sal) {
        super(nom,sal);
        edad=0;
    }

    @Override
	public void darDeAlta() {
		Scanner Teclado = new Scanner(System.in);
		System.out.println("Nombre: ");
        nombre=Teclado.nextLine();
        System.out.println("Saldo: ");
        saldo=Teclado.nextInt();
		do{
        System.out.println("Seguro:\n1)propiedades\t2)carro");
        op=Teclado.nextInt();
        switch (op) {
            case 1:
                seguro.tipo="Propiedad";
                seguro.costo=1000;
                break;
            case 2:
                seguro.tipo="Auto";
                seguro.costo=250;
                break;
            default:
                System.out.println("Intenta con otro numero");
                break;
        }
        }while((op!=1)&&(op!=2));
        if(seguro.tipo.equals("Propiedad")){
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
                    seguro.costo=seguro.costo + montoNegocio*0.01;
                    break;

                case 2:
                    PropResiden residencia = new PropResiden();
                    residencia.darDeAlta();
                    System.out.println("Escriba el monto a pagar por asegurar el terreno: ");
                    int montoResidencia = Teclado.nextInt();
                    residencia.darDeAlta();
                    seguro.costo=seguro.costo + montoResidencia*0.01;
                    break;

                case 3:
                    System.out.println("Ingrese el tamaño en metros cuadrados del terreno: ");
                    tamaño = Teclado.nextInt();
                    PropTerrenos terreno = new PropTerrenos(tamaño);
                    terreno.propTerrenos(tamaño);
                    System.out.println("Escriba el monto a pagar por asegurar el terreno: ");
                    int montoTerreno = Teclado.nextInt();
                    terreno.darDeAlta();
                    seguro.costo=seguro.costo+montoTerreno*0.01;
                    break;
            
                default:
                    break;
            }
        }
		saldo=saldo-seguro.costo;
	}

	@Override
	public void darDeBaja() {
		if (saldo<0) {
            deuda=true;
        }
		if (deuda==true){
            System.out.println("No puedes dar de baja hasta pagar tu deuda");
        }else{
            seguro.darDeBaja();
			System.out.println("Ya nos diste de baja");
        }
	}

	@Override
	public void imprimirDatos() {
		if(seguro.activo==true){
			System.out.println("El usuario "+nombre+" tiene un saldo de "+saldo);
			seguro.imprimirDatos();
		}else{
            seguro.imprimirDatos();
        }
		
	}  
}