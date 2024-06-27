package io.github.dens.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dens.gorban
 */
@Getter
@ToString(callSuper = true)
public final class ProductsDto extends BaseDto {

    @Parsed(field = "URL", defaultNullRead = "")
    private String url;

    @Parsed(field = "expectedValue", defaultNullRead = "")
    private String expectedValue;

}
