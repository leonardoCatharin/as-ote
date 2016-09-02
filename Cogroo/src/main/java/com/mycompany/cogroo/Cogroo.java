package com.mycompany.cogroo;

import java.util.Locale;
import org.cogroo.analyzer.Analyzer;
import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.text.Chunk;
import org.cogroo.text.Document;
import org.cogroo.text.Sentence;
import org.cogroo.text.SyntacticChunk;
import org.cogroo.text.Token;
import org.cogroo.text.impl.DocumentImpl;

public class Cogroo {

    private Analyzer cogroo;

    public Cogroo() {
        ComponentFactory factory = ComponentFactory.create(new Locale("pt", "BR"));
        cogroo = factory.createPipe();
    }

    public InfoSintatica analyzeAndPrintDocument(String documentText) {

        Document document = new DocumentImpl();
        document.setText(documentText);

        // analyze it
        cogroo.analyze(document);

        return criaObjeto(document);
    }

    private InfoSintatica criaObjeto(Document document) {
        InfoSintatica toReturn = new InfoSintatica();

        // and now we navigate the document to print its data
        for (Sentence sentence : document.getSentences()) {
            // we can also print the chunks, but printing it is not that easy!
            for (Chunk chunk : sentence.getChunks()) {
            MyChunks chunkAux = new MyChunks();
                chunkAux.setTag(chunk.getTag());
                for (Token innerToken : chunk.getTokens()) {
                    chunkAux.setPalavra(innerToken.getLexeme());
                }
                toReturn.getListChunk().add(chunkAux);
            }
            
            for (SyntacticChunk structure : sentence.getSyntacticChunks()) {
                MyShallows shallowAux = new MyShallows();
                shallowAux.setTag(structure.getTag());
                for (Token innerToken : structure.getTokens()) {
                    shallowAux.setPalavra(innerToken.getLexeme());
                }
                toReturn.getListShallow().add(shallowAux);
            }
        }

        return toReturn;
    }
}