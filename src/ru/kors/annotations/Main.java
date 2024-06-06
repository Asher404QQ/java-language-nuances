package ru.kors.annotations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car audi = new Audi();
        int speed = 101;
        audi.drive(speed);

        @Query(value = "select * from test", nativeQuery = true)
        String query = "";

        Class<?> cls = Audi.class;
        var annotations = cls.getAnnotations();
        Arrays.stream(annotations).forEach(System.out::println);
    }

    @SuppressWarnings({"unchecked"})
    public void suppressWarning() {
        ArrayList list = new ArrayList();
        list.add("Hello");
    }

    @SafeVarargs
    public static void test(String...strings) {

    }
}
