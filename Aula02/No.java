// classe para o exercício 04

package Ex04;


class No {
    private String nome;
    private No anterior;
    private No proximo;

    public No(String nome) {
        this.nome = nome;
        this.anterior = null;
        this.proximo = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}

