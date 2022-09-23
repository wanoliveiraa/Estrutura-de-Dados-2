
package grafo1;

import java.util.ArrayList;


public class Vertice  {
   private String nome;
   private ArrayList<Aresta> adjEnt;
   private ArrayList<Aresta> adjSai;
   private Boolean visitado;

    public Vertice(String nome) {
        this.nome = nome;
        this.adjEnt = new ArrayList<Aresta>();
        this.adjSai = new ArrayList<Aresta>();
        visitado = false;
    }

    public void adicionaArestaEntra(Aresta a){
        this.adjEnt.add(a);
    }
    
    public void adicionaArestaSaida(Aresta a){
        this.adjSai.add(a);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado){
        this.visitado = visitado;
    }

    public ArrayList<Aresta> getAdjEnt() {
        return adjEnt;
    }

    public void setAdjEnt(ArrayList<Aresta> adjEnt) {
        this.adjEnt = adjEnt;
    }

    public ArrayList<Aresta> getAdjSai() {
        return adjSai;
    }  
}
