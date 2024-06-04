package ru.kors.annotations;

@Overview(version = "1.00", createdBy = "Korsakov Anton")
public class Audi extends Car{
    @Overview(createdBy = "Korsakov Anton", version = "2.00")
    private static final double DEFAULT_SPEED = 45.00;
    @Override
    public @ru.kors.annotations.Overview(version = "1.01", createdBy = "Korsakov Anton") void drive(double speed) {
        System.out.println("Audi.drive(double speed), speed=" + speed);
    }

    @Overview(createdBy = "Korsakov Anton", version = "2.00") public void drive() {
        System.out.println("Audi.drive(), speed=" + DEFAULT_SPEED);
    }
}