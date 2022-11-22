package br.com.newgo.estagio.atividade.loteriafederal.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sorteio {

    private String identificador;
    private List<Integer> numerosSorteados;
    private Set<Aposta> apostasParticipantes;
    private PremioMegaSena premio;

    public Sorteio(String identificador){
        setIdentificador(identificador);
        apostasParticipantes = new HashSet<>();
    }

    public void adicionarAposta(Aposta aposta) {
        apostaEstaRegistrada(aposta);
        apostasParticipantes.add(aposta);
    }

    private void apostaEstaRegistrada(Aposta aposta){
        if(apostasParticipantes.contains(aposta))
            throw new IllegalArgumentException("Aposta já registrada");
    }

    public void realizarSorteio(Volante volante){
        Volante volantePremiado = volante;
        volantePremiado.selecionarNumerosAleatorios();
        numerosSorteados = volantePremiado.retornarNumerosSelecionados();
    }

    public boolean possuiGanhadores() {
         return getApostasGanhadoras().size() > 0;
    }

    public List<Aposta> getApostasGanhadoras() {
        List<Aposta> apostasGanhadoras = new ArrayList<Aposta>();
//        return apostasParticipantes
//                          .stream()
//                          filter(cadaAposta -> numerosSorteados.equals(cadaAposta.getVolante().retornarNumerosSelecionados()))
//                          .collect(Collectors.toList());
        for(Aposta aposta: apostasParticipantes) {
            if(numerosSorteados.equals(
                    aposta.getVolante().retornarNumerosSelecionados()))
                apostasGanhadoras.add(aposta);
        }
        return apostasGanhadoras;
    }

    public void calcularPremio(PremioMegaSena premioAtual) {
        this.premio = premioAtual;
        premio.calcularPremio(apostasParticipantes.size(), getApostasGanhadoras().size());
    }

    public String getIdentificador() {
        return identificador;
    }
    private void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public double getPremioTotal() {
        return premio.getValorPremioTotal();
    }

    public double getPremioPorGanhador() {
        return premio.getValorPremioPorGanhador();
    }

    public Set<Aposta> getApostasParticipantes() {
        return apostasParticipantes;
    }

    public List<Integer> getNumerosSorteados(){
        return numerosSorteados;
    }
}
