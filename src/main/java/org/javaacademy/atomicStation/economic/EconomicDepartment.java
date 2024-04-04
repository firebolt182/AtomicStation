package org.javaacademy.atomicStation.economic;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public abstract class EconomicDepartment {
    @Value("${COUNTRY_NAME}")
    private String country;
    @Value("${economicdepartment.currency}")
    private String currency;

    @Value("${economicdepartment.price}")
    @Setter
    private double price;

    public abstract BigDecimal computeYearsIncome(long countElectricity);
}
