package br.com.newgo.estagio.atividade.loteriafederal.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VolanteMegaSena implements Volante {

    private static final int QUANTIDADE_MAXIMA_DE_NUMEROS_ESCOLHIDOS_POR_VOLANTE = 6;
    private static final int QUANTIDADE_NUMEROS_VALIDOS_POR_VOLANTE = 60;
    private static final int PRIMEIRO_NUMERO_VALIDO = 1;
    private List<Boolean> numerosDisponiveis;

    public VolanteMegaSena(){
        setNumerosDisponiveis();
    }

    private void setNumerosDisponiveis () {
        numerosDisponiveis = new ArrayList<Boolean>();

        for (int indice = 0; indice <= QUANTIDADE_NUMEROS_VALIDOS_POR_VOLANTE;)
            numerosDisponiveis.add(indice++, false);
    }

    public void adicionarNumerosNoVolante(Set<Integer> numerosSelecionados){

        quantidadeIdealNumerosSelecionados(numerosSelecionados.size());

        for(int numeroSelecionado: numerosSelecionados) {
            numeroEhValido(numeroSelecionado);
            numerosDisponiveis.add(numeroSelecionado, true);
        }
    }

    public void selecionarNumerosAleatorios() {
        GeradorInteirosNaoRepetidosOrdenados gerador = new GeradorInteirosNaoRepetidosOrdenados();
        adicionarNumerosNoVolante(gerador.gerar(
                QUANTIDADE_NUMEROS_VALIDOS_POR_VOLANTE,
                QUANTIDADE_MAXIMA_DE_NUMEROS_ESCOLHIDOS_POR_VOLANTE));
    }

    public List<Integer> retornarNumerosSelecionados() {

        List<Integer> numerosSelecionados = new ArrayList<>();

        for (int indice = PRIMEIRO_NUMERO_VALIDO;
             indice <= QUANTIDADE_NUMEROS_VALIDOS_POR_VOLANTE;
             indice++) {
            if (numerosDisponiveis.get(indice))
                numerosSelecionados.add(indice);
        }
        return numerosSelecionados;
    }

    private void numeroEhValido ( int numeroSelecionado){
        if (numeroSelecionado < PRIMEIRO_NUMERO_VALIDO || numeroSelecionado > QUANTIDADE_NUMEROS_VALIDOS_POR_VOLANTE) {
            throw new IllegalArgumentException("O numero " + numeroSelecionado + " é inválido");
        }
    }

    private void quantidadeIdealNumerosSelecionados (int quantidadeNumerosEscolhidos) {
        if ((quantidadeNumerosEscolhidos != QUANTIDADE_MAXIMA_DE_NUMEROS_ESCOLHIDOS_POR_VOLANTE)) {
            throw new IllegalArgumentException("Quantidade de numeros escolhidos inválida. Escolha " +
                    QUANTIDADE_MAXIMA_DE_NUMEROS_ESCOLHIDOS_POR_VOLANTE +
                    " numeros válidos");
        }
    }

}
