public class Spettatore extends Thread{
    String nome;
    Tornello tornello;

    public Spettatore(String nome, Tornello tornello){
        this.nome=nome;
        this.tornello = tornello;
    }

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
}
