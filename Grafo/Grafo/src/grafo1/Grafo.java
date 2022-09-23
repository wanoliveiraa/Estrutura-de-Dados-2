
package grafo1;
import java.util.ArrayList;
import java.util.Objects;

public class Grafo {
    private ArrayList <Aresta> arestas;
    private ArrayList <Vertice> vertices;
    private int qtd;
    
    public Grafo() {;
       this.vertices=new ArrayList<Vertice>();
       this.arestas=new ArrayList<Aresta>();
       
    }
    // dado é a aresta 
    public Vertice adicionaVertice(String dado) {
        if(getVertices(dado) != null){
            return null;
        }  
        Vertice newv = new Vertice(dado);
        vertices.add(newv);
        return newv;
    }

    public Aresta adicionaAresta(Double peso, String dadoInicio, String  dadoFim) {
        
        Vertice inicio = this.getVertices(dadoInicio);
        Vertice fim = this.getVertices(dadoFim);
        Aresta  a = new Aresta(peso,inicio,fim);
        inicio.adicionaArestaSaida(a);
        fim.adicionaArestaEntra(a);
        this.arestas.add(a);
        return a;
    }

    public  Vertice getVertices(String dado){
        Vertice  vertices=null;
        for (int i=0;i<this.vertices.size();i++){
            if(this.vertices.get(i).getNome().equals(dado)){
                vertices=this.vertices.get(i);
                break;
            }
        }
        return vertices;
    }



    public boolean DFS (String origem, String destino){
        Vertice  vertice = getVertices(origem);
        
        if (origem.compareTo(destino) == 0){
            return true;      
        }
        vertice.setVisitado(true);
        for (Aresta e: vertice.getAdjSai()){
            if(!e.getDestino().getVisitado()){
                if (DFS(e.getDestino().getNome(),destino)){
                    return true;
                }   
            }
        }    
        return false;
    }
    public boolean DFScont (String origem, String destino){
        Vertice  vertice =getVertices(origem);
        
        if (origem.compareTo(destino) == 0){
            
            return true;      
        }
        vertice.setVisitado(true);
        for (Aresta e: vertice.getAdjSai()){
            if(!e.getDestino().getVisitado()){
                if (DFS(e.getDestino().getNome(),destino)){
                    return true;
                }   
           }
        }
        return false;
        
    }
    
    
    public String toString() {
        String r = "";
        for (Vertice u : vertices) {
            r += u.getNome()+ " - ";
            for(Aresta e :u.getAdjSai()){
                 Vertice v = e.getDestino();
                    r += v.getNome() + " ";
                    r+=e.getPeso() +" ";
            }
            r += "\n";
        }
        return r;
    }

}
