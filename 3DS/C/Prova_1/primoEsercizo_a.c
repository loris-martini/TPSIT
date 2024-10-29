#include <stdio.h>
#include <stdlib.h>

int main(void){
    printf("Questo e' un programma in linguaggio C");
    int num2, somma; //dichiara le variabili num e a
    int num1 = 10; //dichiara num2 e lo inizailizza a 10
    printf("\nEcco il valore di num2: ");
    printf("%d", num1); //stampa a video il valore di num2
    printf("\nInserisci il valore di num1: "); //va a capo
    scanf("\n%d", &num2); //prende in input il valore di num
    somma = num1 + num2; //assegna ad a la somma num e num2
    printf("Ecco la somma: ");
    printf("%d\n", somma); //stampa a video a
    return 0; //finisce il programma
}
