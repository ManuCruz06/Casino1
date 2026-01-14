public class Main {
    public static void main(String[] args) {
        Banca banca = new Banca(50000);

        Ruleta ruleta = new Ruleta(banca);

        // Crear jugadores de numero
        for (int i = 0; i < 2; i++) {
            Jugador j = new JugadorNumero("JugadorNum" + (i+1), 10, banca);
            ruleta.agregarJugador(j);
            j.start();
        }

        // Crear jugadores de ParImpar
        for (int i = 0; i < 2; i++) {
            Jugador j = new JugadorParImpar("JugadorParImpar" + (i+1), 10, banca);
            ruleta.agregarJugador(j);
            j.start();
        }

        ruleta.start();
    }
}