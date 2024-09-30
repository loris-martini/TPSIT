package GestioneConcerto;

public class Spettatore extends Thread{

    private int idSpettatore;
    private Stadio stadio;
    
    /* ATTRIBUTI v1
    String nome;
    Tornello tornello;
    */

    public Spettatore(int idSpettatore, Stadio stadio) {
        this.idSpettatore = idSpettatore;
        this.stadio = stadio;
    }

    /* COSTRUTTORE v1
    public Spettatore(String nome, Tornello tornello){
        this.nome=nome;
        this.tornello = tornello;
    }
    */

    @Override
    public void run() {
        try {
            stadio.entraStadio(idSpettatore);

            try {
                System.err.println("Che bel concerto...");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            System.err.println("Concerto finito. " + idSpettatore + " se ne è andato.");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* RUN v1
    public void run () {
        try{
            while(true){
                if(!tornello.tryAcquire()){
                    sleep(500);
                }
                break;
            }
            Agente agente = tornello.entra();
            System.out.println(nome + " è passato dal tornello " + tornello.getNumero());

            while(true){
                if(!agente.tryAcquire()){
                    sleep(500);
                }
                break;
            }
            System.out.println(nome + " viene perquisito dall'agente del tornello " + tornello.getNumero());
            agente.perquisisci();

            System.out.println(nome + " è entrato nello stadio e ha preso il suo posto");

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    */
}
