/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erick;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestScoresErick implements IBestScores {

    private static final int MAXSCORES = 10;

    private List<Score> scores = new ArrayList<>(MAXSCORES);

    @Override
    public int getMAXSCORES() {
        return MAXSCORES;
    }

    @Override
    public boolean add(String umNome, int umScore) {
        if (numRecords() == MAXSCORES) {
            if (worstScore() > umScore) return false;
            scores.remove(MAXSCORES - 1);
        }
        scores.add(new Score(umNome, umScore));
        scores.sort(Comparator.comparingInt(Score::getScore).reversed());
        return true;
    }

    @Override
    public int numRecords() {
        return scores.size();
    }

    @Override
    public int getScore(int i) {
        if (i < 0 || i > scores.size()) {
            throw new IllegalArgumentException("Invalid score index.");
        }
        return scores.get(i).getScore();
    }

    @Override
    public int worstScore() {
        ensureNotEmpty();
        return scores.get(scores.size() - 1).getScore();
    }

    @Override
    public int bestScore() {
        ensureNotEmpty();
        return scores.get(0).getScore();
    }

    private void ensureNotEmpty() {
        if (scores.isEmpty()) {
            throw new IllegalStateException("Ranking is empty");
        }
    }
    
}
