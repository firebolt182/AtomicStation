package org.javaacademy.atomicStation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class SecutiryDepartment {
    private NuclearStation nuclearStation;
    private BigInteger accidentCountPeriod = new BigInteger("0");

    @Autowired
    @Lazy
    public SecutiryDepartment(NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

    public void addAccident() {
        accidentCountPeriod = accidentCountPeriod.add(BigInteger.ONE);
    }

    public BigInteger getCountAccidents() {
        return accidentCountPeriod;
    }

    public void reset() {
        nuclearStation.setAccidentCountAllTime(nuclearStation.getAccidentCountAllTime()
                .add(accidentCountPeriod));
        accidentCountPeriod = BigInteger.ZERO;
    }
}
