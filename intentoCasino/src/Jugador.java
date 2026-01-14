abstract class Jugador extends Thread {
    protected String nombre;
    protected int saldo;
    protected Banca banca;
    protected int ultimoNumero;

    public Jugador(String nombre, int saldo, Banca banca) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.banca = banca;
    }

    public abstract void hacerApuesta(int numeroRuleta);

    public void run() {
        while (saldo > 0) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) { }
            hacerApuesta(ultimoNumero);
        }
        System.out.println(nombre + " se queda sin saldo.");
    }

    public void notificarNumero(int numero) {
        this.ultimoNumero = numero;
    }

    public int getSaldo() {
        return saldo;
    }
}