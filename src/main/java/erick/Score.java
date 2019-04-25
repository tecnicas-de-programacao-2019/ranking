package erick;

import java.util.Objects;

public class Score {

    private final String name;
    private final int score;

    public Score(String name, int score) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be null");
        }

        if (score <= 0) {
            throw new IllegalArgumentException("Score must be greater than 0");
        }

        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score &&
            Objects.equals(name, score1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Score{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
    }
}