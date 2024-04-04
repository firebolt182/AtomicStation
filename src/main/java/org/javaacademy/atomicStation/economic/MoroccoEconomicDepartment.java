package org.javaacademy.atomicStation.economic;

import java.math.BigDecimal;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    private final static long FIVE_BILLION = 5_000_000_000L;

    @Override
    public BigDecimal computeYearsIncome(long countElectricity) {
        if (countElectricity <= FIVE_BILLION) {
            return BigDecimal.valueOf(countElectricity * this.getPrice());
        }
        countElectricity -= FIVE_BILLION;
        BigDecimal beforeFive = BigDecimal.valueOf(FIVE_BILLION * this.getPrice());
        BigDecimal afterFive = BigDecimal.valueOf(countElectricity * (this.getPrice() + 1));
        return beforeFive.add(afterFive);
    }
}
