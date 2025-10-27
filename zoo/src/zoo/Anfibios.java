package zoo;
public class Anfibios extends Animales{
    Boolean sano;
    int hi=7,hf=10;
    public Anfibios(int hora, Boolean sano, String nombre, int x){
        super(hora, nombre, x);
        this.sano=sano;
    }
    @Override
    public void comer() {
        if((hi<=hora) && (hf>=hora)){
            if(sano==false){
                System.out.println(nombre+" necesita descansar.\n");
                super.dieta();
                System.out.println("Pero necesitamos darle una variedad de comida parecida a la que encontraria fuera de cautiverio\n");
            }else{
                super.comer();
                System.out.println("El anfibio "+nombre+" puede comer ahora");
            }
        }else{
            System.out.println("El anfibio "+nombre+" aun no tiene hambre prueba con una hora de 7:00 a 10:00");
        }
    }
    @Override
    public void desplazarse() {
        super.desplazarse();
        System.out.println("El anfibio "+nombre+" sera llevado hasta otra area desinada");
    }
    @Override
    public void nombres() {
        System.out.println("Pereneciente al area de anfibios");
        super.nombres();
    }
}