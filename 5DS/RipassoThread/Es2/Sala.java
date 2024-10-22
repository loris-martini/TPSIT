package GestioneConcerto.RipassoThread.Es2;

import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class Sala{
    Semaphore s;
    Team lock;
    int n;
    int perms;

    public Sala(int N) {
        s = new Semaphore(1);

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        do{
            if(N <= 0){
                System.out.println("Input Errato!");
                N = input.nextInt();
            }else {
                flag = false;
            }
        }while (flag);
        n = 0;
        perms = N;
    }

    public synchronized void entra(Team t){
        if(!(n+1>perms)){
            if(n == 0){
                lock = t;
            }

            if(lock.getClass().equals(t.getClass())){
                n++;
                System.out.println(t.nome + " è entrato. Posti: " + n);
                return;
            }
            return;
        }
        System.out.println("Sala Piena!");
    }

    public synchronized void esci(Team t){
        if(lock == null){
            return;
        }
        if(lock.getClass().equals(t.getClass())){
            if(n-1 == 0){
                lock = null;
            }
            n--;
            System.out.println(t.nome + " è uscito. Posti: " + n);
        }
    }
}
