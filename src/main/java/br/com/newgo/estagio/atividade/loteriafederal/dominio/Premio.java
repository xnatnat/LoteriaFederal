package br.com.newgo.estagio.atividade.loteriafederal.dominio;

public interface Premio {
    public void calcularPremio(int quantidadeApostas, int quantidadeGanhadores);
    public Double getValorPremioTotal();
    public Double getValorPremioPorGanhador();


}
