import java.util.concurrent.ThreadLocalRandom;

class JugadorNumero extends Jugador {
    private int miNumero;

    public JugadorNumero(String nombre, int saldo, Banca banca) {
        super(nombre, saldo, banca);
        miNumero = ThreadLocalRandom.current().nextInt(1, 37);
    }

    @Override
    public void hacerApuesta(int numeroRuleta) {
        if (saldo < 10) return;
        saldo -= 10;
        banca.recibir(10);

        if (numeroRuleta == miNumero) {
            if (banca.pagar(360)) {
                saldo += 360;
            } else {
                System.out.println("Banca no puede pagar a " + nombre);
            }
        }
        System.out.println(nombre + " apuesta a " + miNumero + " | Saldo: " + saldo);
    }
}