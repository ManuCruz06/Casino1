import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Ruleta extends Thread {
    private List<Jugador> jugadores;
    private Banca banca;

    public Ruleta(Banca banca) {
        this.banca = banca;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public boolean hayJugadoresActivos() {
        for (Jugador j : jugadores) {
            if (j.getSaldo() > 0) { // Usamos getSaldo() de la clase Jugador
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) { }

            int numero = ThreadLocalRandom.current().nextInt(0, 37);
            System.out.println("\n*** La ruleta saca el número " + numero + " ***");

            // Notificar a todos los jugadores
            for (Jugador j : jugadores) {
                j.notificarNumero(numero);
            }

            // Comprobar si hay jugadores activos
            if (!hayJugadoresActivos()) {
                System.out.println("\n*** Todos los jugadores se han quedado sin saldo. Fin de la simulación ***");
                System.exit(0); // Detener todo el programa
            }
        }
    }
}