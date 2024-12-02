#include <stdio.h>

int main(void){
    int n1, n2, somma, sott, mul;
    float div;

    printf("\nInserisci il valore di n1: ");
    scanf("%d", &n1);
    printf("\nI 4 nserisci il valore di n2: ");
    scanf("%d", &n2);

    somma = n1 + n2;
    printf("\nEcco la somma: ");
    printf("%d", somma);

    sott = n1 - n2;
    printf("\nEcco la sottrazione: ");
    printf("%d", sott);

    div = n1 / n2;
    printf("\nEcco la divizione: ");
    printf("%f", div);

    mul = n1 * n2;
    printf("\nEcco la moltiplicazione: ");
    printf("%d", mul);

    return 0;
}
