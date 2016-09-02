package com.mycompany.cogroo;

//* Main para testes da API Cogroo
public class Main {

    public static void main(String[] args) {
        String sentences[] = {"Paulo Portas como sempre demagogo", 
                             "João foi comprar pão", 
                             "Acredito que Portas vencerá as eleições"};
        Cogroo co = new Cogroo();
        for (int i = 0; i < sentences.length; i++) {
            //retorna um objeto InfoSintatica relacionada a sentença passada por parâmetro
            co.analyzeAndPrintDocument(sentences[i]).printInfo();
        }
    }
}
