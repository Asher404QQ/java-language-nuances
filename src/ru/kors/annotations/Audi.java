package ru.kors.annotations;

@Overview(version = "1.00", status = Overview.ReviewStatus.PASSED)
public class Audi extends Car{
    @Overview(version = "2.00", status = Overview.ReviewStatus.FAILED)
    private static final double DEFAULT_SPEED = 45.00;

    public Audi() {
    }
    @Override
    public @ru.kors.annotations.Overview(version = "1.01", createdBy = "Petr Petrov") void drive(double speed) {
        System.out.println("Audi.drive(double speed), speed=" + speed);
    }

    @Overview(createdBy = "Korsakov Anton", report = @Version(major = 2, minor = 0)) public void drive() {
        System.out.println("Audi.drive(), speed=" + DEFAULT_SPEED);
    }
}