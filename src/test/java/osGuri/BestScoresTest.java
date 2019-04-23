package osGuri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BestScoresTest {
    
    @DisplayName("Testa adicionar jogadores no placar")
    @ParameterizedTest
    @CsvSource({ "Joao, 10, true", "Marcos, 7, true", "Felipe, 8, true", "Henrique, 11, true", "Carlos, 15, true",
    "Jon, 20, true", "Luis, 13, true", "Jade, 8, true", "Marcondes, 18, true", "Moana, 46, true", "Jonatan, 3, false" })
    public void adicionarJogadorTest(String nome, int score, boolean resultEsperado) {
        BestScores best = new BestScores();
        boolean result = best.add(nome, score);
        assertEquals(resultEsperado, result);
    }

}