package org.javaacademy.atomicStation;

import java.math.BigInteger;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.atomicStation.department.ReactorDepartment;
import org.javaacademy.atomicStation.department.SecutiryDepartment;
import org.javaacademy.atomicStation.economic.EconomicDepartment;
import org.javaacademy.atomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.atomicStation.exceptions.ReactorWorkException;
import org.springframework.stereotype.Component;

/*
 * п.7 Атомная станция
 */
@Component
@Data
@Slf4j
public class NuclearStation {
    @NonNull
    private ReactorDepartment reactorDepartment;
    @NonNull
    private SecutiryDepartment secutiryDepartment;
    @NonNull
    private EconomicDepartment economicDepartment;
    private BigInteger totalGeneratedEnergy = BigInteger.ZERO;
    private BigInteger accidentCountAllTime = BigInteger.ZERO;

    private void startYear() {
        log.info("Атомная станция начала работу");
        BigInteger generatedEnergy = new BigInteger("0");
        for (int i = 0; i < 365; i++) {
            try {
                generatedEnergy = generatedEnergy.add(reactorDepartment.run());
                reactorDepartment.stop();
            } catch (ReactorWorkException | NuclearFuelIsEmptyException e) {
                log.warn(e.getMessage());
                log.warn("Внимание! Происходят работы на атомной станции! Электричества нет!");
            }
        }
        log.info("Атомная станция закончила работу."
                + " За год Выработано {} киловатт/часов\n", generatedEnergy);
        log.info("Количество инцидентов за год: " + secutiryDepartment.getCountAccidents());
        log.info("Доход за год составил {} {}\n",
                economicDepartment
                        .computeYearsIncome(Long.parseLong(String.valueOf(generatedEnergy)))
                        .toPlainString(),
                economicDepartment.getCurrency());
        secutiryDepartment.reset();
    }

    public void start(int year) {
        log.info("Действие происходит в стране: " + economicDepartment.getCountry());
        for (int i = 0; i < year; i++) {
            startYear();
        }
        log.info("Количество инцидентов за всю работу станции: " + accidentCountAllTime);
    }

    //2.1 Изменение поля accidentCountAllTime
    public void incrementAccident(int count) {
        accidentCountAllTime = accidentCountAllTime.add(new BigInteger(String.valueOf(count)));
    }
}
