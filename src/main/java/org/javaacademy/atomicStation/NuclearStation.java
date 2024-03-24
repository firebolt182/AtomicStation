package org.javaacademy.atomicStation;

import org.javaacademy.atomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.atomicStation.exceptions.ReactorWorkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * п.7 Атомная станция
 */
@Component
public class NuclearStation {
    private ReactorDepartment reactorDepartment;

    private BigInteger totalGeneratedEnergy;
    private BigInteger accidentCountAllTime;


    @Autowired
    public NuclearStation(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.totalGeneratedEnergy = new BigInteger("0");
    }

    private void startYear() {
        System.out.println("Атомная станция начала работу");
        BigInteger generatedEnergy = new BigInteger("0");
        for (int i = 0; i < 365; i++) {
            try {
                generatedEnergy = generatedEnergy.add(reactorDepartment.run());
                reactorDepartment.stop();
            } catch (ReactorWorkException | NuclearFuelIsEmptyException e) {
                System.out.println(e.getMessage());
                System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
            }
        }
        System.out.printf("Атомная станция закончила работу." +
                " За год Выработано %d киловатт/часов\n", generatedEnergy);
    }

    public void start(int year) {
        for (int i = 0; i < year; i++) {
            startYear();
        }
    }

    //2.1 Изменение поля accidentCountAllTime
    public void incrementAccident(int count) {
        accidentCountAllTime = accidentCountAllTime.add(new BigInteger(String.valueOf(count)));
    }
}
