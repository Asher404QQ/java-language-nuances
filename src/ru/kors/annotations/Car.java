package ru.kors.annotations;

@Overview(status = Overview.ReviewStatus.PASSED, report = @Version(major = 2, minor = 4))
public class Car {
    public void drive(double speed) {
        System.out.println("Car.drive(double speed), speed=" + speed);
    }
}