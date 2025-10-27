import java.util.Scanner;
public class Pfisica extends Personas {
    public Pfisica(String nom,int edad, double sal) {
        super(nom, sal);
        this.edad=edad;
    }
    
    int op;
    
    @Override
    public void darDeAlta(){
        Scanner Teclado = new Scanner(System.in);
       if (edad<18) {
        System.out.println("No te puedes dar de alta hasta tener 18 años");
       } else {
        System.out.println("Nombre: ");
        nombre=Teclado.nextLine();
        System.out.println("Edad: ");
        edad=Teclado.nextInt();
        System.out.println("Saldo: ");
        saldo=Teclado.nextInt();
        seguro.darDeAlta();
        saldo=saldo-seguro.costo;
       }
    }
    @Override
    public void darDeBaja(){
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
    public void imprimirDatos(){
        if(seguro.activo==true){
            System.out.println("El usuario "+nombre+" de "+edad+" años tiene un saldo de "+saldo);
            seguro.imprimirDatos();
        }else{
            seguro.imprimirDatos();
        }
    }
}