package GestioneConcerto.RipassoThread.Es2;

public class MainRipasso {
    public static void main(String[] args) {
        Sala s1 = new Sala(3);

        Thread tT1 = new Thread(new TeamTecnico(s1));
        Thread tM1 = new Thread(new TeamMarketing(s1));
        Thread tT2 = new Thread(new TeamTecnico(s1));
        Thread tM2 = new Thread(new TeamMarketing(s1));

        tT1.start();
        tM1.start();
        tT2.start();
        tM2.start();
    }
}