public class PropResiden extends Propiedades{
    static boolean bool = false;
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
}