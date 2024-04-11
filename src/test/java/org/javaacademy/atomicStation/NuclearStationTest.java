package org.javaacademy.atomicStation;

import lombok.SneakyThrows;
import org.javaacademy.atomicStation.department.ReactorDepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigInteger;

@SpringBootTest
@ActiveProfiles("france")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class NuclearStationTest {
    @Autowired
    NuclearStation nuclearStation;
    @Autowired
    ReactorDepartment reactorDepartment;

    @Test
    void incrementAccidentSuccess() {
        BigInteger expected = BigInteger.ONE;
        Assertions.assertEquals(expected, nuclearStation.incrementAccident(1));
    }

    @Test
    @SneakyThrows
    void runThrows() {
        BigInteger expected = new BigInteger("3620000000");
        nuclearStation.start(1);
        Assertions.assertEquals(expected, nuclearStation.getTotalGeneratedEnergy());

    }
}
