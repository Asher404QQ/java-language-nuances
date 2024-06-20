package ru.kors.inner_classes;

public class A {
    public class B {
        public class C {
            public class D {
                public class E {
                    public static int VALUE = 10;
                    public void getInfo() {
                        System.out.println("Hello from " + this.getClass());
                    }
                }

                public class G extends E{}

                public static class F {
                    public void getInfo() {
                        System.out.println("Hello from " + this.getClass());
                    }
                }
            }
        }
    }
}
