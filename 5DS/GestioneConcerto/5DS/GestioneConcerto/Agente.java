package GestioneConcerto.GestioneConcerto;

import java.util.concurrent.Semaphore;

public class Agente extends Semaphore{

    public Agente(){
        super(1);
    }

    public synchronized void perquisisci(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
