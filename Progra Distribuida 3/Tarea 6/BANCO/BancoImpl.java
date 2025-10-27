import BancoModule.BancoPOA;

class BancoImpl extends BancoPOA {
    private double balance;

    public BancoImpl() {
        balance = 0.0;
    }

    public void depositar(double cantidad) {
        System.out.println("Monto Depositado:" + cantidad);
        balance += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No se puede retirar una cantidad menor o igual a $0.");
        } else if (cantidad <= balance) {
            System.out.println("Monto Retirado: " + cantidad);
            balance -= cantidad;
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    public double consultarSaldo() {
        System.out.println("Consulta de balance");
        return balance;
    }
}
