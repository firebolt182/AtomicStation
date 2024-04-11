package org.javaacademy.atomicStation;

import org.javaacademy.atomicStation.economic.MoroccoEconomicDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("morocco")
@DisplayName("Морроканский департамент")
public class MoroccoEconomicDepartmentTest {
    @Autowired
    MoroccoEconomicDepartment moroccoEconomicDepartment;

    @Test
    @DisplayName("Шесть миллиардов квт")
    void countSixBillionSuccess() {
        MoroccoEconomicDepartment moroccoEconomicDepartment = new MoroccoEconomicDepartment();
        moroccoEconomicDepartment.setPrice(5);
        long input = 6_000_000_000L;
        BigDecimal expected = new BigDecimal("3.10E+10");
        BigDecimal actual = moroccoEconomicDepartment.computeYearsIncome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Три миллиарда квт")
    void countThreeBillionSuccess() {
        MoroccoEconomicDepartment moroccoEconomicDepartment = new MoroccoEconomicDepartment();
        moroccoEconomicDepartment.setPrice(5);
        long input = 3_000_000_000L;
        BigDecimal expected = new BigDecimal("1.5E+10");
        BigDecimal actual = moroccoEconomicDepartment.computeYearsIncome(input);
        Assertions.assertEquals(expected, actual);
    }
}
