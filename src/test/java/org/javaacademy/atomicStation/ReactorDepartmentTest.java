package org.javaacademy.atomicStation;

import org.javaacademy.atomicStation.department.ReactorDepartment;
import org.javaacademy.atomicStation.department.SecutiryDepartment;
import org.javaacademy.atomicStation.economic.EconomicDepartment;
import org.javaacademy.atomicStation.economic.FranceEconomicDepartment;
import org.javaacademy.atomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.atomicStation.exceptions.ReactorWorkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("france")
@DisplayName("Реакторный цех")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ReactorDepartmentTest {
    @Autowired
    ReactorDepartment reactorDepartment;

    @Test
    @DisplayName("Успешный запуск")
    void runSuccess() {
        Assertions.assertDoesNotThrow(() -> reactorDepartment.run());
    }

    @Test
    @DisplayName("Тест ошибки при включении и выключении реактора")
    void runWorkFail() {
        Assertions.assertThrows(ReactorWorkException.class, () -> reactorDepartment.stop());
        reactorDepartment.setWork(true);
        Assertions.assertThrows(ReactorWorkException.class, () -> reactorDepartment.run());


    }

    @Test
    @DisplayName("Тест ошибки при сотом запуске")
    void runCountFail() {
        reactorDepartment.setStartCount(100);
        Assertions.assertThrows(NuclearFuelIsEmptyException.class, () -> reactorDepartment.run());
    }
}
