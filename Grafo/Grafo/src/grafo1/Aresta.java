
package grafo1;
public class Aresta{
    private Double peso;
    private Vertice origem;
    private Vertice destino;

    public Aresta(Double peso, Vertice origem, Vertice destino) {
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
    
}
