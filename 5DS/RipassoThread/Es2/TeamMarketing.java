package GestioneConcerto.RipassoThread.Es2;

public class TeamMarketing extends Team implements Runnable{

    public TeamMarketing(Sala s){
        super(s,"Team Marketing");
    }

    @Override
    public void run() {
        try{
            while(true){
                s1.entra(this);
                Thread.sleep(200);
                s1.esci(this);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
