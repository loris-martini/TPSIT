package GestioneConcerto.RipassoThread.Es1;

public class Caffe implements Runnable {
    public Caffe(){

    }
    @Override
    public void run() {
        System.out.println("Preparazione del caffè in corso... ");
        try{
            Thread.sleep(1000);
            System.out.println("Caffè pronto!");
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
