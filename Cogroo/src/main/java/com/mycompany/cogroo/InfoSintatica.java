package com.mycompany.cogroo;

import java.util.ArrayList;
import java.util.List;

public class InfoSintatica {
    private List<MyChunks> listChunk = new ArrayList<>();
    private List<MyShallows> listShallow = new ArrayList<>();
    
    public InfoSintatica(){
        super();
    }

    public List<MyChunks> getListChunk() {
        return listChunk;
    }

    public void setListChunk(List<MyChunks> listChunk) {
        this.listChunk = listChunk;
    }

    public List<MyShallows> getListShallow() {
        return listShallow;
    }

    public void setListShallow(List<MyShallows> listShallow) {
        this.listShallow = listShallow;
    }
    
    public void printInfo(){
        System.out.println("Chunks: ");
        for(MyChunks c : this.listChunk){
            System.out.println(". " + c.getPalavra() + ": " + c.getTag());
        }
        System.out.println("Shallow Structure: ");
        for(MyShallows s : this.listShallow){
            System.out.println(". " + s.getPalavra() + ": " + s.getTag());
        }
        System.out.print("\n");
    }
}
