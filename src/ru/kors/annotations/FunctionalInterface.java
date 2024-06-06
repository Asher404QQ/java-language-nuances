package ru.kors.annotations;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    void run();
    static void sleep(){}
    default void walk(){}
}
