package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Jogador {
    String nomeJogador;
    Integer	assassinatos, mortes, killStreakAtual, maiorKillStreak, awards;
    Map<String,Integer> armasUsadas = new HashMap<String,Integer>();

    public Jogador( String nomeJogador ){
        this.setNomeJogador(nomeJogador);
        this.setAssassinatos(0);
        this.setMortes(0);
        this.setKillStreakAtual(0);
        this.setMaiorStreak(0);
        this.setAwards(0);
    }

    /**
     * @return the nickname
     */
    public String getNomeJogador() {
        return nomeJogador;
    }
    /**
     * @param nickname the nickname to set
     */
    public void setNomeJogador(String nickname) {
        this.nomeJogador = nickname;
    }
    /**
     * @return the assassinatos
     */
    public Integer getAssassinatos() {
        return assassinatos;
    }
    /**
     * @param assassinatos the assassinatos to set
     */
    public void setAssassinatos(Integer assassinatos) {
        this.assassinatos = assassinatos;
    }
    /**
     * @return the mortes
     */
    public Integer getMortes() {
        return mortes;
    }
    /**
     * @param mortes the mortes to set
     */
    public void setMortes(Integer mortes) {
        this.mortes = mortes;
    }
    /**
     * @return the killStreakAtual
     */
    public Integer getKillStreakAtual() {
        return killStreakAtual;
    }
    /**
     * @param killStreakAtual the killStreakAtual to set
     */
    public void setKillStreakAtual(Integer killStreakAtual) {
        this.killStreakAtual = killStreakAtual;
    }
    /**
     * @return the awards
     */
    public Integer getAwards() {
        return awards;
    }
    /**
     * @param awards the awards to set
     */
    public void setAwards(Integer awards) {
        this.awards = awards;
    }
    /**
     * @return the armasUsadas
     */
    public Map<String, Integer> getArmasUsadas() {
        return armasUsadas;
    }
    /**
     * @param armasUsadas the armasUsadas to set
     */
    public void setArmasUsadas(Map<String, Integer> armasUsadas) {
        this.armasUsadas = armasUsadas;
    }

    public void addAssassinato(String nomeArma) {
        this.setAssassinatos(this.getAssassinatos() + 1);
        this.addKillStreak();

        if( this.getArmasUsadas().get(nomeArma) != null ){
            this.getArmasUsadas().put(nomeArma, this.getArmasUsadas().get(nomeArma)	+ 1);
        } else {
            this.getArmasUsadas().put(nomeArma, 1);
        }

    }

    private void addKillStreak() {
        this.setKillStreakAtual(this.getKillStreakAtual() + 1);

        if ( this.getKillStreakAtual() > this.getMaiorKillStreak() ){
            this.setMaiorStreak(this.getKillStreakAtual());
        }
    }

    public void addMorte() {
        this.setMortes(this.getMortes() + 1);

        this.setKillStreakAtual(0);
    }

    public String getArmaPreferida(){
        Entry<String, Integer> maiorNumeroAssassinatos = null;
        for(Entry<String, Integer> arma : this.getArmasUsadas().entrySet()) {
            if (maiorNumeroAssassinatos == null || arma.getValue() > maiorNumeroAssassinatos.getValue()) {
                maiorNumeroAssassinatos = arma;
            }
        }

        return maiorNumeroAssassinatos.getKey();
    }

    /**
     * @return the maiorKillStreak
     */
    public Integer getMaiorKillStreak() {
        return maiorKillStreak;
    }

    /**
     * @param maiorKillStreak the maiorKillStreak to set
     */
    public void setMaiorStreak(Integer maiorKillStreak) {
        this.maiorKillStreak = maiorKillStreak;
    }



}