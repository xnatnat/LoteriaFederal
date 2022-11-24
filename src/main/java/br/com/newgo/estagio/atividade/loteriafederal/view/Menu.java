package br.com.newgo.estagio.atividade.loteriafederal.view;

import br.com.newgo.estagio.atividade.loteriafederal.dominio.Participante;
import br.com.newgo.estagio.atividade.loteriafederal.dominio.Sorteio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Sorteio> sorteios = new ArrayList<>();
    Integer idUltimoSorteio = 0;
    protected String getMainMenu(){
        return "Digite a opcao desejada:\n" +
                "\t1 - Iniciar novo sorteio\n" +
                "\t2 - Gerenciar sorteio atual\n" +
                "\t3 - Visualizar sorteios anteriores\n" +
                "\t9 - Sair do programa";
    }

    protected String getMenuSorteio(int idSorteio){
        return "\nSorteio " + idSorteio + "\n" +
                "\t1 - Adicionar nova aposta\n" +
                "\t2 - Ver apostas\n" +
                "\t3 - Realizar Sorteio\n" +
                "\t4 - Verificar vencedores\n" +
                "\t9 - Voltar ao menu principal";
    }

    protected String getMenuAdicionarAposta(){
        return "\nSorteio " + idUltimoSorteio + "\n" +
                "\t1 - Adicionar nova aposta\n" +
                "\t2 - Ver apostas\n" +
                "\t3 - Realizar Sorteio\n" +
                "\t4 - Verificar vencedores\n" +
                "\t9 - Voltar ao menu principal";
    }

    protected String getMenuSolicitarNomeParticipante(){
        return "\nDados do participante\n" +
                "\tDigite seu nome:_";
    }

    protected String getMenuSolicitarCpfParticipante(String nomeParticipante){
        return "\nDados do participante\n" +
                "\t\tNome do participante: " + nomeParticipante +
                "\n\n\tDigite seu cpf:_";
    }

    protected String getMenuConfirmarDadosParticipante(String nomeParticipante, String cpfParticipante){
        return "\nDados do participante" +
                "\t\tNome do participante: " + nomeParticipante +
                "\n\t\tCPF do participante: " + cpfParticipante +
                "\n\n\t1 - Confirmar" +
                "\n\t2 - Corrigir dados" +
                "\n\t3 - Voltar ao menu principal";
    }

    protected String getMenuSelecionarNumerosNoVolante(String nomeParticipante, int qtdNumerosSelecionados, int... numerosSelecionados){
        String retorno =  "\nOla " + nomeParticipante +
                "\n\nVolante\n\t\t";
                for(Integer numeroParticipante = 1; numeroParticipante<=60; numeroParticipante++ ){
                    if(Arrays.asList(numerosSelecionados).contains(numeroParticipante))
                        retorno += "[XX]";
                    else if(numeroParticipante <=9)
                        retorno += "[0" + numeroParticipante +"]";
                    else
                        retorno += "[" + numeroParticipante + "]";

                    if(numeroParticipante == 10 || numeroParticipante == 20 || numeroParticipante == 30 || numeroParticipante == 40 || numeroParticipante == 50)
                        retorno += "\n\t\t";

                }
        return retorno += "\n\n\n\nDigite " + ++qtdNumerosSelecionados + "° numero a selecionar:_ ";
    }

    protected String getMenuConfirmarVolante(String nomeParticipante, int qtdNumerosSelecionados, int[] numerosSelecionados){
        String retorno =  "\nOla " + nomeParticipante +
                "\n\nVolante\n\t\t";
        for(int numeroParticipante = 1; numeroParticipante<=60; numeroParticipante++ ){
            if(Arrays.asList(numerosSelecionados).contains(numeroParticipante))
                retorno += "[XX]";
            else if(numeroParticipante <=9)
                retorno += "[0" + numeroParticipante +"]";
            else
                retorno += "[" + numeroParticipante + "]";

            if(numeroParticipante == 10 || numeroParticipante == 20 || numeroParticipante == 30 || numeroParticipante == 40 || numeroParticipante == 50)
                retorno += "\n\t\t";

        }
        return retorno += "\n\n\n\n\t1 - Confirmar aposta" +
                                    "\n\t2 - Corrigir aposta" +
                                    "\n\t9 - Voltar ao menu principal";
    }

    public void executeMainMenu(){
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        do{
            try {
                System.out.println(getMainMenu());
                opcao = Integer.parseInt(scan.nextLine());

                switch (opcao) {
                    case 1:
                        novoSorteio();
                    case 2:
                        executeMenuSorteio(idUltimoSorteio);
                    case 3 :
                        System.out.println("Visualizar sorteios anteriores");

                    case 9 :
                        System.out.println("Agradecemos a utilizacao do sistema!!! Volte sempre!!!");

                    default :
                        throw new Exception("Opcao invalida!!!");
                }
            }catch(Exception e){
                System.out.println("Digite uma opcao valida!!!");
            }

        }while(opcao != 9);
    }


    public void executeMenuSorteio(Integer idSorteio){
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        do{
            try {
                System.out.println(getMenuSorteio(idSorteio));
                opcao = Integer.parseInt(scan.nextLine());

                switch (opcao) {

                    case 1 -> {
                        executeMenuSolicitarDadosParticipante();
                        getMenuAdicionarAposta();
                    }
                    case 2 -> System.out.println("Realizar Sorteio");
                    case 3 -> System.out.println("Verificar vencedores");
                    case 4 -> System.out.println("Voltar ao menu principal");
                    case 9 -> {}
                    default -> throw new Exception("Opcao invalida!!!");
                }
            }catch(Exception e){
                System.out.println("Digite uma opcao valida!!!");
            }

        }while(opcao != 9);
    }

    public void executeMenuSolicitarDadosParticipante(){
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        System.out.println(getMenuSolicitarNomeParticipante());
        //TODO: usar regex para verificar se a entrada para o nome tem apenas caracteres A-Z
        String nomeParticipante = scan.nextLine();
        System.out.println(getMenuSolicitarCpfParticipante(nomeParticipante));
        //TODO: validar cpf
        String cpfParticipante = scan.nextLine();
        System.out.println(getMenuConfirmarDadosParticipante(nomeParticipante,cpfParticipante));

        do{
            try {
                opcao = Integer.parseInt(scan.nextLine());

                switch (opcao) {
                    case 1: executeMenuVolante(new Participante(nomeParticipante, cpfParticipante));
                    case 2: executeMenuSolicitarDadosParticipante();
                    case 9: break;
                    default: throw new Exception("Opcao invalida!!!");
                }
            }catch(Exception e){
                System.out.println("Digite uma opcao valida!!!");
            }

        }while(opcao != 9);
    }

    public void executeMenuVolante(Participante participante){
        Scanner scan = new Scanner(System.in);
        int opcao = 0, qtdNumerosSelecionados = 0;
        int[] numerosSelecionados = new int[6];

        do{
            try {
                for(int posicoesVetor: numerosSelecionados) {
                    System.out.println(getMenuSelecionarNumerosNoVolante(participante.getNome(), qtdNumerosSelecionados, numerosSelecionados));
                    numerosSelecionados[qtdNumerosSelecionados++] = Integer.parseInt(scan.nextLine());
                }
                System.out.println(getMenuConfirmarVolante(participante.getNome(), qtdNumerosSelecionados, numerosSelecionados));
                opcao = Integer.parseInt(scan.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.println("Aposta confirmada");
                    case 2: executeMenuVolante(participante);
                    case 9: executeMainMenu();
                    default: throw new Exception("Opcao invalida!!!");
                }
            }catch(Exception e){
                System.out.println("Digite uma opcao valida!!!");
            }

        }while(qtdNumerosSelecionados < 6);
    }


    public void novoSorteio(){
        idUltimoSorteio++;
        sorteios.add(new Sorteio(idUltimoSorteio.toString()));
    }
}