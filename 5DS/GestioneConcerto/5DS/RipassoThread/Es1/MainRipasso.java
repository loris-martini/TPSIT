package GestioneConcerto.RipassoThread.Es1;

public class MainRipasso{
    public static void main(String[] args) throws InterruptedException {
        Thread l1 = new Thread(new Latte());
        Thread c1 = new Thread(new Caffe());

        l1.start();
        c1.start();

        c1.join();
        l1.join();

        System.out.println("Bevande pronte! Caffè e latte sono stati preparati.  ");

    }
}
