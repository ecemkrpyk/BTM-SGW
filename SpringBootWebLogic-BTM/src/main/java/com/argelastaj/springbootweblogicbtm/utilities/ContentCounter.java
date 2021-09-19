package com.argelastaj.springbootweblogicbtm.utilities;

public interface ContentCounter {

    void incrementRequestCount(Integer CpId, Integer count);
    Integer getPreviousTimeCount(Integer CpID);
}

