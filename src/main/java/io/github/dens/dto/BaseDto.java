package io.github.dens.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dens.gorban
 */
@Getter
@ToString
public class BaseDto {

    @Parsed(field = "Test Case ID", defaultNullRead = "")
    private String testCaseId;
}
