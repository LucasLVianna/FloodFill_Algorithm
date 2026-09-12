public class Pilha {
    private No topo;

    public void empilhar(Coordenada p){
        No novoNo = new No(p);
        if(topo != null){
            novoNo.proximo = topo;
        }
        topo = novoNo;
    }

    public Coordenada desempilhar(){
        if(topo == null){
            throw new RuntimeException("Pilha vazia!");
        }

        Coordenada valor = topo.dados;
        topo = topo.proximo;
        return valor;
    }

    public boolean verificaVazia(){
        return topo == null; // se a pilha estiver vazia, vai retornar true
                            // se estiver preenchida, retornar false
    }
}
