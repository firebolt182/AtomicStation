package org.javaacademy.atomicStation;

import org.javaacademy.atomicStation.department.SecutiryDepartment;
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
public class SecurityDepartmentTest {
    @Autowired
    SecutiryDepartment secutiryDepartment;

    @Test
    void resetSuccess() {
        BigInteger expected = BigInteger.ZERO;
        secutiryDepartment.reset();
        Assertions.assertEquals(expected, secutiryDepartment.getAccidentCountPeriod());
    }

    @Test
    void addAccidentSuccess() {
        BigInteger expected = BigInteger.ONE;
        secutiryDepartment.addAccident();
        Assertions.assertEquals(expected, secutiryDepartment.getAccidentCountPeriod());
    }
}
