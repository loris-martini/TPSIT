public class Main {
    public static void main(String[] args) {
        try {
            ContoBancario contoCondiviso = new ContoBancario(500); // Conto con saldo iniziale di 500€

            // Crea tre utenti (thread) che accederanno al conto contemporaneamente
            Utente utente1 = new Utente(contoCondiviso, "Utente 1");
            Utente utente2 = new Utente(contoCondiviso, "Utente 2");
            Utente utente3 = new Utente(contoCondiviso, "Utente 3");

            // Avvia i thread
            utente1.start();
            utente2.start();
            utente3.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());  // Stampa il messaggio dell'eccezione
            // O, per un debug più dettagliato:
            e.printStackTrace();  // Stampa lo stack trace completo dell'eccezione
        }
    }
}
