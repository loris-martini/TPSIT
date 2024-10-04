package GestioneConcerto.RipassoThread.Es2;

public class TeamTecnico extends Team implements Runnable{

    public TeamTecnico(Sala s){
        super(s,"Team Tecnico");
    }

    @Override
    public void run() {
        try{
            while(true){
                s1.entra(this);
                Thread.sleep(200);
                s1.esci(this);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
