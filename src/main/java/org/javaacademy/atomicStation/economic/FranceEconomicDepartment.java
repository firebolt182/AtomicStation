package org.javaacademy.atomicStation.economic;

import java.math.BigDecimal;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("france")
public class FranceEconomicDepartment extends EconomicDepartment {
    private final static long BILLION = 1_000_000_000L;

    @Override
    public BigDecimal computeYearsIncome(long countElectricity) {
        BigDecimal income = BigDecimal.ZERO;
        if (countElectricity > BILLION) {
            return multiplyHigherThanBillion(countElectricity, income);
        }
        income = income.add(BigDecimal.valueOf(countElectricity * this.getPrice()));
        return income;
    }

    private BigDecimal multiplyHigherThanBillion(long countElectricity, BigDecimal income) {
        BigDecimal incomeFromBillion = BigDecimal.valueOf(BILLION * this.getPrice());
        income = income.add(incomeFromBillion);
        countElectricity -= BILLION;
        long count = (countElectricity / BILLION);
        while (countElectricity >= BILLION) {
            income = income.add(multiplyTemporary(count, incomeFromBillion));
            countElectricity -= BILLION;
            count--;
        }
        return income;
    }

    private BigDecimal multiplyTemporary(long count, BigDecimal incomeFromBillion) {
        for (int i = 0; i < count; i++) {
            incomeFromBillion = incomeFromBillion.multiply(BigDecimal.valueOf(0.99));
        }
        return incomeFromBillion;
    }
}
