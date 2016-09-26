package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import models.Jogador;

public class ListaJogadores {
    Map<String, Jogador> listaJogadores = new HashMap<String, Jogador>();

    public void addJogador(Jogador jogador){
        this.getLista().put(jogador.getNomeJogador(), jogador);
    }

    public void addAssassinato(String nomeJogador, String nomeArma) {
        if(this.getLista().get(nomeJogador) != null){
            this.getLista().get(nomeJogador).addAssassinato(nomeArma);
        } else {
            this.addJogador(new Jogador(nomeJogador));
            this.getLista().get(nomeJogador).addAssassinato(nomeArma);
        }
    }

    public void addMorte(String nomeJogador) {
        if(this.getLista().get(nomeJogador) != null){
            this.getLista().get(nomeJogador).addMorte();
        } else {
            this.addJogador(new Jogador(nomeJogador));
            this.getLista().get(nomeJogador).addMorte();
        }
    }

    public Entry<String, Jogador> getVencedor(){
        Entry<String, Jogador> vencedor = null;
        for(Entry<String, Jogador> jogador : this.getLista().entrySet()) {
            if (vencedor == null || jogador.getValue().getAssassinatos() > vencedor.getValue().getAssassinatos()) {
                vencedor = jogador;
            }
        }

        return vencedor;
    }

    public Entry<String, Jogador> getMaiorKillStreak() {
        Entry<String, Jogador> maiorKillStreak = null;

        for(Entry<String, Jogador> jogador : this.getLista().entrySet()) {
            if (maiorKillStreak == null || jogador.getValue().getMaiorKillStreak() > maiorKillStreak.getValue().getMaiorKillStreak()) {
                maiorKillStreak = jogador;
            }
        }

        return maiorKillStreak;
    }

    /**
     * @return the listaJogadores
     */
    public Map<String, Jogador> getLista() {
        return listaJogadores;
    }

    /**
     * @param listaJogadores the listaJogadores to set
     */
    public void setLista(Map<String, Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

}