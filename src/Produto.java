public class Produto {
    public String nome;
    public String preco;
    private Data dataValidade;

    public Produto(String nome, String preco, Data dataValidadeProduto){
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidadeProduto;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "FRUTAS DISPONIVEIS:\n"+"Fruta: "+nome+"\n"+"preço: "+preco+ "\n"+"data de validade: "+getDataValidade();
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
