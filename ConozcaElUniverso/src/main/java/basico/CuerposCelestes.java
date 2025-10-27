package basico;

//importación de clases
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public abstract class CuerposCelestes implements inter { 
    //declaración del lector
    static Scanner lector = new Scanner(System.in);
    //declaracion de las variables
    String nombre;
    String tipo;
    String constelacion;
    int tempMin;
    long distanciaTierra;
    boolean usado;
    int contador=0;
    static int tam[]={10,7,7};
    //variable para selección del jugador
    static int x;
    static String nombreU[]= new String[2];
    static int puntuacion[]= {0,0};
    //Contador para la cantidad de preguntas que han pasado
    static int cont[] = {0,0,0};
    //constructor para planetas
    CuerposCelestes(){
    }
    CuerposCelestes(String nombre, String tipo,int tempMin,long distanciaTierra){
        this.nombre = nombre;
        this.tipo = tipo;
        this.tempMin = tempMin;
        this.distanciaTierra = distanciaTierra;
    }
    //constructor para estrellas
    CuerposCelestes(String nombre, String tipo, long distanciaTierra, String constelacion){
        this.nombre = nombre;
        this.tipo = tipo;
        this.distanciaTierra = distanciaTierra;
        this.constelacion = constelacion;
    }
    //constructor para nebulosas
    CuerposCelestes(String nombre, String tipo, String constelacion,int tempMin){
        this.nombre = nombre;
        this.tipo = tipo;
        this.constelacion = constelacion;
        this.tempMin = tempMin;
    }
    // metodos setter
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }
    public void setDistanciaTierra(long distanciaTierra) {
        this.distanciaTierra = distanciaTierra;
    }
    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setConstelacion(String constelacion) {
        this.constelacion = constelacion;
    }
    // metodos getter
    public String getConstelacion() {
        return constelacion;
    }
    public long getDistanciaTierra() {
        return distanciaTierra;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    public int getTempMin() {
        return tempMin;
    }
    @Override
    public String getTipo() {
        return tipo;
    }
    // metodos de escaneo de datos
    @Override
    public void lecRes (int resCorrecta, int resInc, int resInc2){
        String resExacta = String.valueOf(resCorrecta);
        String resFallida1 = String.valueOf(resInc);
        String resFallida2 = String.valueOf(resInc2);
        lecRes(resExacta, resFallida1, resFallida2);
    } 
    @Override
    public void lecRes (long resCorrecta, long resInc, long resInc2){
        String resExacta = String.valueOf(resCorrecta);
        String resFallida1 = String.valueOf(resInc);
        String resFallida2 = String.valueOf(resInc2);
        lecRes(resExacta, resFallida1, resFallida2);
    } 
    @Override
    public void lecRes (String resCorrecta, String resInc, String resInc2){
        int res;
        int a = (int) (Math.random()*3);
        int b;
        int c;
        String respuestas[]= new String [3];
        respuestas[a]=resCorrecta;
        do{
            b=(int) (Math.random()*3);
        }while(b==a);
        respuestas[b]=resInc;
        do{
            c=(int) (Math.random()*3);
        }while(c==a||c==b);
        respuestas[c]=resInc2;
        for(int t=0;t<3;t++){
            System.out.println((t+1)+") "+respuestas[t]);
        }
        try {
            res=lector.nextInt();
            if(respuestas[res-1]==resCorrecta){
                puntuacion[x]+=10;
                System.out.println("Respuesta correcta\n+10");
                System.out.println("La puntuacion de "+nombreU[x]+" es: "+puntuacion[x]);
                if(x==0){
                    x=1;
                }else{
                    x=0;
                }    
            }else{
                puntuacion[x]-=4;
                System.out.println("Respuesta incorrecta\n-4");
                System.out.println("La puntuacion de "+nombreU[x]+" es: "+puntuacion[x]);
                if(x==0){
                    x=1;
                }else{
                    x=0;
                }  
                System.out.println("\nOportunidad de "+nombreU[x]);
                for(int t=0;t<3;t++){
                    System.out.println((t+1)+") "+respuestas[t]);
                }
                int cic=1;
                while(cic==1){
                    try {
                        res=lector.nextInt();
                        if(respuestas[res-1]==resCorrecta){
                            puntuacion[x]+=10;
                            System.out.println("Respuesta correcta\n+10");
                            System.out.println("La puntuacion de "+nombreU[x]+" es: "+puntuacion[x]);   
                        }else{
                            puntuacion[x]-=4;
                            System.out.println("Respuesta incorrecta\n-4");
                            System.out.println("La respuesta correcta es: "+resCorrecta);
                        }
                        cic=0;  
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("\nEsa opción no esta disponible");
                    }catch (InputMismatchException e) {
                        System.out.println("\nSolo se pueden ingresar numeros enteros como opción");
                        lector.nextLine();
                    }
                }
            
                
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nEsa opción no esta disponible");
            lecRes(resCorrecta, resInc, resInc2);
        }catch (InputMismatchException e) {
            System.out.println("\nSolo se pueden ingresar numeros enteros como opción");
            lector.nextLine();
            lecRes(resCorrecta, resInc, resInc2);
        }
        
    }
    //metodos abstractos
    public abstract void info();
    public abstract void reseteo();
    //Metodo para implementar las preguntas
    public static void ronda(Estrellas e[],int elec,int z){
        //Variable para selección de lo arreglos
        int a;
        int b;
        int c;
        do{
            a = (int) (Math.random()*z);   
        }while(e[a].usado==true); 
        do{
            b = (int) (Math.random()*z);   
        }while(b==a);
        do{
            c = (int) (Math.random()*z);   
        }while(c==a||c==b);
        //llama la metodo para las preguntas
        lector.nextLine();
        e[a].pregunta(e[b],e[c]);
        //El contador de preguntas usadas aumenta
        cont[elec]++;  
    }
    public static void ronda(Planetas e[],int elec,int z){
        //Variable para selección de lo arreglos
        int a;
        int b;
        int c;
        do{
            a = (int) (Math.random()*z);   
        }while(e[a].usado==true); 
        do{
            b = (int) (Math.random()*z);   
        }while(b==a);
        do{
            c = (int) (Math.random()*z);   
        }while(c==a||c==b);
        //llama la metodo para las preguntas
        lector.nextLine();
        e[a].pregunta(e[b],e[c]);
        //El contador de preguntas usadas aumenta
        cont[elec]++;  
    }
    public static void ronda(Nebulosa e[],int elec,int z){
        //Variable para selección de lo arreglos
        int a;
        int b;
        int c;
        do{
            a = (int) (Math.random()*z);   
        }while(e[a].usado==true); 
        do{
            b = (int) (Math.random()*z);   
        }while(b==a);
        do{
            c = (int) (Math.random()*z);   
        }while(c==a||c==b);
        //llama la metodo para las preguntas
        lector.nextLine();
        e[a].pregunta(e[b],e[c]);
        //El contador de preguntas usadas aumenta
        cont[elec]++;  
    }
    public static void mostrar(CuerposCelestes tod[], int w) {
        for(int i=0;i<tam[w];i++){
            tod[i].info();
        }
    }
    public static void rellenarPrim(CuerposCelestes tod[], int w) {
        tam[w]++;
        System.out.println("Nombre: ");
        lector.nextLine();
        tod[tam[w]-1].setNombre(lector.nextLine());
        System.out.println("Tipo: ");
        tod[tam[w]-1].setTipo(lector.nextLine());
    }
    public static void rellenar(Estrellas todo[], int w) {
        todo[tam[w]]= new Estrellas();
        rellenarPrim(todo,w);
        System.out.println("Distancia a la tierra: ");
        todo[tam[w]-1].setDistanciaTierra(lector.nextInt());
        System.out.println("Luminosidad: ");
        todo[tam[w]-1].setluminosidad(lector.nextInt());
        System.out.println("Constelacion a la que pertenece: ");
        todo[tam[w]-1].setConstelacion(lector.nextLine());
    }
    public static void rellenar(Planetas todo[], int w) {
        todo[tam[w]]= new Planetas();
        rellenarPrim(todo,w);
        System.out.println("Distancia a la tierra: ");
        todo[tam[w]-1].setDistanciaTierra(lector.nextInt());
        System.out.println("Temp. Min: ");
        todo[tam[w]-1].setTempMin(lector.nextInt());
        System.out.println("Rotacion: ");
        todo[tam[w]-1].setRotacion(lector.nextInt());
        System.out.println("Traslacion: ");
        todo[tam[w]-1].setTraslacion(lector.nextLine());
    }
    public static void rellenar(Nebulosa todo[], int w) {
        todo[tam[w]]= new Nebulosa();
        rellenarPrim(todo,w);
        System.out.println("Año de descubrimiento: ");
        todo[tam[w]-1].setAñoDescubrimiento(lector.nextInt());
        System.out.println("Constelacion a la que pertenece: ");
        todo[tam[w]-1].setConstelacion(lector.nextLine());
    } 
}