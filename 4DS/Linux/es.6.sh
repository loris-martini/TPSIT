#!/bin/bash
<<comment
#Es.1
if [ -e "originale.txt" ]; then
    cp originale.txt copia.txt

    echo "Il file è stato copiato con successo come copia.txt"
else
    echo "Il file originale.txt non esiste"
fi
comment

<<comment
#Es.2
while true; do
	echo "Inserisci il nome del file (o 'exit' per terminare): "
    read nome_file

    if [ "$nome_file" == "exit" ]; then
        echo "Exit"
        break
    fi

    if [ -e "$nome_file" ]; then
        echo "Il file $nome_file esiste."
    else
        echo "Il file $nome_file non esiste. Exit."
        break
    fi
done
comment

n=10

while [ "$n" > 0 ]; do
    echo "Contatore: $n"
    ((n--))
done


