package GestioneConcerto.RipassoThread.Es1;

public class Latte implements Runnable {
    public Latte(){

    }
    @Override
    public void run() {
        System.out.println("Preparazione del latte in corso... ");
        try{
            Thread.sleep(1000);
            System.out.println("Latte pronto!");
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
