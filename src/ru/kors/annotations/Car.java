package ru.kors.annotations;

@Overview
public class Car {
    public void drive(double speed) {
        System.out.println("Car.drive(double speed), speed=" + speed);
    }
}