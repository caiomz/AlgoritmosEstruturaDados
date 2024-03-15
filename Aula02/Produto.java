// Classe para o exercício 03

package Ex03;


class Produto {
    private String nome;
    private String segmento;

    public Produto(String nome, String segmento) {
        this.nome = nome;
        this.segmento = segmento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Produto produto = (Produto) o;
        return nome.equals(produto.nome) && segmento.equals(produto.segmento);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + segmento.hashCode();
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nSegmento: " + segmento;
    }
}
