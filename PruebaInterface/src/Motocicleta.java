
class Motocicleta extends Transporte{ // la clase motocicleta hereda de transporte
    public Motocicleta(String nombre){//metodo constructor
        super(nombre);//hereda nombre de transporte
        System.out.println("Constructor Motocicleta, nombre: "+nombre);
       
    }
    public void tipoTransporte(){//se reescribe al ser un metodo de la clase abstracta
        System.out.println("Tipo Transporte: Es una Motocicleta");
        
    }
    public void desplazar(){//se reescribe usando poliformismo
        System.out.println("Metodo desplazar: La Motocicleta se mueve acelerando");
    }
}
