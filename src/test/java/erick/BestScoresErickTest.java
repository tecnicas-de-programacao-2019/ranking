package erick;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BestScoresErickTest {

    @Test
    @DisplayName("Testa se o maxscores eh 10")
    public void maxscoresTest() {
        BestScoresErick best = new BestScoresErick();
        assertTrue(best.getMAXSCORES() == 10);
    }

    @Test
    @DisplayName("Testa adicionar um jogador a um placar ja lotado com um score baixo.")
    public void addJogadorNaoEntraNoPlacarTest() {
        BestScoresErick best = fill();
        boolean result = best.add("Joana", 3);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Testa adicionar um jogador a um placar ja lotado com um score alto.")
    public void addJogadorEntraNoPlacarTest() {
        BestScoresErick best = fill();
        boolean result = best.add("Joana", 99);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Teste passa por um placar cheio e verifica se esta ordenado")
    public void verificaOrdenacaoTest() {
        BestScoresErick best = fill();
        for (int i = 1; i < best.numRecords(); i++) {
            assertTrue(best.getScore(i-1) > best.getScore(i));
        }
    }

    @Test
    @DisplayName("Testa se um score grande vai para primeiro lugar")
    public void adicionaUmJogadorComMaiorScoreTest() {
        BestScoresErick best = fill();
        best.add("Joana", 9999);
        assertEquals(9999, best.bestScore());
        assertEquals(9999, best.getScore(0));
    }

    @Test
    @DisplayName("Testa se um score baixo vai para ultimo lugar")
    public void adicionaUmJogadorComPiorScoreTest() {
        BestScoresErick best = fill();
        best.add("Joana", 14);
        assertEquals(14, best.worstScore());
        assertEquals(14, best.getScore(best.numRecords()-1));
    }

    private BestScoresErick fill() {
        String[] nomes = { "Joao", "Marcos", "Carla", "Henrique", "Matheus", "Ana", "Lucas", "Pedro", "Marcela",
                "Felipe" };
        int[] scores = { 20, 22, 27, 13, 15, 16, 19, 21, 67, 34 };

        BestScoresErick best = new BestScoresErick();
        for (int i = 0; i < scores.length; i++) {
            best.add(nomes[i], scores[i]);
        }

        return best;
    }

}