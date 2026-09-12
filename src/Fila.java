public class Fila {
    private No inicio;
    private No fim;

    public void enfileirar(Coordenada p){
        No novoNo = new No(p);
        if(fim == null){
            inicio = novoNo;
            fim = novoNo;
        }else{
            fim.proximo = novoNo;
            fim = novoNo;
        }


    }

    public Coordenada desenfileirar(){
        if(inicio == null){
            throw new RuntimeException("Fila vazia!");
        }

        Coordenada valor = inicio.dados;
        inicio = inicio.proximo;
        if(inicio == null){
            fim = null;
        }
        return valor;
    }

    public boolean verificaVazia(){
        return inicio == null;
    }
}
