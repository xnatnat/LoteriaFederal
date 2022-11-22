package br.com.newgo.estagio.atividade.loteriafederal;

import br.com.newgo.estagio.atividade.loteriafederal.dominio.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("Criando sorteio...");
        Sorteio sorteio = new Sorteio("Sorteio n 1");
        System.out.println(sorteio.getIdentificador() + " criado!");

        Participante participante1 = new Participante("Nichola", "12345678910");

        Set<Integer> numerosAposta1 = new HashSet<Integer>();
        numerosAposta1.add(1);
        numerosAposta1.add(7);
        numerosAposta1.add(9);
        numerosAposta1.add(25);
        numerosAposta1.add(42);
        numerosAposta1.add(57);

        Volante volanteP1 = new VolanteMegaSena();
        volanteP1.adicionarNumerosNoVolante(numerosAposta1);

        Participante participante2 = new Participante("Marie", "12345678911");

        Set<Integer> numerosAposta2 = new HashSet<Integer>();
        numerosAposta2.add(3);
        numerosAposta2.add(19);
        numerosAposta2.add(22);
        numerosAposta2.add(38);
        numerosAposta2.add(49);
        numerosAposta2.add(60);

        Volante volanteP2 = new VolanteMegaSena();
        volanteP2.adicionarNumerosNoVolante(numerosAposta2);

        Participante participante3 = new Participante("Rene", "12345678912");
        Volante volanteP3 = new VolanteMegaSena();
        volanteP3.selecionarNumerosAleatorios();

        System.out.println();
        System.out.println();
        System.out.println("Adicionando apostas no sorteio...");
        Aposta aposta1 = new Aposta("Aposta n 1",
                                                participante1,
                                                volanteP1);
        sorteio.adicionarAposta(aposta1);
        System.out.println(aposta1.getIdentificador() + " adicionada!");

        Aposta aposta2 = new Aposta("Aposta n 2",
                participante2,
                volanteP2);
        sorteio.adicionarAposta(aposta2);
        System.out.println(aposta2.getIdentificador() + " adicionada!");

        Aposta aposta3 = new Aposta("Aposta n 3",
                participante3,
                volanteP3);
        sorteio.adicionarAposta(aposta3);
        System.out.println(aposta3.getIdentificador() + " adicionada!");

        System.out.println();
        System.out.println();

        System.out.println("Volantes participantes: ");

        for(Aposta aposta: sorteio.getApostasParticipantes()){
            System.out.println(aposta.getVolante().retornarNumerosSelecionados());
        }

        System.out.println();
        System.out.println();

        System.out.println("Realizando sorteio...");
        sorteio.getApostasGanhadoras();
        sorteio.realizarSorteio(new VolanteMegaSena());

        System.out.println("Numeros sorteados: " + sorteio.getNumerosSorteados());

        System.out.println();
        System.out.println("Possui ganhadores? " + sorteio.possuiGanhadores());

        sorteio.calcularPremio(new PremioMegaSena());
        System.out.println();

        if(sorteio.possuiGanhadores()){
            System.out.println("Premio total do sorteio:  " + sorteio.getPremioTotal());
            System.out.println("Premio total por ganhador:  " + sorteio.getPremioPorGanhador());
        }
        else
            System.out.println("Premio total do sorteio:  " + sorteio.getPremioTotal());
    }
}