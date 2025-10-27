public class PropTerrenos extends Propiedades{
static boolean bool = false;
    PropTerrenos(int tamaño){
        this.tamaño = tamaño;
        }
    

	@Override
	public void darDeAlta() {
        System.out.println("Te diste de alta en el seguro de negocio");
        bool = true;
	}

	@Override
	public void darDeBaja() {
		System.out.println("Te diste de baja en el seguro de negocio");
	}

	@Override
	public void imprimirDatos() {
		if (bool){
            System.out.println("Tienes activo un seguro de negocio");
        } else{
            System.out.println("No cuentas con un seguro de este tipo");
        }
	}

	public void propTerrenos(int tamaño) {
        if(tamaño<400){
            System.out.println("El terreno no se puede asegurar por mas de 300,000$");
        }else{
            System.out.println("El terreno se puede asegurar por mas de 300,000$");
        }
	}
}