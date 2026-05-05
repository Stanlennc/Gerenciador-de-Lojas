import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaxLojas){
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaxLojas];
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String info = "Shopping: " + nome +
                "\nEndereço: " + endereco +
                "\n--- Lojas Cadastradas ---";

        if (lojas == null || lojas.length == 0) {
            info += "\nNenhuma loja registrada.";
        } else {
            boolean possuiLoja = false;
            for (Loja l : lojas) {
                if (l != null) {
                    info += "\n- " + l.toString();
                    possuiLoja = true;
                }
            }
            if (!possuiLoja) {
                info += "\nEspaço disponível, mas nenhuma loja cadastrada ainda.";
            }
        }

        return info;
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
        // Validação do tipo (considerando que as subclasses existem)
        if (!tipo.equalsIgnoreCase("Cosmético") && !tipo.equalsIgnoreCase("Vestuário") &&
                !tipo.equalsIgnoreCase("Bijuteria") && !tipo.equalsIgnoreCase("Alimentação") &&
                !tipo.equalsIgnoreCase("Informática")) {
            return -1;
        }

        int contador = 0;
        for (Loja l : lojas) {
            if (l != null) {
                // Verifica se a instância da loja corresponde ao tipo solicitado
                if (tipo.equalsIgnoreCase("Cosmético") && l instanceof Cosmetico) contador++;
                else if (tipo.equalsIgnoreCase("Vestuário") && l instanceof Vestuario) contador++;
                else if (tipo.equalsIgnoreCase("Bijuteria") && l instanceof Bijuteria) contador++;
                else if (tipo.equalsIgnoreCase("Alimentação") && l instanceof Alimentacao) contador++;
                else if (tipo.equalsIgnoreCase("Informática") && l instanceof Informatica) contador++;
            }
        }
        return contador;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;
        double maiorValor = -1;

        for (Loja l : lojas) {
            if (l instanceof Informatica) {
                Informatica lojaInfo = (Informatica) l;
                if (lojaInfo.getSeguroEletronicos() > maiorValor) {
                    maiorValor = lojaInfo.getSeguroEletronicos();
                    maisCara = lojaInfo;
                }
            }
        }
        return maisCara;
    }


}
