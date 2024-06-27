package io.github.dens.annotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

/**
 * @author dens.gorban
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Regression
@Tag("smoke")
public @interface Smoke {}
