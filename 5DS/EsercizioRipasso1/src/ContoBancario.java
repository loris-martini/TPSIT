class ContoBancario {
    private int saldo;

    public ContoBancario(int saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    // Metodo sincronizzato per prelevare denaro
    public synchronized boolean preleva(int importo) {
        if (importo > saldo) {
            System.out.println(Thread.currentThread().getName() + " tenta di prelevare " + importo + "€, ma saldo insufficiente. Saldo attuale: " + saldo + "€.");
            return false;
        } else {
            saldo -= importo;
            System.out.println(Thread.currentThread().getName() + " ha prelevato " + importo + "€. Saldo rimanente: " + saldo + "€.");
            return true;
        }
    }

    // Metodo per ottenere il saldo attuale
    public int getSaldo() {
        return saldo;
    }
}