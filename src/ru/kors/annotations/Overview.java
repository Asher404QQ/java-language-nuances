package ru.kors.annotations;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Overview {
    @Deprecated(since = "1.2", forRemoval = true)
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
