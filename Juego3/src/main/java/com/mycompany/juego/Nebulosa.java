package com.mycompany.juego;
public class Nebulosa extends CuerposCelestes{
    boolean[] preguntasUsadas = new boolean[2];
    String[] pregunta = {"¿Año de descubrimiento?","¿Constelación a al que pertenece?"};
    //constructor
    Nebulosa(){
    }
    public Nebulosa(String nombre, String tipo, String constelacion,int tempMin, int añoDescubrimiento) {
        super(nombre, tipo, constelacion, tempMin);
        this.añoDescubrimiento = añoDescubrimiento;
    }
    int añoDescubrimiento;
    // setter del año de descubrimiento
    public void setAñoDescubrimiento(int añoDescubrimiento){
        this.añoDescubrimiento= añoDescubrimiento;
    }
    //getter de año de descubrimiento
    public int getAñoDescubrimiento(){
        return añoDescubrimiento;
    }    
    public void pregunta(Nebulosa X,Nebulosa Y){
        //Genera un numero aleatorio
        int a= (int) (Math.random()*2);
        //Impresion del nombre de la estrella
        System.out.println("\nNebulosa: "+getNombre());
        //Ciclo por si el numero aleatorio de pregunta ya fue usado
        while(preguntasUsadas[a]==true){
            a = (int) (Math.random()*2);
        }
        //Impresion de la pregunta
        System.out.println("\n"+pregunta[a]);
        //Opciones para aceptar saber que clase de respuesta aceptar
        switch (a){
            case 0:
            lecRes(añoDescubrimiento,X.getAñoDescubrimiento(),Y.getAñoDescubrimiento());
            break;
            case 1:
            lecRes(constelacion,X.getConstelacion(),Y.getConstelacion());
            break; 
        }
        preguntasUsadas[a]=true;
        contador++;
        if(contador==2){
            usado=true;
        }
        info();
    }
    public void reseteo(){ // metodo para resetear el control de las preguntas usadas
        for(int i=0;i<2;i++){
            preguntasUsadas[i]=false;
        }
        contador=0;
    }
    @Override
    public void info() {
        System.out.println("Nombre: "+getNombre()+" Tipo: "+getTipo()+" Constelación: "+getConstelacion()+" Temp. min: "+getTempMin()+" Año de DEscubrimiento: "+getAñoDescubrimiento());
    }
}
