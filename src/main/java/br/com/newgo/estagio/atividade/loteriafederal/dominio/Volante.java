package br.com.newgo.estagio.atividade.loteriafederal.dominio;

import java.util.List;
import java.util.Set;

public interface Volante {

    public void adicionarNumerosNoVolante(Set<Integer> numerosSelecionados);
    public void selecionarNumerosAleatorios();
    public List<Integer> retornarNumerosSelecionados();

}
