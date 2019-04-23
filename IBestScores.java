public interface IBestScores {
    /*@ pure @*/int getMAXSCORES();

    /*@
      @ requires umScore > 0 && umNome != null && umNome.length() > 0;
      @ requires numRecords() == getMAXSCORES() && umScore <= worstScore();
    @ ensures numRecords() == \old(numRecords());
    @ ensures umScore < worstScore)() ==> !(\exists int i; 0<=i && i<numRecords(); umScore == getScore(i));
    @ ensures (\forall int i,j; i<=0 && i<j && j<numRecords();getScore(i) <= getScore(j));
      @ ensures \result == false;
      @ also
      @ requires umScore > 0 && umNome != null && umNome.length() > 0;
      @ requires numRecords() < getMAXSCORES();
      @ ensures numRecords() == \old(numRecords()) + 1;
    @ ensures (\forall int i,j; i<=0 && i<j && j<numRecords();getScore(i) <= getScore(j));
    @ ensures (\exists int i; 0<=i && i<numRecords(); umScore == getScore(i));
    @ ensures \result == true;
      @ also
      @ requires umScore > 0 && umNome != null && umNome.length() > 0;
      @ requires numRecords() == getMAXSCORES() && umScore > worstScore();
      @ ensures numRecords() == \old(numRecords());
    @ ensures (\forall int i,j; i<=0 && i<j && j<numRecords();getScore(i) <= getScore(j));
    @ ensures (\exists int i; 0<=i && i<numRecords(); umScore == getScore(i));
    @ ensures !(\exists int i; 0<=i && i<numRecords(); \old(worstScore()) == getScore(i));
      @ ensures \result == true;
      @*/
    boolean add(String umNome,int umScore);

    //@ ensures \result >= 0 && \result <= getMAXSCORES();
    /*@ pure @*/ int numRecords();

    //@ requires numRecords() > 0;
    //@ requires i>=0 && i<numRecords();
    //@ ensures \result >= 0;
    /*@ pure @*/ int getScore(int i);

    //@ requires numRecords() > 0;
    //@ ensures \result == (\min int i; 0<=i && i<numRecords(); getScore(i));
    /*@ pure @*/ int worstScore();

    //@ requires numRecords() > 0;
    //@ ensures \result == (\max int i; 0<=i && i<numRecords(); getScore(i));
    /*@ pure @*/ int bestScore();
}
