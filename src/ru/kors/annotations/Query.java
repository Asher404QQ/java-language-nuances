package ru.kors.annotations;

public @interface Query {
    String value();
    boolean nativeQuery() default false;
}
