package ru.kors.inner_classes;

import java.util.Iterator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        A.B.C.D.F f = new A.B.C.D.F();

        int a = A.B.C.D.E.VALUE;
        f.getInfo();
    }

    private static void local() {
        class Local  {
            public void sayHello() {
                System.out.println("Hello from " +this.getClass());
            }
        }
    }
}
