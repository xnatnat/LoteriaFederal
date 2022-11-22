package br.com.newgo.estagio.atividade.loteriafederal.dominio;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GeradorInteirosNaoRepetidosOrdenados {

    public Set<Integer> gerar(int ultimoInteiroValido, int quantidadeInteirosARetornar){

        Set<Integer> inteirosGerados = new TreeSet<>();
        Random random = new Random();

        while(inteirosGerados.size() != quantidadeInteirosARetornar){
            int inteiroGerado =  random.nextInt(ultimoInteiroValido + 1);
            if(!inteiroEhZero(inteiroGerado))
                inteirosGerados.add(inteiroGerado);
        }
        return inteirosGerados;
    }

    private boolean inteiroEhZero(int inteiro){
        return inteiro == 0;
    }

}
