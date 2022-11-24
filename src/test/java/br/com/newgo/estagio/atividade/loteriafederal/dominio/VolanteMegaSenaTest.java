package br.com.newgo.estagio.atividade.loteriafederal.dominio;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class VolanteMegaSenaTest {

    @Test(expected = IllegalArgumentException.class)
    public void adicionarMaisNumerosNoVolanteTeste() {
        Set<Integer> numerosAposta1 = new HashSet<Integer>();
        numerosAposta1.add(1);
        numerosAposta1.add(7);
        numerosAposta1.add(9);
        numerosAposta1.add(25);
        numerosAposta1.add(42);
        numerosAposta1.add(57);
        numerosAposta1.add(59);

        Volante volanteP1 = new VolanteMegaSena();
        volanteP1.adicionarNumerosNoVolante(numerosAposta1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void adicionarMenosNumerosNoVolanteTeste() {
        Set<Integer> numerosAposta1 = new HashSet<Integer>();
        numerosAposta1.add(1);
        numerosAposta1.add(7);
        numerosAposta1.add(9);
        numerosAposta1.add(25);
        numerosAposta1.add(42);

        Volante volanteP1 = new VolanteMegaSena();
        volanteP1.adicionarNumerosNoVolante(numerosAposta1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void adicionarNumeroInvalidoNoVolanteTeste() {
        Set<Integer> numerosAposta1 = new HashSet<Integer>();
        numerosAposta1.add(1);
        numerosAposta1.add(7);
        numerosAposta1.add(9);
        numerosAposta1.add(25);
        numerosAposta1.add(42);
        numerosAposta1.add(65);

        Volante volanteP1 = new VolanteMegaSena();
        volanteP1.adicionarNumerosNoVolante(numerosAposta1);
    }


}