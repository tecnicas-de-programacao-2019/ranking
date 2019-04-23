//@ instance invariant numRecords()>=0 && numRecords()<=getMAXSCORES();
  //@ instance invariant numRecords()>0 ==> (worstScore() == (\min int i; 0<=i && i<numRecords(); getScore(i)));
  //@ instance invariant numRecords()>0 ==> (bestScore() == (\max int i; 0<=i && i<numRecords(); getScore(i)));
  //@ instance invariant (\forall int i,j;i<=0 && i<j && j<numRecords();getScore(i) <= getScore(j));