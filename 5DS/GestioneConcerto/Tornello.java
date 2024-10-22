package GestioneConcerto.GestioneConcerto;

import java.util.concurrent.Semaphore;

public class Tornello extends Semaphore{

    private Agente agente;
    private int numero;

    public Tornello(Agente agente, int numero){
        super(1);
        this.numero = numero;
        this.agente = agente;
    }

    public synchronized Agente entra(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        return agente;
    }

    public int getNumero() {
        return numero;
    }
}
