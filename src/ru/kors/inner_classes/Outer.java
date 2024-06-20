package ru.kors.inner_classes;

public class Outer {
    private int a_o = 10;
    public class Inner {
        private int a_i = 99;
        public void sayHello() {
            System.out.println("Hello from " + this.getClass());
        }

        public int sum() {
            return a_o + a_i;
        }
    }

    public Inner inner() {
        return new Inner();
    }
}
