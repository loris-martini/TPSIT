#include <stdio.h>

int main() {
    //Nuova riga
    printf("Questa � una frase.\nQuesta � una nuova riga.\n");

    //Tabulazione
    printf("Questa � una\tfrase con\ttabulazioni.\n");

    //Ritorno a capo
    printf("Questa � una frase.\rQuesta � una frase sovrascritta.\n");

    //Cancellazione
    printf("Questa � una frase con un carattere da cancellare\b.\n");

    //Suono del campanello
    printf("Questa � una frase con un suono del campanello\a.\n");

    //Visualizzazione di un apice
    printf("Questa � una frase con un apice (\') dentro le virgolette.\n");

    //Visualizzazione di una virgoletta
    printf("Questa � una frase con una virgoletta (\") dentro le virgolette.\n");

    return 0;
}
