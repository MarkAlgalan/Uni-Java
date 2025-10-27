package zoo;
public class Aves extends Animales{
    Boolean sano;
    int hi=16;
    int hf=20;
    public Aves(int hora, Boolean sano, String nombre,int x){
        super(hora, nombre, x);
        this.sano=sano;
    }
    @Override
    public void comer() {
        if((hi<=hora) && (hf>=hora)){
            if(sano==false){
                System.out.println(nombre+" necesita descansar.");
                super.dieta();
                System.out.println("Pero hay que evitar darles semillas, y acompañar su dieta con suplementos alimenticios.");
            }else{
                super.comer();
                System.out.println("La ave "+nombre+" puede comer ahora\n");
            }
        }else{
            System.out.println("La ave "+nombre+" aun no tiene hambre prueba con una hora de 16:00 a 20:00\n");
        }
    }
    @Override
    public void desplazarse() {
        super.desplazarse();
        System.out.println("La ave "+nombre+" volara hacia otra area designada.");
    }
    @Override
    public void nombres() {
        System.out.println("Pereneciente al area de aves");
        super.nombres();
    }
}