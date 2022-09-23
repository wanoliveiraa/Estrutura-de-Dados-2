
package ed2;

public class AvlNode {
    private AvlNode esquerda;
    private AvlNode direita;
    private AvlNode pai;
    private String chave;
    private int balanceamento;

    public AvlNode(String chave) {
       setEsquerda(null);
       setDireita(null);
       setPai(null);
       setBalanceamento(0);
       setChave(chave);
    }

    public AvlNode getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(AvlNode esquerda) {
        this.esquerda = esquerda;
    }

    public AvlNode getDireita() {
        return direita;
    }

    public void setDireita(AvlNode direita) {
        this.direita = direita;
    }

    public AvlNode getPai() {
        return pai;
    }

    public void setPai(AvlNode pai) {
        this.pai = pai;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }
    
    
}
