public class Main {
    public static void main(String[] args) {
        Agente a1 = new Agente();
        Agente a2 = new Agente();
        Tornello t1 = new Tornello(a1, 1);
        Tornello t2 = new Tornello(a2, 2);

        Spettatore s1 = new Spettatore("s1", t1);
        Spettatore s2 = new Spettatore("s2", t1);
        Spettatore s3 = new Spettatore("s3", t1);

        Spettatore s4 = new Spettatore("s4", t2);
        Spettatore s5 = new Spettatore("s5", t2);
        Spettatore s6 = new Spettatore("s6", t2);

        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        s6.start();

    }
}