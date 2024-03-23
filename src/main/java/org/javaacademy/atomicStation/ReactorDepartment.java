package org.javaacademy.atomicStation;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

/*
 * Отвечает за производство электроэнергии
 */

@Component
public class ReactorDepartment {
    private boolean isWork;
    private int startCount = 0;

    //Возвращает киловатт-часы
    public BigInteger run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWork) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        if (startCount == 100) {
            throw new NuclearFuelIsEmptyException("Не хватает топлива для запуска");
        }
        isWork = true;
        return new BigInteger("10_000_000");
    }

    public void stop() throws ReactorWorkException {
        if (!isWork) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWork = false;
    }
    
}
