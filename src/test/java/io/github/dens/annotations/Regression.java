package io.github.dens.annotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

/**
 * @author dens.gorban
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("regression")
public @interface Regression {}
