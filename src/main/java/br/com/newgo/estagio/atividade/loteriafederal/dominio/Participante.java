package br.com.newgo.estagio.atividade.loteriafederal.dominio;

public class Participante {

    private String nome;
    private String cpf;

    public Participante(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //TODO: consistencia de dados para não aceitar dados nulos nem invalidos

}
