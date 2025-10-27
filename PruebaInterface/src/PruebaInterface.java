public class PruebaInterface { // Este va a ser el metodo para hacer las pruebas
    public static void main(String[] args) throws Exception { // Inicio del metodo main
        //Creamos mot, objeto Motocicleta  tipo Transporte
        Transporte mot = new Motocicleta("ducaty"); // creacion de un objeto motocicleta
        mot.tipoTransporte();
        mot.desplazar(); 
        //Creamos Motocicleta, objeto Motocicleta de tipo Motocicleta
        Motocicleta Motocicleta = new Motocicleta("victory");
        Motocicleta.tipoTransporte(); // 
        Motocicleta.desplazar();
        System.out.println();
        //Creamos TransportePol, un objeto Motocicleta de tipo Transporte asignamos una referencia ya existente
        Transporte TransportePol = Motocicleta;
        TransportePol.tipoTransporte();
        System.out.println();
        //reasignamos la referencia del objeto mot al objeto Motocicleta esto es valido ya que ambos son de tipo Motocicleta
        Motocicleta = (Motocicleta)mot;
        Motocicleta.tipoTransporte();
        System.out.println();
          //Creamos bici, un objeto Bicicleta de tipo Transporte
        Transporte bici = new Bicicleta("felt");
        bici.tipoTransporte();
        bici.desplazar();
        System.out.println();
        //Creamos bici1, un objeto Bicicleta de tipo ITransporte   
        ITransporte bicil = new Bicicleta("Giant");
        bicil.desplazar();
        //bicil.tipoTransporte(); no funcionaria ya que no existe este metodo en ITransporte
        System.out.println("\nConstante en la interfaz Transporte: "+ITransporte.valor);
        System.out.println("\nEl numero de objetos creados fue de: " + Transporte.contador);
        

    }
}
