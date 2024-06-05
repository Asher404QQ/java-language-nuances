package ru.kors.annotations;

public @interface AuthTest {
    Class<? extends Throwable> willThrow() default UserNotFoundException.class;
}
