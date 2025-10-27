import java.util.InputMismatchException;

public class Juego {
    final static int cantidadObjetos =100;
    public static void main(String[] args) throws Exception {
        //Variables para switches
        char lectura;
        int respuesta, eleccion, opción;
        //Declaración de arreglos
        Estrellas estrellas[]=new Estrellas[cantidadObjetos];
        Planetas planetas[]=new Planetas[cantidadObjetos];
        Nebulosa nebulosas[]=new Nebulosa[cantidadObjetos];
        //instanciaciones
        //Declaración de estrellas
        estrellas[0] = new Estrellas("Arcturo","K", 36, "Bootes", 215);
        estrellas[1] = new Estrellas("Alpha Caeli","F", 66, "Caelum", 5);
        estrellas[2] = new Estrellas("Beta Camepardalis","G", 1000, "Camelopardalis", 1592);
        estrellas[3] = new Estrellas("Muhlifain","A", 4, "Centaurus", 95);
        estrellas[4] = new Estrellas("Cor Caroli","B", 110, "Canes Venatici", 83);
        estrellas[5] = new Estrellas("Omicron Ceti","M", 96, "Cetus", 8400);
        estrellas[6] = new Estrellas("Deneb Algiedi","A", 39, "Capricornius", 8);
        estrellas[7] = new Estrellas("Rigel Kentaurus","B", 4, "Centaurus", 85000);
        estrellas[8] = new Estrellas("Diphda","K", 96, "Cetus", 145);
        estrellas[9] = new Estrellas("Alpha Circini","A", 53, "Circinus", 11);
        //Declaración de planetas
        planetas[0] = new Planetas("Júpiter","gaseoso" ,588000000, 930, 10, "11 años y 314 dias");
        planetas[1] = new Planetas("Saturno","gaseoso" ,1300000000, -176, 11,"29 años y 167 dias");
        planetas[2] = new Planetas("Urano","gaseoso" ,2721, -218, 17, "84 años");
        planetas[3] = new Planetas("Venus","rocoso" ,40000000, 453, 5832, "225 dias");
        planetas[4] = new Planetas("Marte","rocoso" ,102000000, -129, 25, "2 años y 687 dias");
        //arreglar los int y long
        planetas[5] = new Planetas("Neptuno","gaseoso" ,450000000, -220, 16,"164 años");
        planetas[6] = new Planetas("Plutón","rocoso" ,600000000, -240, 153288, "247 años");
        //aqui para
        //Declaración de las nebulosas
        nebulosas[0] = new Nebulosa("Del Anillo", "Nebulosa de emision", "Lyra", 930,1779);
        nebulosas[1] = new Nebulosa("De la hormiga", "Nebulosa de emision", "Norma", -176,1922);
        nebulosas[2] = new Nebulosa("Esquimal", "Nebulosa de emision", "Geminis", -218,1787);
        nebulosas[3] = new Nebulosa("Del insecto", "Nebulosa de emision", "Scorpius", 453,1888);
        nebulosas[4] = new Nebulosa("Ojo de gato", "Nebulosa de emision", "Draco", -129,1786);
        nebulosas[5] = new Nebulosa("Reloj de arena", "Nebulosa de emision", "Musca", -220,1996);
        nebulosas[6] = new Nebulosa("Saturno", "Nebulosa de emision", "Acuario", -240,1782);
        //Mensaje de Bienvenida
        System.out.println("Bienvenido a Conozca el Universo");
        //ciclo para iniciar el juego o salir, y tal vez 
        do{
            //Menu del juego
            System.out.println("\nMenu\nOpciones:\n1. Iniciar Partida\n2. Ver la información y/o agregar\n3. Salir del juego");
            try {
                
                respuesta=CuerposCelestes.lector.nextInt();
                switch(respuesta){
                    case 1:
                    //metodos para resetear las variables que llevan el conteo del avance del juego
                        for(int i=0;i<3;i++){
                            CuerposCelestes.cont[i]=0;
                        }
                        CuerposCelestes.puntuacion[0]=0;
                        CuerposCelestes.puntuacion[1]=0;
                        for(int i=0;i<CuerposCelestes.tam[0];i++){
                            estrellas[i].reseteo();
                        }
                        for(int i=0;i<CuerposCelestes.tam[1];i++){
                            planetas[i].reseteo();
                        }
                        for(int i=0;i<CuerposCelestes.tam[2];i++){
                            nebulosas[i].reseteo();
                        }
                        //Sitema para recibir el nombre de los jugadores
                        CuerposCelestes.lector.nextLine();
                        System.out.println("Deme el nombre del primer jugador");
                        CuerposCelestes.nombreU[0]=CuerposCelestes.lector.nextLine();
                        System.out.println("Deme el nombre del segundo jugador");
                        CuerposCelestes.nombreU[1]=CuerposCelestes.lector.nextLine();
                      //for de la cantidad de rondas que pasan   
                      for(int r=0;(r<(CuerposCelestes.tam[0]*4+CuerposCelestes.tam[1]*4+CuerposCelestes.tam[2]*2)/2)&&(CuerposCelestes.puntuacion[0]<220)&&(CuerposCelestes.puntuacion[1]<220);r++ ){
                            if(CuerposCelestes.puntuacion[0]>CuerposCelestes.puntuacion[1]){
                                CuerposCelestes.x=0;
                            }else if(CuerposCelestes.puntuacion[1]>CuerposCelestes.puntuacion[0]){
                                CuerposCelestes.x=1;
                            }else{
                                if(Math.random()>0.5){
                                    CuerposCelestes.x=1;
                                }else{
                                    CuerposCelestes.x=0;
                                }
                            }
                            //Ciclo de rondas, cada rondas son dos turnos
                            System.out.println("\t\t\t\t\tRonda "+(r+1));
                            for(int i=0;i<2&&(r<(CuerposCelestes.tam[0]*4+CuerposCelestes.tam[1]*4+CuerposCelestes.tam[2]*2)/2);i++){
                                System.out.println("\nTurno de "+CuerposCelestes.nombreU[CuerposCelestes.x]);
                                //ciclo para comprobar que se selecciono la opcion correcta
                                do{
                                    //Opciones de temas a preguntar
                                    System.out.println("\n¿Que tema quieres escoger?\n\n1.Estrellas\n2.Planetas\n3.Nebulosas\n4.Rendirse");
                                    try {
                                        eleccion=CuerposCelestes.lector.nextInt();
                                        switch(eleccion){
                                            //Preguntas de estrellas
                                            case 1:
                                            //Comprobación de que haya preguntas exitentes
                                                if(CuerposCelestes.cont[0]<(CuerposCelestes.tam[0]*4)){
                                                    //seleccion de una estrella que todavia tenga preguntas
                                                    CuerposCelestes.ronda(estrellas,0,CuerposCelestes.tam[0]);
                                                } else {
                                                //En caso de acabarse las preguntas no se te descontara el turno    
                                                    System.out.println("Ya no hay más preguntas de estrellas");
                                                    eleccion=0;
                                                }                                     
                                            break;
                                            //Preguntas de planetas
                                            case 2:
                                                if(CuerposCelestes.cont[1]<(CuerposCelestes.tam[1]*4)){
                                                    CuerposCelestes.ronda(planetas,1,CuerposCelestes.tam[1]);
                                                } else {
                                                    System.out.println("Ya no hay más preguntas de planetas");
                                                    eleccion=0;
                                                }                
                                            break;
                                            //Preguntas de nebulosas
                                            case 3:
                                                if(CuerposCelestes.cont[2]<(CuerposCelestes.tam[2]*2)){
                                                    CuerposCelestes.ronda(nebulosas, 2, CuerposCelestes.tam[2]);
                                                } else {
                                                    System.out.println("Ya no hay más preguntas de nebulosas");
                                                    eleccion=0;
                                                }               
                                            break;
                                            //rendirse
                                            case 4: //terminamos el for y con eso la corrida del juego antes de tiempo
                                            r=(CuerposCelestes.tam[0]*4+CuerposCelestes.tam[1]*4+CuerposCelestes.tam[2]*2)/2;
                                            CuerposCelestes.puntuacion[CuerposCelestes.x]=-100000;
                                            break;
                                            // opcion por defecto
                                            default:
                                                System.out.println("Esa opción no es valida");
                                            break;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("\nSolo se pueden ingresar numeros enteros como opción");
                                        eleccion=0;
                                        CuerposCelestes.lector.nextLine();
                                    }
                                    
                                    
                                }while(eleccion!=1&&eleccion!=2&&eleccion!=3&&eleccion!=4); // repetir hasta que se escriba una opcion invalida
                            }
                        }
                        if(CuerposCelestes.puntuacion[0]<0&&CuerposCelestes.puntuacion[1]<0){ // en el caso de que nadie consiguiera puntos positivos
                            System.out.println("\nLASTIMA LA IGNORANCIA HA GANADO\nNINGÚN JUGADOR OBTUVO PUNTOS POSITIVOS");
                            System.out.println("\nPuntuación\n"+CuerposCelestes.nombreU[0]+" "+CuerposCelestes.puntuacion[0]+"\n"+CuerposCelestes.nombreU[1]+" "+CuerposCelestes.puntuacion[1]);//Puntuación de los jugadores
                        }else if(CuerposCelestes.puntuacion[0]>CuerposCelestes.puntuacion[1]){ // en el caso en el que el jugador 1 tenga mas puntos
                            System.out.println("\n"+CuerposCelestes.nombreU[0]+" HA GANADO");
                            System.out.println("\nPuntuación\n"+CuerposCelestes.nombreU[0]+" "+CuerposCelestes.puntuacion[0]+"\n"+CuerposCelestes.nombreU[1]+" "+CuerposCelestes.puntuacion[1]);
                        }else if(CuerposCelestes.puntuacion[1]>CuerposCelestes.puntuacion[0]){ // en el caso de que el jugador 2 tenga mas puntos
                            System.out.println("\n"+CuerposCelestes.nombreU[1]+" HA GANADO");
                            System.out.println("\nPuntuación\n"+CuerposCelestes.nombreU[1]+" "+CuerposCelestes.puntuacion[1]+"\n"+CuerposCelestes.nombreU[0]+" "+CuerposCelestes.puntuacion[0]);
                        }else{
                            System.out.println("\nEMPATE\nPuntuación\n"+CuerposCelestes.nombreU[0]+" "+CuerposCelestes.puntuacion[0]+"\n"+CuerposCelestes.nombreU[1]+" "+CuerposCelestes.puntuacion[1]);
                        }                    
                    break;
                    case 2:
                        System.out.println("\nEstrellas: ");
                        CuerposCelestes.mostrar(estrellas, 0);
                        System.out.println("\nPlanetas: ");
                        CuerposCelestes.mostrar(planetas, 1);
                        System.out.println("\nNebulosas: ");
                        CuerposCelestes.mostrar(nebulosas, 2);   
                        do{
                            System.out.println("¿Quieres agregar información? (S/N)"); 
                            lectura = CuerposCelestes.lector.next().charAt(0);
                        }while((lectura != 'S' )&&(lectura !='N'));
                        if (lectura=='S') {
                            do{
                                System.out.println("¿Que nuevo objeto quieres agregar?");
                                System.out.println("1. Estrellas\n2. Planetas\n3. Nebulosas\n4. Regresar");
                                try {
                                    opción=CuerposCelestes.lector.nextInt();
                                    
                                    switch (opción) {
                                        case 1:
                                            CuerposCelestes.rellenar(estrellas, 0);
                                            break;
                                        case 2:
                                            CuerposCelestes.rellenar(planetas, 1);
                                            break;
                                        case 3:
                                            CuerposCelestes.rellenar(nebulosas, 2);
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Esa opción no es valida");                 
                                            break;
                                    } 
                                } catch (InputMismatchException e) {
                                    System.out.println("\nSolo se pueden ingresar numeros enteros como opción");
                                    opción=0;
                                    CuerposCelestes.lector.nextLine();
                                }
                                
                            }while(opción!=4);
                        } else {
                            System.out.println("Entendible");
                        }
                    break;
                    case 3:
                        System.out.println("Saliendo del juego..."); // mensaje de salida para el programa
                    break;
                    default:
                        System.out.println("\nEsa opción no existe");
                    break;
                } 
            } catch (InputMismatchException ex){
                System.out.println("\nSolo se pueden ingresar numeros enteros como opción");
                respuesta=0;
                CuerposCelestes.lector.nextLine();
            } 
            //Elección si iniciar el juego o salir
        }while(respuesta!=3); // repetir el proceso del menu hasta que se escoja la seguna opcion 
    }
}