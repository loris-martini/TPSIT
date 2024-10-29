//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] numeri = {2, 5, 8, 12, 3, 7, 10, 6};

        SommaThread thread1 = new SommaThread(numeri, 0, 3);
        SommaThread thread2 = new SommaThread(numeri, 4, 7);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int risultatoTotale = thread1.getRisultatoParziale() + thread2.getRisultatoParziale();

        System.out.println("La somma totale è: " + risultatoTotale);
    }
}