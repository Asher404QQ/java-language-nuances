package ru.kors.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface Overview {
    @Deprecated
    String createdBy() default "Korsakov Anton";
    Author[] creators() default {
        @Author(firstName = "Korsakov", lastName = "Anton"),
        @Author(firstName = "Petr", lastName = "Petrov")
    };
    @Deprecated
    String version() default "";
    Version report() default @Version(major = 1, minor = 0);
    ReviewStatus status() default ReviewStatus.PENDING;

    enum ReviewStatus {FAILED, PASSED, PENDING}
}
