package io.github.dens.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class CurrencyDto extends BaseDto {

    @Parsed(field = "URL", defaultNullRead = "")
    private String url;

    @Parsed(field = "expectedValue", defaultNullRead = "")
    private String expectedValue;

}
