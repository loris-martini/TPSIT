class SommaThread extends Thread {
    private int[] numeri;
    private int inizio, fine;
    private int risultatoParziale;

    public SommaThread(int[] numeri, int inizio, int fine) {
        this.numeri = numeri;
        this.inizio = inizio;
        this.fine = fine;
    }

    @Override
    public void run() {
        risultatoParziale = 0;
        for (int i = inizio; i <= fine; i++) {
            risultatoParziale += numeri[i];
        }
    }

    public int getRisultatoParziale() {
        return risultatoParziale;
    }
}
