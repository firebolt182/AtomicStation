package org.javaacademy.atomicStation;

import org.javaacademy.atomicStation.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.atomicStation.exceptions.ReactorWorkException;
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
        //возможно дальше по тз придется обнулять startcount по другому
        if (startCount == 100) {
            startCount = 0;
            throw new NuclearFuelIsEmptyException("Не хватает топлива для запуска");
        }
        isWork = true;
        startCount++;
        return new BigInteger("10000000");
    }

    public void stop() throws ReactorWorkException {
        if (!isWork) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWork = false;
    }
    
}
