#include <stdio.h>

int main() {
    //Nuova riga
    printf("Questa è una frase.\nQuesta è una nuova riga.\n");

    //Tabulazione
    printf("Questa è una\tfrase con\ttabulazioni.\n");

    //Ritorno a capo
    printf("Questa è una frase.\rQuesta è una frase sovrascritta.\n");

    //Cancellazione
    printf("Questa è una frase con un carattere da cancellare\b.\n");

    //Suono del campanello
    printf("Questa è una frase con un suono del campanello\a.\n");

    //Visualizzazione di un apice
    printf("Questa è una frase con un apice (\') dentro le virgolette.\n");

    //Visualizzazione di una virgoletta
    printf("Questa è una frase con una virgoletta (\") dentro le virgolette.\n");

    return 0;
}
