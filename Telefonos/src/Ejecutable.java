import java.lang.Math;
public class Ejecutable {
    static void ejecutarAlm(Telefonos x){
        x.almacenar();
    }
    static void ejecutarLista(Telefonos x){
        for(int i=0;i<x.numContactos;i++){         
           x.verDatosDeContactos(i);
        }
    }
    static void ejecutarLlamada(Telefonos x){
        if(x.numContactos==0){
            System.out.println("Aun no tiene contactos");
            return;
        }
        int a;
        for(int i=0;i<x.numContactos;i++){         
           System.out.println((i+1)+" "+x.nombresGuardados[i]);
        }
        
        System.out.println("Seleccione el numero del contacto que quiere llamar");
        a=Telefonos.teclado.nextInt();
        if(((a-1)>=0)&&(a<=x.numContactos)){
            x.llamar(x.nombresGuardados[a-1]);
        }else{
            System.out.println("Ese contacto no existe");
        }
    }
    public static void main(String[] args) throws Exception {
        int numTel=0;
        int res, opc;
        int r=(int) (Math.random()*4.99999);
        int numeroExtraño=(int) ((Math.random()*2229999999.999)+1000000000);
        Telefonos[] telefonos=new Telefonos[10];
        telefonos[0]= new Fijos("Juan Martinez Pedrosa","2093481931");
        telefonos[1]=new Celulares("Yael Lopez Hernandez","5783453222","yaellopezz@yahoo.com.mx");
        telefonos[2]=new Celulares("Marco Antonio Algalan Martinez","2721543670","marco.algalan@correo.buap.mx");
        telefonos[3]=new Celulares("Angel Samuel Olivares Sanchez","2837104812","olivares69angel@hotmail.com");
        telefonos[4]=new Fijos("Alejandro Rodriguez Fernandez","1428192384");
        telefonos[5]=new Fijos("Juan Manuel Alvarado","9928123045");
        telefonos[6]=new Celulares("Dylan Madrid Mendoza","7523001234","dymamen38@gmail.com");
        telefonos[7]=new Celulares("Damian Juarez Perez","3838192941","damm_3070@outlook.com");
        telefonos[8]=new Fijos("Fernando Domingo Hernandez","8097591293");
        telefonos[9]=new Celulares("Pedro Herrera Amador","2903918921","herrera_amape@gmail.com");
        
        do{
            System.out.println("\n1. Elegir telefono\n2. Usar aplicacion de llamadas\n3. Finalizar Simulación");
            res=Telefonos.teclado.nextInt();
            switch(res){
                case 1:
                    for(int b=0;b<10;b++){
                        System.out.println("\n("+(b+1)+")");
                        telefonos[b].verDatos();
                    }
                    System.out.println("\nSeleccione el numero () del telefono que quiere usar");
                    numTel=Telefonos.teclado.nextInt();
                    if((numTel-1)>=0&&(numTel-1)<10){
                        System.out.println("\nTelefono "+numTel+" seleccionado");
                        numTel=numTel-1;
                    }else{
                        System.out.println("\nNo existe ese telefono");
                        numTel=0;
                    }
                break;
                case 2:
                    System.out.println("\nInicia con el telefono numero "+(numTel+1));
                    do{
                        r=(int) (Math.random()*4.99999);
                        if(r==0){
                            System.out.println("\n"+numeroExtraño+" te esta llamando\nPresione 1 para contestar o cualquier otra tecla para rechazar");
                            opc=Telefonos.teclado.nextInt();
                            if(opc==1){
                                telefonos[numTel].contestar();
                                
                            }else{
                                System.out.println("\nLlamada rechazada");
                            }
                        }
                        System.out.println("\n\t1. Llamar\n\t2. Contactos\n\t3. Ver Información Propia\n\t4. Regresar");
                        res=Telefonos.teclado.nextInt();
                        switch(res){
                            case 1:
                            do{
                                System.out.println("\n\t\t1. Digitar un numero\n\t\t2. Llamar contactos\n\t\t3. Regresar");
                                opc=Telefonos.teclado.nextInt();
                                switch(opc){
                                    case 1:
                                        Telefonos.teclado.nextLine();
                                        System.out.print("Digite el numero a marcar: ");;
                
                                        telefonos[numTel].llamar(Telefonos.teclado.nextLine());
                                    break;
                                    case 2:
                                        ejecutarLlamada(telefonos[numTel]);
                                    break;
                                    case 3:
                                    break;
                                }
            
                            }while(opc!=3);       
                            break;
                            case 2:
                                do{
                                    System.out.println("\n\t\t1. Agregar contactos\n\t\t2. Ver contactos\n\t\t3. Regresar");
                                    opc=Telefonos.teclado.nextInt();
                                    switch(opc){
                                        case 1:
                                            ejecutarAlm(telefonos[numTel]);
                                        break;
                                        case 2:
                                            ejecutarLista(telefonos[numTel]);
                                        break;
                                        case 3:
                                        break;
                                    }
            
                                }while(opc!=3);
                            break;
                            case 3:
                                telefonos[numTel].verDatos();
                            break;
                            case 4:
                            break;
                        }
                    }while(res!=4); 
                break;
                case 3:

                break;
            }
        }while(res!=3);
        
    } 
}
