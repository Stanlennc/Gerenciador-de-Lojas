public class Produto {
    public String nome;
    public double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidadeProduto) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidadeProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Preço: " + preco + " | Validade: " + dataValidade;
    }

    public boolean estaVencido(Data dataAtual) {

        if (this.dataValidade.getAno() < dataAtual.getAno()) {
            return true;
        } else if (this.dataValidade.getAno() > dataAtual.getAno()) {
            return false;
        }

        if (this.dataValidade.getMes() < dataAtual.getMes()) {
            return true;
        } else if (this.dataValidade.getMes() > dataAtual.getMes()) {
            return false;
        }

        return this.dataValidade.getDia() < dataAtual.getDia();
    }

}
