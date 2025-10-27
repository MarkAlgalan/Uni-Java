
class Bicicleta extends Transporte{ // la clase bicicleta hereda de transporte
    
    public Bicicleta(String nombre){//metodo constructor
        super(nombre); //hereda nombre de transporte
        System.out.println("Constructor Bicicleta, nombre: "+nombre);

    }
    public void tipoTransporte(){ //se reescribe al ser un metodo de la clase abstracta
        System.out.println("Tipo Transporte: Es Bicicleta");
    }
    public void desplazar(){ //se reescribe usando poliformismo
        System.out.println("Metodo desplazar: La bicicleta se mueve pedaleando");
    }
}
