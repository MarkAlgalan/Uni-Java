package zoo;

public class Felinos extends Animales{
    Boolean sano;
    int hi=10;
    int hf=13;
    public Felinos(int hora, Boolean sano, String nombre, int x){
        super(hora, nombre, x);
        this.sano=sano;
    }
    @Override
    public void comer() {
        if((hi<=hora) && (hf>=hora)){
            if(sano==false){
                System.out.println(nombre+" necesita descansar.");
                super.dieta();
                System.out.println("Pero se podria decir que un aporte de energia o calorias, y algo mas pastoso y equlibrado para su paladar");
            }else{
                super.comer();
                System.out.println("El felino "+nombre+" puede comer ahora\n");
            }
        }else{
            System.out.println("El felino "+nombre+" aun no tiene hambre prueba con una hora de 10:00 a 13:00\n");
        }
    }
    @Override
    public void desplazarse() {
        super.desplazarse();
        System.out.println("El felino "+nombre+" caminara hacia otra area designada\n");
    }
    @Override
    public void nombres() {
        System.out.println("\nPereneciente al area de felinos");
        super.nombres();
    }
}
