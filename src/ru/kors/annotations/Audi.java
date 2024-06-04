package ru.kors.annotations;

public class Audi extends Car{
    @Override
    public void drive(double speed) {
        System.out.println("Audi.drive(), speed=" + speed);
    }

    // Этот метод возвращает целое число
    public double sum(double a, double b) {
        return a + b;
    }
}