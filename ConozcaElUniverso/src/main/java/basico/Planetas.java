package basico;
public class Planetas extends CuerposCelestes{
    //atributos
    String traslacion; 
    int rotacion;
    boolean[] preguntasUsadas = new boolean[4];
    String[] pregunta = {"¿Distancia desde la tierra?(km)"," ¿Tiempo de traslación(años y dias)?"," ¿Tipo de planeta?","¿Temperatura mínima?(C°)"};
    //constructor
    Planetas(){   
    }
    Planetas(String nombre, String tipo,long distanciaTierra ,int tempMin, int rotacion, String traslacion) {
        super(nombre, tipo, tempMin,distanciaTierra);
        this.rotacion = rotacion;
        this.traslacion = traslacion;      
    }
    // setter de la rotacion
    public void setRotacion (int rotacion){
        this.rotacion=rotacion;
    }
    // getter de la rotacion
    public int getRotacion(){
        return rotacion;
    }
    // setter de la traslacion
    public void setTraslacion(String traslacion){
        this.traslacion = traslacion;       
    }
    // getter de la traslacion
    public String getTraslacion(){
        return traslacion;
    }
    public void pregunta(Planetas X, Planetas Y){
        //Genera un numero aleatorio
        int a= (int) (Math.random()*4);
        //Impresion del nombre de la estrella
        System.out.println("\nPlaneta: "+getNombre());
        //Ciclo por si el numero aleatorio de pregunta ya fue usado
        while(preguntasUsadas[a]==true){
            a = (int) (Math.random()*4);
        }
        //Impresion de la pregunta
        System.out.println("\n"+pregunta[a]);
        //Opciones para aceptar saber que clase de respuesta aceptar
        switch (a){
            case 0 -> lecRes(distanciaTierra, X.getDistanciaTierra(), Y.getDistanciaTierra());
            case 1 -> lecRes(traslacion, X.getTraslacion(), Y.getTraslacion());
            case 2 -> lecRes(tipo,X.getTipo(),Y.getTipo());
            case 3 -> lecRes(tempMin,X.getTempMin(),Y.getTempMin());
        }
        preguntasUsadas[a]=true;
        contador++;
        if(contador==4){
            usado=true;
        }
        info();
    }
    @Override
    public void reseteo(){ // metodo para resetear el control de las preguntas usadas
        for(int i=0;i<4;i++){
            preguntasUsadas[i]=false;
        }
        contador=0;
    }
    @Override
    public void info() {
        System.out.println("Nombre: "+getNombre()+" Tipo: "+getTipo()+" Distancia a la Tierra: "+ getDistanciaTierra()+" Temperatura minima: "+getTempMin()+" Rotación: "+getRotacion()+" Traslacion: "+getTraslacion());
    }
}