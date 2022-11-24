package br.com.newgo.estagio.atividade.loteriafederal.dominio;

public class Aposta {

    private String identificador;
    private Participante participante;
    private Volante volante;

    public Aposta(String identificador, Participante participante) {
        setIdentificador(identificador);
        setParticipante(participante);
        setVolante(volante);
    }

    public String getIdentificador() {
        return identificador;
    }

    private void setIdentificador (String identificador){
        this.identificador = identificador;
    }

    public Participante getParticipante () {
        return participante;
    }

    private void setParticipante (Participante participante){
        this.participante = participante;
    }

    private void setVolante(Volante volante){
        this.volante = volante;
    }

    public Volante getVolante(){
        return volante;
    }

}
