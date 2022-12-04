package pl.roslon.xCode.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RatesDto {

    private String currency;
    private String code;
    private double mid;

}
