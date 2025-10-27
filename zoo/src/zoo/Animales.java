package zoo;
import java.util.Scanner;
public class Animales{
    int hora; 
    String nombre;
    int x;
    boolean sano;
    public Animales(int hora,String nombre,int x){
        this.nombre=nombre;
        this.hora=hora;
        this.x=x;
    }
    
    public void comer() {
        System.out.println("A comer");
    }
    public void desplazarse() {
        System.out.println("Nos trasladamos");
    }
    public void dieta() {
        System.out.println("Tendra una dieta especial, dado por el veterinario");
    }
    public void nombres() {
        System.out.println("Nombre: "+nombre+" ;Jaula numero: "+(x+1)+"\n");
    }
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int res, z, ani, jau;

        Felinos Felinos[]=new Felinos[3];
        Aves Aves[]=new Aves[3];
        Anfibios Anfibios[]=new Anfibios[3];

        Felinos[0]= new Felinos(10,true,"Tigre", 0);
        Felinos[1]= new Felinos(15,true,"Puma", 1);
        Felinos[2]= new Felinos(11,false,"Leon", 2);

        Aves[0]= new Aves(16,true,"Tucan",0);
        Aves[1]= new Aves(10,true,"Loro",1);
        Aves[2]= new Aves(19,false,"Pato",2);

