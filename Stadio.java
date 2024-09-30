package GestioneConcerto;

class Stadio {
    private Tornello[] tornelli;

    public Stadio(int numeroTornelli) {
        tornelli = new Tornello[numeroTornelli];
        
        for (int i = 0; i < numeroTornelli; i++) {
            tornelli[i] = new Tornello( new Agente(), i);
        }
    }

    public void entraStadio(int nome) throws InterruptedException {
        int tornelloScelto = -1;
        for (int i=0; i < tornelli.length; i++){
            if (tornelli[i].tryAcquire()){
                tornelloScelto = tornelli[i].getNumero();
                System.out.println(nome + " sceglie il tornello " + tornelloScelto);
                break;
            }
            if (i==tornelli.length-1){ // forzatissima lo so...
                i=-1;
            }
        }

        Agente agente = tornelli[tornelloScelto].entra();
        System.out.println(nome + " è passato dal tornello " + tornelloScelto);
        tornelli[tornelloScelto].release();

        System.out.println(nome + " viene perquisito dall'agente del tornello");
        agente.perquisisci();
        agente.release();
        
        System.out.println(nome + " è entrato nello stadio e ha preso il suo posto");
    }
}