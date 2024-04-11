package org.javaacademy.atomicStation.department;

import java.math.BigInteger;
import lombok.Data;
import org.javaacademy.atomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.atomicStation.exceptions.ReactorWorkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReactorDepartment {
    private boolean isWork;
    private int startCount = 0;
    @Autowired
    private SecutiryDepartment secutiryDepartment;

    public BigInteger run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWork) {
            secutiryDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже работает");
        }
        if (startCount == 100) {
            startCount = 0;
            secutiryDepartment.addAccident();
            throw new NuclearFuelIsEmptyException("Не хватает топлива для запуска");
        }
        isWork = true;
        startCount++;
        return new BigInteger("10000000");
    }

    public void stop() throws ReactorWorkException {
        if (!isWork) {
            secutiryDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWork = false;
    }
    
}