        Anfibios[0]= new Anfibios(8,true,"Rana",0);
        Anfibios[1]= new Anfibios(10,false,"Lagartija",1);
        Anfibios[2]= new Anfibios(11,true,"dragon de comodo",2);
        do{
        System.out.println("¿Quieres llamar a comer(0), desplazar los animales(1) o salir(2)?");
        res=teclado.nextInt();
        }while((res!=0)&&(res!=1)&&(res!=2));
            if (res==0){
                do{
                    System.out.println("1.-A todos\n2.-A un grupo\n3.-A uno\n4.-Salir");
                    z=teclado.nextInt();
                    switch(z){
                        case 1:
                            for(int i=0;i<3;i++){
                                Anfibios[i].comer();                                
                                Felinos[i].comer();                                
                                Aves[i].comer();                                
                            }
                        break;
                        case 2:
                            do{
                                System.out.println("¿Qué grupo de animales quieres llamar?\n1: Felinos\n2: Aves\n3: Anfibios\n4: Ninguno, deseo salir");
                                ani=teclado.nextInt();                            
                                switch (ani) {
                                    case 1:
                                        for (int i = 0; i < 3; i++) {
                                            Felinos[i].comer();
                                        }
                                        break;
                                    case 2:
                                        for (int i = 0; i < 3; i++) {
                                            Aves[i].comer();
                                        }
                                        break;
                                    case 3:
                                        for (int i = 0; i < 3; i++) {
                                            Anfibios[i].comer();
                                        }
                                        break;
                                    case 4:
                                        System.out.println("De acuerdo");
                                        break;
                                    default:
                                        System.out.println("Vuelvelo a intentar");
                                        break;
                                }     
                            }while (ani!=4);
                        break;
                        case 3:
                            do{
                                System.out.println("\nAnimales disponibles");
                                for (int i = 0; i < 3; i++) {
                                    Felinos[i].nombres();
                                    Aves[i].nombres();
                                    Anfibios[i].nombres();
                                }
                                System.out.println("¿De qué area es el animal que buscas?\n1: Felinos\n2: Aves\n3: Anfibios\n4: Ninguno, deseo salir");
                                ani=teclado.nextInt();                            
                                switch (ani) {
                                    case 1:
                                        do{
                                            System.out.println("¿A que jaula pertenece?");
                                            jau=teclado.nextInt();
                                        }while((jau!=1)&&(jau!=2)&&(jau!=3));
                                        Felinos[jau-1].comer();
                                        break;
                                    case 2:
                                        do{
                                            System.out.println("¿A que jaula pertenece?");
                                            jau=teclado.nextInt();                                            
                                        }while((jau!=1)&&(jau!=2)&&(jau!=3));
                                        Aves[jau-1].comer();
                                        break;
                                    case 3:
                                        do{
                                            System.out.println("¿A que jaula pertenece?");
                                            jau=teclado.nextInt();                                            
                                        }while((jau!=1)&&(jau!=2)&&(jau!=3));
                                        Aves[jau-1].comer();
                                        break;
                                    case 4:
                                        System.out.println("De acuerdo");
                                        break;
                                    default:
                                        System.out.println("Vuelvelo a intentar");
                                        break;
                                }   
                                  
                            }while (ani!=4);
                        break;
                        case 4:
                            System.out.println("\nSaliendo...\n");
                        break;
                        default:
                            System.out.println("Vuelvelo a intentar");
                        break;
                    }
                }while((z!=4));
            }else{
                if(res==1){
                    do{
                        System.out.println("1.-A todos\n2.-A un grupo\n3.-A uno\n4.-Salir");
                        z=teclado.nextInt();
                        switch(z){
                            case 1:
                                for(int i=0;i<3;i++){                                    
                                    Anfibios[i].desplazarse();                                    
                                    Felinos[i].desplazarse();                                    
                                    Aves[i].desplazarse();
                                }
                            break;
                            case 2:
                                do{
                                    System.out.println("¿Qué grupo de animales quieres llamar?\n1: Felinos\n2: Aves\n3: Anfibios\n4: Ninguno");
                                    ani=teclado.nextInt();
                                    
                                        switch (ani) {
                                            case 1:
                                                for (int i=0; i<3; i++) {
                                                Felinos[i].desplazarse();
                                                } 
                                                break;
                                            case 2:
                                                for (int i= 0; i < 3; i++) {
                                                    Aves[i].desplazarse();
                                                }
                                                break;
                                            case 3:
                                                for (int i = 0; i < 3; i++) {
                                                    Anfibios[i].desplazarse();
                                                }
                                                break;
                                            case 4:
                                                System.out.println("De acuerdo");
                                                break;
                                            default:
                                                System.out.println("Vuelvelo a intentar");
                                                break;
                                        }           
                                }while (ani!=4);
                            break;
                            case 3:
                                do{
                                    System.out.println("\nAnimales disponibles");
                                    for (int i = 0; i < 3; i++) {
                                        Felinos[i].nombres();
                                        Aves[i].nombres();
                                        Anfibios[i].nombres();
                                    }
                                    System.out.println("¿De qué area es el animal que buscas?\n1: Felinos\n2: Aves\n3: Anfibios\n4: Ninguno, deseo salir");
                                    ani=teclado.nextInt();                            
                                    switch (ani) {
                                        case 1:
                                            do{
                                                System.out.println("¿A que jaula pertenece?");
                                                jau=teclado.nextInt();                                                
                                            }while((jau!=1)&&(jau!=2)&&(jau!=3));
                                            Felinos[jau-1].desplazarse();
                                            break;
                                        case 2:
                                            do{
                                                System.out.println("¿A que jaula pertenece?");
                                                jau=teclado.nextInt();                                                
                                            }while((jau!=1)&&(jau!=2)&&(jau!=3));
                                            Aves[jau-1].desplazarse();
                                            break;
                                        case 3:
                                            do{
                                                System.out.println("¿A que jaula pertenece?");
                                                jau=teclado.nextInt();                                                
                                            }while((jau!=1)&&(jau!=2)&&(jau!=3));
                                            Anfibios[jau-1].desplazarse();
                                            break;
                                        case 4:
                                            System.out.println("De acuerdo");
                                            break;
                                        default:
                                            System.out.println("Vuelvelo a intentar");
                                            break;
                                    }
                                           
                                }while (ani!=4);
                                break;
                            case 4:
                                System.out.println("\nSaliendo...\n");
                            break;
                            default:
                                System.out.println("Vuelvelo a intentar");
                            break;
                        }
                    }while((z!=4));
                }else{
                    System.out.println("¡¡Hasta luego!!");
                }
            }

        
        
    }
}
