package GestioneConcerto.RipassoThread.Es2;

abstract public class Team{
    public String nome;
    Sala s1;

    public Team(Sala s,String name){
        s1 = s;
        nome = name;
    }
}
