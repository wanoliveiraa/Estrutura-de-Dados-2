
package ed2;

public class Avl_Funcao {
    protected AvlNode raiz;
    
    public void insert(String valor){
        AvlNode no = new AvlNode(valor); //Cria nó
        inserirAVL(this.raiz, no); //Chama a função que insere
    }
    public void inserirAVL(AvlNode Comparar, AvlNode Inserir) {
        if (Comparar == null) {
            this.raiz = Inserir;
        } else{
            if (Inserir.getChave().compareTo(Comparar.getChave())<0) {
                if (Comparar.getEsquerda() == null) {
                    Comparar.setEsquerda(Inserir);
                    Inserir.setPai(Comparar);
                    verificarBalanceamento(Comparar);
                }else{
                    inserirAVL(Comparar.getEsquerda(), Inserir);
                }
            }else if(Inserir.getChave().compareTo(Comparar.getChave())>0) {
                if (Comparar.getDireita() == null) {
                    Comparar.setDireita(Inserir);
                    Inserir.setPai(Comparar);
                    verificarBalanceamento(Comparar);
                }else{
                    inserirAVL(Comparar.getDireita(), Inserir);
                }
            }else{
		// O nó já existe
            }
        }
    }
    private int Altura (AvlNode no){
        if (no == null){
            return -1;
        }
        if (no.getEsquerda() == null && no.getDireita()==null){
            return 0;
        }else if(no.getEsquerda() == null){ //tem direita
            return 1+ Altura(no.getDireita());
        }else if (no.getDireita() == null){ // ir para a esquerda
            return 1+Altura(no.getEsquerda());
        }else{ //Se tem ambos
            return 1 + Math.max(Altura(no.getEsquerda()), Altura(no.getDireita()));
        }
    }
    
    private void setBalanceamento(AvlNode no){
        no.setBalanceamento(Altura(no.getDireita()) - Altura(no.getEsquerda()) );
    }
     
    public AvlNode rotacaoEsquerda (AvlNode no){
        AvlNode direita = no.getDireita();
        direita.setPai(no.getPai());
        no.setDireita(direita.getEsquerda());
        if (no.getDireita()!=null){
            no.getDireita().setPai(no);
        }
        direita.setEsquerda(no);
        no.setPai(direita);
        if (direita.getPai()!=null){
            if (direita.getPai().getDireita() == no){
                direita.getPai().setDireita(direita);
            }else if (direita.getPai().getEsquerda() == no){
                direita.getPai().setEsquerda(direita);
            }
        }
        setBalanceamento(no);
        setBalanceamento(direita);
        return direita;
    }
    
    public AvlNode rotacaoDireita(AvlNode no){
        AvlNode esquerda = no.getEsquerda();
        esquerda.setPai(no.getPai());
        no.setEsquerda(esquerda.getDireita());
        if (no.getEsquerda()!= null){
            no.getEsquerda().setPai(no);
        }
        esquerda.setDireita(no);
        no.setPai(esquerda);
        if (esquerda.getPai() != null){
            if (esquerda.getPai().getDireita() == no){
                esquerda.getPai().setDireita(esquerda);
            }else if (esquerda.getPai().getEsquerda() == no){
                esquerda.getPai().setEsquerda(esquerda);
            }
        }
        
        setBalanceamento(no);
        setBalanceamento(esquerda);
        return esquerda;
    }
   
    public AvlNode duplaRotacaoEsquerdaDireita(AvlNode no){
        no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
        return rotacaoDireita(no);
    }
      
    public AvlNode duplaRotacaoDireitaEsquerda(AvlNode no){
        no.setDireita(rotacaoDireita(no.getDireita()));
        return rotacaoEsquerda(no);
    }  
    
    public void verificarBalanceamento(AvlNode atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();
        if (balanceamento == -2) {
            if (Altura(atual.getEsquerda().getEsquerda()) >= Altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);
            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }
        } else if (balanceamento == 2) {
            if (Altura(atual.getDireita().getDireita()) >= Altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);
            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }
        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }
    
  public boolean pesquisar(String data){
        AvlNode temp = raiz;
        while(temp != null){
            if(data.compareTo(temp.getChave()) < 0){
                if(temp.getEsquerda() == null){
                    break;
                }else{
                    temp = temp.getEsquerda();
                }    
            }else if(data.equals(temp.getChave())){
                //System.out.println(data + " - " + temp.getKey());
                break;
            }else{
                if(temp.getDireita() == null){
                    break;
                } else {
                    temp = temp.getDireita();
                }
            }
        }
        if(data.equals(temp.getChave()))
            return true;    
        return false;
    }    
}      
            
