package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;

import controllers.ListaJogadores;

public class Partida {
    Date dataInicio, dataFim;
    String idPartida;
    ListaJogadores listaJogadores = new ListaJogadores();

    public Partida(){
    }

    public Partida(String idPartida, Date dataInicio){
        this.setIdPartida(idPartida);
        this.setDataInicio(dataInicio);
    }

    public void addAssasinatoJogador(String nomeJogador, String nomeArma) {
        listaJogadores.addAssassinato(nomeJogador, nomeArma);
    }

    public void addMorteJogador(String nomeJogador) {
        listaJogadores.addMorte(nomeJogador);
    }

    public Entry<String, Jogador> getVencedor() {
        return listaJogadores.getVencedor();
    }

    public Entry<String, Jogador> getMaiorKillStreak() {
        return listaJogadores.getMaiorKillStreak();
    }

    /**
     * @return the idPartida
     */
    public String getIdPartida() {
        return idPartida;
    }
    /**
     * @param idPartida the idPartida to set
     */
    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the listaJogadores
     */
    public ListaJogadores getListaJogadores() {
        return listaJogadores;
    }

    /**
     * @param listaJogadores the listaJogadores to set
     */
    public void setListaJogadores(ListaJogadores listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

}