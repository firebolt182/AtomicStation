package org.javaacademy.atomicStation;

import org.javaacademy.atomicStation.economic.EconomicDepartment;
import org.javaacademy.atomicStation.economic.FranceEconomicDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
@SpringBootTest
@ActiveProfiles("france")
@DisplayName("Французский департамент")
public class FranceEconomicDepartmentTest {

    @Autowired
    FranceEconomicDepartment franceEconomicDepartment;

    @Test
    @DisplayName("3 миллиарда квт")
    void countThreeBillionSuccess() {
        long input = 3_000_000_000L;
        BigDecimal expected = new BigDecimal("1485050000");
        BigDecimal actual = franceEconomicDepartment.computeYearsIncome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("5 миллиардов квт")
    void countFiveBillionSuccess() {
        long input = 5_000_000_000L;
        BigDecimal expected = new BigDecimal("2450497505.0");
        BigDecimal actual = franceEconomicDepartment.computeYearsIncome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("1 миллиард квт")
    void countOneBillionSuccess() {
        long input = 1_000_000_000L;
        BigDecimal expected = new BigDecimal("500000000");
        BigDecimal actual = franceEconomicDepartment.computeYearsIncome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Имя страны")
    void nameSuccess() {
        String expected = "Франция";
        String actual = franceEconomicDepartment.getCountry();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Наименование валюты")
    void currencySuccess() {
        String expected = "евро";
        String actual = franceEconomicDepartment.getCurrency();
        Assertions.assertEquals(expected, actual);
    }
}
