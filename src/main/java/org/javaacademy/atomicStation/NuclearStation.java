package org.javaacademy.atomicStation;

import lombok.Getter;
import lombok.Setter;
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
    private SecutiryDepartment secutiryDepartment;

    private BigInteger totalGeneratedEnergy;
    @Getter
    @Setter
    private BigInteger accidentCountAllTime = new BigInteger("0");


    @Autowired
    public NuclearStation(ReactorDepartment reactorDepartment, SecutiryDepartment secutiryDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.secutiryDepartment = secutiryDepartment;
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
        System.out.println("Количество инцидентов за год: " + secutiryDepartment.getCountAccidents());
        secutiryDepartment.reset();
    }

    public void start(int year) {
        for (int i = 0; i < year; i++) {
            startYear();
        }
        System.out.println("Количество инцидентов за всю работу станции: " + accidentCountAllTime);
    }

    //2.1 Изменение поля accidentCountAllTime
    public void incrementAccident(int count) {
        accidentCountAllTime = accidentCountAllTime.add(new BigInteger(String.valueOf(count)));
    }
}
