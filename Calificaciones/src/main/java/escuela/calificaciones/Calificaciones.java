package escuela.calificaciones;
import java.io.*;
public class Calificaciones {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr =new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String respuesta="Hola Mundo";
        int resp;
        float suma;

        File file = new File("elMejorArchivoDelMundo.txt");
        FileWriter fw = new FileWriter(file);
        File fileSecuela = new File("elMejorArchivoDelMundo22.txt");
        FileWriter fwPrecuela = new FileWriter(fileSecuela);
        for(int i=0;i<40;i++){
            System.out.print("Para el alumno "+(i+1));
            suma=0;
            for(int j=0;j<3;j++){
                System.out.println(" deme la calificación "+(j+1)+" ");
                try{
                   respuesta = br.readLine();
                   resp = Integer.parseInt(respuesta);
                   fw.write(resp+" ");
                   fw.flush();
                   suma=suma+resp;
                }catch(Exception eeee){
                    System.out.println("La respuesta tiene que ser un numero entero");
                    j--;
                }
            }
            fwPrecuela.write((suma/3)+"");
            fw.write("\n");
            fwPrecuela.write("\n");
            fwPrecuela.flush();
        }
        fw.close();
        fwPrecuela.close();      
    }
}
