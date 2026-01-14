import java.util.concurrent.ThreadLocalRandom;

class JugadorParImpar extends Jugador {
    private String apuesta;
    private int random;

    public JugadorParImpar(String nombre, int saldo, Banca banca) {
        super(nombre, saldo, banca);
        random = ThreadLocalRandom.current().nextInt(0, 2);
        if (random % 2 == 0) {
            apuesta = "par";
        } else {apuesta = "impar";}
    }

    @Override
    public void hacerApuesta(int numeroRuleta) {
        if (saldo < 10) return;
        saldo -= 10;
        banca.recibir(10);

        if (numeroRuleta % 2 == random % 2 && numeroRuleta != 0) {
            if (banca.pagar(20)) {
                saldo += 20;
            } else {
                System.out.println("Banca no puede pagar a " + nombre);
            }
        }
        System.out.println(nombre + " apuesta a " + apuesta + " | Saldo: " + saldo);
    }
}