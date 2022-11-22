package br.com.newgo.estagio.atividade.loteriafederal.dominio;

public class PremioMegaSena implements Premio {

    private static final Double PRECO_APOSTA = 6.00;
    private Double valorPremioTotal = 0.00;
    private Double valorPremioPorGanhador = 0.00;


    public void calcularPremio(int quantidadeApostas, int quantidadeGanhadores) {
        setValorPremioTotal(quantidadeApostas);
        setValorPremioPorGanhador(quantidadeGanhadores);
    }

    public Double getValorPremioTotal() {
        return valorPremioTotal;
    }

    public void setValorPremioTotal(int quantidadeApostas) {
        valorPremioTotal += PRECO_APOSTA * quantidadeApostas;
    }

    public Double getValorPremioPorGanhador() {
        return valorPremioPorGanhador;
    }

    public void setValorPremioPorGanhador(int quantidadeGanhadores) {
        valorPremioPorGanhador = getValorPremioTotal() / quantidadeGanhadores;
    }

}
