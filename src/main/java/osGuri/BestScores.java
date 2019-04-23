/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osGuri;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BestScores implements IBestScores {
    List<Jogador> ranking = new LinkedList();
    
    public class Jogador{
        String nome;
        int score;
        
        public Jogador(String nome, int score){
            this.nome=nome;
            this.score=score;
        }
        
    }
    
    
    @Override
    public int getMAXSCORES() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(String umNome, int umScore) {
         Jogador jogador = new Jogador(umNome,umScore);
         if (ranking.size() < 10){
             int i = 0;
             for (Jogador j : ranking){
                 
                 
                 i++;
             
             }
         }
         
         
                 
             
             
             
         }
         
         
         
         
    }}

    @Override
    public int numRecords() {
        return ranking.length;
    }

    @Override
    public int getScore(int i) {
        
    }

    @Override
    public int worstScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int bestScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
