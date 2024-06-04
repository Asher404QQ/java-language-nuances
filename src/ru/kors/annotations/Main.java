package ru.kors.annotations;

public class Main {
    public static void main(String[] args) {
        Car audi = new Audi();
        int speed = 101;
        audi.drive(speed);
    }
}
