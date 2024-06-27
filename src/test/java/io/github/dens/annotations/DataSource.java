package io.github.dens.annotations;

import io.github.dens.utils.DataArgumentsProvider;
import io.github.dens.dto.BaseDto;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

/**
 * @author dens.gorban
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(DataArgumentsProvider.class)
public @interface DataSource {

    String id();

    String fileName();

    Class<? extends BaseDto> clazz();
}
