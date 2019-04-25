/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;



public class BestScores implements IBestScores, Comparable<Jogador> {
    public class Jogador implements Comparable<Jogador> {

        String nome;
        int score;

        public Jogador(String nome, int score){
            this.nome = nome;
            this.score = score;
        }

        public int compareTo(Jogador j){
            if (this.score > j.score)
                return -1;

            
            else
                return 1;
        }

        

    }


 

    public List<Jogador> ranking;

    public BestScores(){
        ranking = new LinkedList<Jogador>();
    }
    
    @Override
    public int numRecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getScore(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int worstScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int bestScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    @Override
    public int getMAXSCORES() {
        return 10;
    }

    @Override
    public boolean add(String umNome, int umScore) {
        Jogador jogador = new Jogador(umNome, umScore);
        ranking.add(jogador);
        Collections.sort(ranking);         
        return true;
    }

       




    public void imprime(){
        for (Jogador j : ranking){
            System.out.println(j.nome);

        }

    }

   public static void main(String[] args){
       BestScores placar = new BestScores();
       placar.add("Ryan", 10);
       placar.add("Jose", 20);    
       placar.add("Bred", 40);
       placar.add("Silvio", 30);    
       placar.add("Greg", 500);
       placar.add("Will", 5);    
       placar.imprime();
       System.out.println(placar.ranking.size());

   }

}
