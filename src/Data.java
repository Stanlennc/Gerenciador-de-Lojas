public class Data {
    int dia;
    int mes;
    int ano;

    public Data(int dia, int mes, int ano) {
        boolean dataValida = true;

        // 1. Verifica se o mês é válido
        if (mes < 1 || mes > 12) {
            dataValida = false;
        } else {
            // 2. Determina o limite de dias do mês
            int diasNoMes;
            switch (mes) {
                case 2: // Fevereiro
                    // Regra do ano bissexto
                    if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                        diasNoMes = 29;
                    } else {
                        diasNoMes = 28;
                    }
                    break;
                case 4: case 6: case 9: case 11: // Meses de 30 dias
                    diasNoMes = 30;
                    break;
                default: // Meses de 31 dias
                    diasNoMes = 31;
            }

            // 3. Verifica se o dia está no intervalo correto
            if (dia < 1 || dia > diasNoMes) {
                dataValida = false;
            }
        }

        // 4. Atribui os valores ou define o padrão
        if (dataValida) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Erro: Data inválida! Definindo padrão 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public boolean verificaAnoBissexto() {
        if ((this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

}
