import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Banca {
    private int saldo;

    public Banca(int saldo) {
        this.saldo = saldo;
    }

    public synchronized boolean pagar(int cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public synchronized void recibir(int cantidad) {
        saldo += cantidad;
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}
