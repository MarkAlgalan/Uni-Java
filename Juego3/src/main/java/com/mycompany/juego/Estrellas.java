package com.mycompany.juego;
public class Estrellas extends CuerposCelestes{
    //atributos
    int luminosidad;
    boolean[] preguntasUsadas = new boolean[4];
    String[] pregunta = {"¿A que constelación pertenece? ","¿Distancia en años luz desde la tierra?","¿Tipo de estrella?","¿Luminosidad?(soles)"};
    //constructor
    Estrellas(){  
    }
    Estrellas(String nombre, String tipo, long distanciaTierra, String constelacion, int luminosidad) {
		super(nombre, tipo, distanciaTierra, constelacion);
		this.luminosidad = luminosidad;
	}
    // setter de luminosidad
    public void setluminosidad(int luminosidad){
        this.luminosidad = luminosidad;
    }
    //getter de luminosidad
    public int getluminosidad(){
        return luminosidad;
    }
    //metodo para elección de preguntas
    public void pregunta(Estrellas X,Estrellas Y){
        //Genera un numero aleatorio
        int a= (int) (Math.random()*4);
        //Impresion del nombre de la estrella
        System.out.println("\nEstrella: "+getNombre());
        //Ciclo por si el numero aleatorio de pregunta ya fue usado
        while(preguntasUsadas[a]==true){
            a = (int) (Math.random()*4);
        }
        //Impresion de la pregunta
        System.out.println("\n"+pregunta[a]);
        //Opciones para aceptar saber que clase de respuesta aceptar
            switch (a){
            case 0:
            lecRes(constelacion,X.getConstelacion(),Y.getConstelacion());
            break;
            case 1:
            lecRes(distanciaTierra, X.getDistanciaTierra(),Y.getDistanciaTierra());
            break;
            case 2:
            lecRes(tipo,X.getTipo(),Y.getTipo());
            break;
            case 3:
            lecRes(luminosidad,X.getluminosidad(),Y.getluminosidad());
            break;
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
        System.out.println("Nombre: "+getNombre()+" Tipo: "+getTipo()+" Distancia a la Tierra: "+ getDistanciaTierra()+" Constelación: "+getConstelacion()+" Luminosidad: "+getluminosidad() );
    }
}