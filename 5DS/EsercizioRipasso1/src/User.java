import java.util.Random;

class Utente extends Thread {
    private ContoBancario conto;
    private Random random = new Random();

    public Utente(ContoBancario conto, String nome) {
        super(nome);
        this.conto = conto;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            int importo = random.nextInt(100) + 1;
            conto.preleva(importo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}