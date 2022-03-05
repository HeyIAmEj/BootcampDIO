package com.heyiamej.bootcamp.controller;

import java.util.ArrayList;
import java.util.List;

public class DesafioTeste {
    public static void main(String[] args) {
        String s = "ola mundo";
        s = s.replace(" ", "");

        int t = s.length();
        double raizT = Math.sqrt(t);
        int tamanho = (int) Math.ceil(raizT);

        String newString = "";

        int aux = 0;
        for (int posicao=0;posicao<t;posicao++){
            newString += s.charAt(posicao);
            aux +=1;
            if (aux == tamanho){
                newString += "\n";
                aux = 0;
            }
        }
        System.out.println(newString);

        String[] lista = newString.split("\n");
        List<String> novaLista = new ArrayList<>();
        String auxStr = "";
            for(int x = 0;x<tamanho;x++){
                for(String partes : lista){
                    if (partes.length() > x) auxStr += partes.charAt(x);
                    else break;
                }
                novaLista.add(auxStr);
                auxStr = "";
        }

        for (String item : novaLista){
            System.out.print(item+" ");
        }

    }
}
