public class Endereco {
    String nomeDaRua;
    String cidade;
    String estado;
    String pais;
    String cep;
    String numero;
    String complemento;

    public Endereco(String cep, String cidade, String complemento, String estado, String nomeDaRua, String numero, String pais) {
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomeDaRua() {
        return nomeDaRua;
    }

    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Rua: " + nomeDaRua + " | N°: " + numero + " | Compl: " + complemento +
                " | CEP: " + cep + " | Cidade: " + cidade + " | Estado: " + estado + " | País: " + pais;

    }
}
