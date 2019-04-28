/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class BestScores implements IBestScores{
    public class Jogador implements Comparable<Jogador> {

        private String nome;
        private int score;

        public Jogador(String nome, int score){
            this.nome = nome;
            this.score = score;
        }

        public int compareTo(Jogador j){
            if (this.score > j.score)
                return 1;

            
            else
                return -1;
        }

        

    }


 

    private List<Jogador> ranking;

    public BestScores(){
        ranking = new LinkedList<Jogador>();
    }
    
    @Override
    public int numRecords() {
        int i=0;
        for (Jogador j : ranking){
            i++;
        }
        if (i>10)
            i=10;
        return i;

    }

    @Override
    public int getScore(int i) {
        if (i<0 || i> this.numRecords() || i>10)
            return -1;
        return ranking.get(i).score;
    }

    @Override
    public int worstScore() {
        if (ranking.size()==0) return -1;
        return ranking.get(this.numRecords()-1).score;
    }

    @Override
    public int bestScore() {
       if (ranking.size()==0) return -1;
        return ranking.get(0).score;
    }

    
    

    @Override
    public int getMAXSCORES() {
        return 10;
    }

    @Override
    public boolean add(String umNome, int umScore) {
        Jogador jogador = new Jogador(umNome, umScore);
        ranking.add(jogador);
        Collections.sort(ranking, new Comparator<Jogador>() {
            public int compare(Jogador s1, Jogador s2) {
                return s1.compareTo(s2);
            }
        }); 
        if (worstScore() > umScore)
            return false;
        return true;
    }

       




    public void imprime(){
        for (Jogador j : ranking){
            System.out.println("Nome: " + j.nome + "         Score: " + j.score);

        }

    }

}
